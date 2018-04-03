/*
 * AmdFactory.java 2017年11月1日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.designpattern.abstractfactory;

public class AmdFactory implements AbstractFactory {

	@Override
	public Cpu createCpu() {
		return new AmdCpu(938);
	}

	@Override
	public Mainboard createMainboard() {
		return new AmdMainboard(938);
	}

}
