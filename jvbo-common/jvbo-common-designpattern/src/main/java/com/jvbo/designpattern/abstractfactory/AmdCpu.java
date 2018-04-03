/*
 * AmdCpu.java 2017年11月1日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.designpattern.abstractfactory;

public class AmdCpu implements Cpu {
	
	private int pins = 0;
	
	public AmdCpu(int pins){
		this.pins = pins;
	}
	
	@Override
	public void calculate() {
		System.out.println("amd cpu针脚数：" + pins);
	}

}
