/*
 * WebSocketClientHandler.java 2018年8月23日
 * Copyright (c) 2015-2018, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.springboot.netty.websocket.example.client;

import io.netty.channel.*;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.handler.codec.http.websocketx.*;
import io.netty.util.CharsetUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WebSocketClientHandler extends SimpleChannelInboundHandler<Object>{
	private static final Logger logger = LoggerFactory.getLogger(WebSocketClientHandler.class);

	private final WebSocketClientHandshaker handshaker;
	private ChannelPromise handshakeFuture;

	public WebSocketClientHandler(WebSocketClientHandshaker webSocketClientHandshaker) {
		this.handshaker = webSocketClientHandshaker;
	}

	public ChannelFuture handshakeFuture(){
		return handshakeFuture;
	}

	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		handshaker.handshake(ctx.channel());
	}

	@Override
	public void channelInactive(ChannelHandlerContext ctx) throws Exception {
		logger.info("WebSocket Client disconnected");
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		cause.printStackTrace();
		if(!handshakeFuture.isDone()){
			handshakeFuture.setFailure(cause);
		}
		ctx.close();
	}

	@Override
	public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
		handshakeFuture = ctx.newPromise();
	}

	@Override
	protected void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {
		Channel ch = ctx.channel();
		if(!handshaker.isHandshakeComplete()){
			try {
				handshaker.finishHandshake(ch, (FullHttpResponse) msg);
				logger.info("WebSocket Client connected");
				handshakeFuture.setSuccess();
			} catch (Exception e) {
				logger.info("WebSocket Client failed to connect");
				handshakeFuture.setFailure(e);
			}
			return;
		}

		if(msg instanceof FullHttpResponse){
			FullHttpResponse response = (FullHttpResponse) msg;
			throw new IllegalStateException("Unexpected FullHttpResponse (getStatus=" + response.status() +
			", content=" + response.content().toString(CharsetUtil.UTF_8) + ")");
		}

		WebSocketFrame frame = (WebSocketFrame) msg;
		if(frame instanceof TextWebSocketFrame){
			TextWebSocketFrame textFrame = (TextWebSocketFrame) msg;
			logger.info("WebSocket Client received message: " + textFrame.text());
		}else if(frame instanceof PongWebSocketFrame){
			logger.info("WebSocket Client received pong");
		}else if(frame instanceof CloseWebSocketFrame){
			logger.info("WebSocket Client received closing");
			ch.close();
		}
	}
}
