/*
 * ConcretePrototype2.java 2017年11月2日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.designpattern.prototype.sample;

public class ConcretePrototype2 implements Prototype {
	
	public Prototype clone(){
		Prototype prototype = new ConcretePrototype2();
		return prototype;
	}
	
}
