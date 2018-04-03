/*
 * ConcretePrototype2.java 2017年11月2日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.designpattern.prototype.register;

public class ConcretePrototype2 implements Prototype {
	
	private String name;
	
	@Override
	public Prototype clone(){
		Prototype prototype = new ConcretePrototype2();
		prototype.setName(this.name);
		return prototype;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "ConcretePrototype2 [name=" + name + "]";
	}
}
