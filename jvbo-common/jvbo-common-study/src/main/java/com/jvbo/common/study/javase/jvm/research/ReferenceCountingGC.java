/*
 * ReferenceCountingGC.java 2018年1月13日
 * Copyright (c) 2015-2017, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.common.study.javase.jvm.research;

/**
 * 引用计数法很难解决循环引用的问题
 * @ClassName: ReferenceCountingGC 
 * @Description: TODO
 * @author jvbo
 * @date 2018年1月13日
 */
public class ReferenceCountingGC {
    /**
     * 1. [root@vm-centos-openjdk8 research]# jvbo-javac ReferenceCountingGC.java
     * 2. [root@vm-centos-openjdk8 java]# jvbo-java -XX:+PrintGCDetails com.jvbo.common.study.javase.jvm.research.ReferenceCountingGC
     * 3. 日志如下
[root@vm-centos-openjdk8 java]# jvbo-java -XX:+PrintGCDetails com.jvbo.common.study.javase.jvm.research.ReferenceCountingGC
[Full GC (System.gc()) [Tenured: 4096K->418K(23296K), 0.0046577 secs] 4669K->418K(24448K), [Metaspace: 2963K->2963K(1056768K)], 0.0084680 secs] [Times: user=0.01 sys=0.01, real=0.01 secs] 
Heap
 def new generation   total 10560K, used 380K [0x00000000e8e00000, 0x00000000e9970000, 0x00000000f0950000)
  eden space 9408K,   4% used [0x00000000e8e00000, 0x00000000e8e5f078, 0x00000000e9730000)
  from space 1152K,   0% used [0x00000000e9730000, 0x00000000e9730000, 0x00000000e9850000)
  to   space 1152K,   0% used [0x00000000e9850000, 0x00000000e9850000, 0x00000000e9970000)
 tenured generation   total 23296K, used 418K [0x00000000f0950000, 0x00000000f2010000, 0x0000000100000000)
   the space 23296K,   1% used [0x00000000f0950000, 0x00000000f09b8970, 0x00000000f09b8a00, 0x00000000f2010000)
 Metaspace       used 2974K, capacity 4486K, committed 4864K, reserved 1056768K
  class space    used 285K, capacity 386K, committed 512K, reserved 1048576K
[Verifying threads heap tenured generation def new generation remset syms strs zone dict cldg metaspace chunks hand C-heap code cache ]
     */
    
    public Object instance = null;
    
    private static final int _1MB = 1024 * 1024;
    
    /**
     * 这个成员属性的意义就是占点内存,以便能在GC日志中看清楚是否被回收过
     */
    private byte[] bigSize = new byte[2 * _1MB];

    public static void testGC(){
        ReferenceCountingGC objA = new ReferenceCountingGC();
        ReferenceCountingGC objB = new ReferenceCountingGC();
        objA.instance = objB;
        objB.instance = objA;
        
        objA = null;
        objB = null;
        
        // 假设此行发生GC,objA和objB是否能被回收
        System.gc();
    }
    
    public static void main(String[] args) {
        testGC();
    }
}
