/*
 * Client.java 2017年11月10日
 * Copyright (c) 2015-2017, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.designpattern.command.sample;

/**
 * 命令模式-客户端类
 * @ClassName: Client 
 * @Description: 创建一个具体命令(ConcreteCommand)对象并确定其接收者;
 * 命令模式属于对象的行为模式;
 * 命令模式又称为行动(Action)模式或交易(Transaction)模式;
 * 命令模式把一个请求或者操作封装到一个对象中,命令模式允许系统使用不同的请求把客户端参数化,
 * 对请求排队或者记录请求日志，可以提供命令的撤销和恢复功能;
 * @author jvbo
 * @date 2017年11月10日
 */
public class Client {
	public static void main(String[] args) {
        //创建接收者
        Receiver receiver = new Receiver();
        //创建命令对象,设定它的接收者
        Command command = new ConcreteCommand(receiver);
        //创建请求者,把命令对象设置进去
        Invoker invoker = new Invoker(command);
        //执行方法
        invoker.action();
    }
}
