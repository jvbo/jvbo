/*
 * Point.java 2018年1月30日
 * Copyright (c) 2015-2017, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.common.study.javase.effective.equals.two;

public class Point {
    private final int x;
    private final int y;
    
    public Point(int x, int y){
        this.x = x;
        this.y = y;
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
        if(!(obj instanceof Point))
            return false;
        Point p = (Point)obj;
        return p.x == x && p.y == y;
    }*/
    
    public boolean equals(Object obj) {
        if(obj == null || obj.getClass() != getClass())
            return false;
        Point p = (Point)obj;
        return p.x == x && p.y == y;
    }
    
    
}
