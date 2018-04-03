/*
 * Client.java 2017年11月2日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.designpattern.prototype.register;

/**
 * 原型模式(登记形式)-客户端角色类
 * @ClassName: Client 
 * @Description: TODO
 * @author jvbo
 * @date 2017年11月2日
 */
public class Client {
	
	public static void main(String[] args) {
		try {
			Prototype p1= new ConcretePrototype1();
			PrototypeManager .setPrototype("p1", p1);
			//获取原型来创建对象
			Prototype p3 = PrototypeManager.getPrototype("p1");
			p3.setName("张三");
			System.out.println("第一个实例：" + p3);
			//有人动态切换了实现
			Prototype p2 = new ConcretePrototype2();
			PrototypeManager.setPrototype("p1", p2);
			//重新获取原型来创建对象
			Prototype p4 = PrototypeManager.getPrototype("p1").clone();
			p4.setName("李四");
			System.out.println("第二个实例：" + p4);
			//有人注销了这个原型
			PrototypeManager.removePrototype("p1");
			//再次获取原型来创建对象
			Prototype p5 = PrototypeManager.getPrototype("p1").clone();
			p5.setName("王五");
			System.out.println("第三个实例：" + p5);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}

/**
 * java中的克隆(浅克隆和深克隆)
 * 1.浅度克隆
 * 只负责克隆按值传递的数据(比如基本数据类型,String类型),而不复制它所引用的对象,
 * 即所有对其他对象的引用都仍然指向原来的对象;
 * 2.深度克隆
 * 除了浅度克隆要克隆的值外,还负责克隆引用类型的数据,那些引用其他对象的变量将指向被复制过的新对象,
 * 而不再是原有的那些被引用的对象,即深度克隆把要复制的对象所引用的对象都复制了一遍,
 * 而这种对被引用到的对象的复制叫做间接复制,深度克隆要深入到多少层,是一个不易确定的问题;
 * 
 * 实现克隆
 * 1.利用序列化实现深度克隆:把对象写到流里的过程是序列化过程,而把对象从流中读出来的过程叫反序列化;
 * 写到流里的是对象的一个拷贝,而原对象仍然存在于jvm里面;在java中深入克隆一个对象,可以先使对象实现Serializable接口,
 * 然后把对象(实际上只是对象的拷贝)写到一个流里(序列化),再从流里读回来(反序列化),便可以重建对象;
 * 2.java中所有类都会继承一个clone()方法,这个clone()方法所做的正式浅度克隆;
 * 
 * 注:有一些对象,比如线程(Thread)对象或Socket对象,是不能简单复制或共享的,不管是使用深度克隆还是浅度克隆,
 * 只要涉及这样的间接对象,就必须把间接对象设成transient而不予复制,或者由程序自行创建出相当的同种对象,权且当做复制件使用;
 */