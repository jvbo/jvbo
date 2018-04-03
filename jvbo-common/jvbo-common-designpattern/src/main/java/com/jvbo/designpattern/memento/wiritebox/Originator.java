/*
 * Originator.java 2017年11月13日
 * Copyright (c) 2015-2017, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.designpattern.memento.wiritebox;

/**
 * 发起人角色
 * @ClassName: Originator 
 * @Description: TODO
 * @author jvbo
 * @date 2017年11月13日
 */
public class Originator {
	
	private String state;
	
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
		System.out.println("赋值状态:" + this.state);
	}

	//工厂方法,返回一个新的备忘录对象
	public MementoIF createMemento(){
		return new Memento(state);
	}
	
	//将发起人恢复到备忘录对象所记载的状态
	public void restoreMement(MementoIF memento){
		this.setState(((Memento)memento).getState());
	}
	
	public class Memento implements MementoIF {
		
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

}
