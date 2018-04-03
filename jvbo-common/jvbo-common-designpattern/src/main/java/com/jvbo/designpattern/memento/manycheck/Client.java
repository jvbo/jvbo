/*
 * Client.java 2017年11月13日
 * Copyright (c) 2015-2017, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.designpattern.memento.manycheck;

/**
 * 备忘录模式-多重检查点-客户端类
 * @ClassName: Client 
 * @Description: TODO
 * @author jvbo
 * @date 2017年11月13日
 */
public class Client {
	public static void main(String[] args) {
		Originator o = new Originator();
        Caretaker c = new Caretaker(o);
        //改变状态
        o.setState("state 0");
        //建立一个检查点
        c.createMemento();
        //改变状态
        o.setState("state 1");
        //建立一个检查点
        c.createMemento();
        //改变状态
        o.setState("state 2");
        //建立一个检查点
        c.createMemento();
        //改变状态
        o.setState("state 3");
        //建立一个检查点
        c.createMemento();
        //打印出所有检查点
        o.printStates();
        System.out.println("-----------------恢复检查点-----------------");
        //恢复到第二个检查点
        c.restoreMemento(2);
        //打印出所有检查点
        o.printStates();
	}
}
