/*
 * SubEast2.java 2017年11月13日
 * Copyright (c) 2015-2017, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.designpattern.visitor.dispatch.manyd;

public class SubEast2 extends East {

	@Override
	public void goEast(West west) {
		west.goWest2(this);
	}

	public String myName2(){
        return "SubEast2";
    }
}
