package com.jvbo.springboot.practice.core.enums;

public enum ResponseStatusEnum implements IEnum {

    DEFAULT_ERROR("9999", "错误"),
    LOGIN_TIMEOUT_ERROR("9998", "未登录或登录超时"),
    TIMEOUT_ERROR("9997", "超时"),
    DEFAULT_SUCCESS("0000", "成功");

    ResponseStatusEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }

    private String code;

    private String name;

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getName() {
        return name;
    }
}
