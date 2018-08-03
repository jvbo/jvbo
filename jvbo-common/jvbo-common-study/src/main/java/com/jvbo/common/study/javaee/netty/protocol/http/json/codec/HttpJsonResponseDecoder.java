package com.jvbo.common.study.javaee.netty.protocol.http.json.codec;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.FullHttpResponse;

import java.util.List;

/**
 * @ClassName:
 * @Description: TODO
 * @author: jvbo
 * @date: 2018/7/31
 */
public class HttpJsonResponseDecoder extends AbstractHttpJsonDecoder<FullHttpResponse> {

	public HttpJsonResponseDecoder(Class<?> clazz) {
		this(clazz, false);
	}

	public HttpJsonResponseDecoder(Class<?> clazz, boolean isPrint) {
		super(clazz, isPrint);
	}

	@Override
	protected void decode(ChannelHandlerContext ctx, FullHttpResponse msg, List<Object> out) throws Exception {
		HttpJsonResponse response = new HttpJsonResponse(msg, decode0(ctx, msg.content()));
		out.add(response);
	}
}
