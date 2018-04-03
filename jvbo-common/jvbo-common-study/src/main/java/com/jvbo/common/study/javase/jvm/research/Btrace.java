/*
 * Btrace.java 2018年1月16日
 * Copyright (c) 2015-2017, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.common.study.javase.jvm.research;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Btrace测试
 * @ClassName: Btrace 
 * @Description: TODO
 * @author jvbo
 * @date 2018年1月16日
 */
public class Btrace {
    /**
     * 测试脚本 @see #com.jvbo.common.study.javase.jvm.research.BtraceTest
     * @Description: TODO
     * @param @param a
     * @param @param b
     * @param @return   
     * @return int  
     * @throws
     * @author jvbo
     * @date 2018年1月16日
     */
    
    public int add(int a, int b){
        return a + b;
    }

    public static void main(String[] args) throws Exception {
        Btrace test = new Btrace();
        //BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 1000; i++) {
            //reader.readLine();
            Thread.sleep(3000);
            int a = (int) Math.round(Math.random() * 1000);
            int b = (int) Math.round(Math.random() * 1000);
            System.out.println(test.add(a, b));
        }
    }
    
}
