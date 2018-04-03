/*
 * GoodbyeBuilder.java 2017年11月1日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.designpattern.builder.message;

/**
 * 具体建造者GoodbyeBuilder
 * @ClassName: GoodbyeBuilder 
 * @Description: TODO
 * @author jvbo
 * @date 2017年11月1日
 */
public class GoodbyeBuilder extends Builder {

	public GoodbyeBuilder() {
		msg = new GoodbyeMessage();
	}

	@Override
	void buildSubject() {
		msg.setSubject("欢送标题");
	}

	@Override
	void buildBody() {
		msg.setBody("欢送内容");
	}

}
