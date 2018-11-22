/*
 * LogAspect.java 2016年4月21日
 * Copyright (c) 2015-2018, Jv Bo (programmer_jv_bo@163.com).
 */
package site.jvbo.fun.upms.web.aop;

import com.alibaba.fastjson.JSON;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import site.jvbo.fun.common.annotation.log.ControllerLog;
import site.jvbo.fun.common.annotation.log.ServiceLog;
import site.jvbo.fun.common.enums.LogTypeEnum;
import site.jvbo.fun.common.enums.PublicEnum;
import site.jvbo.fun.common.util.UUIDUtil;
import site.jvbo.fun.upms.dao.model.UpmsLog;
import site.jvbo.fun.upms.dao.model.UpmsUser;
import site.jvbo.fun.upms.dao.model.UpmsUserExample;
import site.jvbo.fun.upms.service.IUpmsLogService;
import site.jvbo.fun.upms.service.IUpmsUserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;
import java.time.Instant;
import java.util.Date;

@Aspect
@Component
public class LogAspect {
    private static final Logger logger = LoggerFactory.getLogger(LogAspect.class);
    
    @Autowired
    private IUpmsLogService sysLogService;
	@Autowired
	private IUpmsUserService upmsUserService;

    /**
     * Service层切点
     */
    @Pointcut("@annotation(site.jvbo.fun.common.annotation.log.ServiceLog)")
    public void serviceAspect(){ }
    
    /**
     * Controller层切点
     */
    @Pointcut("@annotation(site.jvbo.fun.common.annotation.log.ControllerLog)")
    public void controllerAspect(){ }
    
    /*@Before("controllerAspect()")
    public void doControllerBefore(JoinPoint joinPoint) {
        logger.debug("");
    }*/
    
    @Around("controllerAspect()")
    public void doControllerAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		RequestAttributes ra = RequestContextHolder.getRequestAttributes();
		ServletRequestAttributes sra = (ServletRequestAttributes)ra;
		HttpServletRequest request = sra.getRequest();
		// TODO db中用户标识 或者 session中的系统标识/用户标识 local-session/redis-session
		Subject subject = SecurityUtils.getSubject();
		String username = (String) subject.getPrincipal();
		UpmsUserExample upmsUserExample = new UpmsUserExample();
		upmsUserExample.createCriteria().andIsDeletedEqualTo(PublicEnum.FALSE.getCodeInt())
				.andIsLockedEqualTo(PublicEnum.FALSE.getCodeInt()).andUsernameEqualTo(username);
		UpmsUser upmsUser = upmsUserService.selectFirstByExample(upmsUserExample);
		Long requestUser = upmsUser.getUserId();

		String appName = "jvbo.fun.upms";
		Integer logType = LogTypeEnum.OPERTATION.getCodeInt();
		String requestIp = request.getRemoteAddr();
		String requestUrl = request.getRequestURL().toString();
		String requestUri = request.getRequestURI();
		String requestType = request.getMethod();
		String requestBasePath = new StringBuilder(64).append(request.getScheme())
				.append("://").append(request.getServerName()).append(":").append(request.getServerPort())
				.append(request.getContextPath()).append("/").toString();
		String requestUserAgent = request.getHeader("user-agent");

		Object[] requestParams = proceedingJoinPoint.getArgs();
		long startTimestamp = Instant.now().toEpochMilli();
		Object result = proceedingJoinPoint.proceed(requestParams);

		HttpServletResponse response = sra.getResponse();

		int responseStatusCode = response.getStatus();
		String responseResult = JSON.toJSONString(result);

		long endTimestamp = Instant.now().toEpochMilli();
		long spendTime = endTimestamp - startTimestamp;


		UpmsLog log = new UpmsLog();
		log.setLogType(logType);
		log.setAppName(appName);
		log.setMethodName((proceedingJoinPoint.getTarget().getClass().getName() + "." + proceedingJoinPoint.getSignature().getName() + "()"));
		log.setMethodDesc(getControllerMethodDescription(proceedingJoinPoint));
		log.setSpendTimeMs(spendTime);
		log.setRequestUser(requestUser);
		log.setRequestIp(requestIp);
		log.setRequestBasePath(requestBasePath);
		log.setRequestType(requestType);
		log.setRequestUserAgent(requestUserAgent);
		log.setRequestUrl(requestUrl);
		log.setRequestUri(requestUri);
		log.setRequestParams(JSON.toJSONString(requestParams));
		//log.setExceptionCode(null);
		//log.setExceptionDesc(null);
		log.setResponseStatusCode(responseStatusCode);
		log.setResponseResult(responseResult);
		log.setGmtCreate(endTimestamp);
		log.setIsDeleted(PublicEnum.FALSE.getCodeInt());
		sysLogService.insertSelective(log);
	}
    
    /*@AfterReturning("controllerAspect()")
    public void doControllerAfterReturning(JoinPoint joinPoint) {
        logger.debug("");
    }
    
    @After("controllerAspect()")
    public void doControllerAfter(JoinPoint joinPoint) {
        logger.debug("");
    }*/

    /*@AfterThrowing(pointcut = "controllerAspect()", throwing = "e")
    public void doControllerAfterThrowing(JoinPoint joinPoint, Throwable e) throws Exception {
    	logger.debug("");
    }*/
    
    /*@Before("serviceAspect()")
    public void doServiceBefore(JoinPoint joinPoint) {
        logger.debug("");
    }*/
    
    @Around("serviceAspect()")
    public void doServiceAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        logger.debug("");
    }
    
    /*@AfterReturning("serviceAspect()")
    public void doServiceAfterReturning(JoinPoint joinPoint) {
        logger.debug("");
    }*/

    /*@After("serviceAspect()")
    public void doServiceAfter(JoinPoint joinPoint) {
        logger.debug("");
    }*/

    /*@AfterThrowing(pointcut = "serviceAspect()", throwing = "e")
    public void doServiceAfterThrowing(JoinPoint joinPoint, Throwable e) {
        logger.debug("");
    }*/

    /**
     * 获取注解中对方法的描述信息 用于Controller层注解
     * @param joinPoint 切点
     * @return 方法描述
     * @throws Exception
     */
    @SuppressWarnings("rawtypes")
    private static String getControllerMethodDescription(JoinPoint joinPoint) throws Exception {
        String targetName = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Object[] arguments = joinPoint.getArgs();
        Class targetClass = Class.forName(targetName);
        Method[] methods = targetClass.getMethods();
        String description = "";
        for (Method method : methods) {
            if (method.getName().equals(methodName)) {
                Class[] clazzs = method.getParameterTypes();
                if (clazzs.length == arguments.length) {
                    description = method.getAnnotation(ControllerLog.class).value();
                    break;
                }
            }
        }
        return description;
    }
    
    /**
     * 获取注解中对方法的描述信息 用于service层注解
     * @param joinPoint 切点
     * @return 方法描述
     * @throws Exception
     */
    @SuppressWarnings("rawtypes")
    private static String getServiceMethodDescription(JoinPoint joinPoint) throws Exception {
        String targetName = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Object[] arguments = joinPoint.getArgs();
        Class targetClass = Class.forName(targetName);
        Method[] methods = targetClass.getMethods();
        String description = "";
        for (Method method : methods) {
            if (method.getName().equals(methodName)) {
                Class[] clazzs = method.getParameterTypes();
                if (clazzs.length == arguments.length) {
                    description = method.getAnnotation(ServiceLog.class).value();
                    break;
                }
            }
        }
        return description;
    }
}
