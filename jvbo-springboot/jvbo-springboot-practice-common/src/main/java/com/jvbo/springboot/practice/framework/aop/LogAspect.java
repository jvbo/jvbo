/*
 * LogAspect.java 2016年4月21日
 * Copyright (c) 2015-2018, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.springboot.practice.framework.aop;

import java.lang.reflect.Method;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.alibaba.fastjson.JSON;
import com.jvbo.springboot.practice.core.enums.LogTypeEnum;
import com.jvbo.springboot.practice.core.enums.PublicEnum;
import com.jvbo.springboot.practice.core.model.SysLog;
import com.jvbo.springboot.practice.core.service.ISysLogService;
import com.jvbo.springboot.practice.framework.annotation.ControllerLog;
import com.jvbo.springboot.practice.framework.annotation.ServiceLog;
import com.jvbo.springboot.practice.framework.util.UUIDUtil;

@Aspect
@Component
public class LogAspect {

    private static final Logger logger = LoggerFactory.getLogger(LogAspect.class);
    
    @Autowired
    private ISysLogService sysLogService;

    /**
     * Service层切点
     */
    @Pointcut("@annotation(com.jvbo.springboot.practice.framework.annotation.ServiceLog)")
    public void serviceAspect(){ }
    
    /**
     * Controller层切点
     */
    @Pointcut("@annotation(com.jvbo.springboot.practice.framework.annotation.ControllerLog)")
    public void controllerAspect(){ }
    
    /*@Before("controllerAspect()")
    public void doControllerBefore(JoinPoint joinPoint) {
        logger.debug("");
    }
    
    @Around("controllerAspect()")
    public void doControllerAround(JoinPoint joinPoint) {
        logger.debug("");
    }
    
    @AfterReturning("controllerAspect()")
    public void doControllerAfterReturning(JoinPoint joinPoint) {
        logger.debug("");
    }*/
    
    @After("controllerAspect()")
    public void doControllerAfter(JoinPoint joinPoint) {
        try {
            RequestAttributes ra = RequestContextHolder.getRequestAttributes();
            ServletRequestAttributes sra = (ServletRequestAttributes)ra;
            HttpServletRequest request = sra.getRequest();
            HttpSession session = request.getSession();
            // TODO session中的系统标识/用户标识 local-session/redis-session
            String requestUser = 
                    session.getAttribute("MEMBER_NAME") == null ?
                            "member" : session.getAttribute("MEMBER_NAME").toString();
            
            HttpServletResponse response = sra.getResponse();
            String responseStatus = response.getHeader("status");
            String responseCode = response.getHeader("code");
            String responseMsg = response.getHeader("msg");
            String responseData = response.getHeader("data");
            
            String appName = "edobee";
            Integer logType = LogTypeEnum.OPERTATION.getCodeInt();
            String requestIp = request.getRemoteAddr();
            String requestUri = request.getRequestURI();
            String requestPath = request.getPathInfo();
            String requestParams = JSON.toJSONString(joinPoint.getArgs());
            String createBy = "admin";
            long now = new Date().getTime();
            
            SysLog log = new SysLog();
            log.setLogId(UUIDUtil.generateUUID32());
            log.setAppName(appName);
            log.setLogType(logType);
            log.setMethodName((joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName() + "()"));
            log.setMethodDesc(getControllerMethodDescription(joinPoint));
            log.setRequestUser(requestUser);
            log.setRequestIp(requestIp);
            log.setRequestUri(requestUri);
            log.setRequestPath(requestPath);
            log.setRequestParams(requestParams);
            //log.setExceptionCode(null);
            //log.setExceptionDesc(null);
            log.setResponseStatus(responseStatus);
            log.setResponseCode(responseCode);
            log.setResponseMsg(responseMsg);
            log.setResponseData(responseData);
            log.setCreatedBy(createBy);
            log.setGmtCreated(now);
            log.setIsDeleted(PublicEnum.FALSE.getCodeInt());
            sysLogService.insertSelective(log);
        } catch (Exception e) {
            logger.error("异常:{}, 详情:{}", e.getMessage(), JSON.toJSONString(e));
        }
    }

    @AfterThrowing(pointcut = "controllerAspect()", throwing = "e")
    public void doControllerAfterThrowing(JoinPoint joinPoint, Throwable e) {
        String methodName = (joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName() + "()");
        String requestParams = JSON.toJSONString(joinPoint.getArgs());
        String exceptionCode = e.getClass().getName();
        String exceptionDesc = e.getMessage();
        try {
            RequestAttributes ra = RequestContextHolder.getRequestAttributes();
            ServletRequestAttributes sra = (ServletRequestAttributes)ra;
            HttpServletRequest request = sra.getRequest();
            HttpSession session = request.getSession();  
            // TODO session中的系统标识/用户标识 local-session/redis-session
            String requestUser = 
                    session.getAttribute("MEMBER_NAME") == null ?
                            "member" : session.getAttribute("MEMBER_NAME").toString();

            HttpServletResponse response = sra.getResponse();
            String responseStatus = response.getHeader("status");
            String responseCode = response.getHeader("code");
            String responseMsg = response.getHeader("msg");
            String responseData = response.getHeader("data");
            
            String appName = "edobee";
            Integer logType = LogTypeEnum.OPERTATION.getCodeInt();
            String methodDesc = getControllerMethodDescription(joinPoint);
            String requestIp = request.getRemoteAddr();
            String requestUri = request.getRequestURI();
            String requestPath = request.getPathInfo();
            String createBy = "admin";
            long now = new Date().getTime();
            
            SysLog log = new SysLog();
            log.setLogId(UUIDUtil.generateUUID32());
            log.setAppName(appName);
            log.setLogType(logType);
            log.setMethodName(methodName);
            log.setMethodDesc(methodDesc);
            log.setRequestUser(requestUser);
            log.setRequestIp(requestIp);
            log.setRequestUri(requestUri);
            log.setRequestPath(requestPath);
            log.setRequestParams(requestParams);
            log.setExceptionCode(exceptionCode);
            log.setExceptionDesc(exceptionDesc);
            log.setResponseStatus(responseStatus);
            log.setResponseCode(responseCode);
            log.setResponseMsg(responseMsg);
            log.setResponseData(responseData);
            log.setCreatedBy(createBy);
            log.setGmtCreated(now);
            log.setIsDeleted(PublicEnum.FALSE.getCodeInt());
            sysLogService.insertSelective(log);
        } catch (Exception ex) {
            logger.error("异常:{}, 详情:{}", ex.getMessage(), JSON.toJSONString(ex));
        }
        logger.error("异常方法:{}, 异常代码:{}, 异常信息:{}, 参数:{}", methodName, exceptionCode, exceptionDesc, requestParams);
    }
    
    /*@Before("serviceAspect()")
    public void doServiceBefore(JoinPoint joinPoint) {
        logger.debug("");
    }
    
    @Around("serviceAspect()")
    public void doServiceAround(JoinPoint joinPoint) {
        logger.debug("");
    }
    
    @AfterReturning("serviceAspect()")
    public void doServiceAfterReturning(JoinPoint joinPoint) {
        logger.debug("");
    }

    @After("serviceAspect()")
    public void doServiceAfter(JoinPoint joinPoint) {
        logger.debug("");
    }*/

    @AfterThrowing(pointcut = "serviceAspect()", throwing = "e")
    public void doServiceAfterThrowing(JoinPoint joinPoint, Throwable e) {
        String methodName = (joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName() + "()");
        String requestParams = JSON.toJSONString(joinPoint.getArgs());
        String exceptionCode = e.getClass().getName();
        String exceptionDesc = e.getMessage();
        try {
            RequestAttributes ra = RequestContextHolder.getRequestAttributes();
            ServletRequestAttributes sra = (ServletRequestAttributes)ra;
            HttpServletRequest request = sra.getRequest();
            HttpSession session = request.getSession();  
            // TODO session中的系统标识/用户标识 local-session/redis-session
            String requestUser = 
                    session.getAttribute("MEMBER_NAME") == null ?
                            "member" : session.getAttribute("MEMBER_NAME").toString();

            HttpServletResponse response = sra.getResponse();
            String responseStatus = response.getHeader("status");
            String responseCode = response.getHeader("code");
            String responseMsg = response.getHeader("msg");
            String responseData = response.getHeader("data");
            
            String appName = "edobee";
            Integer logType = LogTypeEnum.OPERTATION.getCodeInt();
            String methodDesc = getServiceMethodDescription(joinPoint);
            String requestIp = request.getRemoteAddr();
            String requestUri = request.getRequestURI();
            String requestPath = request.getPathInfo();
            String createBy = "admin";
            long now = new Date().getTime();
            
            SysLog log = new SysLog();
            log.setLogId(UUIDUtil.generateUUID32());
            log.setAppName(appName);
            log.setLogType(logType);
            log.setMethodName(methodName);
            log.setMethodDesc(methodDesc);
            log.setRequestUser(requestUser);
            log.setRequestIp(requestIp);
            log.setRequestUri(requestUri);
            log.setRequestPath(requestPath);
            log.setRequestParams(requestParams);
            log.setExceptionCode(exceptionCode);
            log.setExceptionDesc(exceptionDesc);
            log.setResponseStatus(responseStatus);
            log.setResponseCode(responseCode);
            log.setResponseMsg(responseMsg);
            log.setResponseData(responseData);
            log.setCreatedBy(createBy);
            log.setGmtCreated(now);
            log.setIsDeleted(PublicEnum.FALSE.getCodeInt());
            sysLogService.insertSelective(log);
        } catch (Exception ex) {
            logger.error("异常:{}, 详情:{}", ex.getMessage(), JSON.toJSONString(ex));
        }
        logger.error("异常方法:{}, 异常代码:{}, 异常信息:{}, 参数:{}", methodName, exceptionCode, exceptionDesc, requestParams);
    }

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
