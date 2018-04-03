/*
 * Prototype.java 2017年11月2日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.designpattern.prototype.register;

/**
 * 抽象原型角色
 * @ClassName: Prototype 
 * @Description: TODO
 * @author jvbo
 * @date 2017年11月2日
 */
public interface Prototype {
	
	//克隆自身方法
	public Prototype clone();
	
	public String getName();
	
	public void setName(String name);
}
