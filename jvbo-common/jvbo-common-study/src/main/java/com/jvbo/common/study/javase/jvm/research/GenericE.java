/*
 * GenericE.java 2018年3月18日
 * Copyright (c) 2015-2018, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.common.study.javase.jvm.research;

import java.util.HashMap;
import java.util.Map;

/**
 * 泛型
 * @ClassName: GenericE 
 * @Description: TODO
 * @author jvbo
 * @date 2018年3月18日
 */
public class GenericE {

    /*public static void main(String[] args) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("hello", "你好");
        map.put("how are you?", "吃了没?");
        System.out.println(map.get("hello"));
        System.out.println(map.get("how are you?"));
    }*/
    
    public static void main(String[] args) {
        Map map = new HashMap();
        map.put("hello", "你好");
        map.put("how are you?", "吃了没?");
        System.out.println(map.get("hello"));
        System.out.println(map.get("how are you?"));
    }
    
}
