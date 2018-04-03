/*
 * TestAllocation.java 2018年1月16日
 * Copyright (c) 2015-2017, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.common.study.javase.jvm.research;

/**
 * 内存分配
 * 1. 对象优先在Eden分配
 * 2. 大对象直接进入老年代
 * 3. 长期存活的对象将进入老年代
 * 4. 动态对象年龄判定
 * 5. 空间分配担保
 * @ClassName: TestAllocation 
 * @Description: vm args: -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:PretenureSizeThreshold=3145728
 * @author jvbo
 * @date 2018年1月16日
 */
public class TestAllocation {
    /**
     * 1. 对象优先在Eden分配
1. [root@vm-centos-openjdk8 research]# jvbo-javac TestAllocation.java
2. [root@vm-centos-openjdk8 java]# jvbo-java -client -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 com.jvbo.common.study.javase.jvm.research.TestAllocation 
3. 结果:
[GC (Allocation Failure) [DefNew: 7144K->419K(9216K), 0.0038309 secs] 7144K->6563K(19456K), 0.0039079 secs] [Times: user=0.00 sys=0.00, real=0.01 secs] 
Heap
 def new generation   total 9216K, used 4761K [0x00000000fec00000, 0x00000000ff600000, 0x00000000ff600000)
  eden space 8192K,  53% used [0x00000000fec00000, 0x00000000ff03d8f0, 0x00000000ff400000)
  from space 1024K,  40% used [0x00000000ff500000, 0x00000000ff568c50, 0x00000000ff600000)
  to   space 1024K,   0% used [0x00000000ff400000, 0x00000000ff400000, 0x00000000ff500000)
 tenured generation   total 10240K, used 6144K [0x00000000ff600000, 0x0000000100000000, 0x0000000100000000)
   the space 10240K,  60% used [0x00000000ff600000, 0x00000000ffc00030, 0x00000000ffc00200, 0x0000000100000000)
 Metaspace       used 2973K, capacity 4486K, committed 4864K, reserved 1056768K
  class space    used 285K, capacity 386K, committed 512K, reserved 1048576K
[Verifying threads heap tenured generation def new generation remset syms strs zone dict cldg metaspace chunks hand C-heap code cache ]
     * 
     * 2. 大对象直接进入老年代
1. [root@vm-centos-openjdk8 research]# jvbo-javac TestAllocation.java 
2. [root@vm-centos-openjdk8 java]# jvbo-java -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:PretenureSizeThreshold=3145728 com.jvbo.common.study.javase.jvm.research.TestAllocation
3. 结果
Heap
 def new generation   total 9216K, used 1164K [0x00000000fec00000, 0x00000000ff600000, 0x00000000ff600000)
  eden space 8192K,  14% used [0x00000000fec00000, 0x00000000fed23278, 0x00000000ff400000)
  from space 1024K,   0% used [0x00000000ff400000, 0x00000000ff400000, 0x00000000ff500000)
  to   space 1024K,   0% used [0x00000000ff500000, 0x00000000ff500000, 0x00000000ff600000)
 tenured generation   total 10240K, used 4096K [0x00000000ff600000, 0x0000000100000000, 0x0000000100000000)
   the space 10240K,  40% used [0x00000000ff600000, 0x00000000ffa00010, 0x00000000ffa00200, 0x0000000100000000)
 Metaspace       used 2970K, capacity 4486K, committed 4864K, reserved 1056768K
  class space    used 284K, capacity 386K, committed 512K, reserved 1048576K
[Verifying threads heap tenured generation def new generation remset syms strs zone dict cldg metaspace chunks hand C-heap code cache ]
     * 
     * 3. 长期存活的对象将进入老年代
1. [root@vm-centos-openjdk8 research]# jvbo-javac TestAllocation.java 
2. [root@vm-centos-openjdk8 java]# jvbo-java -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:PretenureSizeThreshold=3145728 -XX:MaxTenuringThreshold=1 com.jvbo.common.study.javase.jvm.research.TestAllocation
3. 结果
[GC (Allocation Failure) [Tenured: 8192K->4770K(10240K), 0.0061690 secs] 9448K->4770K(19456K), [Metaspace: 2963K->2963K(1056768K)], 0.0062989 secs] [Times: user=0.00 sys=0.00, real=0.01 secs] 
Heap
 def new generation   total 9216K, used 246K [0x00000000fec00000, 0x00000000ff600000, 0x00000000ff600000)
  eden space 8192K,   3% used [0x00000000fec00000, 0x00000000fec3d8e0, 0x00000000ff400000)
  from space 1024K,   0% used [0x00000000ff400000, 0x00000000ff400000, 0x00000000ff500000)
  to   space 1024K,   0% used [0x00000000ff500000, 0x00000000ff500000, 0x00000000ff600000)
 tenured generation   total 10240K, used 8866K [0x00000000ff600000, 0x0000000100000000, 0x0000000100000000)
   the space 10240K,  86% used [0x00000000ff600000, 0x00000000ffea8880, 0x00000000ffea8a00, 0x0000000100000000)
 Metaspace       used 2973K, capacity 4486K, committed 4864K, reserved 1056768K
  class space    used 285K, capacity 386K, committed 512K, reserved 1048576K
[Verifying threads heap tenured generation def new generation remset syms strs zone dict cldg metaspace chunks hand C-heap code cache ]
2. [root@vm-centos-openjdk8 java]# jvbo-java -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:PretenureSizeThreshold=3145728 -XX:MaxTenuringThreshold=15 com.jvbo.common.study.javase.jvm.research.TestAllocation
5. 结果
[GC (Allocation Failure) [Tenured: 8192K->4770K(10240K), 0.0059400 secs] 9451K->4770K(19456K), [Metaspace: 2963K->2963K(1056768K)], 0.0060388 secs] [Times: user=0.01 sys=0.00, real=0.01 secs] 
Heap
 def new generation   total 9216K, used 246K [0x00000000fec00000, 0x00000000ff600000, 0x00000000ff600000)
  eden space 8192K,   3% used [0x00000000fec00000, 0x00000000fec3d8e0, 0x00000000ff400000)
  from space 1024K,   0% used [0x00000000ff400000, 0x00000000ff400000, 0x00000000ff500000)
  to   space 1024K,   0% used [0x00000000ff500000, 0x00000000ff500000, 0x00000000ff600000)
 tenured generation   total 10240K, used 8866K [0x00000000ff600000, 0x0000000100000000, 0x0000000100000000)
   the space 10240K,  86% used [0x00000000ff600000, 0x00000000ffea8850, 0x00000000ffea8a00, 0x0000000100000000)
 Metaspace       used 2973K, capacity 4486K, committed 4864K, reserved 1056768K
  class space    used 285K, capacity 386K, committed 512K, reserved 1048576K
[Verifying threads heap tenured generation def new generation remset syms strs zone dict cldg metaspace chunks hand C-heap code cache ]
     * 4. 动态对象年龄判定
1. [root@vm-centos-openjdk8 research]# jvbo-javac TestAllocation.java 
2. [root@vm-centos-openjdk8 java]# jvbo-java -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:PretenureSizeThreshold=3145728 -XX:MaxTenuringThreshold=15 com.jvbo.common.study.javase.jvm.research.TestAllocation
3. 结果
[GC (Allocation Failure) [Tenured: 8192K->5026K(10240K), 0.0064258 secs] 9704K->5026K(19456K), [Metaspace: 2963K->2963K(1056768K)], 0.0065139 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
Heap
 def new generation   total 9216K, used 246K [0x00000000fec00000, 0x00000000ff600000, 0x00000000ff600000)
  eden space 8192K,   3% used [0x00000000fec00000, 0x00000000fec3d8e0, 0x00000000ff400000)
  from space 1024K,   0% used [0x00000000ff400000, 0x00000000ff400000, 0x00000000ff500000)
  to   space 1024K,   0% used [0x00000000ff500000, 0x00000000ff500000, 0x00000000ff600000)
 tenured generation   total 10240K, used 9122K [0x00000000ff600000, 0x0000000100000000, 0x0000000100000000)
   the space 10240K,  89% used [0x00000000ff600000, 0x00000000ffee8890, 0x00000000ffee8a00, 0x0000000100000000)
 Metaspace       used 2973K, capacity 4486K, committed 4864K, reserved 1056768K
  class space    used 285K, capacity 386K, committed 512K, reserved 1048576K
[Verifying threads heap tenured generation def new generation remset syms strs zone dict cldg metaspace chunks hand C-heap code cache ]
     * 
     * 5. 空间分配担保
1. [root@vm-centos-openjdk8 research]# jvbo-javac TestAllocation.java 
2. [root@vm-centos-openjdk8 java]# jvbo-java -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:-PromotionFailureALot com.jvbo.common.study.javase.jvm.research.TestAllocation
3. 结果
[GC (Allocation Failure) [DefNew: 7144K->419K(9216K), 0.0035823 secs] 7144K->4515K(19456K), 0.0036543 secs] [Times: user=0.01 sys=0.00, real=0.00 secs] 
[GC (Allocation Failure) [DefNew: 6652K->419K(9216K), 0.0034021 secs] 10748K->4515K(19456K), 0.0034601 secs] [Times: user=0.01 sys=0.00, real=0.00 secs] 
Heap
 def new generation   total 9216K, used 2713K [0x00000000fec00000, 0x00000000ff600000, 0x00000000ff600000)
  eden space 8192K,  28% used [0x00000000fec00000, 0x00000000fee3d8f0, 0x00000000ff400000)
  from space 1024K,  40% used [0x00000000ff400000, 0x00000000ff468d00, 0x00000000ff500000)
  to   space 1024K,   0% used [0x00000000ff500000, 0x00000000ff500000, 0x00000000ff600000)
 tenured generation   total 10240K, used 4096K [0x00000000ff600000, 0x0000000100000000, 0x0000000100000000)
   the space 10240K,  40% used [0x00000000ff600000, 0x00000000ffa00020, 0x00000000ffa00200, 0x0000000100000000)
 Metaspace       used 2973K, capacity 4486K, committed 4864K, reserved 1056768K
  class space    used 285K, capacity 386K, committed 512K, reserved 1048576K
[Verifying threads heap tenured generation def new generation remset syms strs zone dict cldg metaspace chunks hand C-heap code cache ]
     * 
     */
    
