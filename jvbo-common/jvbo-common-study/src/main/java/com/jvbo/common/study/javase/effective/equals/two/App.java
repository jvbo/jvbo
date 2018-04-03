/*
 * App.java 2018年1月30日
 * Copyright (c) 2015-2017, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.common.study.javase.effective.equals.two;

import java.util.HashSet;
import java.util.Set;

public class App {
    
    public static void main(String[] args) {
        /*Point p = new Point(1, 2);
        ColorPoint cp = new ColorPoint(1, 2, Color.RED);
        System.out.println(p.equals(cp));
        System.out.println(cp.equals(p));*/
        
        /*ColorPoint p1 = new ColorPoint(1, 2, Color.RED);
        Point p2 = new Point(1, 2);
        ColorPoint p3 = new ColorPoint(1, 2, Color.BLUE);
        System.out.println(p1.equals(p2));
        System.out.println(p2.equals(p3));
        System.out.println(p1.equals(p3));*/
        
        
    }
    
    private static final Set<Point> unitCircle;
    
    static {
        unitCircle = new HashSet<Point>();
        unitCircle.add(new Point(1, 0));
        unitCircle.add(new Point(0, 1));
        unitCircle.add(new Point(-1, 0));
        unitCircle.add(new Point(0, -1));
    }
    
    public static boolean onUnitCircle(Point p){
        return unitCircle.contains(p);
    }
    
}
