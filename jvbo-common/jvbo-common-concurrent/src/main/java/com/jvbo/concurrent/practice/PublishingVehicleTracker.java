/*
 * PublishingVehicleTracker.java 2018年4月4日
 * Copyright (c) 2015-2018, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.concurrent.practice;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.jvbo.concurrent.practice.annotation.ThreadSafe;

/**
 * 安全发布底层状态的车辆追踪器
 * @ClassName: PublishingVehicleTracker 
 * @Description: TODO
 * @author jvbo
 * @date 2018年4月4日
 */
@ThreadSafe
public class PublishingVehicleTracker {
    private final Map<String, SafePoint> locations;
    private final Map<String, SafePoint> unmodifiableMap;
    
    public PublishingVehicleTracker(Map<String, SafePoint> locations){
        this.locations = new ConcurrentHashMap<>(locations);
        this.unmodifiableMap = Collections.unmodifiableMap(this.locations);
    }
    
    public Map<String, SafePoint> getLocations(){
        return unmodifiableMap;
    }
    
    public SafePoint getLocation(String id){
        return locations.get(id);
    }
    
    public void setLocation(String id, int x, int y){
        if(!locations.containsKey(id))
            throw new IllegalArgumentException("invalid vehicle name: " + id);
        locations.get(id).set(x, y);
    }
}
