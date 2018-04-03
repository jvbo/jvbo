/*
 * Test.java 2017年10月31日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.designpattern.samplefactory;

/**
 * 简单工厂模式-测试类
 * @ClassName: Test 
 * @Description: TODO
 * @author jvbo
 * @date 2017年10月31日
 */
public class Test {
	
	/**
	 * 优点：简单工厂模式的核心类是工厂类，这个类含有必要的逻辑判断，
	 * 可以决定在什么时候创建哪一个登录验证类的实例，调用者可以免除直接创建对象的责任，
	 * 这种做法实现了对责任的分割，当系统引入新的登录方式的时候无需修改调用者。
	 * 
	 * 缺点：工厂类中集中了所有的创建逻辑，当有复杂的多层次等级结构时，
	 * 所有的业务逻辑都在这个工厂类中实现，当其无法工作时，整个系统都会受到影响。
	 */
	
	public static void main(String[] args) {
		String loginType = "password";
		String name = "name";
		String password = "password";
		Login login = LoginManager.factory(loginType);
		boolean flag = login.verify(name, password);
		if(flag){
			//具体业务逻辑
		}else{
			//具体业务逻辑
		}
	}
}
