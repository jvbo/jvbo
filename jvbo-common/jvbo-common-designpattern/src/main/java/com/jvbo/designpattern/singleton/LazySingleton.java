/*
 * LazySingleton.java 2017年10月31日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.designpattern.singleton;

/**
 * 懒汉式单例
 * @ClassName: LazySingleton 
 * @Description: TODO
 * @author jvbo
 * @date 2017年10月31日
 */
public class LazySingleton {
	
	/**
	 * 1.私有默认构造方法
	 * 2.静态工厂方法(synchronized同步、懒加载，使用时创建对象)
	 */
	private static LazySingleton instance = null;
	
	private LazySingleton(){}
	
	public static synchronized LazySingleton getInstance(){
		if(instance == null){
			instance = new LazySingleton();
		}
		return instance;
	}
	
	
}
/**
 * 1.类加载时未创建对象实例，使用时才创建，节约内存空间；
 * 2.每次创建时判断，浪费了时间，时间换空间；
 * 3.其实现是线程安全的，会降低整体访问速度；
 */