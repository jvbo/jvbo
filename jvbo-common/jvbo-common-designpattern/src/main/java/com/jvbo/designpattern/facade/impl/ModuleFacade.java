/*
 * ModuleFacade.java 2017年11月10日
 * Copyright (c) 2015-2017, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.designpattern.facade.impl;

/**
 * 门面角色类
 * @ClassName: ModuleFacade 
 * @Description: TODO
 * @author jvbo
 * @date 2017年11月10日
 */
public class ModuleFacade {
	ModuleA a = new ModuleA();
	ModuleB b = new ModuleB();
	ModuleC c = new ModuleC();
	
	//这些是a,b,c模块对子系统外部提供的方法
	public void a1(){
		a.a1();
	}
	public void b1(){
		b.b1();
	}
	public void c1(){
		c.c1();
	}
}
