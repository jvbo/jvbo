/*
 * UUIDUtil.java 2017年8月29日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.springboot.template.admin.core.util.uuid;

import java.util.UUID;

public class UUIDUtil {
	
	public static String generateUUID32() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
