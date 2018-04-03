/*
 * PasswordLogin.java 2017年10月31日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.designpattern.samplefactory;

public class PasswordLogin implements Login {

	@Override
	public boolean verify(String name, String password) {
		//具体业务逻辑
		return true;
	}

}
