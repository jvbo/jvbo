package com.jvbo.common.study.javaee.netty.protocol.http.json.codec;

import io.netty.handler.codec.http.FullHttpResponse;

/**
 * @ClassName:
 * @Description: TODO
 * @author: jvbo
 * @date: 2018/7/31
 */
public class HttpJsonResponse {
	private FullHttpResponse response;
	private Object result;

	public HttpJsonResponse(FullHttpResponse response, Object result){
		this.response = response;
		this.result = result;
	}

	public FullHttpResponse getResponse() {
		return response;
	}

	public void setResponse(FullHttpResponse response) {
		this.response = response;
	}

	public Object getResult() {
		return result;
	}

	public void setResult(Object result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return "HttpJsonResponse{" +
				"response=" + response +
				", result=" + result +
				'}';
	}
}
