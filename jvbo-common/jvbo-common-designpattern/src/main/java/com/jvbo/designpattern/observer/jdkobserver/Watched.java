/*
 * Watched.java 2017年11月10日
 * Copyright (c) 2015-2017, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.designpattern.observer.jdkobserver;

import java.util.Observable;

/**
 * 被观察者类
 * @ClassName: Watched 
 * @Description: TODO
 * @author jvbo
 * @date 2017年11月10日
 */
public class Watched extends Observable {
	private String data = "";
	
	public String getData(){
		return this.data;
	}
	
	public void setData(String data){
		if(!this.data.equals(data)){
			this.data = data;
			setChanged();
		}
		notifyObservers();
	}
}
