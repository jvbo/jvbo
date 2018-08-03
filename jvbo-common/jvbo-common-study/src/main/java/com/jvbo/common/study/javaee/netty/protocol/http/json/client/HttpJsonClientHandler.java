package com.jvbo.common.study.javaee.netty.protocol.http.json.client;

import com.jvbo.common.study.javaee.netty.protocol.http.json.codec.HttpJsonRequest;
import com.jvbo.common.study.javaee.netty.protocol.http.json.codec.HttpJsonResponse;
import com.jvbo.common.study.javaee.netty.protocol.http.pojo.ObjectFactory;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @ClassName:
 * @Description: TODO
 * @author: jvbo
 * @date: 2018/7/31
 */
public class HttpJsonClientHandler extends SimpleChannelInboundHandler<HttpJsonResponse> {

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		cause.printStackTrace();
		ctx.close();
	}

	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		HttpJsonRequest request = new HttpJsonRequest(null, ObjectFactory.create(123));
		ctx.writeAndFlush(request);
	}

	@Override
	protected void messageReceived(ChannelHandlerContext ctx, HttpJsonResponse msg) throws Exception {
		System.out.println("client receive response of http header is : " + msg.getResponse().headers().names());
		System.out.println("client receive response of http body is : " + msg.getResult());
	}
}
