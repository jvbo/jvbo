/*
 * SoundCard.java 2017年11月13日
 * Copyright (c) 2015-2017, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.designpattern.mediator.eg;

/**
 * 同事类-声卡
 * @ClassName: SoundCard 
 * @Description: TODO
 * @author jvbo
 * @date 2017年11月13日
 */
public class SoundCard extends Colleague {

	public SoundCard(Mediator mediator) {
		super(mediator);
		// TODO Auto-generated constructor stub
	}
	
	//按照声频数据发出声音
    public void soundData(String data){
        System.out.println("画外音：" + data);
    }
}
