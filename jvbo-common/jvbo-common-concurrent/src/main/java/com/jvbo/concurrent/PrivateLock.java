/*
 * PrivateLock.java 2018年4月4日
 * Copyright (c) 2015-2018, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.concurrent;

import com.jvbo.concurrent.practice.annotation.GuardedBy;

/**
 * 通过一个私有锁来保护状态
 * @ClassName: PrivateLock 
 * @Description: TODO
 * @author jvbo
 * @date 2018年4月4日
 */
public class PrivateLock {
    private final Object myLock = new Object();
    @GuardedBy("this")
    Widget widget;
    
    void someMethod(){
        synchronized(myLock){
            // 访问或者修改widget状态;
        }
    }
    
    private static class Widget{}
}
