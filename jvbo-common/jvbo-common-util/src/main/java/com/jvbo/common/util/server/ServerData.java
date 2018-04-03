/*
 * @(#) PageVo.java 2016-2-25
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.common.util.server;

import com.alibaba.fastjson.JSON;

/**
 * 后台服务器返回Android端参数
 * @Description: TODO
 * @author jv.bo
 * @version 1.0
 * @since 2016-2-25
 */
public class ServerData {

	
	/**
	 * 200 访问正常
	 * 500 服务器出错
	 * 105 未接受到v参数
	 * 106 v参数中子参数未接收到  或 为空
	 * 107 访问成功 数据保存时 数据库未执行成功
	 * 108 数据库参数未读取到
	 */
	private boolean status;//成功与否
	private String data;//返回数据
	private int code;//服务器状态
	private String info;
	
	public ServerData(){
		code=200;
		status=true;
		data="";
		info="";
	}
	
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = JSON.toJSONString(data);
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	
}
