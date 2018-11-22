package site.jvbo.fun.okex.common.enums;

import site.jvbo.fun.common.enums.IEnum;

/**
 * @ClassName:
 * @Description: TODO
 * @author: jvbo
 * @date: 2018/10/19
 */
public enum HeartBeatEnum implements IEnum {
	PING("ping", "ping"),
	PONG("pong", "pong");

	HeartBeatEnum(String code, String name) {
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
