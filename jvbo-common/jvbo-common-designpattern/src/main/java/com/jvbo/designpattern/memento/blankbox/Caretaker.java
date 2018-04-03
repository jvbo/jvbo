/*
 * Caretaker.java 2017年11月13日
 * Copyright (c) 2015-2017, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.designpattern.memento.blankbox;

/**
 * 负责人角色
 * @ClassName: Caretaker 
 * @Description: TODO
 * @author jvbo
 * @date 2017年11月13日
 */
public class Caretaker {
	private Memento memento;
	
	//备忘录的取值方法
	public Memento retrieveMemento(){
		return this.memento;
	}
	
	//备忘录的赋值方法
	public void saveMemento(Memento memento){
		this.memento = memento;
	}
}
