/*
 * Handler.java 2017年11月10日
 * Copyright (c) 2015-2017, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.designpattern.chain.sample;

/**
 * 抽象处理者角色
 * @ClassName: Handler 
 * @Description: 定义出一个处理请求的接口,
 * 如果需要,接口可以定义出一个方法以设定和返回对下家的引用,
 * 这个角色通常由一个抽象类或者接口实现;
 * @author jvbo
 * @date 2017年11月10日
 */
public abstract class Handler {
	//持有后继的责任对象
	protected Handler successor;
	
	//示意处理请求的方法,虽然这个示意方法没有传入参数,但实际是可以传参的,根据需要选择是否传参
	public abstract void handleRequester();
	
	//取值
	public Handler getSuccessor(){
		return successor;
	}
	
	//赋值
	public void setSuccessor(Handler successor){
		this.successor = successor;
	}
}
