package site.jvbo.fun.upms.web.enums;

import site.jvbo.fun.common.enums.IEnum;
import site.jvbo.fun.upms.common.enums.RedisCacheEnum;

/**
 * @ClassName:
 * @Description: TODO
 * @author: jvbo
 * @date: 2018/10/26
 */
public enum UpmsEnum implements IEnum {
	UPMS_TYPE("jvbo.upms.type", "upms类型")
	;


	UpmsEnum(String code, String name) {
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

	public static String toJsonStr(){
		StringBuilder jsonStr = new StringBuilder();
		for (UpmsEnum enums : values()) {
			if(!"[".equals(jsonStr))
				jsonStr.append(",");
			jsonStr.append("{code:'").append(enums.getCode()).append("',name:'").append(enums.getName()).append("'}");
		}
		jsonStr.append("]");
		return jsonStr.toString();
	}
}


