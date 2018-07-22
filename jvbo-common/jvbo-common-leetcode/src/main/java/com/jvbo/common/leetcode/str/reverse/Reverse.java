/*
 * Reverse.java 2018年5月6日
 * Copyright (c) 2015-2018, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.common.leetcode.str.reverse;

/**
 * 反转字符串
 * @ClassName: Reverse 
 * @Description: TODO
 * @author jvbo
 * @date 2018年5月6日
 */
public class Reverse {
    public static void main(String[] args) {
        String str="hello";
        reverseStr(str);
    }
    
    public static void reverseStr(String str){
        String reverseStr = new StringBuffer(str).reverse().toString();
        System.out.println("input:"+str);
        System.out.println("output:"+reverseStr);
    }
}
