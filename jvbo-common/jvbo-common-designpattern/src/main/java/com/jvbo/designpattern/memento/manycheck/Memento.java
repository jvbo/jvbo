/*
 * Memento.java 2017年11月13日
 * Copyright (c) 2015-2017, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.designpattern.memento.manycheck;

import java.util.ArrayList;
import java.util.List;

/**
 * 备忘录角色
 * @ClassName: Memento 
 * @Description: TODO
 * @author jvbo
 * @date 2017年11月13日
 */
public class Memento {
	
	private List<String> states;
	
    private int index;
    
    public Memento(List<String> states , int index){
        this.states = new ArrayList<String>(states);
        this.index = index;
    }
    
    public List<String> getStates() {
        return states;
    }
    
    public int getIndex() {
        return index;
    }

}
