/*
 * Abstraction.java 2017年11月10日
 * Copyright (c) 2015-2017, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.designpattern.bridge.sample;

/**
 * 抽象化角色
 * @ClassName: Abstraction 
 * @Description: 抽象化给出的定义,并保存一个对实现化对象的引用
 * @author jvbo
 * @date 2017年11月10日
 */
public abstract class Abstraction {
	protected Implementor impl;
	
	public Abstraction(Implementor impl){
		this.impl = impl;
	}
	
	public void operation(){
		impl.operationImpl();
	}
	
}
