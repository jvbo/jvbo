/*
 * SafeListener.java 2018年4月2日
 * Copyright (c) 2015-2018, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.concurrent.practice;

import java.awt.Event;
import java.util.EventListener;

public class SafeListener {
    
    private final EventListener listener;
    
    private SafeListener(){
        listener = new EventListener(){
            @SuppressWarnings("unused")
            public void onEvent(Event e){
                doSomething(e);
            }
        };
    }

    protected void doSomething(Event e) {
        // TODO Auto-generated method stub
        
    }
    
    public static SafeListener newInstance(EventSource source){
        SafeListener safe = new SafeListener();
        source.registerListenr(safe.listener);
        return safe;
    }

}
