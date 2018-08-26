/*
 * App.java 2018年8月21日
 * Copyright (c) 2015-2018, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.springboot.kafka.abstractp;

import com.alibaba.fastjson.JSONObject;

public class App {
    public static void main(String[] args) {
        UseBase useBase1 = new UseBase("useBase1");
        System.out.println(useBase1);
        useBase1.start();
        JSONObject oneJo = new JSONObject();
        oneJo.put("oneKey", "oneValue");
        useBase1.addSub(oneJo);
        
        UseBase useBase2 = new UseBase("useBase2");
        System.out.println(useBase2);
        useBase2.start();
        JSONObject twoJo = new JSONObject();
        twoJo.put("towKey", "twoValue");
        useBase2.addSub(twoJo);
    }
}
