/*
 * Solution.java 2018年2月1日
 * Copyright (c) 2015-2017, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.common.study.javase.work;

public class Solution {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(aplusb(1, 4));
    }

    /*public static int aplusab(int a, int b){
        return 0;
    }*/

    public static int aplusb(int a, int b) {
        while (b!=0){
            int carry = a & b; 
            a = a^b;          
            b = carry << 1;
        }
        return a;
    }

}
