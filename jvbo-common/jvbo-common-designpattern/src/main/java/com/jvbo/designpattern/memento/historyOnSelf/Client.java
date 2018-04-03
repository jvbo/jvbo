/*
 * Client.java 2017年11月13日
 * Copyright (c) 2015-2017, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.designpattern.memento.historyOnSelf;

/**
 * 备忘录模式-自述历史-客户端类
 * @ClassName: Client 
 * @Description: TODO
 * @author jvbo
 * @date 2017年11月13日
 */
public class Client {
	public static void main(String[] args) {
		Originator o = new Originator();
        //修改状态
        o.changeState("state 0");
        //创建备忘录
        MementoIF memento = o.createMemento();
        //修改状态
        o.changeState("state 1");
        //按照备忘录恢复对象的状态
        o.restoreMement(memento);
	}
}
