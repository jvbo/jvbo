/*
 * Jvm.java 2018年1月11日
 * Copyright (c) 2015-2017, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.common.study.javase.jvm.research;

/**
 * 测试jvbo-opensdk8编译情况
 * @ClassName: Jvm 
 * @Description: TODO
 * @author jvbo
 * @date 2018年1月11日
 */
public class Jvm {
    /**
     * 1. centos7下下载openjdk8源码,编译;
     * 2. jdk目录/opt/software/git/openjdk8/build/linux-x86_64-normal-server-fastdebug/jdk
     *    利用alias自定义3个命令,在全局文件:/etc/bashrc,添加如下:
# jvbo-command
# jvbo-openjdk8-javac
alias jvbo-openjdk8='echo /opt/software/git/openjdk8/build/linux-x86_64-normal-server-fastdebug/jdk'
alias jvbo-javac='"/opt/software/git/openjdk8/build/linux-x86_64-normal-server-fastdebug/jdk/bin/javac" $@'
alias jvbo-java='"/opt/software/git/openjdk8/build/linux-x86_64-normal-server-fastdebug/jdk/bin/java" $@'
     * 3. 项目目录:/opt/software/git/jvbo-common/jvbo-common/jvbo-common-study/
     * 4. 项目java代码目录/opt/software/git/jvbo-common/jvbo-common/jvbo-common-study/src/main/java
     * 5. 项目具体java文件目录:/opt/software/git/jvbo-common/jvbo-common/jvbo-common-study/src/main/java/com/jvbo/common/study/javase/jvm/research
     * 6. 在相关目录执行:
[root@vm-centos-openjdk8 research]# jvbo-javac Jvm.java
[root@vm-centos-openjdk8 java]# jvbo-java -XX:+PrintGCDetails com.jvbo.common.study.javase.jvm.research.Jvm
     */

    public static void main(String[] args) {
        System.out.println(System.getProperty("user.home"));
        System.out.println(System.getProperty("java.version"));
        System.out.println(System.getProperty("os.name"));
        System.out.println(System.getProperty("java.vendor.url"));
    }

}
