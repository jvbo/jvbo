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
