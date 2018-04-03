/*
 * CommonMessage.java 2017年11月10日
 * Copyright (c) 2015-2017, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.designpattern.bridge.message;

/**
 * 普通消息类
 * @ClassName: CommonMessage 
 * @Description: TODO
 * @author jvbo
 * @date 2017年11月10日
 */
public class CommonMessage extends AbstractMessage {

	public CommonMessage(MessageImplementor impl) {
		super(impl);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void sendMessage(String message, String toUser) {
		//普通消息,直接调用父类方法
		super.sendMessage(message, toUser);
	}

}
