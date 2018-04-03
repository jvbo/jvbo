/*
 * Client.java 2017年11月10日
 * Copyright (c) 2015-2017, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.designpattern.chain.sample;

/**
 * 责任链模式-客户端类
 * @ClassName: Client 
 * @Description: 责任链模式是一种对象的行为模式;
 * 在责任链模式里,很多对象由每一个对象对其下家的引用而连接起来形成一条链;
 * 请求在这个链上传递,直到链上的某一个对象决定处理此请求;
 * 发出这个请求的客户端并不知道链上的哪一个对象最终处理这个请求,
 * 这使得系统可以在不影响客户端的情况下动态地重新组织和分配责任;
 * @author jvbo
 * @date 2017年11月10日
 */
public class Client {
	/**
	 * 
	 */
	
	public static void main(String[] args) {
		//组装责任链
		Handler handler1 = new ConcreteHandler();
		Handler handler2 = new ConcreteHandler();
		handler1.setSuccessor(handler2);
		//提交请求
		handler1.handleRequester();
	}
}
