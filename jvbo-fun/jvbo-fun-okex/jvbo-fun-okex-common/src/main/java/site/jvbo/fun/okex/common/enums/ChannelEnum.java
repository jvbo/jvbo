package site.jvbo.fun.okex.common.enums;

import site.jvbo.fun.common.enums.IEnum;

/**
 * @ClassName:
 * @Description: TODO
 * @author: jvbo
 * @date: 2018/10/18
 */
public enum ChannelEnum implements IEnum {
	SPOT("0", "spot", "spot"),
	FUTURE_THIS_WEEK("1", "this_week", "future"),
	FUTURE_NEXT_WEEK("2", "next_week", "future"),
	FUTURE_QUARTER("3", "quarter", "future")
	;

	ChannelEnum(String code, String name, String flag) {
		this.code = code;
		this.name = name;
		this.flag = flag;
	}

	public static final String TYPE_CODE = "channelEnum";

	private String code;

	private String name;

	private String flag;

	@Override
	public String getCode() {
		return code;
	}

	@Override
	public String getName() {
		return name;
	}


	public String getFlag() {
		return flag;
	}

	public Integer getCodeInt() {
		//if(NumberUtils.isDigits(code)){
		if (code.matches("-?[0-9]+.*[0-9]*")) {
			return Integer.parseInt(code);
		}
		return null;
	}

	public static ChannelEnum getEnumByCode(String code){
		for (ChannelEnum enums : values()) {
			if(enums.getCode().equalsIgnoreCase(code)){
				return enums;
			}
		}
		return null;
	}

	public static ChannelEnum getEnumByFlag(String flag){
		for (ChannelEnum enums : values()) {
			if(enums.getFlag().equalsIgnoreCase(flag)){
				return enums;
			}
		}
		return null;
	}

	public static String toJsonString() {
		StringBuffer jsonStr = new StringBuffer("[");
		for (ChannelEnum enums : values()) {
			if (!"[".equals(jsonStr.toString())) {
				jsonStr.append(",");
			}
			jsonStr.append("{code:'").append(enums.getCode()).append("',name:'").append(enums.getName()).append("'}");
		}
		jsonStr.append("]");
		return jsonStr.toString();
	}
}
