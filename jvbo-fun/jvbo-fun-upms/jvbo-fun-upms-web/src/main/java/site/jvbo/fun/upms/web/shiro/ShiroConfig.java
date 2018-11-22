package site.jvbo.fun.upms.web.shiro;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.SessionListener;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import site.jvbo.fun.upms.web.filter.UpmsAuthenticationFilter;
import site.jvbo.fun.upms.web.filter.UpmsSessionForceLogoutFilter;
import site.jvbo.fun.upms.web.listener.UpmsSessionListener;
import site.jvbo.fun.upms.web.shiro.session.UpmsSessionDao;

import javax.servlet.Filter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @ClassName:
 * @Description: TODO
 * @author: jvbo
 * @date: 2018/9/12
 */
@Configuration
public class ShiroConfig {
	private static final Logger logger = LoggerFactory.getLogger(ShiroConfig.class);

	@Bean
	public ShiroDialect shiroDialect(){
		return new ShiroDialect();
	}

	@Bean
	public SimpleCredentialsMatcher simpleCredentialsMatcher(){
		return new ShiroCredentialsMatcher();
	}

	@Bean
	public UpmsSessionDao upmsSessionDao(){
		UpmsSessionDao upmsSessionDao = new UpmsSessionDao();
		return upmsSessionDao;
	}

	@Bean
	public SessionManager sessionManager() {
		DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
		Collection<SessionListener> listeners = new ArrayList<SessionListener>();
		listeners.add(new UpmsSessionListener());
		sessionManager.setSessionListeners(listeners);
		sessionManager.setSessionDAO(upmsSessionDao());
		return sessionManager;
	}

	@Bean
	public EhCacheManager ehCacheManager() {
		EhCacheManager ehCacheManager = new EhCacheManager();
		ehCacheManager.setCacheManagerConfigFile("classpath:ehcache/ehcache-shiro.xml");
		return ehCacheManager;
	}

	@Bean
	public UpmsRealm upmsRealm() {
		UpmsRealm upmsRealm = new UpmsRealm();
		upmsRealm.setCacheManager(ehCacheManager());
		upmsRealm.setCredentialsMatcher(simpleCredentialsMatcher());
		return upmsRealm;
	}

	@Bean
	public DefaultWebSecurityManager securityManager() {
		DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
		securityManager.setSessionManager(sessionManager());
		securityManager.setRealm(upmsRealm());
		return securityManager;
	}

	/*@Bean
	public static DefaultAdvisorAutoProxyCreator getDefaultAdvisorAutoProxyCreator() {
		DefaultAdvisorAutoProxyCreator creator = new DefaultAdvisorAutoProxyCreator();
		*//**
		 * setUsePrefix(false)用于解决一个奇怪的bug。在引入spring aop的情况下。
		 * 在@Controller注解的类的方法中加入@RequiresRole注解，会导致该方法无法映射请求，导致返回404。
		 * 加入这项配置能解决这个bug
		 *//*
		creator.setUsePrefix(true);
		return creator;
	}*/

	@Bean
	public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
		DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
		// 强制使用cglib，防止重复代理和可能引起代理出错的问题
		// https://zhuanlan.zhihu.com/p/29161098
		defaultAdvisorAutoProxyCreator.setProxyTargetClass(true);
		return defaultAdvisorAutoProxyCreator;
	}

	@Bean
	public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
		AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();
		advisor.setSecurityManager(securityManager);
		return advisor;
	}

	@Bean
	public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
		return new LifecycleBeanPostProcessor();
	}

	@Bean
	public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager) {
		ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
		// 必须设置SecuritManager
		shiroFilterFactoryBean.setSecurityManager(securityManager);
		Map<String, Filter> filters = shiroFilterFactoryBean.getFilters();
		filters.put("upmsAuthenticationFilter", upmsAuthenticationFilter());// upmsAuthenticationFilter重写默认的authc
		filters.put("upmsSessionForceLogoutFilter", upmsSessionForceLogoutFilter());
		shiroFilterFactoryBean.setFilters(filters);

		shiroFilterFactoryBean.setLoginUrl("/sso/login");
		shiroFilterFactoryBean.setSuccessUrl("/index");
		shiroFilterFactoryBean.setUnauthorizedUrl("/403");

		// 过滤链定义
		Map<String, String> chain = new LinkedHashMap<>();
		// 认证访问
		// 首页
		chain.put("/index", "user");
		// druid
		chain.put("/druid/**", "user");
		// swagger相关
		chain.put("/swagger-ui.html", "user");
		chain.put("/swagger-ui.html/**", "user");
		chain.put("/doc.html", "user");
		chain.put("/doc.html/**", "user");
		chain.put("/webjars/**", "user");
		chain.put("/v2/api-docs/**", "user");
		chain.put("/configuration/ui/**", "user");
		chain.put("/swagger-resources/**", "user");
		chain.put("/configuration/security/**", "user");
		chain.put("/configuration/ui/**", "user");

		// 授权访问
		chain.put("/manage/**", "upmsAuthenticationFilter,upmsSessionForceLogoutFilter");
		// 匿名访问
		chain.put("/**", "anon");

		shiroFilterFactoryBean.setFilterChainDefinitionMap(chain);
		return shiroFilterFactoryBean;
	}

	@Bean
	public UpmsAuthenticationFilter upmsAuthenticationFilter(){
		UpmsAuthenticationFilter upmsAuthenticationFilter = new UpmsAuthenticationFilter();
		return upmsAuthenticationFilter;
	}
	@Bean
	public UpmsSessionForceLogoutFilter upmsSessionForceLogoutFilter(){
		UpmsSessionForceLogoutFilter upmsSessionForceLogoutFilter = new UpmsSessionForceLogoutFilter();
		return upmsSessionForceLogoutFilter;
	}

	@Bean
	public FilterRegistrationBean filterRegistrationBean(){
		FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
		filterRegistrationBean.setFilter(upmsAuthenticationFilter());
		filterRegistrationBean.setFilter(upmsSessionForceLogoutFilter());
		filterRegistrationBean.setEnabled(false); //Shiro相关的Filter不自动注册,不会添加到FilterChain中;
		return filterRegistrationBean;
	}

	@Bean
	public EmbeddedServletContainerCustomizer containerCustomizer() {
		return container -> {
			container.addErrorPages(new ErrorPage(HttpStatus.BAD_REQUEST, "/error/400"));
			container.addErrorPages(new ErrorPage(HttpStatus.UNAUTHORIZED, "/error/403"));
			container.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND, "/error/404"));
			container.addErrorPages(new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/error/500"));
			container.addErrorPages(new ErrorPage(Throwable.class, "/error/500"));
		};
	}
}
