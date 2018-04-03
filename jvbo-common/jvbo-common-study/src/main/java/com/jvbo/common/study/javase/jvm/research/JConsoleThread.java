/*
 * JConsoleThread.java 2018年1月16日
 * Copyright (c) 2015-2017, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.common.study.javase.jvm.research;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 检测JConsole工具线程监控的功能
 * @ClassName: JConsoleThread 
 * @Description: TODO
 * @author jvbo
 * @date 2018年1月16日
 */
public class JConsoleThread {
    
    /**
     * 线程死循环演示
     * @Description: TODO
     * @param    
     * @return void  
     * @throws
     * @author jvbo
     * @date 2018年1月16日
     */
    public static void createBusyThread(){
        Thread thread = new Thread(new Runnable(){

            @Override
            public void run() {
                while(true);
            }
            
        }, "testBusyThread");
        thread.start();
    }
    
    public static void createLockThread(final Object lock){
        Thread thread = new Thread(new Runnable(){

            @Override
            public void run() {
                synchronized (lock) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }
            
        }, "testLockThread");
        thread.start();
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        createBusyThread();
        br.ready();
        
        Object obj = new Object();
        createLockThread(obj);
    }
    
    /**
     * 线程死锁等待演示
     */
    /*static class SynAddRunnable implements Runnable {
        int a, b;
        public SynAddRunnable(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public void run() {
            synchronized (Integer.valueOf(a)){
                synchronized (Integer.valueOf(b)){
                    System.out.println(a + b);
                }
            }
        }
    }
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(new SynAddRunnable(1, 2)).start();
            new Thread(new SynAddRunnable(2, 1)).start();
        }
    }*/

}
