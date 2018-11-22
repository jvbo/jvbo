package site.jvbo.fun.upms.web.shiro.session;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.ValidatingSession;
import org.apache.shiro.session.mgt.eis.CachingSessionDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import site.jvbo.fun.upms.common.enums.RedisCacheEnum;
import site.jvbo.fun.upms.web.enums.UpmsEnum;

import java.io.*;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName:
 * @Description: TODO
 * @author: jvbo
 * @date: 2018/10/26
 */
public class UpmsSessionDao extends CachingSessionDAO {
	private static final Logger logger = LoggerFactory.getLogger(UpmsSessionDao.class);

	@Autowired
	private RedisTemplate<String, String> redisTemplate;

    @Override
    protected Serializable doCreate(Session session) {
        Serializable sessionId = generateSessionId(session);
        assignSessionId(session, sessionId);
		redisTemplate.opsForValue().set(String.format(RedisCacheEnum.REDIS_SHIRO_SESSION_ID.getCode(), sessionId),
				serialize(session), session.getTimeout(), TimeUnit.MILLISECONDS);
		logger.debug("doCreate - sessionId={}", sessionId);
        return sessionId;
    }

    @Override
    protected Session doReadSession(Serializable sessionId) {
		String sessionKey = String.format(RedisCacheEnum.REDIS_SHIRO_SESSION_ID.getCode(), sessionId);
		Session session = deserialize(redisTemplate.opsForValue().get(sessionKey));
		logger.debug("doReadSession - sessionId={}", sessionId);
        return session;
    }

    @Override
    protected void doUpdate(Session session) {
        // 如果会话过期/停止 没必要再更新了
        if(session instanceof ValidatingSession && !((ValidatingSession)session).isValid()) {
            return;
        }
        // 更新session的最后一次访问时间
        UpmsSession upmsSession = new UpmsSession();
		BeanUtils.copyProperties(session, upmsSession);
        UpmsSession cacheUpmsSession = new UpmsSession();
		BeanUtils.copyProperties(doReadSession(session.getId()), cacheUpmsSession);
        if (null != cacheUpmsSession) {
            upmsSession.setStatus(cacheUpmsSession.getStatus());
            upmsSession.setAttribute("FORCE_LOGOUT", cacheUpmsSession.getAttribute("FORCE_LOGOUT"));
        }
		String sessionKey = String.format(RedisCacheEnum.REDIS_SHIRO_SESSION_ID.getCode(), session.getId());
		redisTemplate.opsForValue().set(sessionKey, serialize(session), session.getTimeout(), TimeUnit.MILLISECONDS);
		logger.debug("doUpdate - sessionId={}", session.getId());
    }

    @Override
    protected void doDelete(Session session) {
        String sessionId = session.getId().toString();
        String upmsType = ObjectUtils.toString(session.getAttribute(UpmsEnum.UPMS_TYPE.getCode()));
        if ("client".equals(upmsType)) {
            // 删除局部会话和同一code注册的局部会话
			String sessionKey = String.format(RedisCacheEnum.REDIS_CLIENT_SESSION_ID.getCode(), sessionId);
			String code = redisTemplate.opsForValue().get(sessionKey);
			logger.debug("doCreate - sessionId={}", sessionId);
			redisTemplate.delete(sessionKey);
			redisTemplate.opsForSet().remove(String.format(RedisCacheEnum.REDIS_CLIENT_SESSION_IDS.getCode(), code), sessionId);
        }
        if ("server".equals(upmsType)) {
            // 当前全局会话code

			String sessionKey = String.format(RedisCacheEnum.REDIS_SERVER_SESSION_ID.getCode(), sessionId);
			String code = redisTemplate.opsForValue().get(sessionKey);
			// 清除全局会话
			redisTemplate.delete(sessionKey);
            // 清除code校验值
			redisTemplate.delete(String.format(RedisCacheEnum.REDIS_SERVER_CODE.getCode(), code));
            // 清除所有局部会话
			Set<String> clientSessionIds = redisTemplate.opsForSet().members(String.format(RedisCacheEnum.REDIS_CLIENT_SESSION_IDS.getCode(), code));
            if(CollectionUtils.isNotEmpty(clientSessionIds)){
				for (String clientSessionId : clientSessionIds) {
					redisTemplate.delete(String.format(RedisCacheEnum.REDIS_CLIENT_SESSION_ID.getCode(), clientSessionId));
					redisTemplate.opsForSet().remove(String.format(RedisCacheEnum.REDIS_CLIENT_SESSION_IDS.getCode(), code), clientSessionId);
				}
			}
			Long size =redisTemplate.opsForSet().size(String.format(RedisCacheEnum.REDIS_CLIENT_SESSION_IDS.getCode(), code));
			logger.debug("当前code={}，对应的注册系统个数：{}个", code, size);
            // 维护会话id列表，提供会话分页管理
			redisTemplate.opsForList().remove(String.format(RedisCacheEnum.REDIS_SERVER_SESSION_IDS.getCode(), ""), 1, sessionId);
        }
        // 删除session
		redisTemplate.delete(String.format(RedisCacheEnum.REDIS_SERVER_SESSION_ID.getCode(), sessionId));
        logger.debug("doUpdate - sessionId={}", sessionId);
    }

