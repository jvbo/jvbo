/*
 * Subject.java 2017年11月10日
 * Copyright (c) 2015-2017, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.designpattern.observer.pull;

import java.util.ArrayList;
import java.util.List;

/**
 * 拉模型抽象主题类
 * @ClassName: Subject 
 * @Description: TODO
 * @author jvbo
 * @date 2017年11月10日
 */
public abstract class Subject {
	
	//保存注册的观察者对象
	private List<Observer> list = new ArrayList<Observer>();
	
	//注册观察者对象
	public void attach(Observer observer){
        list.add(observer);
        System.out.println("Attached an observer");
    }
	
	//删除观察者对象
	public void detach(Observer observer){
        list.remove(observer);
    }
	
	//通知所有注册的观察者对象
	public void nodifyObservers(){
        for(Observer observer : list){
            observer.update(this);
        }
    }
}
