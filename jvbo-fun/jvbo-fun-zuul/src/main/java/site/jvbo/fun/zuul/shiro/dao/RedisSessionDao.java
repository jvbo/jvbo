package site.jvbo.fun.zuul.shiro.dao;


import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.EnterpriseCacheSessionDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName:
 * @Description: TODO
 * @author: jvbo
 * @date: 2018/9/16
 */
public class RedisSessionDao extends EnterpriseCacheSessionDAO {
    private static Logger logger = LoggerFactory.getLogger(RedisSessionDao.class);

    public static String prefix = "platform-shiro-session-";

    private ThreadLocal<String> sessionLocal = new ThreadLocal();

    @Resource
    private RedisTemplate<String, Object> redisTemplate;


    @Override
    protected Serializable doCreate(Session session) {
        Serializable sessionId = sessionLocal.get();
        assignSessionId(session, sessionId);
        sessionLocal.remove();
        redisTemplate.opsForValue().set(prefix + sessionId.toString(), session);
        return sessionId;
    }

    @Override
    protected Session doReadSession(Serializable sessionId) {
        sessionLocal.set(String.valueOf(sessionId));
        Session session = super.doReadSession(sessionId);
        if (session == null) {
            session = (Session) redisTemplate.opsForValue().get(prefix + sessionId.toString());
        }

        return session;
    }

    @Override
    protected void doUpdate(Session session) {
        super.doUpdate(session);
        String key = prefix + session.getId().toString();
        if (redisTemplate.hasKey(key)) {
            redisTemplate.opsForValue().set(key, session);
        }
        redisTemplate.expire(key, 1800, TimeUnit.SECONDS);
    }

    @Override
    protected void doDelete(Session session) {
        super.doDelete(session);
        redisTemplate.delete(prefix + session.getId().toString());
    }
}