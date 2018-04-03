/*
 * NoNew.java 2018年1月29日
 * Copyright (c) 2015-2017, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.common.study.javase.effective.nonew;

/**
 * 强制某类不可被实例化
 * @ClassName: NoNew 
 * @Description: TODO
 * @author jvbo
 * @date 2018年1月29日
 */
public class NoNew {
    
    // Noninstantiable utility class
    private NoNew(){
        // Suppress default constructor for noninstantiability
        throw new AssertionError();
    }
    
    public static void main(String[] args) {
        NoNew.use();
        NoNew noNew = new NoNew();
        noNew.use();
    }
    
    public static void use(){
        System.out.println("use");
    }

}
