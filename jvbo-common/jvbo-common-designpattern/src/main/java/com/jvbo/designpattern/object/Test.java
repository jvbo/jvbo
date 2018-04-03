/*
 * App.java 2017年6月20日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.designpattern.object;

public class Test {
	public static void main(String[] args) {
		//创建主题对象
		ConcreteSubject subject = new ConcreteSubject();
		//创建观察者对象
		Observer observer = new ConcreteObserver();
		//将观察者对象登记到主题对象上
		subject.attach(observer);
		//改变主题对象状态
		subject.change("new state");
	}
}
