/*
 * MessageSMS.java 2017年11月10日
 * Copyright (c) 2015-2017, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.designpattern.bridge.message;

/**
 * 系统内短消息的实现类
 * @ClassName: MessageSMS 
 * @Description: TODO
 * @author jvbo
 * @date 2017年11月10日
 */
public class MessageSMS implements MessageImplementor {

	@Override
	public void send(String message, String toUser) {
		System.out.println("系统内短消息,消息:" + message + "给:" + toUser);
	}

}
