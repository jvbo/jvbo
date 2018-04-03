/*
 * AudioPlayer.java 2017年11月10日
 * Copyright (c) 2015-2017, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.designpattern.command.audioplayer;

/**
 * 接收者角色,由录音机类扮演
 * @ClassName: AudioPlayer 
 * @Description: TODO
 * @author jvbo
 * @date 2017年11月10日
 */
public class AudioPlayer {
	public void play(){
        System.out.println("播放...");
    }
    
    public void rewind(){
        System.out.println("倒带...");
    }
    
    public void stop(){
        System.out.println("停止...");
    }
}
