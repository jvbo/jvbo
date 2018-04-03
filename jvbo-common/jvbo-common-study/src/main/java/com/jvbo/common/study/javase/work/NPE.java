/*
 * NPE.java 2018年2月6日
 * Copyright (c) 2015-2017, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.common.study.javase.work;

import com.alibaba.fastjson.JSON;

public class NPE {
    private int id;
    private int age;
    
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the age
     */
    public int getAge() {
        return age;
    }

    /**
     * @param age the age to set
     */
    public void setAge(int age) {
        this.age = age;
    }

    public static void main(String[] args) {
        NPE npe1 = new NPE();
        System.out.println(JSON.toJSONString(npe1));

        NPE npe2 = null;
        System.out.println(JSON.toJSONString(npe2));
        
        while(true){
            System.out.println(JSON.toJSONString(npe1));
        }
    }
}
