/*
 * StopThread.java 2018年3月13日
 * Copyright (c) 2015-2018, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.common.study.javase.effective.thread;

import java.util.concurrent.TimeUnit;

public class StopThread {
    /*private static boolean stopRequested;
    public static void main(String[] args) throws InterruptedException {
        Thread backgroundThread = new Thread(new Runnable(){

            @Override
            public void run() {
                int i = 0;
                while(!stopRequested){
                    i++;
                }
            }
            
        });
        backgroundThread.start();
        TimeUnit.SECONDS.sleep(1);
        stopRequested = true;
    }*/
    
    
    
    /*private static boolean stopRequested;
    private static synchronized void requestStop(){
        stopRequested = true;
    }
    private static synchronized boolean stopRequested(){
        return stopRequested;
    }
    public static void main(String[] args) throws InterruptedException {
        Thread backgroundThread = new Thread(new Runnable(){

            @Override
            public void run() {
                int i = 0;
                while(!stopRequested()){
                    i++;
                }
            }
            
        });
        backgroundThread.start();
        TimeUnit.SECONDS.sleep(1);
        requestStop();
    }*/
    
    
    
    private static volatile boolean stopRequested;
    public static void main(String[] args) throws InterruptedException {
        Thread backgroundThread = new Thread(new Runnable(){

            @Override
            public void run() {
                int i = 0;
                while(!stopRequested){
                    i++;
                }
            }
            
        });
        backgroundThread.start();
        TimeUnit.SECONDS.sleep(1);
        stopRequested = true;
    }
}
