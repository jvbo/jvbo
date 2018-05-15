/*
 * AccessFilter.java 2018年5月15日
 * Copyright (c) 2015-2018, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.springcloud.gateway.filter;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

public class AccessFilter extends ZuulFilter {
    
    private static final Logger logger = LoggerFactory.getLogger(AccessFilter.class);

    @Override
    public boolean shouldFilter() {
        /**
         * 返回一个boolean类型来判断该过滤器是否要执行
         */
        return true;
    }

    @Override
    public Object run() {
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();
        logger.info("send {} request to {}", request.getMethod(), request.getRequestURL().toString());
        Object accessToken = request.getParameter("access_token");
        if(accessToken == null){
            logger.warn("no access_token");
            requestContext.setSendZuulResponse(false);
            requestContext.setResponseStatusCode(403);
            JSONObject responseBodyJo = new JSONObject();
            responseBodyJo.put("status", 200);
            responseBodyJo.put("code", "3002");
            responseBodyJo.put("msg", "没有访问权限");
            responseBodyJo.put("data", "");
            requestContext.setResponseBody(responseBodyJo.toJSONString());
            return null;
        }
        logger.info("access_token success");
        return null;
    }

    @Override
    public String filterType() {
        /**
         * 1. pre:可以在请求被路由之前调用;
         * 2. routing:在路由请求时候被调用;
         * 3. post:在routing和error过滤器之后被调用;
         * 4. error:处理请求时发生错误时被调用;
         */
        return "pre";
    }

    @Override
    public int filterOrder() {
        /**
         * 数值越小优先级越高
         */
        return 0;
    }

}
