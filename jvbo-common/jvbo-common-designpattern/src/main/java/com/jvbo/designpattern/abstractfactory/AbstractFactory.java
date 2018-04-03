/*
 * AbstractFactory.java 2017年11月1日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.designpattern.abstractfactory;

public interface AbstractFactory {
	//创建cpu对象
	Cpu createCpu();
	
	//创建主板对象
	Mainboard createMainboard();
}
