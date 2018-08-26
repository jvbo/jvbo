package com.jvbo.springboot.netty.websocket.example.benchmarkserver;

import com.jvbo.springboot.netty.websocket.example.server.WebSocketServer;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.*;
import io.netty.handler.codec.http.websocketx.*;
import io.netty.util.CharsetUtil;

/**
 * @ClassName:
 * @Description: TODO
 * @author: jvbo
 * @date: 2018/8/23
 */
public class WebSocketServerHandler extends SimpleChannelInboundHandler<Object> {

	private static final String WEBSOCKET_PATH = "/websocket";

	private WebSocketServerHandshaker handshaker;

	@Override
	protected void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {
		if(msg instanceof FullHttpRequest){
			handlerHttpRequest(ctx, (FullHttpRequest)msg);
		}else if(msg instanceof WebSocketFrame){
			handlerWebSocketFrame(ctx, (WebSocketFrame)msg);
		}
	}

	@Override
	public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
		ctx.flush();
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		cause.printStackTrace();
		ctx.close();
	}

	private void handlerWebSocketFrame(ChannelHandlerContext ctx, WebSocketFrame frame) {
		if(frame instanceof CloseWebSocketFrame){
			handshaker.close(ctx.channel(), (CloseWebSocketFrame) frame.retain());
			return;
		}
		if(frame instanceof PingWebSocketFrame){
			ctx.write(new PongWebSocketFrame(frame.content().retain()));
			return;
		}
		if(frame instanceof TextWebSocketFrame){
			ctx.write(frame.retain());
			return;
		}
		if(frame instanceof BinaryWebSocketFrame){
			ctx.write(frame.retain());
		}
	}

	private void handlerHttpRequest(ChannelHandlerContext ctx, FullHttpRequest req) {
		// 异常请求
		if(!req.decoderResult().isSuccess()){
			sendHttpResponse(ctx, req, new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.BAD_REQUEST));
			return;
		}

		// 只允许get
		if(req.method() != HttpMethod.GET){
			sendHttpResponse(ctx, req, new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.FORBIDDEN));
			return;
		}

		// 默认页面和favicon.ico
		if("/".equals(req.uri())){
			ByteBuf content = WebSocketServerBenchmarkPage.getContent(getWebSocketLocation(req));
			FullHttpResponse res = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK, content);

			res.headers().set(HttpHeaderNames.CONTENT_TYPE, "text/html; charset=UTF-8");
			HttpUtil.setContentLength(res, content.readableBytes());

			sendHttpResponse(ctx, req, res);
			return;
		}
		if("favicon.ico".equals(req.uri())){
			FullHttpResponse res = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.NOT_FOUND);
			sendHttpResponse(ctx, req, res);
			return;
		}

		// 握手
		WebSocketServerHandshakerFactory wsFactory = new WebSocketServerHandshakerFactory(
				getWebSocketLocation(req), null, true, 5 * 1024 * 1024);
		handshaker = wsFactory.newHandshaker(req);
		if(handshaker == null){
			WebSocketServerHandshakerFactory.sendUnsupportedVersionResponse(ctx.channel());
		}else{
			handshaker.handshake(ctx.channel(), req);
		}
	}

	private static String getWebSocketLocation(FullHttpRequest req) {
		String location = req.headers().get(HttpHeaderNames.HOST) + WEBSOCKET_PATH;
		if(WebSocketServer.SSL){
			return "wss://" + location;
		}else{
			return "ws://" + location;
		}
	}

	private static void sendHttpResponse(ChannelHandlerContext ctx, FullHttpRequest req, FullHttpResponse res) {
		// 非正常
		if(200 != res.status().code()){
			ByteBuf buf = Unpooled.copiedBuffer(res.status().toString(), CharsetUtil.UTF_8);
			res.content().writeBytes(buf);
			buf.release();
			HttpUtil.setContentLength(res, res.content().readableBytes());
		}

		// 发送响应,判断是否需要关闭连接
		ChannelFuture f = ctx.channel().writeAndFlush(res);
		if(!HttpUtil.isKeepAlive(req) || 200 != res.status().code()){
			f.addListener(ChannelFutureListener.CLOSE);
		}
	}
}
