/*
 * UrgencyMessage.java 2017年11月10日
 * Copyright (c) 2015-2017, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.designpattern.bridge.message;

/**
 * 加急消息类
 * @ClassName: UrgencyMessage 
 * @Description: TODO
 * @author jvbo
 * @date 2017年11月10日
 */
public class UrgencyMessage extends AbstractMessage {
	
	public UrgencyMessage(MessageImplementor impl) {
		super(impl);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void sendMessage(String message, String toUser){
		message = "加急--" + message;
		super.sendMessage(message, toUser);
	}

	/**
	 * 监控指定消息的处理过程
	 * @Description: TODO
	 * @param @param messageId 被监控消息编号
	 * @param @return   
	 * @return Object 监控到消息的处理状态
	 * @throws
	 * @author jvbo
	 * @date 2017年11月10日
	 */
	public Object watch(String messageId) {
		return null;
	}
}
