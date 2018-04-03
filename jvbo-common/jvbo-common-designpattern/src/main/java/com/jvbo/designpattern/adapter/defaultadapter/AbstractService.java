/*
 * AbstractService.java 2017年11月9日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.designpattern.adapter.defaultadapter;

public abstract class AbstractService implements Target  {
	
	public void serviceOperation1() {
		
	}
	
	public int serviceOperation2() {
		return 0;
	}
	
	public String serviceOperation3() {
		return null;
	}
}
