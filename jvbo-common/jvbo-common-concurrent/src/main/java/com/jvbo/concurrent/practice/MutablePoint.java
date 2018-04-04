/*
 * MutablePoint.java 2018年4月4日
 * Copyright (c) 2015-2018, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.concurrent.practice;

import com.jvbo.concurrent.practice.annotation.NotThreadSafe;

/**
 * 与 #java.awt.Point 类似的可变Point类(不要这么做)
 * @ClassName: MutablePoint 
 * @Description: TODO
 * @author jvbo
 * @date 2018年4月4日
 */
@NotThreadSafe
public class MutablePoint {

    public int x, y;
    
    public MutablePoint(){x = 0; y = 0;}

    public MutablePoint(MutablePoint loc) {
        this.x = loc.x;
        this.y = loc.y;
    }

}
