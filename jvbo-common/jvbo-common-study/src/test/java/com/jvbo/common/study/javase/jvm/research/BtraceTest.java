/*
 * BtraceTest.java 2018年1月16日
 * Copyright (c) 2015-2017, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.common.study.javase.jvm.research;

import com.sun.btrace.annotations.*;
import static com.sun.btrace.BTraceUtils.*;

@BTrace
public class BtraceTest {
    
    @OnMethod(clazz = "com.jvbo.common.study.javase.jvm.research.Btrace", 
            method = "add",
            location = @Location(Kind.RETURN))
    public static void func(@Self com.jvbo.common.study.javase.jvm.research.Btrace instance,
            int a, int b, @Return int result){
        println("调用堆栈:");
        jstack();
        println(strcat("方法参数a:", str(a)));
        println(strcat("方法参数b:", str(b)));
        println(strcat("方法结果:", str(result)));
    }
}
