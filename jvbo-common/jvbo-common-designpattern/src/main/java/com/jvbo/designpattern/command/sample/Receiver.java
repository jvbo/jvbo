/*
 * Receiver.java 2017年11月10日
 * Copyright (c) 2015-2017, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.designpattern.command.sample;

/**
 * 接收者角色
 * @ClassName: Receiver 
 * @Description: 负责具体实施和执行一个请求,任何一个类都可以成为接收者,
 * 实施和执行请求的方法叫做行动方法;
 * @author jvbo
 * @date 2017年11月10日
 */
public class Receiver {
	//真正执行命令相应的操作
    public void action(){
        System.out.println("执行操作");
    }
}
