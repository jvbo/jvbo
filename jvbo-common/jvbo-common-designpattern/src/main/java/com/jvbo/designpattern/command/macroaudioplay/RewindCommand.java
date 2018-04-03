/*
 * RewindCommand.java 2017年11月10日
 * Copyright (c) 2015-2017, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.designpattern.command.macroaudioplay;

/**
 * 具体命令角色类
 * @ClassName: RewindCommand 
 * @Description: TODO
 * @author jvbo
 * @date 2017年11月10日
 */
public class RewindCommand implements Command {
	private AudioPlayer myAudio;
	
	public RewindCommand(AudioPlayer audioPlayer){
        myAudio = audioPlayer;
    }

	@Override
	public void execute() {
		myAudio.rewind();
	}

}
