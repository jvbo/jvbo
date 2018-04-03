/*
 * WelcomeMessage.java 2017年11月1日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.designpattern.builder.message;

/**
 * 具体产品类WelcomeMessage
 * @ClassName: WelcomeMessage 
 * @Description: TODO
 * @author jvbo
 * @date 2017年11月1日
 */
public class WelcomeMessage extends AutoMessage {
	
	/**
	 * 无参构造子
	 */
	public WelcomeMessage(){
		System.out.println("发送欢迎信息");
	}
	
}
