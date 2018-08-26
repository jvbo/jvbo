/*
 * WebSocketFrameHandler.java 2018年8月23日
 * Copyright (c) 2015-2018, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.springboot.netty.websocket.example.server;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.handler.codec.http.websocketx.WebSocketFrame;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WebSocketFrameHandler extends SimpleChannelInboundHandler<WebSocketFrame> {
	private static final Logger logger = LoggerFactory.getLogger(WebSocketFrameHandler.class);

	@Override
	protected void channelRead0(ChannelHandlerContext ctx, WebSocketFrame frame) throws Exception {
		if(frame instanceof TextWebSocketFrame){
			String request = ((TextWebSocketFrame) frame).text();
			logger.info("{} received {}", ctx.channel(), request);
			// 返回大写
			ctx.channel().writeAndFlush(new TextWebSocketFrame(request.toUpperCase()));
		}
	}
}
