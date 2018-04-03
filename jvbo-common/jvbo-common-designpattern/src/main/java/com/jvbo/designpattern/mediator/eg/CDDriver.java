/*
 * CDDriver.java 2017年11月13日
 * Copyright (c) 2015-2017, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.designpattern.mediator.eg;

/**
 * 同事类-光驱
 * @ClassName: CDDriver 
 * @Description: TODO
 * @author jvbo
 * @date 2017年11月13日
 */
public class CDDriver extends Colleague {
	//光驱读出来的数据
	private String data = "";

	public CDDriver(Mediator mediator) {
		super(mediator);
		// TODO Auto-generated constructor stub
	}
	
	//获取光盘读取出来的数据
    public String getData() {
        return data;
    }
    
    //读取光盘
    public void readCD(){
        //逗号前是视频显示的数据,逗号后是声音
        this.data = "One Piece,海贼王我当定了";
        //通知主板,自己的状态发生了改变
        getMediator().changed(this);
    }

}
