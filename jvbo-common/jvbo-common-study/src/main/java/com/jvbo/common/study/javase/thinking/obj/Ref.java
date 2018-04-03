/*
 * Ref.java 2018年3月29日
 * Copyright (c) 2015-2018, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.common.study.javase.thinking.obj;

/**
 * 对象与引用
 * @ClassName: Ref 
 * @Description: TODO
 * @author jvbo
 * @date 2018年3月29日
 */
public class Ref {

    public static void main(String[] args) throws InterruptedException {
        String a = null;
        while(true){
            Thread.sleep(3000);
            System.out.println(a);
        }
    }

}
