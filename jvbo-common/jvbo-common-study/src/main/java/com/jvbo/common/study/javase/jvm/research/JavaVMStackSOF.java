/*
 * JavaVMStackSOF.java 2018年1月11日
 * Copyright (c) 2015-2017, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.common.study.javase.jvm.research;

/**
 * 虚拟机栈和本地方法栈溢出
 * @ClassName: JavaVMStackSOF 
 * @Description: vm args: -Xss128k(这里在jvbo-openjdk8上提示至少236k)
 * @author jvbo
 * @date 2018年1月11日
 */
public class JavaVMStackSOF {
    
    private int stackLength = 1;
    
    public void stackLeak(){
        stackLength ++;
        stackLeak();
    }

    public static void main(String[] args) throws Throwable {
        JavaVMStackSOF oom = null;
        try {
            oom =  new JavaVMStackSOF();
            oom.stackLeak();
        } catch (Exception e) {
            System.out.println("stack length:" + oom.stackLength);
            throw e;
        }
    }

}
