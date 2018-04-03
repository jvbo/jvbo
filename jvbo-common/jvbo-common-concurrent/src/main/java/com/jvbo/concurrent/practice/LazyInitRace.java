/*
 * LazyInitRace.java 2018年4月2日
 * Copyright (c) 2015-2018, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.concurrent.practice;

import com.jvbo.concurrent.practice.annotation.NotThreadSafe;

@NotThreadSafe
public class LazyInitRace {
    private Object instance = null;
    
    public Object getInstance(){
        if(instance == null){
            instance = new Object();
        }
        return instance;
    }
}
