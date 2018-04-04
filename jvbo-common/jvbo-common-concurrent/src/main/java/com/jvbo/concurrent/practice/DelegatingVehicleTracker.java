/*
 * DelegatingVehicleTracker.java 2018年4月4日
 * Copyright (c) 2015-2018, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.concurrent.practice;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import com.jvbo.concurrent.practice.annotation.ThreadSafe;

@ThreadSafe
public class DelegatingVehicleTracker {
    private final ConcurrentMap<String, Point> locations;
    private final Map<String, Point> unmodifiableMap;
    
    public DelegatingVehicleTracker(Map<String, Point> points){
        locations = new ConcurrentHashMap<>(points);
        unmodifiableMap = Collections.unmodifiableMap(locations);
    }
    
    /**
     * 实时拷贝
     * @Description: TODO
     * @param @return   
     * @return Map<String,Point>  
     * @throws
     * @author jvbo
     * @date 2018年4月4日
     */
    /*public Map<String, Point> getLocations(){
        return unmodifiableMap;
    }*/
    
    /**
     * 静态拷贝
     * @Description: TODO
     * @param @return   
     * @return Map<String,Point>  
     * @throws
     * @author jvbo
     * @date 2018年4月4日
     */
    public Map<String, Point> getLocations(){
        return Collections.unmodifiableMap(new HashMap<>(locations));
    }
    
    public Point getLocation(String id){
        return locations.get(id);
    }
    
    public void setLocation(String id, int x, int y){
        if(locations.replace(id, new Point(x, y)) == null)
            throw new IllegalArgumentException("invalid vehicle name:" + id);
    }
}
