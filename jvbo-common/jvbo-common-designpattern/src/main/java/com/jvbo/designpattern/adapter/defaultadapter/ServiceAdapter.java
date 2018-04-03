/*
 * ServiceAdapter.java 2017年11月9日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.designpattern.adapter.defaultadapter;

/**
 * 适配器角色
 * @ClassName: ServiceAdapter 
 * @Description: TODO
 * @author jvbo
 * @date 2017年11月9日
 */
public class ServiceAdapter extends AbstractService {
	
	/**
	 * 缺省适配,是为了方便建立一个不平庸的适配器类而提供的一种平庸实现;
	 */
	
	@Override
	public String serviceOperation3() {
		return null;
	}

}
