/*
 * MvcExceptionHandler.java 2017年9月12日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.springboot.practice.framework.exception;

import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.charset.Charset;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.ExceptionHandlerExceptionResolver;

import com.alibaba.fastjson.JSONObject;
import com.jvbo.springboot.practice.core.enums.EnCodingEnum;
import com.jvbo.springboot.practice.core.enums.ResponseStatusEnum;

public class MvcExceptionHandler extends ExceptionHandlerExceptionResolver {

    private Logger logger = LoggerFactory.getLogger(MvcExceptionHandler.class);

    @Override
    public ModelAndView doResolveHandlerMethodException(HttpServletRequest request, HttpServletResponse response, HandlerMethod handlerMethod, Exception exception) {
        if (handlerMethod == null) 
            return null;

        Method method = handlerMethod.getMethod();
        if (method == null) 
            return null;

        //如果定义了ExceptionHandler则返回相应的Map中的数据
        ModelAndView returnValue = super.doResolveHandlerMethodException(request, response, handlerMethod, exception);
        ResponseBody responseBodyAnn = AnnotationUtils.findAnnotation(method, ResponseBody.class);
        ResponseBody classBodyAnn = AnnotationUtils.findAnnotation(method.getDeclaringClass(), ResponseBody.class);
        if (responseBodyAnn != null || classBodyAnn != null) {
            response.setCharacterEncoding(EnCodingEnum.UTF8.getCode());
            
            String exceptionCode = ResponseStatusEnum.ERR.getCode();
            String exceptionDesc = exception.getMessage();
            
            // TODO 这里结合业务场景判断是否需要入库
            JSONObject jo = new JSONObject();
            jo.put("exceptionCode", exceptionCode);
            jo.put("exceptionDesc", exceptionDesc);
            
            logger.error("异常代码:{}, 异常信息:{}", exceptionCode, exceptionDesc);
            ServletOutputStream out = null;
            try {
                out = response.getOutputStream();
                out.write(jo.toJSONString().getBytes(Charset.forName(EnCodingEnum.UTF8.getCode())));
                out.flush();
            } catch (IOException e) {
                if (out != null) {
                    try {
                        out.close();
                    } catch (IOException e1) {
                    }
                }
            }
            return new ModelAndView();
        }
        return returnValue;
    }
}
