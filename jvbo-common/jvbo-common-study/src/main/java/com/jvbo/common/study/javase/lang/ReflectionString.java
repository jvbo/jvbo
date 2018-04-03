/*
 * ReflectionString.java 2018年4月3日
 * Copyright (c) 2015-2018, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.common.study.javase.lang;

import java.lang.reflect.Field;

/**
 * 通过反射改变不可变的String
 * @ClassName: ReflectionString 
 * @Description: TODO
 * @author jvbo
 * @date 2018年4月3日
 */
public class ReflectionString {
    /**
     * 反射对面向对象的破坏,但是在高级开发人员手中还是利大于弊的;
     */

    public static void main(String[] args) throws NoSuchFieldException, 
        SecurityException, IllegalArgumentException, IllegalAccessException {
        String str = "hello world";
        System.out.println("改变前str:" + str);
        Field valueFieldOfString  = String.class.getDeclaredField("value");
        valueFieldOfString.setAccessible(true);
        char[] value = (char[]) valueFieldOfString.get(str);
        value[1] = '_';
        System.out.println("改变后str:" + str);
    }

}
