/*
 * SafePoint.java 2018年4月4日
 * Copyright (c) 2015-2018, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.concurrent.practice;

import com.jvbo.concurrent.practice.annotation.GuardedBy;
import com.jvbo.concurrent.practice.annotation.ThreadSafe;

/**
 * 线程安全且可变的Point类
 * @ClassName: SafePoint 
 * @Description: TODO
 * @author jvbo
 * @date 2018年4月4日
 */
@ThreadSafe
public class SafePoint {
    @GuardedBy("this")
    private int x, y;
    
    private SafePoint(int[] a){this(a[0], a[1]);}
    
    public SafePoint(SafePoint p) {
        this(p.get());
    }

    public SafePoint(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public synchronized int[] get() {
        return new int[]{x, y};
    }
    
    public synchronized void set(int x, int y){
        this.x = x;
        this.y = y;
    }
}
