/*
 * Test.java 2017年11月13日
 * Copyright (c) 2015-2017, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.designpattern.visitor.dispatch.manyd;

public class Test {
	public static void main(String[] args) {
        //组合1
        East east = new SubEast1();
        West west = new SubWest1();
        east.goEast(west);
        //组合2
        east = new SubEast1();
        west = new SubWest2();
        east.goEast(west);
    }
}
