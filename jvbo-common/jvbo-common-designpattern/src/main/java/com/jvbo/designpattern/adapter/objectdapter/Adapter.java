/*
 * Adapter.java 2017年11月9日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.designpattern.adapter.objectdapter;

/**
 * 适配器角色-使用委托方式连接到Adaptee
 * @ClassName: Adapter 
 * @Description: TODO
 * @author jvbo
 * @date 2017年11月9日
 */
public class Adapter {
	private Adaptee adaptee;
	
	public Adapter(Adaptee adaptee){
		this.adaptee = adaptee;
	}
	
	//源类Adaptee有方法sampleOperation1,直接委派
	public void sampleOperation1(){
		this.adaptee.sampleOperate1();
	}
	
	//源类Adaptee没有方法sampleOperation2,由适配器类补充
	public void sampleOperation2(){
		//业务逻辑
		
	}
	
}
