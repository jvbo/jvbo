/*
 * Invoker.java 2017年11月10日
 * Copyright (c) 2015-2017, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.designpattern.command.sample;

/**
 * 请求者角色
 * @ClassName: Invoker 
 * @Description: 负责调用命令对象执行请求,相关的方法叫做行动方法;
 * @author jvbo
 * @date 2017年11月10日
 */
public class Invoker {
	//持有命令对象
    private Command command = null;
    
    public Invoker(Command command){
        this.command = command;
    }
    
    //行动方法
    public void action(){
        command.execute();
    }
}
