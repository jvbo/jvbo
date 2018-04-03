/*
 * EagerSingleton.java 2017年10月31日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.designpattern.singleton;

/**
 * 饿汉式单例
 * @ClassName: EagerSingleton 
 * @Description: TODO
 * @author jvbo
 * @date 2017年10月31日
 */
public class EagerSingleton {
	/**
	 * 1.私有默认构造方法
	 * 2.静态工厂方法
	 */
	private static EagerSingleton instance = new EagerSingleton();
	
	private EagerSingleton(){}
	
	public static EagerSingleton getInstance(){
		return instance;
	}
}
/**
 * 1.类加载时，静态变量instance初始化，调用私有构造方法；
 * 2.在装载类时就创建对象实例，不管用不用，先创建出来，然后每次调用的时候无需做
 * 额外的判断，节省了运行时间，已空间换时间；
 *
 */