/*
 * RealObject.java 2017年11月10日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.designpattern.proxy;

/**
 * 目标对象角色
 * @ClassName: RealObject 
 * @Description: 代理对象所代表的目标对象
 * @author jvbo
 * @date 2017年11月10日
 */
public class RealObject extends AbstractObject {

	@Override
	public void operation() {
		//TODO 业务
		System.out.println("一些操作");
	}

}
