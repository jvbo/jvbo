/*
 * App.java 2018年3月28日
 * Copyright (c) 2015-2018, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.common.study.javase.thinking;

import java.util.Random;

public class App {
    
    public static void main(String[] args) {
        System.getProperties().list(System.out);
        Random randA = new Random();
        int i = randA.nextInt();
        System.out.println(i);
        

        Random randB = new Random(47);
        int j = randB.nextInt(20);
        System.out.println(j);
    }
    
}
