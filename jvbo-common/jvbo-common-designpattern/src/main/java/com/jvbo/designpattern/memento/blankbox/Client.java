/*
 * Client.java 2017年11月13日
 * Copyright (c) 2015-2017, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.designpattern.memento.blankbox;

/**
 * 备忘录模式-黑箱-客户端类
 * @ClassName: Client 
 * @Description: 又叫做快照模式/Token模式,是对象的行为模式;
 * 备忘录对象是一个用来存储另外一个对象内部状态的快照的对象,
 * 备忘录模式的用意是在不破坏封装的条件下,将一个对象的状态捕捉(Capture)住,
 * 并外部化,存储起来,从而可以在将来合适的时候把这个对象还原到存储起来的状态;
 * 备忘录模式常常与命令模式和迭代子模式一同使用;
 * @author jvbo
 * @date 2017年11月13日
 */
public class Client {
	public static void main(String[] args) {
		Originator o = new Originator();
		Caretaker c = new Caretaker();
		//改变负责人对象的状态
		o.setState("on");
		//创建备忘录对象,并将发起人的状态存储
		c.saveMemento(o.createMemento());
		//修改发起人的状态
		o.setState("off");
		o.restoreMement(c.retrieveMemento());
		
		System.out.println(o.getState());
	}
}
