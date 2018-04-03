/*
 * Watcher.java 2017年11月10日
 * Copyright (c) 2015-2017, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.designpattern.observer.jdkobserver;

import java.util.Observable;
import java.util.Observer;

/**
 * 观察者类
 * @ClassName: Watcher 
 * @Description: TODO
 * @author jvbo
 * @date 2017年11月10日
 */
public class Watcher implements Observer {
	
	public Watcher(Observable o){
		o.addObserver(this);
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		System.out.println("状态发生改变:" + ((Watched)o).getData());
	}
	
	

}
