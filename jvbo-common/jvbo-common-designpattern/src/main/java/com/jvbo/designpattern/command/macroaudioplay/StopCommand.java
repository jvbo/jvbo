/*
 * StopCommand.java 2017年11月10日
 * Copyright (c) 2015-2017, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.designpattern.command.macroaudioplay;

/**
 * 具体命令角色类
 * @ClassName: StopCommand 
 * @Description: TODO
 * @author jvbo
 * @date 2017年11月10日
 */
public class StopCommand implements Command {
	private AudioPlayer myAudio;
	
	public StopCommand(AudioPlayer audioPlayer){
        myAudio = audioPlayer;
    }

	@Override
	public void execute() {
		myAudio.stop();
	}

}
