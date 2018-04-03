/*
 * Client.java 2017年11月10日
 * Copyright (c) 2015-2017, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.designpattern.facade.sample;

/**
 * 门面模式-客户端类
 * @ClassName: Client 
 * @Description: 门面模式是对象的结构模式,外部与一个子系统的通信通过一个统一的门面对象进行,
 * 门面模式提供一个高层次的接口,使得子系统易于使用;
 * @author jvbo
 * @date 2017年11月10日
 */
public class Client {
	/**
	 * 
	 */
	
	public static void main(String[] args) {
		Facade facade = new Facade();
		facade.test();
	}
}
