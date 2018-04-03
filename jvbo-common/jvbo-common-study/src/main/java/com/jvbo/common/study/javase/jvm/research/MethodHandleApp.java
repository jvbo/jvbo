/*
 * MethodHandleApp.java 2018年3月17日
 * Copyright (c) 2015-2018, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.common.study.javase.jvm.research;

import java.lang.invoke.MethodType;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;

/**
 * 动态确定目标方法
 * @ClassName: MethodHandleApp 
 * @Description: TODO
 * @author jvbo
 * @date 2018年3月17日
 */
public class MethodHandleApp {
    
    static class ClassA{
        public void println(String s){
            System.out.println(s);
        }
    }
    
    public static void main(String[] args) throws Throwable {
         Object obj = System.currentTimeMillis() % 2 == 0 ? System.out : new ClassA();
         /*无论obj最终是哪个实现类,下面这句都能正确调用到println方法*/
         getPrintMH(obj).invokeExact("icyfenix");
    }

    private static MethodHandle getPrintMH(Object reciever) throws NoSuchMethodException, IllegalAccessException {
        MethodType mt = MethodType.methodType(void.class, String.class);
        return MethodHandles.lookup().findVirtual(reciever.getClass(), "println", mt).bindTo(reciever);
    }

}