    private static final int _1MB = 1024 * 1024;
    
    /**
     * 1.对象优先在Eden分配
     * @Description: TODO
     * @param    
     * @return void  
     * @throws
     * @author jvbo
     * @date 2018年1月16日
     */
    /*public static void testAllocation(){
        byte[] allocation1, allocation2, allocation3, allocation4;
        allocation1 = new byte[2 * _1MB];
        allocation2 = new byte[2 * _1MB];
        allocation3 = new byte[2 * _1MB];
        allocation4 = new byte[4 * _1MB];// 出现一次MinorGC
    }*/
    
    /**
     * 2. 大对象直接进入老年代
     * @Description: TODO
     * @param    
     * @return void  
     * @throws
     * @author jvbo
     * @date 2018年1月16日
     */
    /*public static void testPretenureSizeThreshold(){
        byte[] allocation;
        allocation = new byte[4 * _1MB];
    }*/
    
    /**
     * 3. 长期存活的对象将进入老年代
     * @Description: TODO
     * @param    
     * @return void  
     * @throws
     * @author jvbo
     * @date 2018年1月16日
     */
    /*public static void testTenuringThreshold(){
        byte[] allocation1, allocation2, allocation3;
        allocation1 = new byte[_1MB / 4];
        // 什么时候进入老年代取决于XX:MaxTenuringThreshold设置
        allocation2 = new byte[4 * _1MB];
        allocation3 = new byte[4 * _1MB];
        allocation3 = null;
        allocation3 = new byte[4 * _1MB];
    }*/
    
