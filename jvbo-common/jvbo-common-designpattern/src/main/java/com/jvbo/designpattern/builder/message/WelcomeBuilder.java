/*
 * WelcomBuilder.java 2017年11月1日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.designpattern.builder.message;

/**
 * 具体建造者WelcomBuilder
 * @ClassName: WelcomBuilder 
 * @Description: TODO
 * @author jvbo
 * @date 2017年11月1日
 */
public class WelcomeBuilder extends Builder {

	public WelcomeBuilder() {
		msg = new WelcomeMessage();
	}

	@Override
	void buildSubject() {
		msg.setBody("欢迎内容");
	}

	@Override
	void buildBody() {
		msg.setSubject("欢迎标题");
	}

}
