/*
 * MacroAudioCommand.java 2017年11月10日
 * Copyright (c) 2015-2017, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.designpattern.command.macroaudioplay;

import java.util.ArrayList;
import java.util.List;

/**
 * 具体的宏命令MacroAudioCommand类负责把个别的命令合成宏命令
 * @ClassName: MacroAudioCommand 
 * @Description: TODO
 * @author jvbo
 * @date 2017年11月10日
 */
public class MacroAudioCommand implements MacroCommand {
	
	private List<Command> commandList = new ArrayList<Command>();

	@Override
	public void execute() {
		for(Command cmd : commandList){
            cmd.execute();
        }
	}
	
	//宏命令聚集管理方法
	@Override
	public void add(Command cmd) {
		commandList.add(cmd);
	}
	
	//宏命令聚集管理方法
	@Override
	public void remove(Command cmd) {
		commandList.remove(cmd);
	}

}
