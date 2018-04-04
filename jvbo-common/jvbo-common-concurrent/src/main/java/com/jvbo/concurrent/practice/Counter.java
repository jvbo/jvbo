/*
 * Counter.java 2018年4月4日
 * Copyright (c) 2015-2018, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.concurrent.practice;

import com.jvbo.concurrent.practice.annotation.GuardedBy;
import com.jvbo.concurrent.practice.annotation.ThreadSafe;

/**
 * 使用java监视器模式的线程安全计数器
 * @ClassName: Counter 
 * @Description: TODO
 * @author jvbo
 * @date 2018年4月4日
 */
@ThreadSafe
public class Counter {
    
    @GuardedBy("this")
    private long value = 0;
    
    public synchronized long getValue(){
        if(value == Long.MAX_VALUE)
            throw new IllegalStateException("counter overflow");
        return ++value;
    }

}
