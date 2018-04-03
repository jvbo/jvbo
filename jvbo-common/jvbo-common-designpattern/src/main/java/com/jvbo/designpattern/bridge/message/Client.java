/*
 * Client.java 2017年11月10日
 * Copyright (c) 2015-2017, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.designpattern.bridge.message;

/**
 * 桥梁模式--客户端类
 * @ClassName: Client 
 * @Description: TODO
 * @author jvbo
 * @date 2017年11月10日
 */
public class Client {
	public static void main(String[] args) {
		//创建具体实现对象
		MessageImplementor impl = new MessageSMS();
		//创建普通消息对象
		AbstractMessage message = new CommonMessage(impl);
		message.sendMessage("加班申请速批", "张三");
		
		//将实现方式切换成邮件,再次发送
		impl = new MessageEmail();
		//创建加急消息对象
		message = new UrgencyMessage(impl);
		message.sendMessage("加班申请速批", "张三");
	}
}
/**
 * 桥梁模式优点:
 * 1.分离抽象和实现部分:分离了抽象部分和实现部分,从而极大地提供了系统灵活性;
 * 让抽象部分和实现部分独立出来,分别定义接口,这有助于对系统进行分层,从而产生更好的结构化系统;
 * 2.更好的扩展性:桥梁模式使得抽象部分和实现部分可以分别独立扩展,不会相互影响,提高了可扩展性;
 */