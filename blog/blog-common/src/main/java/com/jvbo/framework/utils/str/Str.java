/*
 * Str.java 2016年10月31日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.framework.utils.str;

import java.util.UUID;

public class Str {
	
	/**
	 * 生成唯一32位UUID
	 * @Description: TODO
	 * @param @return
	 * @return String
	 * @author jv.bo
	 * @version 1.0
	 * @since 2016-2-25
	 */
	public static String getUUID() {
		UUID uuid = UUID.randomUUID();
		String uuidStr = (uuid.toString()).replaceAll("-", "");
		return uuidStr;
	}
}
