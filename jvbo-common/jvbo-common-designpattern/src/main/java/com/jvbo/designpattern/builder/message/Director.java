/*
 * Director.java 2017年11月1日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.designpattern.builder.message;

public class Director {
	
	private Builder builder;
	
	public Director(Builder builder) {
		this.builder = builder;
	}
	
	public void construct(String to, String from){
		this.builder.buildTo(to);
		this.builder.buildFrom(from);
		this.builder.buildSubject();
		this.builder.buildBody();
		this.builder.buildSendDate();
		this.builder.sendMessage();
	}
	
}
