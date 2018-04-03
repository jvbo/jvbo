/*
 * OopMap.java 2018年1月15日
 * Copyright (c) 2015-2017, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.common.study.javase.jvm.research;

/**
 * OopMap记录
 * @ClassName: OopMap 
 * @Description: TODO
 * @author jvbo
 * @date 2018年1月15日
 */
public class OopMap {
    /**
     * 1. 查看反汇编代码,先下载hsdis,地址:https://kenai.com/projects/base-hsdis/downloads,也可自行下载源代码编译,将hsdis-*.so放在目录$JAVA_HOME/jre/lib/amd64/server下
     * 2. 执行命令:
1. [root@vm-centos-openjdk8 research]# jvbo-javac OopMap.java
2. [root@vm-centos-openjdk8 java]# jvbo-java -XX:+PrintAssembly com.jvbo.common.study.javase.jvm.research.OopMap
     * 3. result:
  0x00007fec29208f3d: callq  0x00007fec291c2900  ; OopMap{rsi=Oop rdi=Oop off=898}
                                                ;*invokevirtual read
                                                ; - java.io.DataInputStream::readShort@4 (line 312)
                                                ;   {runtime_call}
  0x00007fec29208f42: mov    %rsp,-0x28(%rsp)
  0x00007fec29208f47: sub    $0x80,%rsp
  0x00007fec29208f4e: mov    %rax,0x78(%rsp)
  0x00007fec29208f53: mov    %rcx,0x70(%rsp)
  0x00007fec29208f58: mov    %rdx,0x68(%rsp)
  0x00007fec29208f5d: mov    %rbx,0x60(%rsp)
  0x00007fec29208f62: mov    %rbp,0x50(%rsp)
     * 
     */

    public static void main(String[] args) {
        String str = "111111";
        System.out.println(str.hashCode());
    }

}
