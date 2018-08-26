/*
 * BaseAbstract.java 2018年8月21日
 * Copyright (c) 2015-2018, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.springboot.kafka.abstractp;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;

import org.springframework.util.CollectionUtils;

import com.alibaba.fastjson.JSON;

public abstract class BaseAbstract {

    private Timer timerTask = null;
    private MoniterTask moniter = null;
    private String str = null;
    private Set<Object> sub = new HashSet<>();
    
    public BaseAbstract(String str){
        this.str = str;
    }
    
    public void start(){
        moniter = new MoniterTask(this);
        this.connect();
        timerTask = new Timer();
        timerTask.schedule(moniter, 1000, 5000);
    }
    
    public void addSub(Object params){
        sub.add(params);
    }
    
    public void connect(){
        System.out.println("str : " + str);
    }
    
    public void reConnect(){
        this.connect();
        this.print();
    }
    
    public void print(){
        if(!CollectionUtils.isEmpty(sub)){
            System.out.println("sub : " + JSON.toJSONString(sub));
        }
    }
}

class MoniterTask extends TimerTask {
    private long startTime = System.currentTimeMillis();
    private int checkTime = 5000;
    private BaseAbstract client = null;

    public void updateTime() {
        startTime = System.currentTimeMillis();
    }

    public MoniterTask(BaseAbstract client) {
        this.client = client;
    }

    public void run() {
        if (System.currentTimeMillis() - startTime > checkTime) {
            client.reConnect();;
        }
        client.print();
    }

}
