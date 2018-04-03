/*
 * Mozi.java 2017年11月13日
 * Copyright (c) 2015-2017, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.designpattern.visitor.dispatch.staticd;

public class Mozi {
	public void ride(Horse h){
		System.out.println("骑马");
	}
	
	public void ride(WhiteHorse h){
		System.out.println("骑白马");
	}
	
	public void ride(BlankHorse h){
		System.out.println("骑黑马");
	}
	
	public static void main(String[] args) {
        Horse wh = new WhiteHorse();
        Horse bh = new BlankHorse();
        Mozi mozi = new Mozi();
        mozi.ride(wh);
        mozi.ride(bh);
    }
}

/**
 * 两次对ride()方法的调用传入的是不同的参数,
 * 也就是wh和bh;它们虽然具有不同的真实类型,但是它们的静态类型都是一样的,均是Horse类型;
 * 重载方法的分派是根据静态类型进行的，这个分派过程在编译时期就完成了
 */
