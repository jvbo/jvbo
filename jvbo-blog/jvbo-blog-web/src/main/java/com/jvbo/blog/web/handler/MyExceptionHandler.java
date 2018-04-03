/*
 * MyExceptionHandler.java 2016年11月20日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.blog.web.handler;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.jvbo.blog.framework.filter.SysLogin;

public class MyExceptionHandler implements HandlerExceptionResolver {
	
	private static final Logger logger = LoggerFactory.getLogger(SysLogin.class);
	
	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		Map<String, Object> viewMap = new HashMap<String, Object>();  
		viewMap.put("ex", ex);
		if(StringUtils.containsAny(request.getRequestURI(), "/front/")){
			logger.info("--------------------前台异常==请求URI中包含/front/-----------------------");
			return new ModelAndView("front/error/error", viewMap);
		}else if(StringUtils.containsAny(request.getRequestURI(), "/sys/")){
			logger.info("--------------------后台异常==请求URI中包含/sys/-----------------------");
			return new ModelAndView("sys/error/error", viewMap);
		}else{
			logger.info("--------------------未知异常==请求URI中不包含/front/，也不包含/sys/，暂时先转到前台异常页面-----------------------");
			return new ModelAndView("front/error/error", viewMap);
		}
	}

}
