/*
 * Originator.java 2017年11月13日
 * Copyright (c) 2015-2017, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.designpattern.memento.historyOnSelf;

/**
 * 发起人角色同时还兼任负责人角色，也就是说它自己负责保持自己的备忘录对象
 * @ClassName: Originator 
 * @Description: TODO
 * @author jvbo
 * @date 2017年11月13日
 */
public class Originator {
	
	public String state;
	
	/**
	 * 改变状态
	 * @Description: TODO
	 * @param @param state   
	 * @return void  
	 * @throws
	 * @author jvbo
	 * @date 2017年11月13日
	 */
	public void changeState(String state){
        this.state = state;
        System.out.println("状态改变为：" + state);
    }
	
	//工厂方法,返回一个新的备忘录对象
	public Memento createMemento(){
		return new Memento(this);
	}
	
	//将发起人恢复到备忘录对象所记载的状态
	public void restoreMement(MementoIF memento){
		Memento m = (Memento)memento;
        changeState(m.state);
	}
	
	public class Memento implements MementoIF {
		
		private String state;

		public Memento(Originator o) {
			this.state = o.state;
		}
		
		/**
		 * @return the state
		 */
		public String getState() {
			return state;
		}
		
	}

}
