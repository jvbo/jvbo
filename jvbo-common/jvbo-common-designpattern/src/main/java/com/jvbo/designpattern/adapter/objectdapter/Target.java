/*
 * Target.java 2017年11月7日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.designpattern.adapter.objectdapter;

/**
 * 目标角色
 * @ClassName: Target 
 * @Description: TODO
 * @author jvbo
 * @date 2017年11月9日
 */
public interface Target {
	
	//源类Adaptee也有的方法
	void sampleOperation1();
	
	//源类Adaptee没有的方法
	void sampleOperation2();
}
