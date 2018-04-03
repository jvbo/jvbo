/*
 * NotInitialization.java 2018年1月19日
 * Copyright (c) 2015-2017, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.common.study.javase.jvm.research;

/**
 * 非主动使用类字段演示
 * @ClassName: NotInitialization 
 * @Description: TODO
 * @author jvbo
 * @date 2018年1月19日
 */
public class NotInitialization {
    
    public static void main(String[] args) {
        // 1 被动使用类字段演示一:通过子类引用父类的静态字段,不会导致子类初始化
        //System.out.println(SubClass.value);
        
        // 2 被动使用类字段演示二:通过数组定义来引用类,不会触发此类的初始化;
        //SuperClass[] sca = new SuperClass[10];
        
        // 3 被动使用类子弹演示三:常量在编译阶段会存入调用类的常量池,本质上并没有直接引用到定义
        // 常量的类,因此触发定义常量的类的初始化;
        System.out.println(ConstClass.A);
    }

}

/**
 * 被动使用类字段演示一:
 * 通过子类引用父类的静态字段,不会导致子类初始化
 * @ClassName: SuperClass 
 * @Description: TODO
 * @author jvbo
 * @date 2018年1月19日
 */
class SuperClass{
    
    static {
        System.out.println("SuperClass init");
    }
    
    public static int value = 123;
}

class SubClass extends SuperClass{
    
    static {
        System.out.println("SubClass init");
    }
    
}

class ConstClass {
    static {
        System.out.println("ConstClass init");
    }
    
    public static final String A = "a";
}
