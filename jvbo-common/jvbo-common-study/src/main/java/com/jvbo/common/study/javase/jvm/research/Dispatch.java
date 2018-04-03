/*
 * Dispatch.java 2018年3月16日
 * Copyright (c) 2015-2018, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.common.study.javase.jvm.research;

public class Dispatch {
    
    static class QQ {}
    
    static class _360 {}
    
    public static class Father{
        public void hardChoice(QQ qq){
            System.out.println("father qq");
        }
        
        public void hardChoice(_360 arg){
            System.out.println("father 360");
        }
    }
    
    public static class Son extends Father{
        public void hardChoice(QQ qq){
            System.out.println("son qq");
        }
        
        public void hardChoice(_360 arg){
            System.out.println("son 360");
        }
    }

    public static void main(String[] args) {
        Father father = new Father();
        Father son = new Son();
        father.hardChoice(new _360());
        son.hardChoice(new QQ());
    }

}
