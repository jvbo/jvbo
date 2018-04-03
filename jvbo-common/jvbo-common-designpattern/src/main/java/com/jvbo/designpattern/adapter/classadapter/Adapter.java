/*
 * Adapter.java 2017年11月7日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.designpattern.adapter.classadapter;

/**
 * 适配器角色-适配器类是本模式的核心,适配器把源接口转换成目标接口
 * 这里使用类继承的方式,连接到Adaptee
 * @ClassName: Adapter 
 * @Description: TODO
 * @author jvbo
 * @date 2017年11月9日
 */
public class Adapter extends Adaptee implements Target {

	@Override
	public void sampleOperation1() {
		// TODO Auto-generated method stub

	}
	
	//源类Adaptee没有方法sampleOperation2(),适配器补充上这个方法
	@Override
	public void sampleOperation2() {
		// TODO Auto-generated method stub

	}

}
