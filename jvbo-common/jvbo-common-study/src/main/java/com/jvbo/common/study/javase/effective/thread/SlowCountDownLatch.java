/*
 * SlowCountDownLatch.java 2018年3月14日
 * Copyright (c) 2015-2018, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.common.study.javase.effective.thread;

public class SlowCountDownLatch {
    private int count;
    
    public SlowCountDownLatch(int count){
        if(count < 0){
            throw new IllegalArgumentException(count + " < 0 ");
        }
        this.count = count;
    }
    
    public void await(){
        while(true){
            synchronized(this){
                if(count == 0) return;
            }
        }
    }
    
    public synchronized void countDown(){
        if(count != 0){
            count--;
        }
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
