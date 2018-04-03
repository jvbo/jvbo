/*
 * ColorPoint.java 2018年1月30日
 * Copyright (c) 2015-2017, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.common.study.javase.effective.equals.three;

import java.awt.Color;

import com.jvbo.common.study.javase.effective.equals.two.Point;

public class ColorPoint {
    
    private final Point point;
    private final Color color;
    
    public ColorPoint(int x, int y, Color color){
        if(color == null)
            throw new NullPointerException();
        point = new Point(x, y);
        this.color = color;
    }
    
    public Point asPoint(){
        return point;
    }

    /**
     * @Description: TODO
     * @param @param obj
     * @param @return   
     * @return  
     * @throws
     * @author jvbo
     * @date 2018年1月30日
     */
    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof ColorPoint))
            return false;
        ColorPoint cp = (ColorPoint)obj;
        return cp.point.equals(point) && cp.color.equals(color);
    }
    
}
