/*
 * StaticInnerSingleton.java 2017年10月31日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.designpattern.singleton;

/**
 * 静态内部类单例(类级内部类)
 * @ClassName: StaticInnerSingleton 
 * @Description: TODO
 * @author jvbo
 * @date 2017年10月31日
 */
public class StaticInnerSingleton {
	
	/**
	 * 1.java静态内部类
	 */
	
	private StaticInnerSingleton(){}
	
	/**
	 * 静态内部类，静态的成员式内部类，该内部类的实例与外部类的实例没有绑定关系，
	 * 且只有被调用是才加载，实现了懒加载
	 * @ClassName: SingletonHolder 
	 * @Description: TODO
	 * @author jvbo
	 * @date 2017年10月31日
	 */
	private static class SingletonHolder{
		private static StaticInnerSingleton instance = new StaticInnerSingleton();
	}
	
	public static StaticInnerSingleton getInstance(){
		return SingletonHolder.instance;
	}
	
}

/**
 * 1.静态内部类(类级内部类)
 * 简单点说，类级内部类指的是，有static修饰的成员式内部类。如果没有static修饰的成员式内部类被称为对象级内部类。
 * a.类级内部类相当于其外部类的static成分，它的对象与外部类对象间不存在依赖关系，因此可直接创建。而对象级内部类的实例，是绑定在外部对象实例中的。
 * b.类级内部类中，可以定义静态的方法。在静态方法中只能够引用外部类中的静态成员方法或者成员变量。
 * c.类级内部类相当于其外部类的成员，只有在第一次被使用的时候才被会装载。
 * 
 * 2.多线程缺省同步锁
 * a.由静态初始化器(在静态字段上或static{}块中的初始化器)初始化数据时
 * b.访问final字段时
 * c.在创建线程之前创建对象时
 * d.线程可以看见它将要处理的对象时
 */
