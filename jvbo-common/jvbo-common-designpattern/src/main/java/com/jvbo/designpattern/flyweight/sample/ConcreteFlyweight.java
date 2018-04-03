/*
 * ConcreteFlyweight.java 2017年11月10日
 * Copyright (c) 2015-2017, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.designpattern.flyweight.sample;

/**
 * 具体享元角色
 * @ClassName: ConcreteFlyweight 
 * @Description: 实现抽象享元角色所规定的接口,如果有内蕴状态,
 * 必须负责为内蕴状态提供存储空间
 * @author jvbo
 * @date 2017年11月10日
 */
public class ConcreteFlyweight implements Flyweight {
	
	private Character intrinsicState = null;
	
	//构造函数,内蕴状态作为参数传入
	public ConcreteFlyweight(Character state){
		this.intrinsicState = state;
	}
	
	//外蕴状态作为参数传入方法中,改变方法的行为,但是并不改变对象的内蕴状态
	@Override
	public void operation(String state) {
		// TODO Auto-generated method stub
		System.out.println("intrinsic state = " + this.intrinsicState);
		
		System.out.println("extrinsic state = " + state);
	}

}
