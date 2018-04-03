/*
 * Keypad.java 2017年11月10日
 * Copyright (c) 2015-2017, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.designpattern.command.audioplayer;

/**
 * 请求者角色,由键盘类扮演
 * @ClassName: Keypad 
 * @Description: TODO
 * @author jvbo
 * @date 2017年11月10日
 */
public class Keypad {
	
	private Command playCommand;
    private Command rewindCommand;
    private Command stopCommand;
	
    public void setPlayCommand(Command playCommand) {
        this.playCommand = playCommand;
    }
    public void setRewindCommand(Command rewindCommand) {
        this.rewindCommand = rewindCommand;
    }
    public void setStopCommand(Command stopCommand) {
        this.stopCommand = stopCommand;
    }
    
    //执行播放方法
    public void play(){
        playCommand.execute();
    }
    
    //执行倒带方法
    public void rewind(){
        rewindCommand.execute();
    }
    
    //执行播放方法
    public void stop(){
        stopCommand.execute();
    }
}
