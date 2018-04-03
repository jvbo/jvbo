/*
 * IntelCpu.java 2017年11月1日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.designpattern.abstractfactory;

public class IntelCpu implements Cpu {
	
	private int pins = 0;
	
	public IntelCpu(int pins){
		this.pins = pins;
	}
	
	@Override
	public void calculate() {
		System.out.println("intel cpu 针脚数：" + pins);
	}

}
