/*
 * LogTypeEnum.java 2018年4月11日
 * Copyright (c) 2015-2018, Jv Bo (programmer_jv_bo@163.com).
 */
package site.jvbo.fun.common.enums;

public enum LogTypeEnum implements IEnum {
    OPERTATION("0", "操作日志"),
    EXCEPTION("1", "异常日志");

    LogTypeEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public static final String TYPE_CODE = "logTypeEnum";

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
    
    public Integer getCodeInt(){
        //if(NumberUtils.isDigits(code)){
        if(code.matches("-?[0-9]+.*[0-9]*")){
            return Integer.parseInt(code);
        }
        return null;
    }
    
    public static String toJsonString() {
        StringBuffer jsonStr = new StringBuffer("[");
        for (LogTypeEnum enums : values()) {
            if (!"[".equals(jsonStr.toString())) {
                jsonStr.append(",");
            }
            jsonStr.append("{code:'").append(enums.getCode()).append("',name:'").append(enums.getName()).append("'}");
        }
        jsonStr.append("]");
        return jsonStr.toString();
    }
}
