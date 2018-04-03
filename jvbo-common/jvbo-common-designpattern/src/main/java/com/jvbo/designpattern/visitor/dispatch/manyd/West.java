/*
 * West.java 2017年11月13日
 * Copyright (c) 2015-2017, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.designpattern.visitor.dispatch.manyd;

public abstract class West {
	public abstract void goWest1(SubEast1 east);
    
    public abstract void goWest2(SubEast2 east);
}
