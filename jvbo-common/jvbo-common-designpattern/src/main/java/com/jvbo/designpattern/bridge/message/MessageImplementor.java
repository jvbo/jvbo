/*
 * MessageImplementor.java 2017年11月10日
 * Copyright (c) 2015-2017, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.designpattern.bridge.message;

/**
 * 实现发送消息的统一接口
 * @ClassName: MessageImplementor 
 * @Description: TODO
 * @author jvbo
 * @date 2017年11月10日
 */
public interface MessageImplementor {

	void send(String message, String toUser);

}
