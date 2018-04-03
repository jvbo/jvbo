/*
 * FinalizeEscapeGC.java 2018年1月14日
 * Copyright (c) 2015-2017, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.common.study.javase.jvm.research;

/**
 * 最后确定对象是否需要回收
 * 代码有以下两个功能:
 * 1. 对象可以在被GC时自我拯救
 * 2. 这种自救机会只有一次,因为一个对象的finalize()方法最多只会被系统调用一次
 * @ClassName: FinalizeEscapeGC 
 * @Description: TODO
 * @author jvbo
 * @date 2018年1月14日
 */
public class FinalizeEscapeGC {
    /**
     * 1.命令:
1. [root@vm-centos-openjdk8 research]# jvbo-javac FinalizeEscapeGC.java
2. [root@vm-centos-openjdk8 java]# jvbo-java -XX:+PrintGCDetails com.jvbo.common.study.javase.jvm.research.FinalizeEscapeGC
3. result:
[Full GC (System.gc()) [Tenured: 0K->418K(23296K), 0.0045987 secs] 573K->418K(24448K), [Metaspace: 2964K->2964K(1056768K)], 0.2326021 secs] [Times: user=0.00 sys=0.23, real=0.23 secs] 
finalize method excuted.
yes, i am still alive.
[Full GC (System.gc()) [Tenured: 418K->420K(23296K), 0.0099361 secs] 972K->420K(33856K), [Metaspace: 3005K->3005K(1056768K)], 0.0100764 secs] [Times: user=0.01 sys=0.00, real=0.01 secs] 
no, i am dead.
Heap
 def new generation   total 10560K, used 234K [0x00000000e8e00000, 0x00000000e9970000, 0x00000000f0950000)
  eden space 9408K,   2% used [0x00000000e8e00000, 0x00000000e8e3a9a8, 0x00000000e9730000)
  from space 1152K,   0% used [0x00000000e9730000, 0x00000000e9730000, 0x00000000e9850000)
  to   space 1152K,   0% used [0x00000000e9850000, 0x00000000e9850000, 0x00000000e9970000)
 tenured generation   total 23296K, used 420K [0x00000000f0950000, 0x00000000f2010000, 0x0000000100000000)
   the space 23296K,   1% used [0x00000000f0950000, 0x00000000f09b9140, 0x00000000f09b9200, 0x00000000f2010000)
 Metaspace       used 3012K, capacity 4486K, committed 4864K, reserved 1056768K
  class space    used 289K, capacity 386K, committed 512K, reserved 1048576K
[Verifying threads heap tenured generation def new generation remset syms strs zone dict cldg metaspace chunks hand C-heap code cache ]
     */
    
    private static FinalizeEscapeGC SAVE_HOOK = null;
    
    public void isAlive(){
        System.out.println("yes, i am still alive.");
    }
    
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize method excuted.");
        FinalizeEscapeGC.SAVE_HOOK = this;
    }



    public static void main(String[] args) throws Throwable {
        SAVE_HOOK = new FinalizeEscapeGC();
        
        //对象第一次成功拯救自己
        SAVE_HOOK = null;
        System.gc();
        
        //finalize()方法优先级很低,所以暂停1秒执行
        Thread.sleep(1000);
        if (SAVE_HOOK != null){
            SAVE_HOOK.isAlive();
        }else{
            System.out.println("no, i am dead.");
        }
        
        // 下面的代码与上面完全一样,但是这次却失败了
        SAVE_HOOK = null;
        System.gc();
        //finalize()方法优先级很低,所以暂停1秒执行
        Thread.sleep(1000);
        if (SAVE_HOOK != null){
            SAVE_HOOK.isAlive();
        }else{
            System.out.println("no, i am dead.");
        }
    }

}
