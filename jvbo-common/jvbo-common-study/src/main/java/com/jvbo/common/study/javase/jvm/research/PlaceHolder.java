/*
 * PlaceHolder.java 2018年3月14日
 * Copyright (c) 2015-2018, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.common.study.javase.jvm.research;

public class PlaceHolder {

    public static void main(String[] args) {
        /*byte[] placeholder = new byte[64 * 1024 * 1024];
        System.gc();*/
        
        
        
        /*{
            byte[] placeholder = new byte[64 * 1024 * 1024];
        }
        System.gc();*/
        
        
        
        {
            byte[] placeholder = new byte[64 * 1024 * 1024];
        }
        int a = 0;
        System.gc();
    }

}
