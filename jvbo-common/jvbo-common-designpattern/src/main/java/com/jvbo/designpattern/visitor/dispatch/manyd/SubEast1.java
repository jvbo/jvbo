/*
 * SubEast1.java 2017年11月13日
 * Copyright (c) 2015-2017, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.designpattern.visitor.dispatch.manyd;

public class SubEast1 extends East {

	@Override
	public void goEast(West west) {
		west.goWest1(this);
	}
	
	public String myName1(){
        return "SubEast1";
    }

}
