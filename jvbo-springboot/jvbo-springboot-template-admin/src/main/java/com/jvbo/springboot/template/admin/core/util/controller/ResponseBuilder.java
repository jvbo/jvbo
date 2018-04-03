package com.jvbo.springboot.template.admin.core.util.controller;

import java.util.concurrent.Callable;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.jvbo.springboot.template.admin.core.util.exception.ControllerException;

public class ResponseBuilder {

    private static final Log logger = LogFactory.getLog(ResponseBuilder.class);

    private String successMessage = "请求成功！";
    private Response.Status defaultErrorStatus = Response.Status.ERR_UNKNOWN;
    private String defaultErrorMessage = "请求失败！";

    public static ResponseBuilder create() {
        return new ResponseBuilder();
    }

    public ResponseBuilder successMessage(String successMessage) {
        this.successMessage = successMessage;
        return this;
    }

    public ResponseBuilder defaultErrorStatus(Response.Status defaultErrorStatus) {
        this.defaultErrorStatus = defaultErrorStatus;
        return this;
    }

    public ResponseBuilder defaultErrorMessage(String defaultErrorMessage) {
        this.defaultErrorMessage = defaultErrorMessage;
        return this;
    }

    public ResponseBuilder defaultError(Response.Status defaultErrorStatus, String defaultErrorMessage) {
        return defaultErrorStatus(defaultErrorStatus).defaultErrorMessage(defaultErrorMessage);
    }

    public <T> Response<T> buildResponse(Callable<T> c) {
        try {
            return buildResponseFromCallable(c);
        } catch (ControllerException e) {
            return buildResponseFromControllerException(e);
        } catch (Exception e) {
            return buildResponseFromException(e);
        }
    }

    public Response<Void> buildResponseNoData(Runnable r) {
        try {
            return buildResponseFromRunnable(r);
        } catch (ControllerException e) {
            return buildResponseFromControllerException(e);
        } catch (Exception e) {
            return buildResponseFromException(e);
        }
    }

    private <T> Response<T> buildResponseFromCallable(Callable<T> c) throws Exception {
        T result = c.call();
        Response<T> response = new Response<>();
        response.setStatus(Response.Status.OK);
        response.setMessage(successMessage);
        response.setData(result);
        return response;
    }

    private Response<Void> buildResponseFromRunnable(Runnable r) {
        r.run();
        Response<Void> response = new Response<>();
        response.setStatus(Response.Status.OK);
        response.setMessage(successMessage);
        return response;
    }

    private <T> Response<T> buildResponseFromControllerException(ControllerException e) {
        Response<T> response = new Response<>();
        Response.Status status = e.getStatus();
        if (status == null) {
            status = defaultErrorStatus;
        }
        response.setStatus(status);
        response.setMessage(e.getMessage());
        return response;
    }

    private <T> Response<T> buildResponseFromException(Exception e) {
        logger.error(defaultErrorMessage, e);
        Response<T> response = new Response<>();
        response.setStatus(defaultErrorStatus);
        response.setMessage(defaultErrorMessage);
        return response;
    }

}
