/*
 * Handler.java 2017年11月10日
 * Copyright (c) 2015-2017, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.designpattern.chain.eg;

/**
 * 抽象处理者角色类
 * @ClassName: Handler 
 * @Description: TODO
 * @author jvbo
 * @date 2017年11月10日
 */
public abstract class Handler {
	//持有下一个处理请求的对象
	protected Handler successor = null;

	/**
	 * 取值方法
	 */
	public Handler getSuccessor() {
		return successor;
	}

	/**
	 * 设置下一个处理请求的对象
	 */
	public void setSuccessor(Handler successor) {
		this.successor = successor;
	}
	
	//处理费用申请
	public abstract String handlerFeeRequest(String user, double fee);
}
