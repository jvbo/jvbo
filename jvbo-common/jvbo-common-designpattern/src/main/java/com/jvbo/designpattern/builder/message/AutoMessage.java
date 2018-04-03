/*
 * AutoMessage.java 2017年11月1日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.designpattern.builder.message;

import java.util.Date;

/**
 * 抽象类AutoMessage
 * @ClassName: AutoMessage 
 * @Description: TODO
 * @author jvbo
 * @date 2017年11月1日
 */
public abstract class AutoMessage {
	private String to;
	private String from;
	private String subject;
	private String body;
	private Date sendDate;
	
	public void send(){
		System.out.println("收件人地址：" + to);
		System.out.println("发件人地址：" + from);
		System.out.println("主题：" + subject);
		System.out.println("内容：" + body);
		System.out.println("发送日期：" + sendDate);
	}
	
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public Date getSendDate() {
		return sendDate;
	}
	public void setSendDate(Date sendDate) {
		this.sendDate = sendDate;
	}
}
