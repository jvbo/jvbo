/*
 * Result.java 2018年4月16日
 * Copyright (c) 2015-2018, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.springboot.practice.framework.response;

import com.jvbo.springboot.practice.core.enums.ResponseStatusEnum;

public class Result {
    // 状态码：1成功，其他为失败
    public String code;

    // 成功为success，其他为失败原因
    public String message;

    // 数据结果集
    public Object data;

    public Result(String code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
    
    public Result(ResponseStatusEnum responseStatus, Object data) {
        this.code = responseStatus.getCode();
        this.message = responseStatus.getName();
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