    /**
     * 获取会话列表
     * @param offset
     * @param limit
     * @return
     */
    public Map getActiveSessions(int offset, int limit) {
        Map sessions = new HashMap();
        // 获取在线会话总数
		long total = redisTemplate.opsForList().size(String.format(RedisCacheEnum.REDIS_SERVER_SESSION_IDS.getCode(), ""));
        // 获取当前页会话详情
        List<String> ids = redisTemplate.opsForList().range(String.format(RedisCacheEnum.REDIS_SERVER_SESSION_IDS.getCode(), ""), offset, (offset + limit - 1));
        List<Session> rows = new ArrayList<>();
        for (String id : ids) {
			String session = redisTemplate.opsForValue().get(String.format(RedisCacheEnum.REDIS_SHIRO_SESSION_ID.getCode(), id));
            // 过滤redis过期session
            if (null == session) {
				redisTemplate.opsForList().remove(String.format(RedisCacheEnum.REDIS_SHIRO_SESSION_ID.getCode(), id), 1 ,id);
                total = total - 1;
                continue;
            }
            rows.add(deserialize(session));
        }
        sessions.put("total", total);
        sessions.put("rows", rows);
        return sessions;
    }

    /**
     * 强制退出
     * @param ids
     * @return
     */
    public int forceout(String ids) {
        String[] sessionIds = ids.split(",");
        for (String sessionId : sessionIds) {
            // 会话增加强制退出属性标识，当此会话访问系统时，判断有该标识，则退出登录
			String sessionKey = String.format(RedisCacheEnum.REDIS_SHIRO_SESSION_ID.getCode(), sessionId);
			Session session = deserialize(redisTemplate.opsForValue().get(sessionKey));
			UpmsSession upmsSession = new UpmsSession();
			BeanUtils.copyProperties(session, upmsSession);
            upmsSession.setStatus(UpmsSession.OnlineStatus.FORCE_LOGOUT);
            upmsSession.setAttribute("FORCE_LOGOUT", "FORCE_LOGOUT");
			redisTemplate.opsForValue().set(String.format(RedisCacheEnum.REDIS_SHIRO_SESSION_ID.getCode(), sessionId), serialize(upmsSession), upmsSession.getTimeout(), TimeUnit.MILLISECONDS);
        }
        return sessionIds.length;
    }

    /**
     * 更改在线状态
     *
     * @param sessionId
     * @param onlineStatus
     */
    public void updateStatus(Serializable sessionId, UpmsSession.OnlineStatus onlineStatus) {
		UpmsSession session = new UpmsSession();
		BeanUtils.copyProperties(doReadSession(sessionId), session);
        if (null == session) {
            return;
        }
        session.setStatus(onlineStatus);
		redisTemplate.opsForValue().set(String.format(RedisCacheEnum.REDIS_SHIRO_SESSION_ID.getCode(), session.getId()), serialize(session), session.getTimeout(), TimeUnit.MILLISECONDS);
    }

	public static String serialize(Session session) {
		if (null == session) {
			return null;
		}
		try {
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(bos);
			oos.writeObject(session);
			return org.apache.shiro.codec.Base64.encodeToString(bos.toByteArray());
		} catch (Exception e) {
			throw new RuntimeException("serialize session error", e);
		}
	}

	public static Session deserialize(String sessionStr) {
		if (StringUtils.isBlank(sessionStr)) {
			return null;
		}
		try {
			ByteArrayInputStream bis = new ByteArrayInputStream(org.apache.shiro.codec.Base64.decode(sessionStr));
			ObjectInputStream ois = new ObjectInputStream(bis);
			return (Session) ois.readObject();
		} catch (Exception e) {
			throw new RuntimeException("deserialize session error", e);
		}
	}

}
