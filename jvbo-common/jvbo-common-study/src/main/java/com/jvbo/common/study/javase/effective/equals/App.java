/*
 * App.java 2018年1月30日
 * Copyright (c) 2015-2017, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.common.study.javase.effective.equals;

import java.util.HashMap;
import java.util.Map;

/**
 * equals()方法约定
 * @ClassName: App 
 * @Description: TODO
 * @author jvbo
 * @date 2018年1月30日
 */
public class App {
    public static void main(String[] args) {
        /*Equals equals = new Equals("Polish");
        String s = "polish";
        System.out.println(equals.equals(s));
        System.out.println(s.equals(equals));*/
        
        Map<PhoneNumber, String> map = new HashMap<>();
        Short.valueOf("1");
        map.put(new PhoneNumber(Short.valueOf("1"),
                Short.valueOf("11"), 
                Short.valueOf("111")), "Jenny");
        System.out.println(map.get(new PhoneNumber(Short.valueOf("1"),
                Short.valueOf("11"), 
                Short.valueOf("111"))).toString());
        
    }
}
