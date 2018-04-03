/*
 * Client.java 2017年11月10日
 * Copyright (c) 2015-2017, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.designpattern.observer.sample;

/**
 * 观察者模式-客户端类
 * @ClassName: Client 
 * @Description: 是对象的行为模式,又叫发布-订阅模式(publish/subscribe),
 * 模型-视图模式(model/view),源-监听器模式(source/listener)模式,或者从属模式(dependents);
 * 其定义了一种一对多的依赖关系,让多个观察者对象同时监听某一个主题对象,这个主题对象在状态上发生变化时,
 * 会通知所有观察者对象,使它们能够自动更新自己;
 * @author jvbo
 * @date 2017年11月10日
 */
public class Client {
	public static void main(String[] args) {
		//创建主题对象
        ConcreteSubject subject = new ConcreteSubject();
        //创建观察者对象
        Observer observer = new ConcreteObserver();
        //将观察者对象登记到主题对象上
        subject.attach(observer);
        //改变主题对象的状态
        subject.change("new state");
	}
}
