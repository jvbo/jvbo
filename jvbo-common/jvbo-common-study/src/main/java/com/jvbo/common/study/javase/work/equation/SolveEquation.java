/*
 * SolveEquation.java 2018年8月14日
 * Copyright (c) 2015-2018, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.common.study.javase.work.equation;

public class SolveEquation {
    
    public static void getResult(final double a, final double b, final double c) {
        System.out.printf("方程: %fx^2+%fx+%f=0%n", a, b, c);
        double k = Math.pow(b, 2) - 4 * a * c;
        if (k > 0) {
            double root1 = (-b + Math.sqrt(k)) / (2 * a);
            double root2 = (-b - Math.sqrt(k)) / (2 * a);
            System.out.println("两个解:" + root1 + "或" + root2);
        } else if (k == 0) {
            double root = -b / (2 * a);
            System.out.println("一个解:" + root);
        } else {
            System.out.println("无解!");
        }
    }
    
    public static void main(String[] args) {
        /**
         * 正根(-b+Math.pow((b*b-4*a*c),0.5))/(2*a);
         * 负根(-b-Math.pow((b*b-4*a*c),0.5))/(2*a);
         */
        getResult(1, 2, 1);
        
        getResult(1, -2, 1);
    }
}
