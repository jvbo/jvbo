/*
 * VideoCard.java 2017年11月13日
 * Copyright (c) 2015-2017, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.designpattern.mediator.eg;

/**
 * 同事类-显卡
 * @ClassName: VideoCard 
 * @Description: TODO
 * @author jvbo
 * @date 2017年11月13日
 */
public class VideoCard extends Colleague {

	public VideoCard(Mediator mediator) {
		super(mediator);
		// TODO Auto-generated constructor stub
	}
	
	//显示视频数据
    public void showData(String data){
        System.out.println("您正在观看的是：" + data);
    }
}
