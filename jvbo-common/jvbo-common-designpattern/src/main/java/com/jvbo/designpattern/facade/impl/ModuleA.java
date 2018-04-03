/*
 * ModuleA.java 2017年11月10日
 * Copyright (c) 2015-2017, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.designpattern.facade.impl;

/**
 * 子系统角色类
 * @ClassName: ModuleA 
 * @Description: TODO
 * @author jvbo
 * @date 2017年11月10日
 */
public class ModuleA {
	public void a1(){}//提供子系统外部使用方法
	
	//子系统内部模块之间相互调用时使用的方法
	public void a2(){};
	public void a3(){};
}
