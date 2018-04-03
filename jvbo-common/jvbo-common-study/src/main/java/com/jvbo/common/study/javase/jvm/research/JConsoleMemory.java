/*
 * JConsoleMemory.java 2018年1月16日
 * Copyright (c) 2015-2017, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.common.study.javase.jvm.research;

import java.util.ArrayList;
import java.util.List;

/**
 * 检测JConsole工具内存监控的功能
 * @ClassName: JConsoleMemory 
 * @Description: vm args: -Xms100M -Xmx100M -XX:+UseSerialGC
 * @author jvbo
 * @date 2018年1月16日
 */
public class JConsoleMemory {
    
    /**
     * 
1. F:\software\git\repo\jvbo-common\jvbo-common\jvbo-common-study\src\main\java\com
\jvbo\common\study\javase\jvm\research>javac -encoding UTF-8 JConsoleMemory.java
2. F:\software\git\repo\jvbo-common\jvbo-common\jvbo-common-study\src\main\java>jav
a -Xms100M -Xmx100M -XX:+UseSerialGC com.jvbo.common.study.javase.jvm.research.J
ConsoleMemory
     */
    
    // 一个64K
    static class OOMObject{
        public byte[] placeholder = new byte[64 * 1024];
    }
    
    public static void fillHeap(int num) throws InterruptedException{
        List<OOMObject> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            // 稍作延时,令监视曲线的变化更加明显
            Thread.sleep(50);
            list.add(new OOMObject());
        }
        System.gc();
    }

    public static void main(String[] args) throws Exception {
        fillHeap(1000);
    }

}
