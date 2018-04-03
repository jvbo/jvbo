/*
 * MapOrder.java 2018年1月12日
 * Copyright (c) 2015-2017, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.common.study.javase.collection;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;

public class MapOrder {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Map<String, Object> mapParam = new HashMap<String, Object>();
        mapParam.put("username", "111111");
        mapParam.put("version", 1);
        System.out.println(JSON.toJSONString(mapParam));
        Map<String, Object> mapParams = new LinkedHashMap<String, Object>();
        mapParams.put("username", "111111");
        mapParams.put("version", 1);
        System.out.println(JSON.toJSONString(mapParams));
    }

}
