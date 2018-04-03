/*
 * ConcretePrototype1.java 2017年11月2日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.designpattern.prototype.register;

/**
 * 具体原型角色
 * @ClassName: ConcretePrototype1 
 * @Description: TODO
 * @author jvbo
 * @date 2017年11月2日
 */
public class ConcretePrototype1 implements Prototype {
	
	private String name;
	
	@Override
	public Prototype clone(){
		Prototype prototype = new ConcretePrototype1();
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
		return "ConcretePrototype1 [name=" + name + "]";
	}
}
