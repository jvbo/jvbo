/*
 * SynchronizedMean.java 2018年3月19日
 * Copyright (c) 2015-2018, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.common.study.javase.jvm.research;

import java.util.Vector;

/**
 * Vector类验证:线程安全的手段
 * @ClassName: SynchronizedMean 
 * @Description: TODO
 * @author jvbo
 * @date 2018年3月19日
 */
public class SynchronizedMean {
    
    private static Vector<Integer> vector = new Vector<Integer>();

    public static void main(String[] args) {
        while(true){
            for(int i = 0; i < 10; i++)
                vector.add(i);
            
            /*Thread removeThread = new Thread(new Runnable(){

                @Override
                public void run() {
                    for (int i = 0; i < vector.size(); i++) {
                        vector.remove(i);
                    }
                }
                
            });
            
            Thread printThread = new Thread(new Runnable(){

                @Override
                public void run() {
                    for (int i = 0; i < vector.size(); i++) {
                        System.out.println(vector.get(i));
                    }
                }
                
            });*/
            
            Thread removeThread = new Thread(new Runnable(){

                @Override
                public void run() {
                    synchronized(vector){
                        for (int i = 0; i < vector.size(); i++) {
                            vector.remove(i);
                        }
                    }
                }
                
            });
            
            Thread printThread = new Thread(new Runnable(){

                @Override
                public void run() {
                    synchronized(vector){
                        for (int i = 0; i < vector.size(); i++) {
                            System.out.println(vector.get(i));
                        }
                    }
                }
                
            });
            
            removeThread.start();
            printThread.start();

            //不要同时产生过多的线程,防止操作系统假死 
            while(Thread.activeCount() > 20);
        }
    }

}
