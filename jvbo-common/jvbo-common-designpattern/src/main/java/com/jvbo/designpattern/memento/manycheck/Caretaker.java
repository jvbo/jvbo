/*
 * Caretaker.java 2017年11月13日
 * Copyright (c) 2015-2017, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.designpattern.memento.manycheck;

import java.util.ArrayList;
import java.util.List;

/**
 * 负责人角色
 * @ClassName: Caretaker 
 * @Description: TODO
 * @author jvbo
 * @date 2017年11月13日
 */
public class Caretaker {
	private Originator o;
    private List<Memento> mementos = new ArrayList<Memento>();
    private int current;
    
    public Caretaker(Originator o){
        this.o = o;
        current = 0;
    }
	
    public int createMemento(){
        Memento memento = o.createMemento();
        mementos.add(memento);
        return current++;
    }
    
    public void restoreMemento(int index){
        Memento memento = mementos.get(index);
        o.restoreMemento(memento);
    }
	
    //将某个检查点删除
    public void removeMemento(int index){
        mementos.remove(index);
    }
}
