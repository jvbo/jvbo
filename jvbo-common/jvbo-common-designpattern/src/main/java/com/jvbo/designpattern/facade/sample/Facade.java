/*
 * Facade.java 2017年11月10日
 * Copyright (c) 2015-2017, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.designpattern.facade.sample;

/**
 * 门面角色类
 * @ClassName: Facade 
 * @Description: TODO
 * @author jvbo
 * @date 2017年11月10日
 */
public class Facade {
	
	//示意方法,满足客户端需要的功能
	public void test(){
		ModuleA a = new ModuleA();
		a.test();
		ModuleB b = new ModuleB();
		b.test();
		ModuleC c = new ModuleC();
		c.test();
	}
}
