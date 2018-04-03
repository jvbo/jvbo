/*
 * Client.java 2017年11月13日
 * Copyright (c) 2015-2017, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.designpattern.state.sample;

/**
 * 状态模式-客户端类
 * @ClassName: Client 
 * @Description: 状态模式,又称状态对象模式(Pattern of Objects for States),
 * 状态模式是对象的行为模式;状态模式允许一个对象在其内部状态改变的时候改变其行为;
 * 这个对象看上去就像是改变了它的类一样;
 * @author jvbo
 * @date 2017年11月13日
 */
public class Client {
	/**
	 * 环境类Context的行为request()是委派给某一个具体状态类的;
	 * 通过使用多态性原则,可以动态改变环境类Context的属性State的内容,
	 * 使其从指向一个具体状态类变换到指向另一个具体状态类,
	 * 从而使环境类的行为request()由不同的具体状态类来执行;
	 */
	
	public static void main(String[] args) {
		//创建状态
        State state = new ConcreteStateB();
        //创建环境
        Context context = new Context();
        //将状态设置到环境中
        context.setState(state);
        //请求
        context.request("test");
	}
}
