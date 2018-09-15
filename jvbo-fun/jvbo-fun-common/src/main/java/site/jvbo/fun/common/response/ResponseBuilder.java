package site.jvbo.fun.common.response;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import site.jvbo.fun.common.enums.ResponseCodeEnum;
import site.jvbo.fun.common.exception.ControllerException;

import java.util.concurrent.Callable;

public class ResponseBuilder {

    private static final Log logger = LogFactory.getLog(ResponseBuilder.class);

    private String successMessage = "ok";
    private String defaultErrorCode = ResponseCodeEnum.INTERNAL_SERVER_ERROR.getCode();
    private String defaultErrorMessage = "error";

    public static ResponseBuilder create() {
        return new ResponseBuilder();
    }

    public ResponseBuilder successMessage(String successMessage) {
        this.successMessage = successMessage;
        return this;
    }

    public ResponseBuilder defaultErrorCode(String defaultErrorCode) {
        this.defaultErrorCode = defaultErrorCode;
        return this;
    }

    public ResponseBuilder defaultErrorMessage(String defaultErrorMessage) {
        this.defaultErrorMessage = defaultErrorMessage;
        return this;
    }

    public ResponseBuilder defaultError(String defaultErrorCode, String defaultErrorMessage) {
        return defaultErrorCode(defaultErrorCode).defaultErrorMessage(defaultErrorMessage);
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
        response.setCode(ResponseCodeEnum.OK.getCode());
        response.setMsg(successMessage);
        response.setData(result);
        return response;
    }

    private Response<Void> buildResponseFromRunnable(Runnable r) {
        r.run();
        Response<Void> response = new Response<>();
        response.setCode(ResponseCodeEnum.OK.getCode());
        response.setMsg(successMessage);
        return response;
    }

    private <T> Response<T> buildResponseFromControllerException(ControllerException e) {
        Response<T> response = new Response<>();
        String code = e.getCode();
        if (code == null) {
            code = defaultErrorCode;
        }
        response.setCode(code);
        response.setMsg(e.getMessage());
        return response;
    }

    private <T> Response<T> buildResponseFromException(Exception e) {
        logger.error(defaultErrorMessage, e);
        Response<T> response = new Response<>();
        response.setCode(defaultErrorCode);
        response.setMsg(defaultErrorMessage);
        return response;
    }

}
