package com.jvbo.springboot.template.admin.core.util.controller;

public class Response<T> {

    public enum Status {
        OK,
        ERR_UNKNOWN,
        ERR_INTERNAL_SERVER,
        ERR_LOAD,
        ERR_CREATE,
        ERR_UPDATE,
        ERR_DELETE,
        ERR_UNAUTHORIZED,
        ERR_NOT_FOUND,
        ERR_DATA_FORMAT,
        ERR_VALIDATE,
        ERR_FILE_LOAD,
        ERR_FILE_SAVE,
        ERR_INVALID_DATE,
        ERR_PAY_FAILED,
        ERR_OPERATE,
        ERR_UPLOAD
    }

    private Status status;
    private String message;
    private T data;

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}