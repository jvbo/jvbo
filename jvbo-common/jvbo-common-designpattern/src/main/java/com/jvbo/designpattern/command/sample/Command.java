/*
 * Command.java 2017年11月10日
 * Copyright (c) 2015-2017, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.designpattern.command.sample;

/**
 * 命令角色
 * @ClassName: Command 
 * @Description: 声明了一个给所有具体命令类的抽象接口
 * @author jvbo
 * @date 2017年11月10日
 */
public interface Command {
	//执行方法
	void execute();
}
