/*
 * MvcExceptionHandler.java 2017年9月12日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
package site.jvbo.fun.upms.web.handler;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.ExceptionHandlerExceptionResolver;
import site.jvbo.fun.common.enums.EnCodingEnum;
import site.jvbo.fun.common.enums.ResponseCodeEnum;
import site.jvbo.fun.upms.common.response.UpmsResponse;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.charset.Charset;

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
            response.setContentType("application/json");

            String exceptionCode = ResponseCodeEnum.INTERNAL_SERVER_ERROR.getCode();
            String exceptionDesc = exception.getLocalizedMessage();

            UpmsResponse upmsResponse = null;
			// TODO 这里结合业务场景判断是否需要入库
			String requestUser =
					request.getAttribute("userId") == null ?
							"member" : request.getAttribute("userId").toString();

			// TODO 响应信息
			upmsResponse = new UpmsResponse(ResponseCodeEnum.INTERNAL_SERVER_ERROR.getCodeInt(), ResponseCodeEnum.INTERNAL_SERVER_ERROR.getName(), null);

            logger.error("异常代码:{}, 异常信息:{}", exceptionCode, exceptionDesc);
            ServletOutputStream out = null;
            try {
                out = response.getOutputStream();
                out.write(JSON.toJSONString(upmsResponse).getBytes(Charset.forName(EnCodingEnum.UTF8.getCode())));
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
