package site.jvbo.fun.okex.crawler.websocket;

import com.alibaba.fastjson.JSON;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufInputStream;
import io.netty.channel.*;
import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.handler.codec.http.websocketx.*;
import io.netty.util.CharsetUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import site.jvbo.fun.okex.common.enums.CatchResponseEnum;
import site.jvbo.fun.okex.common.enums.HeartBeatEnum;
import site.jvbo.fun.okex.crawler.websocket.service.IWebSocketService;

import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

/**
 * @ClassName:
 * @Description: TODO
 * @author: jvbo
 * @date: 2018/10/18
 */
public class WebSocketClientHandler extends SimpleChannelInboundHandler<Object> {
	private static final Logger logger = LoggerFactory.getLogger(WebSocketClientHandler.class);

	private final WebSocketClientHandshaker handshaker;
	private ChannelPromise handshakeFuture;
	private MoniterTask moniter;
	private IWebSocketService service ;
	public WebSocketClientHandler(WebSocketClientHandshaker handshaker, IWebSocketService service, MoniterTask moniter) {
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
					"Unexpected FullHttpResponse (status=" + response.status() +
							", content=" + response.content().toString(CharsetUtil.UTF_8) + ')');
		}

		WebSocketFrame frame = (WebSocketFrame) msg;
		if (frame instanceof TextWebSocketFrame) {
			TextWebSocketFrame textFrame = (TextWebSocketFrame) frame;
			String serverMsg = textFrame.text();
			handlerDateFacade(ctx, serverMsg);
		}else if(frame instanceof BinaryWebSocketFrame) {
			BinaryWebSocketFrame binaryFrame=(BinaryWebSocketFrame)frame;
			String serverMsg = decodeByteBuff(binaryFrame.content());
			handlerDateFacade(ctx, serverMsg);
		}else if(frame instanceof PongWebSocketFrame) {
			logger.info("WebSocket Client received pong");
		}else if(frame instanceof CloseWebSocketFrame) {
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

	public  String decodeByteBuff(ByteBuf buf) throws IOException, DataFormatException {
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

	private void handlerDateFacade(ChannelHandlerContext ctx, String serverMsg) {
		if(serverMsg.contains(HeartBeatEnum.PING.getCode())){
			// send pong
			//ctx.writeAndFlush(new TextWebSocketFrame(), handshakeFuture);
			logger.info("websocket client receive server ping : {}", serverMsg);
		}else if(serverMsg.contains(HeartBeatEnum.PONG.getCode())){
			logger.info("websocket client receive server pong : {}", serverMsg);
		}else if(serverMsg.contains(CatchResponseEnum.RESULT.getCode())){
			logger.info("websocket client receive server result : {}", serverMsg);
		}else{
			dealData(serverMsg);
		}
	}

	private void dealData(String serverMsg){
		logger.info("serverMsg : {}", serverMsg);
		String msg = JSON.parseArray(serverMsg).getString(0);
		if(msg.contains(CatchResponseEnum.SPOT.getCode())){
			if(msg.contains(CatchResponseEnum.TICKER.getCode())){
				service.receiveSpotTicker(msg);
			}else{
				logger.info("possible error - msg : {}", msg);
			}
		}else if (msg.contains(CatchResponseEnum.FUTURE.getCode())){
			if(msg.contains(CatchResponseEnum.TICKER.getCode())){
				service.receiveFutureTicker(msg);
			}else{
				logger.info("possible error - msg : {}", msg);
			}
		}
	}
}
