/*
 * BaseRuntimeException.java 2017年9月12日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
package site.jvbo.fun.common.exception;


import site.jvbo.fun.common.enums.ResponseCodeEnum;

/**
 * BaseRuntimeException
 */
public class BaseRuntimeException extends RuntimeException {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    /**
     * 异常代码
     */
    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public BaseRuntimeException(String code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }

    public BaseRuntimeException(String message) {
        this(ResponseCodeEnum.INTERNAL_SERVER_ERROR.getCode(), message, null);
    }

    public BaseRuntimeException(String code, String message) {
        this(code, message, null);
    }


    public BaseRuntimeException(String message, Throwable cause) {
        this(ResponseCodeEnum.INTERNAL_SERVER_ERROR.getCode(), message, cause);
    }

    public BaseRuntimeException(Throwable cause) {
        this(ResponseCodeEnum.INTERNAL_SERVER_ERROR.getCode(), "", cause);
    }
}
