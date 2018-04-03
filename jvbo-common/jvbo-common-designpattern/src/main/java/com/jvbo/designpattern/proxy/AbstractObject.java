/*
 * AbstractObject.java 2017年11月10日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.designpattern.proxy;

/**
 * 抽象对象角色
 * @ClassName: AbstractObject 
 * @Description: 声明目标对象和代理对象的共同接口,
 * 这样在任何可以使用目标对象的地方都可以使用代理对象
 * @author jvbo
 * @date 2017年11月10日
 */
public abstract class AbstractObject {
	
	//操作
	public abstract void operation();
	
}
