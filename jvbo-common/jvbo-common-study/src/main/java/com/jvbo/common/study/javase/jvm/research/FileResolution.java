/*
 * FileResolution.java 2018年1月20日
 * Copyright (c) 2015-2017, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.common.study.javase.jvm.research;

/**
 * 字段解析
 * @ClassName: FileResolution 
 * @Description: TODO
 * @author jvbo
 * @date 2018年1月20日
 */
public class FileResolution {
    
    interface Interface0 {
        int A = 0;
    }
    
    interface Interface1 extends Interface0 {
        int A = 1;
    }
    
    interface Interface2 {
        int A = 2;
    }
    
    static class Parent implements Interface1 {
        public static int A = 3;
    }
    
    static class Sub extends Parent implements Interface2{
        public static int A = 4;
    }
    
    public static void main(String[] args) {
        System.out.println(Sub.A);
    }

}
