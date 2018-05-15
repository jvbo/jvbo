package com.jvbo.springcloud.zuul.filter;

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
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

}
