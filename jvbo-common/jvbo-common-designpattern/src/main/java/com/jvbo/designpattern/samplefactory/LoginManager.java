/*
 * LoginManager.java 2017年10月31日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.designpattern.samplefactory;

/**
 * 工厂类
 * @ClassName: LoginManager 
 * @Description: TODO
 * @author jvbo
 * @date 2017年10月31日
 */
public class LoginManager {
	public static Login factory(String type){
		if("password".equals(type)){
			return new PasswordLogin();
		}else if("passcode".equals(type)){
			return new DomainLogin();
		}else{
			//抛出一个自定义的异常最好
			throw new RuntimeException("未找到登录类型");
		}
	}
}
