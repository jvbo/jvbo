/*
 * Request.java 2017年7月19日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.common.httpserver.serverFive;

import java.io.IOException;
import java.io.InputStream;

public class Request {
	
	private InputStream input;
	private String uri;

	public Request(InputStream input) {
		this.input = input;
	}
	
	//从InputStream中读取request信息,并从request中获取uri值
	public void parse() {
		StringBuffer request = new StringBuffer(2048);
		int i;
		byte[] buffer = new byte[2048];
		try {
			i = input.read(buffer);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			i = -1;
		}
		for (int j = 0; j < i; j++) {
			request.append((char) buffer[j]);
		}
		System.out.println(request.toString());
		uri = parseUri(request.toString());
	}
	
	/**
	 * requestString形式(该函数目的是获取/index.html字符串)
	 * GET /index.html HTTP/1.1
	 * Host: localhost:8080
	 * Connection: keep-alive
	 * Cache-Control: max-age=0
	 * ...
	 * @Description: TODO
	 * @param @param requestString
	 * @param @return   
	 * @return String  
	 * @throws
	 * @author jvbo
	 * @date 2017年7月19日
	 */
	private String parseUri(String requestString) {
		int index1, index2;
		index1 = requestString.indexOf(' ');
		if(index1 != -1){
			index2 = requestString.indexOf(' ', index1 + 1);
			if(index2 > index1){
				return requestString.substring(index1 + 1, index2);
			}
		}
		return null;
	}

	public String getUri() {
		return uri;
	}

}
