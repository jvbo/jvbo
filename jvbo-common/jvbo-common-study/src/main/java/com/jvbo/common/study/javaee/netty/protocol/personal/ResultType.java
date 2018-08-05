package com.jvbo.common.study.javaee.netty.protocol.personal;

/**
 * @ClassName:
 * @Description: TODO
 * @author: jvbo
 * @date: 2018/8/2
 */
public enum  ResultType {
	SUCCESS((byte)0),
	FAIL((byte)-1)
	;

	private byte value;

	private ResultType(byte value){
		this.value = value;
	}

	public byte value(){
		return this.value;
	}


}
