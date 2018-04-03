/*
 * HeapOOM.java 2018年1月11日
 * Copyright (c) 2015-2017, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.common.study.javase.jvm.research;

import java.util.ArrayList;
import java.util.List;

/**
 * java堆溢出
 * @ClassName: HeapOOM 
 * @Description: vm args: -Xms20M -Xmx20M -XX:+HeapDumpOnOutOfMemoryError
 * @author jvbo
 * @date 2018年1月11日
 */
public class HeapOOM {
    
    static class OOMObject {
        
    }

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<>();
        while(true){
            list.add(new OOMObject());
        }
    }

}
