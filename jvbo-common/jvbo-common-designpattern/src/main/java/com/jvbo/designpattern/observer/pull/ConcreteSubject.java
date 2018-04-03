/*
 * ConcreteSubject.java 2017年11月10日
 * Copyright (c) 2015-2017, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.designpattern.observer.pull;

/**
 * 拉模型具体主题类
 * @ClassName: ConcreteSubject 
 * @Description: TODO 
 * @author jvbo
 * @date 2017年11月10日
 */
public class ConcreteSubject extends Subject {
	private String state;
	
	public String getState(){
		return state;
	}
	
	public void change(String newState){
		this.state = newState;
		System.out.println("主题状态为:" + state);
		//状态发生改变，通知各个观察者
        this.nodifyObservers();
	}
}
