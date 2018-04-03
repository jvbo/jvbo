/*
 * App.java 2018年3月13日
 * Copyright (c) 2015-2018, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.common.study.javase.effective.reflection;

import java.util.Arrays;
import java.util.Set;

public class App {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        Class<?> cl = null;
        try {
            cl = Class.forName(args[0]);
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found.");
            System.exit(1);
        }
        
        Set<String> s = null;
        try {
            s = (Set<String>)cl.newInstance();
        } catch (InstantiationException e) {
            System.out.println("Class not instantiation.");
            System.exit(1);
        } catch (IllegalAccessException e) {
            System.out.println("Class not accessible.");
            System.exit(1);
        }
        s.addAll(Arrays.asList(args).subList(1, args.length));
        System.out.println(s);
    }
}
