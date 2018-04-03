/*
 * Originator.java 2017年11月13日
 * Copyright (c) 2015-2017, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.designpattern.memento.manycheck;

import java.util.ArrayList;
import java.util.List;

/**
 * 发起人角色
 * @ClassName: Originator 
 * @Description: TODO
 * @author jvbo
 * @date 2017年11月13日
 */
public class Originator {
	private List<String> states;
	
	private int index;
	
	public Originator(){
		states = new ArrayList<String>();
		index = 0;
	}
	
	public Memento createMemento(){
		return new Memento(states, index);
	}
	
	public void restoreMemento(Memento memento){
        states = memento.getStates();
        index = memento.getIndex();
    }
	
	public void setState(String state){
        states.add(state);
        index++;
    }
	
	public void printStates(){
        for(String state : states){
            System.out.println(state);
        }
    }
	
}
