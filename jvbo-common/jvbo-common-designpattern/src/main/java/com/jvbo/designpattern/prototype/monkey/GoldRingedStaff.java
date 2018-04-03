/*
 * GoldRingedStaff.java 2017年11月7日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.designpattern.prototype.monkey;

/**
 * 金箍棒类
 * @ClassName: GoldRingedStaff 
 * @Description: TODO
 * @author jvbo
 * @date 2017年11月7日
 */
public class GoldRingedStaff {
	private float height = 100.0f;
	private float diameter = 10.0f;
	
	//增长行为,每次调用长度和半径增加一倍
	public void grow(){
		this.height *= 2;
		this.diameter *= 2;
	}
	
	//缩小行为,每次调用长度和半径缩小一半
	public void shrink(){
		this.height /= 2;
		this.diameter /= 2;
	}
}
