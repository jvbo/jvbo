/*
 * MonitorVehicleTracker.java 2018年4月4日
 * Copyright (c) 2015-2018, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.concurrent.practice;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.jvbo.concurrent.practice.annotation.GuardedBy;
import com.jvbo.concurrent.practice.annotation.ThreadSafe;

/**
 * 基于监视器模式的车辆追踪
 * @ClassName: MonitorVehicleTracker 
 * @Description: TODO
 * @author jvbo
 * @date 2018年4月4日
 */
@ThreadSafe
public class MonitorVehicleTracker {
    
    @GuardedBy("this")
    private final Map<String, MutablePoint> locations;
    
    public MonitorVehicleTracker(Map<String, MutablePoint> locations){
        this.locations = deepCopy(locations);
    }
    
    public synchronized Map<String, MutablePoint> getLocations(){
        return deepCopy(locations);
    }
    
    public synchronized MutablePoint getLocation(String id){
        MutablePoint loc = locations.get(id);
        return loc == null ? null : new MutablePoint(loc);
    }
    
    public synchronized void setLocation(String id, int x, int y){
        MutablePoint loc = locations.get(id);
        if(loc == null)
            throw new IllegalArgumentException("no such id:" + id);
        loc.x = x;
        loc.y = y;
    }
    
    private static Map<String, MutablePoint> deepCopy(Map<String, MutablePoint> locatios){
        Map<String, MutablePoint> result = new HashMap<>();
        for (String id : locatios.keySet())
            result.put("id", new MutablePoint(locatios.get(id)));
        return Collections.unmodifiableMap(result);
    }
    
}
