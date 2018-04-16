package com.jvbo.springboot.practice.core.enums;

public enum ResponseStatusEnum implements IEnum {

    OK("0000", "成功"),
    
    ERR("9999", "错误"),
    
    ERR_UNKNOWN("9900", "未知错误"),
    
    ERR_UNAUTHORIZED("9800", "未登录或登录超时"),
    ERR_TIMEOUT("9801", "超时"),
    
    ERR_LOAD("9700", "加载错误"),
    ERR_LOAD_NOT_FOUND("9701", "未查询到数据错误"),
    
    ERR_CREATE("9600", "创建错误"),
    ERR_UPDATE("9601", "修改错误"),
    ERR_DELETE("9602", "删除错误"),
    ERR_OPERATE("9603", "操作错误"),
    
    ERR_UPLOAD("9500", "上传错误"),
    ERR_FILE_LOAD("9501", "文件上传错误"),
    ERR_FILE_SAVE("9502", "文件保存错误"),

    ERR_VALIDATE("9400", "数据格式错误"),
    ERR_DATA_FORMAT("9401", "数据转换错误"),
    ERR_INVALID_DATE("9402", "时间转换错误");

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
    
    public Integer getCodeInt(){
        //if(NumberUtils.isDigits(code)){
        if(code.matches("-?[0-9]+.*[0-9]*")){
            return Integer.parseInt(code);
        }
        return null;
    }
    
    public static ResponseStatusEnum getEnumByCode(String code){
        for (ResponseStatusEnum enums : values()) {
            if(enums.getCode().equalsIgnoreCase(code)){
                return enums;
            }
        }
        return null;
    }
    
    public static String toJsonString() {
        StringBuffer jsonStr = new StringBuffer("[");
        for (ResponseStatusEnum enums : values()) {
            if (!"[".equals(jsonStr.toString())) {
                jsonStr.append(",");
            }
            jsonStr.append("{code:'").append(enums.getCode()).append("',name:'").append(enums.getName()).append("'}");
        }
        jsonStr.append("]");
        return jsonStr.toString();
    }
}
