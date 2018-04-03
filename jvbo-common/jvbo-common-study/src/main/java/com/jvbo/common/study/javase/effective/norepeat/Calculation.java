/*
 * Calculation.java 2018年1月29日
 * Copyright (c) 2015-2017, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.common.study.javase.effective.norepeat;

import java.util.Date;

public class Calculation {
    
    
    public static void main(String[] args) {
        Long start = new Date().getTime();
        Long sum = 0L;
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            sum += i;
        }
        System.out.println("花费时间:" + (new Date().getTime() - start) + "");
        System.out.println(sum);
    }
    
}
