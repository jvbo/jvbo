package com.jvbo.springboot.practice.core.enums;

/**
 * 编码枚举
 */
public enum EnCodingEnum implements IEnum {

    UTF8("UTF-8", "UTF-8"),
    GBK("GBK", "GBK");

    EnCodingEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }

    /**
     * 代码
     */
    private String code;

    /**
     * 名称
     */
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
