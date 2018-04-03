/*
 * ColorPoint.java 2018年1月30日
 * Copyright (c) 2015-2017, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.common.study.javase.effective.equals.two;

import java.awt.Color;

public class ColorPoint extends Point {
    
    private final Color color;

    public ColorPoint(int x, int y, Color color) {
        super(x, y);
        this.color = color;
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
    /*@Override
    public boolean equals(Object obj) {
        if(!(obj instanceof ColorPoint))
            return false;
        return super.equals(obj) && ((ColorPoint)obj).color == color;
    }*/
    
    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Point))
            return false;
        if(!(obj instanceof ColorPoint))
            return obj.equals(this);
        return super.equals(obj) && ((ColorPoint)obj).color == color;
    }
    
    
}
