/*
 * IntelMainboard.java 2017年11月1日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.designpattern.abstractfactory;

public class IntelMainboard implements Mainboard {
	
	private int cpuHoles = 0;
	
	public IntelMainboard(int cpuHoles){
		this.cpuHoles = cpuHoles;
	}
	
	@Override
	public void installCpu() {
		System.out.println("intel 主板的cpu插槽孔数：" + cpuHoles);
	}

}
