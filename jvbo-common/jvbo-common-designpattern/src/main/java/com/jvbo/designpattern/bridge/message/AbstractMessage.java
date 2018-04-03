/*
 * AbstractMessage.java 2017年11月10日
 * Copyright (c) 2015-2017, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.designpattern.bridge.message;

/**
 * 消息的统一接口
 * @ClassName: AbstractMessage 
 * @Description: TODO
 * @author jvbo
 * @date 2017年11月10日
 */
public abstract class AbstractMessage {
	
	//持有一个实现部分的对象
	private MessageImplementor impl;
	
	//构造方法,传入实现部分的对象
	public AbstractMessage(MessageImplementor impl){
		this.impl = impl;
	}
	
	/**
	 * 发送消息,委派给实现部分的方法
	 * @Description: TODO
	 * @param @param message
	 * @param @param toUser   
	 * @return void  
	 * @throws
	 * @author jvbo
	 * @date 2017年11月10日
	 */
	public void sendMessage(String message, String toUser){
		this.impl.send(message, toUser);
	}
}
