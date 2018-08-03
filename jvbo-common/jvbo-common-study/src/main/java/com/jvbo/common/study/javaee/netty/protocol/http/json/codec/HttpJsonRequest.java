package com.jvbo.common.study.javaee.netty.protocol.http.json.codec;

import io.netty.handler.codec.http.FullHttpRequest;

/**
 * @ClassName:
 * @Description: TODO
 * @author: jvbo
 * @date: 2018/7/31
 */
public class HttpJsonRequest {
	private FullHttpRequest request;
	private Object body;

	public HttpJsonRequest(FullHttpRequest request, Object body){
		this.request = request;
		this.body = body;
	}

	public FullHttpRequest getRequest() {
		return request;
	}

	public void setRequest(FullHttpRequest request) {
		this.request = request;
	}

	public Object getBody() {
		return body;
	}

	public void setBody(Object body) {
		this.body = body;
	}

	@Override
	public String toString() {
		return "HttpJsonRequest{" +
				"request=" + request +
				", body=" + body +
				'}';
	}
}
