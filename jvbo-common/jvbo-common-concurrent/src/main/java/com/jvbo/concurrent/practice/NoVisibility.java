/*
 * NoVisibility.java 2018年4月2日
 * Copyright (c) 2015-2018, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.concurrent.practice;

import com.jvbo.concurrent.practice.annotation.NotThreadSafe;

/**
 * 在没有同步的情况下共享变量(不要这么做)
 * @ClassName: NoVisibility 
 * @Description: TODO
 * @author jvbo
 * @date 2018年4月2日
 */
@NotThreadSafe
public class NoVisibility {
    private static boolean ready;
    private static int number;
    
    public static class ReaderThread extends Thread{
        public void run(){
            while(!ready)
                Thread.yield();
            System.out.println(number);
        }
    }
    
    public static void main(String[] args) {
        new ReaderThread().start();
        number = 42;
        ready = true;
    }
}