    /**
     * 4. 动态对象年龄判定
     * @Description: TODO
     * @param    
     * @return void  
     * @throws
     * @author jvbo
     * @date 2018年1月16日
     */
    /*public static void testTenuringThreshold2(){
        byte[] allocation1, allocation2, allocation3, allocation4;
        allocation1 = new byte[_1MB / 4];
        // allocation1 + allocation2 大于survivor空间一半
        allocation2 = new byte[_1MB / 4];
        allocation3 = new byte[4 * _1MB];
        allocation4 = new byte[4 * _1MB];
        allocation4 = null;
        allocation4 = new byte[4 * _1MB];
    }*/
    
    /**
     * 5. 空间分配担保
     * @Description: TODO
     * @param    
     * @return void  
     * @throws
     * @author jvbo
     * @date 2018年1月16日
     */
    public static void testHandlePromotion(){

        byte[] allocation1, allocation2, allocation3, 
        allocation4, allocation5, allocation6, allocation7;
        allocation1 = new byte[2 * _1MB];
        allocation2 = new byte[2 * _1MB];
        allocation3 = new byte[2 * _1MB];
        allocation1 = null;
        allocation4 = new byte[2 * _1MB];
        allocation5 = new byte[2 * _1MB];
        allocation6 = new byte[2 * _1MB];
        allocation4 = null;
        allocation5 = null;
        allocation6 = null;
        allocation7 = new byte[2 * _1MB];
    }
    
    public static void main(String[] args) {
        //testAllocation();
        //testPretenureSizeThreshold();
        //testTenuringThreshold();
        //testTenuringThreshold2();
        //testHandlePromotion();
        int a = 2;
        Integer b = 4;
        String c = "5";
        test(a, b, c);
        System.out.println("a:" + a + "b:" + b + "c:" + c);
    }

    private static void test(int a, Integer b, String c) {
        a = 3;
        b = 3;
        c = "3";
        System.out.println("a:" + a + "b:" + b + "c:" + c);
    }
}
