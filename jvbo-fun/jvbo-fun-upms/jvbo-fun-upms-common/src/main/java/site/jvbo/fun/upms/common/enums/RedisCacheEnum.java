package site.jvbo.fun.upms.common.enums;

import site.jvbo.fun.common.enums.IEnum;

/**
 * @ClassName:
 * @Description: TODO
 * @author: jvbo
 * @date: 2018/10/26
 */
public enum RedisCacheEnum implements IEnum {
	REDIS_SHIRO_SESSION_ID("upms.shiro.session.id.%s", "会话key"),
	REDIS_SERVER_SESSION_ID("upms.server.session.id.%s", "全局会话key"),
	REDIS_SERVER_SESSION_IDS("upms.server.session.ids.%s", "全局会话列表key"),
	REDIS_CLIENT_SESSION_ID("upms.client.session.id.%s", "局部会话key"),
	REDIS_CLIENT_SESSION_IDS("upms.client.session.ids.%s", "单点同一个code所有局部会话key"),
	REDIS_SERVER_CODE("upms.server.code.%s", "code key"),
	REDIS_LOCK("redis.lock.%s", "redis分布式锁key");


	RedisCacheEnum(String code, String name) {
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
		for (RedisCacheEnum enums : values()) {
			if(!"[".equals(jsonStr))
				jsonStr.append(",");
			jsonStr.append("{code:'").append(enums.getCode()).append("',name:'").append(enums.getName()).append("'}");
		}
		jsonStr.append("]");
		return jsonStr.toString();
	}
}

