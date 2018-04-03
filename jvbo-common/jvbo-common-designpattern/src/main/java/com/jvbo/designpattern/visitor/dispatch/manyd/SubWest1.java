/*
 * SubWest1.java 2017年11月13日
 * Copyright (c) 2015-2017, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.designpattern.visitor.dispatch.manyd;

public class SubWest1 extends West {
	@Override
    public void goWest1(SubEast1 east) {
        System.out.println("SubWest1 + " + east.myName1());
    }
    
    @Override
    public void goWest2(SubEast2 east) {
        System.out.println("SubWest1 + " + east.myName2());
    }
}
