package site.jvbo.fun.upms.web.filter;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.AuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import site.jvbo.fun.common.util.PropertiesFileUtil;
import site.jvbo.fun.upms.common.enums.RedisCacheEnum;
import site.jvbo.fun.upms.web.enums.UpmsEnum;
import site.jvbo.fun.upms.web.shiro.session.UpmsSessionDao;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName:
 * @Description: TODO
 * @author: jvbo
 * @date: 2018/10/26
 */
public class UpmsAuthenticationFilter extends AuthenticationFilter {
	private static final Logger logger = LoggerFactory.getLogger(UpmsAuthenticationFilter.class);

	@Value("${jvbo.fun.sso.client.type}")private String clientType;

	@Autowired
	UpmsSessionDao upmsSessionDao;
	@Autowired
	private RedisTemplate<String, String> redisTemplate;

	@Override
	protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
		Subject subject = getSubject(request, response);
		Session session = subject.getSession();
		// 判断请求类型
		String upmsType = clientType;
		session.setAttribute(UpmsEnum.UPMS_TYPE.getCode(), upmsType);
		if ("client".equals(upmsType)) {
			return validateClient(request, response);
		}
		if ("server".equals(upmsType)) {
			return subject.isAuthenticated();
		}
		return false;
	}

	@Override
	protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
		StringBuffer ssoServerUrl = new StringBuffer(96);
		// server需要登录
		String upmsType = clientType;
		if ("server".equals(upmsType)) {
			WebUtils.toHttp(response).sendRedirect(ssoServerUrl.append("/sso/login").toString());
			return false;
		}
		ssoServerUrl.append("/sso/index").append("?").append("appid").append("=").append("1");
		// 回跳地址
		HttpServletRequest httpServletRequest = WebUtils.toHttp(request);
		StringBuffer backurl = httpServletRequest.getRequestURL();
		String queryString = httpServletRequest.getQueryString();
		if (StringUtils.isNotBlank(queryString)) {
			backurl.append("?").append(queryString);
		}
		ssoServerUrl.append("&").append("backurl").append("=").append(URLEncoder.encode(backurl.toString(), "utf-8"));
		WebUtils.toHttp(response).sendRedirect(ssoServerUrl.toString());
		return false;
	}

	/**
	 * 认证中心登录成功带回code
	 *
	 * @param request
	 */
	private boolean validateClient(ServletRequest request, ServletResponse response) {
		Subject subject = getSubject(request, response);
		Session session = subject.getSession();
		String sessionId = session.getId().toString();
		long timeOut = session.getTimeout();
		// 判断局部会话是否登录
		String cacheClientSession = redisTemplate.opsForValue().get(String.format(RedisCacheEnum.REDIS_CLIENT_SESSION_ID.getCode(), session.getId()));
		if (StringUtils.isNotBlank(cacheClientSession)) {
			// 更新code有效期
			redisTemplate.opsForValue().set(String.format(RedisCacheEnum.REDIS_CLIENT_SESSION_ID.getCode(), session.getId()), cacheClientSession, timeOut, TimeUnit.MILLISECONDS);
			redisTemplate.expire(String.format(RedisCacheEnum.REDIS_CLIENT_SESSION_IDS.getCode(), cacheClientSession), timeOut, TimeUnit.MILLISECONDS);
			// 移除url中的code参数
			if (null != request.getParameter("code")) {
				String backUrl = getParameterWithOutCode(WebUtils.toHttp(request));
				HttpServletResponse httpServletResponse = WebUtils.toHttp(response);
				try {
					httpServletResponse.sendRedirect(backUrl.toString());
				} catch (IOException e) {
					logger.error("局部会话已登录，移除code参数跳转出错：", e);
				}
			} else {
				return true;
			}
		}
		// 判断是否有认证中心code
		String code = request.getParameter("upms_code");
		// 已拿到code
		if (StringUtils.isNotBlank(code)) {
			// 校验code
			String redisServerCode = redisTemplate.opsForValue().get(String.format(RedisCacheEnum.REDIS_SERVER_CODE.getCode(), code));
			if (StringUtils.isNotBlank(redisServerCode) && redisServerCode.equals(code)) {
				// code校验正确，创建局部会话
				redisTemplate.opsForValue().set(String.format(RedisCacheEnum.REDIS_CLIENT_SESSION_ID.getCode(), sessionId), code, timeOut, TimeUnit.MILLISECONDS);
				// 保存code对应的局部会话sessionId，方便退出操作
				redisTemplate.opsForSet().add(String.format(RedisCacheEnum.REDIS_CLIENT_SESSION_IDS.getCode(), code), sessionId);
				redisTemplate.expire(String.format(RedisCacheEnum.REDIS_CLIENT_SESSION_IDS.getCode(), code), timeOut, TimeUnit.MILLISECONDS);
				logger.debug("当前code={}，对应的注册系统个数：{}个", code, redisTemplate.opsForSet().size(String.format(RedisCacheEnum.REDIS_CLIENT_SESSION_IDS.getCode(), code)));
				// 移除url中的token参数
				String backUrl = getParameterWithOutCode(WebUtils.toHttp(request));
				// 返回请求资源
				try {
					// client无密认证
					String username = request.getParameter("upms_username");
					subject.login(new UsernamePasswordToken(username, ""));
					HttpServletResponse httpServletResponse = WebUtils.toHttp(response);
					httpServletResponse.sendRedirect(backUrl.toString());
					return true;
				} catch (IOException e) {
					logger.error("已拿到code，移除code参数跳转出错：", e);
				}
			}else{
				logger.warn("token检验失败");
			}
		}
		return false;
	}

	public static String getParameterWithOutCode(HttpServletRequest request) {
		StringBuffer backUrl = request.getRequestURL();
		String params = "";
		Map<String, String[]> parameterMap = request.getParameterMap();
		for (Map.Entry<String, String[]> entry : parameterMap.entrySet()) {
			if (!"upms_code".equals(entry.getKey()) && !"upms_username".equals(entry.getKey())) {
				if ("".equals(params)) {
					params = entry.getKey() + "=" + entry.getValue()[0];
				} else {
					params += "&" + entry.getKey() + "=" + entry.getValue()[0];
				}
			}
		}
		if (!StringUtils.isBlank(params)) {
			backUrl = backUrl.append("?").append(params);
		}
		return backUrl.toString();
	}
}
