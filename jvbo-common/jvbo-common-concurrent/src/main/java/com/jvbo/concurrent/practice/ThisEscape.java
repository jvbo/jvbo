/*
 * ThisEscape.java 2018年4月2日
 * Copyright (c) 2015-2018, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.concurrent.practice;

import java.awt.Event;
import java.util.EventListener;

/**
 * 隐式地使this引用逸出(不要这么做)
 * @ClassName: ThisEscape 
 * @Description: TODO
 * @author jvbo
 * @date 2018年4月2日
 */
public class ThisEscape {
    public ThisEscape(EventSource source){
        source.registerListenr(
                new EventListener(){
                    @SuppressWarnings("unused")
                    public void onEvent(Event e) {
                        // TODO Auto-generated method stub
                        doSomething(e);
                    }
                });
    }

    protected void doSomething(Event e) {
        // TODO Auto-generated method stub
        
    }
}

class EventSource {

    public void registerListenr(EventListener eventListener) {
        // TODO Auto-generated method stub
        
    }

}
