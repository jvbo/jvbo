/*
 * MacroCommand.java 2017年11月10日
 * Copyright (c) 2015-2017, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.designpattern.command.macroaudioplay;

/**
 * 宏命令所需要的接口
 * @ClassName: MacroCommand 
 * @Description: TODO
 * @author jvbo
 * @date 2017年11月10日
 */
public interface MacroCommand extends Command {

	//宏命令聚集的管理方法,可以添加一个成员命令
    public void add(Command cmd);
    
    //宏命令聚集的管理方法,可以删除一个成员命令
    public void remove(Command cmd);

}
