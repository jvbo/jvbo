/*
 * CPU.java 2017年11月13日
 * Copyright (c) 2015-2017, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.designpattern.mediator.eg;

/**
 * 同事类-CPU
 * @ClassName: CPU 
 * @Description: TODO
 * @author jvbo
 * @date 2017年11月13日
 */
public class CPU extends Colleague {
	//分解出来的视频数据
    private String videoData = "";
    //分解出来的声音数据
    private String soundData = "";
    
	public CPU(Mediator mediator) {
		super(mediator);
		// TODO Auto-generated constructor stub
	}
	
	//获取分解出来的视频数据
    public String getVideoData() {
        return videoData;
    }
    
    //获取分解出来的声音数据
    public String getSoundData() {
        return soundData;
    }
    
    //处理数据,把数据分成音频和视频的数据
    public void executeData(String data){
        //把数据分解开,前面是视频数据,后面是音频数据
        String[] array = data.split(",");
        this.videoData = array[0];
        this.soundData = array[1];
        //通知主板,CPU完成工作
        getMediator().changed(this);
    }

}
