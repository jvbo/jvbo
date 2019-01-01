/*
 * PublicEnum.java 2018年1月24日
 * Copyright (c) 2015-2017, Jv Bo (programmer_jv_bo@163.com).
 */
package site.jvbo.fun.common.enums;

public enum PublicEnum implements IEnum {
    YES("Y", "是"),
    NO("N", "否"),
    FALSE("0","假"),
    TRUE("1","真"),
    ZERO("0","整数0"),
    ONE("1","正整数1"),
    TWO("2","正整数2"),
    THREE("3","正整数3"),
    FOUR("4","正整数4"),
    FIVE("5","正整数5"),
    MINUS_ONE("-1", "负整数1");

    PublicEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public static final String TYPE_CODE = "publicEnum";

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

	public static PublicEnum getEnumByCode(String code){
		for (PublicEnum enums : values()) {
			if(enums.getCode().equalsIgnoreCase(code)){
				return enums;
			}
		}
		return null;
	}

    public static String toJsonString() {
        StringBuffer jsonStr = new StringBuffer("[");
        for (PublicEnum enums : values()) {
            if (!"[".equals(jsonStr.toString())) {
                jsonStr.append(",");
            }
            jsonStr.append("{code:'").append(enums.getCode()).append("',name:'").append(enums.getName()).append("'}");
        }
        jsonStr.append("]");
        return jsonStr.toString();
    }

}
