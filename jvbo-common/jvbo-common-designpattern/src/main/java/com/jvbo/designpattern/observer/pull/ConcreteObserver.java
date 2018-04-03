/*
 * ConcreteObserver.java 2017年11月10日
 * Copyright (c) 2015-2017, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.designpattern.observer.pull;

/**
 * 具体观察者角色
 * @ClassName: ConcreteObserver 
 * @Description: 存储与主题的状态自恰的状态,具体观察者角色实现抽象观察者角色所要求的更新接口,
 * 以便使本身的状态与主题的状态相协调,如果需要,具体观察者角色可以保持一个指向具体主题对象的引用;
 * @author jvbo
 * @date 2017年11月10日
 */
public class ConcreteObserver implements Observer {
    
	public ConcreteObserver(Subject subject){
		subject.attach(this);;
	}
	
	@Override
	public void update(Subject subject) {
		subject.nodifyObservers();
	}

}
