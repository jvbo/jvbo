/*
 * ConcretePrototype1.java 2017年11月2日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.designpattern.prototype.sample;

/**
 * 具体原型角色
 * @ClassName: ConcretePrototype1 
 * @Description: TODO
 * @author jvbo
 * @date 2017年11月2日
 */
public class ConcretePrototype1 implements Prototype {
	
	public Prototype clone(){
		Prototype prototype = new ConcretePrototype1();
		return prototype;
	}
	
}
