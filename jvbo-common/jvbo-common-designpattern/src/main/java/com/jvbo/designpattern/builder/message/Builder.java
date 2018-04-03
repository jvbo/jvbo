/*
 * Builder.java 2017年11月1日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.designpattern.builder.message;

import java.util.Date;

/**
 * 抽象建造者类
 * @ClassName: Builder 
 * @Description: TODO
 * @author jvbo
 * @date 2017年11月1日
 */
public abstract class Builder {
	
	protected AutoMessage msg;
	
	abstract void buildSubject();
	
	abstract void buildBody();
	
	void buildTo(String to){
		msg.setTo(to);
	}
	
	void buildFrom(String from){
		msg.setFrom(from);
	}
	
	void buildSendDate(){
		msg.setSendDate(new Date());
	}
	
	/**
	 * 邮件产品完成后,用此方法发送邮件，
	 * 此方法相当于产品返还方法
	 * @Description: TODO
	 * @param    
	 * @return void  
	 * @throws
	 * @author jvbo
	 * @date 2017年11月1日
	 */
	public void sendMessage(){
		msg.send();
	}
}
