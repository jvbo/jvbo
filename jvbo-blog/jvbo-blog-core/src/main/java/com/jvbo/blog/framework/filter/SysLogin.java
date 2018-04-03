/*
 * @(#) ShopLoginFilter.java 2016-2-29
 *
 * Copyright (c) 2016, ZuiQiang Technology. All Rights Reserved.
 * ZuiQiang  Technology. CONFIDENTIAL
 */
package com.jvbo.blog.framework.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jvbo.blog.framework.constant.Constants;

/**
 * @Description: TODO
 * @author jv.bo
 * @version 1.0
 * @since 2016-2-29
 */
public class SysLogin implements Filter {
	
	private static final Logger logger = LoggerFactory.getLogger(SysLogin.class);
	
	private static String [] url=new String[]{
		"sys/login",
		"sys/noLogin",
		"sys/main"
	};
	
	public void doFilter(ServletRequest rq, ServletResponse rp,FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request=(HttpServletRequest)rq;
		HttpServletResponse response=(HttpServletResponse)rp;
		if(StringUtils.containsAny(request.getRequestURI(), url)){
			logger.info("--------------------请求URI中包含:{}中的一个-----------------------", new Object[]{url});
			chain.doFilter(request, response);
		}else{
			Object user = request.getSession().getAttribute(Constants.USER);
			logger.info("--------------------user:{}-----------------------", new Object[]{user});
			if(user==null){
				if(request.getRequestURI().indexOf(".ajax")!=-1){
					logger.info("--------------------session中USER为null,请求URI以.ajax结尾-----------------------");
					response.setStatus(301);
				}else{
					logger.info("--------------------重定向/sys/login.htm-----------------------");
					response.sendRedirect(request.getContextPath()+"/sys/login.htm");
				}
			}else{
				chain.doFilter(request, response);
			}
		}
	}
	
	
	
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
	
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
