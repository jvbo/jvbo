/*
 * Client.java 2017年11月10日
 * Copyright (c) 2015-2017, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.designpattern.immutable;

/**
 * 不变模式-客户端类
 * @ClassName: Client 
 * @Description: 一个对象的状态在对象被创建之后就不再变化,这就是所谓的不变模式;
 * @author jvbo
 * @date 2017年11月10日
 */
public class Client {
	/**
	 * 
	 */
	
	public static void main(String[] args) {
		
	}
}
/**
 * 不变模式的优点:
 * 1.因为不能修改一个不变对象的状态,所以可以避免由此引起的不必要的程序错误;
 * 即一个不变的对象要比可变的对象更加容易维护;
 * 2.因为没有任何一个线程能够修改不变对象的内部状态,一个不变对象自动就是线程安全的,
 * 这样就可以省掉处理同步化的开销,一个不变的对象可以自由的被不同的客户端共享;
 * 
 * 不变模式的缺点:
 * 一旦要修改一个不变对象的状态,就只好创建一个新的同类对象,在需要频繁修改不变对象的环境,
 * 会有大量的不变对象作为中间结果被创建出来,再被jvm垃圾回收,这是一种资源上的浪费;
 */
