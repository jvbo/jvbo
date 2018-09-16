package site.jvbo.fun.zuul.shiro.config;

import com.google.common.collect.Maps;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import site.jvbo.fun.zuul.shiro.cache.RedisCacheManager;
import site.jvbo.fun.zuul.shiro.dao.RedisSessionDao;
import site.jvbo.fun.zuul.shiro.mgt.AuthAccessFilter;
import site.jvbo.fun.zuul.shiro.mgt.AuthUserRealm;
import site.jvbo.fun.zuul.shiro.mgt.CredentialsMatcher;

import java.util.Map;

/**
 * @ClassName:
 * @Description: TODO
 * @author: jvbo
 * @date: 2018/9/16
 */
@Configuration
public class ShiroConfig {

	@Autowired
	private RedisSessionDao redisSessionDao;

	@Bean
	public RedisSessionDao sessionDAO() {
		return new RedisSessionDao();
	}

	@Bean
	public RedisCacheManager redisCacheManager() {
		return new RedisCacheManager();
	}

	@Bean
	public CredentialsMatcher credentialsMatcher() {
		return new CredentialsMatcher();
	}

	@Bean
	public SessionManager sessionManager() {
		DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
		sessionManager.setSessionValidationSchedulerEnabled(false);
		sessionManager.setSessionDAO(redisSessionDao);
		sessionManager.setGlobalSessionTimeout(1 * 60 * 1000 * 30);
		sessionManager.setCacheManager(redisCacheManager());
		return sessionManager;
	}


	@Bean
	public DefaultWebSecurityManager securityManager() {
		DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
		securityManager.setSessionManager(sessionManager());
		securityManager.setCacheManager(redisCacheManager());
		securityManager.setRealm(authUserRealm());
		return securityManager;
	}

	@Bean
	public ShiroFilterFactoryBean getShiroFilterFactoryBean() {
		// TODO
		Map<String, String> filterChainDefinitionMap = Maps.newHashMap();
		ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
		shiroFilterFactoryBean.setSecurityManager(securityManager());

		shiroFilterFactoryBean.getFilters().put("authAccessFilter", authAccessFilter());

		shiroFilterFactoryBean.setLoginUrl("/");
		shiroFilterFactoryBean.setSuccessUrl("/");
		shiroFilterFactoryBean.setUnauthorizedUrl("/");

		filterChainDefinitionMap.put("/", "anon");
		filterChainDefinitionMap.put("/", "authAccessFilter");
		shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
		return shiroFilterFactoryBean;
	}


	@Bean
	public AuthUserRealm authUserRealm() {
		AuthUserRealm authUserRealm = new AuthUserRealm();
		authUserRealm.setCredentialsMatcher(credentialsMatcher());
		return authUserRealm;
	}

	@Bean
	public AuthAccessFilter authAccessFilter() {
		return new AuthAccessFilter();
	}

}
