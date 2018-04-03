/*
 * PossiableRecordering.java 2018年3月26日
 * Copyright (c) 2015-2018, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.common.study.javase.jvm.research;

/**
 * 指令重排序
 * @ClassName: PossiableRecordering 
 * @Description: TODO
 * @author jvbo
 * @date 2018年3月26日
 */
public class PossiableRecordering {
    
    static int x = 0, y = 0;
    static int a = 0, b = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread one = new Thread(new Runnable(){

            @Override
            public void run() {
                a = 1;
                x = b;
            }
            
        });
        Thread other = new Thread(new Runnable(){

            @Override
            public void run() {
                b = 1;
                y = a;
            }
            
        });
        
        one.start();
        other.start();
        one.join();
        other.join();
        System.out.println("x:" + x + ",y:" + y);
    }

}
