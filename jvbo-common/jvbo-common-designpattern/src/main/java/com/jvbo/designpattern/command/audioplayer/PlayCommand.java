/*
 * PlayCommand.java 2017年11月10日
 * Copyright (c) 2015-2017, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.designpattern.command.audioplayer;

/**
 * 具体命令角色类
 * @ClassName: PlayCommand 
 * @Description: TODO
 * @author jvbo
 * @date 2017年11月10日
 */
public class PlayCommand implements Command {
	private AudioPlayer myAudio;
	
	public PlayCommand(AudioPlayer audioPlayer){
        myAudio = audioPlayer;
    }

	@Override
	public void execute() {
		myAudio.play();
	}

}
