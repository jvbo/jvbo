/*
 * SampleMapBuilder.java 2017年7月28日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.springboot.template.admin.core.util.collection;

import java.util.HashMap;
import java.util.Map;

public class SampleMapBuilder {
	
	private Map<String, Object> map = new HashMap<>();

    public SampleMapBuilder and(String key, Object value) {
        map.put(key, value);
        return this;
    }

    public Map<String, Object> build() {
        return map;
    }

    public static SampleMapBuilder with(String key, Object value) {
    	SampleMapBuilder mb = new SampleMapBuilder();
        mb.and(key, value);
        return mb;
    }
}
