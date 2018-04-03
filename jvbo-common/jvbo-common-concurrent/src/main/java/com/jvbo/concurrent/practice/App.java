/*
 * App.java 2018年4月1日
 * Copyright (c) 2015-2018, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.concurrent.practice;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class App {
    public Map<String, Date> lastLogin = Collections.synchronizedMap(new HashMap<String, Date>());

    public Map<String, Date> lastLoginO = new ConcurrentHashMap<>();

    public static void main(String[] args) {
        
    }
    
    
}
