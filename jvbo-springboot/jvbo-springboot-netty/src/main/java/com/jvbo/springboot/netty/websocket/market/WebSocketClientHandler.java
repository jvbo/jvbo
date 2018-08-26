package com.jvbo.springboot.netty.websocket.market;

import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jvbo.springboot.netty.websocket.market.service.IWebSocketService;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufInputStream;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.handler.codec.http.websocketx.BinaryWebSocketFrame;
import io.netty.handler.codec.http.websocketx.CloseWebSocketFrame;
import io.netty.handler.codec.http.websocketx.PongWebSocketFrame;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.handler.codec.http.websocketx.WebSocketClientHandshaker;
import io.netty.handler.codec.http.websocketx.WebSocketFrame;
import io.netty.util.CharsetUtil;

public class WebSocketClientHandler extends SimpleChannelInboundHandler<Object> {
	private static final Logger logger = LoggerFactory.getLogger(WebSocketClientHandler.class);

	private static final String PONG = "pong";
	private static final String TICKER = "ticker";
	private static final String KLINE = "kline";

	private final WebSocketClientHandshaker handshaker;
	private ChannelPromise handshakeFuture;
	private MoniterTask moniter;
	private IWebSocketService service ;
	public WebSocketClientHandler(WebSocketClientHandshaker handshaker,IWebSocketService service,MoniterTask moniter) {
		this.handshaker = handshaker;
		this.service = service;
		this.moniter = moniter;
	}

	public ChannelFuture handshakeFuture() {
		return handshakeFuture;
	}

	@Override
	public void handlerAdded(ChannelHandlerContext ctx) {
		handshakeFuture = ctx.newPromise();
	}

	@Override
	public void channelActive(ChannelHandlerContext ctx) {
		handshaker.handshake(ctx.channel());
	}

	@Override
	public void channelInactive(ChannelHandlerContext ctx) {
		logger.info("WebSocket Client disconnected!");
	}

	@Override
	public void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {
		Channel ch = ctx.channel();
		moniter.updateTime();
		if (!handshaker.isHandshakeComplete()) {
			handshaker.finishHandshake(ch, (FullHttpResponse) msg);
			logger.info("WebSocket Client connected!");
			handshakeFuture.setSuccess();
			return;
		}

		if (msg instanceof FullHttpResponse) {
			FullHttpResponse response = (FullHttpResponse) msg;
			throw new IllegalStateException(
					"Unexpected FullHttpResponse (getStatus=" + response.getStatus() +
							", content=" + response.content().toString(CharsetUtil.UTF_8) + ')');
		}

		WebSocketFrame frame = (WebSocketFrame) msg;
		if (frame instanceof TextWebSocketFrame) {
			TextWebSocketFrame textFrame = (TextWebSocketFrame) frame;
			String serverMsg = textFrame.text();
			JSONArray dataJa = JSON.parseObject(serverMsg).getJSONArray("params");
			if(serverMsg.contains(TICKER)){
				String symbol = dataJa.getString(0);
				JSONObject dataResult = dataJa.getJSONObject(1);
				dataResult.put("symbol", symbol);
				service.receiveTicker(dataResult.toJSONString());
			}else if(serverMsg.contains(KLINE)){
				JSONArray dataResult = dataJa.getJSONArray(0);
				service.receiveKline(dataResult.toJSONString());
			}else if(serverMsg.contains(PONG)){
                logger.info("WebSocket Client received pong");
            }else{
				logger.error("无效消息:{}", serverMsg);
			}
		} else if (frame instanceof BinaryWebSocketFrame) {
			BinaryWebSocketFrame binaryFrame=(BinaryWebSocketFrame)frame;
			String serverMsg = decodeByteBuff(binaryFrame.content());
			service.onReceive(serverMsg);
		}else if (frame instanceof PongWebSocketFrame) {
			logger.info("WebSocket Client received pong");
		} else if (frame instanceof CloseWebSocketFrame) {
			logger.info("WebSocket Client received closing");
			ch.close();
		}
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
		cause.printStackTrace();
		if (!handshakeFuture.isDone()) {
			handshakeFuture.setFailure(cause);
		}
		ctx.close();
	}

	public String decodeByteBuff(ByteBuf buf) throws IOException, DataFormatException {
		byte[] temp = new byte[buf.readableBytes()];
		ByteBufInputStream bis = new ByteBufInputStream(buf);
		bis.read(temp);
		bis.close();
		Inflater decompresser = new Inflater(true);
		decompresser.setInput(temp, 0, temp.length);
		StringBuilder sb = new StringBuilder();
		byte[] result = new byte[1024];
		while (!decompresser.finished()) {
			int resultLength = decompresser.inflate(result);
			sb.append(new String(result, 0, resultLength, "UTF-8"));
		}
		decompresser.end();
		return sb.toString();
	}
}
