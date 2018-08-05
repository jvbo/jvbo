package com.jvbo.common.study.javaee.netty.protocol.personal;

/**
 * @ClassName:
 * @Description: TODO
 * @author: jvbo
 * @date: 2018/8/2
 */
public enum MessageType {
	SERVICE_REQ((byte)0),// 业务请求消息
	SERVICE_RESP((byte)1),// 业务响应消息
	ONE_WAY((byte)2), // 业务ONE WAY消息,既是请求消息又是响应消息
	LOGIN_REQ((byte)3),// 握手请求消息
	LOGIN_RESP((byte)4),//握手响应消息
	HEARTBEAT_REQ((byte)5),//心跳请求消息
	HEARTBEAT_RESP((byte)6),//心跳响应消息
	;

	private byte value;

	private MessageType(byte value){
		this.value = value;
	}

	public byte value(){
		return this.value;
	}
}
