/*
 * Point.java 2018年4月4日
 * Copyright (c) 2015-2018, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.concurrent.practice;

import com.jvbo.concurrent.practice.annotation.Immutable;

@Immutable
public class Point {
    
    public final int x, y;
    
    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }
    
}
