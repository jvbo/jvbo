/*
 * Client.java 2017年11月10日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.designpattern.proxy;

/**
 * 代理模式-客户端类
 * @ClassName: Client 
 * @Description: TODO
 * @author jvbo
 * @date 2017年11月10日
 */
public class Client {
	
	/**
	 * 代理模式是对象的结构模式,代理模式给某一个对象提供一个代理对象,
	 * 并由代理对象控制对原对象的引用;
	 * 
	 * 所谓代理,就是一个人活着机构代表另一个人或者机构采取行动,
	 * 在一些情况下,一个客户不想或者不能够直接引用一个对象,
	 * 而代理对象可以在客户端和目标对象之前起到中介的作用;
	 */
	
	public static void main(String[] args) {
		AbstractObject obj = new ProxyObject();
		obj.operation();
	}
	
}
