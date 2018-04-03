/*
 * Test.java 2017年11月2日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.designpattern.prototype.sample;

/**
 * 原型模式(简单)-客户端角色类
 * @ClassName: Test 
 * @Description: TODO
 * @author jvbo
 * @date 2017年11月2日
 */
public class Client {
	/**
	 * 原型模式属于对象的创建模式，通过给出一个原型对象来指明所有创建的对象的类型，
	 * 然后用复制这个原型对象的办法创建出更多同类型的对象；
	 */
	//持有需要使用的原型接口对象
	private Prototype prototype;
	
	//构造方法传入需要使用的原型接口对象
	public Client(Prototype prototype){
		this.prototype = prototype;
	}
	
	public void operation(Prototype example){
		//需要创建原型接口的对象
		Prototype copyPrototype = prototype.clone();
		
	}
}
