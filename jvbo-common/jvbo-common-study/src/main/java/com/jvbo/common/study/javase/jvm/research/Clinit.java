/*
 * Clinit.java 2018年1月21日
 * Copyright (c) 2015-2017, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.common.study.javase.jvm.research;

/**
 * <clinit>()方法执行过程分析
 * @ClassName: Clinit 
 * @Description: TODO
 * @author jvbo
 * @date 2018年1月21日
 */
public class Clinit {
    /**
     * 注意:同一个类加载器下,一个类型只会初始化一次
     * @ClassName: Parent 
     * @Description: TODO
     * @author jvbo
     * @date 2018年1月21日
     */
    
    /*static {
        i = 0;// 给变量赋值可以正常编译通过
        //System.out.println(i);//非法向前引用 Cannot reference a field before it is defined
    }
    static int i = 1;*/
    
    
    
    /*static class Parent {
        public static int A = 1;
        static {
            A = 2;
        }
    }
    
    static class Sub extends Parent {
        public static int B = A;
    }
    
    public static void main(String[] args) {
        System.out.println(Sub.B);// 结果是2 
    }*/
    
    
    
    static class DeadLoopClass {
        static {
            /**
             * 如果不加上这个if语句,ide提示"Initializer does not complete normally"并拒绝编译
             */
            if (true) {
                System.out.println(Thread.currentThread() + "init DeadLoopClass");
                while (true) {
                    
                }
            }
        }
    }
    
    public static void main(String[] args) {
        Runnable script = new Runnable(){

            @Override
            public void run() {
                System.out.println(Thread.currentThread() + "start");
                DeadLoopClass dlc = new DeadLoopClass();
                System.out.println(Thread.currentThread() + "run over");
            }
            
        };
        
        Thread thread1 = new Thread(script);
        Thread thread2 = new Thread(script);
        thread1.start();
        thread2.start();
    }
    
}