/*
 * Client.java 2017年11月10日
 * Copyright (c) 2015-2017, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.designpattern.facade.impl;

/**
 * 门面模式-客户端类
 * @ClassName: Client 
 * @Description: TODO
 * @author jvbo
 * @date 2017年11月10日
 */
public class Client {
	
	public static void main(String[] args) {
		ModuleFacade facade = new ModuleFacade();
		facade.a1();
		facade.b1();
		facade.c1();
	}
	
}

/**
 * 门面模式优点:
 * 1.松散耦合:门面模式松散了客户端和子系统的耦合关系,让子系统内部的模块更容易扩展和维护;
 * 2.简单易用:让子系统更加易用,客户端不在需要了解子系统内部的实现,也不需要和众多子系统内部的模块交互,只需和门面类交互即可;
 * 3.更好的划分访问层次:合理使用Facade,可以帮助我们更好地划分访问层次,有些方法是对系统外的,有些方法是系统内部使用的,
 * 把需要暴露给外部的功能集中到门面中,这样既方便客户端使用,也很好的隐藏了内部的细节;
 */
