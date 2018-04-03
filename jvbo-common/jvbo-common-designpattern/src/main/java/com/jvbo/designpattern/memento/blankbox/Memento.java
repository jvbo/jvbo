/*
 * Memento.java 2017年11月13日
 * Copyright (c) 2015-2017, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.designpattern.memento.blankbox;

/**
 * 备忘录角色
 * @ClassName: Memento 
 * @Description: TODO
 * @author jvbo
 * @date 2017年11月13日
 */
public class Memento {
	
	private String state;

	public Memento(String state) {
		this.state = state;
	}
	
	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

}
