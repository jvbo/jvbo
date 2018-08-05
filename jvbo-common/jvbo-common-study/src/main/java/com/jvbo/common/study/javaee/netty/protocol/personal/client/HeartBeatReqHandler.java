package com.jvbo.common.study.javaee.netty.protocol.personal.client;

import com.jvbo.common.study.javaee.netty.protocol.personal.MessageType;
import com.jvbo.common.study.javaee.netty.protocol.personal.pojo.Header;
import com.jvbo.common.study.javaee.netty.protocol.personal.pojo.NettyMessage;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName:
 * @Description: TODO
 * @author: jvbo
 * @date: 2018/8/1
 */
public class HeartBeatReqHandler extends ChannelHandlerAdapter {
	private static final Logger logger = LoggerFactory.getLogger(HeartBeatReqHandler.class);

	private volatile ScheduledFuture<?> heartbeat;

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		cause.printStackTrace();
		// 断连期间,心跳定时器停止工作,不再发送心跳信息
		if(heartbeat != null){
			heartbeat.cancel(true);
			heartbeat = null;
		}
		ctx.fireExceptionCaught(cause);
	}

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		NettyMessage message = (NettyMessage) msg;
		// 握手成功,主动发送心跳消息
		if(message.getHeader() != null && message.getHeader().getType() == MessageType.LOGIN_RESP.value()){
			heartbeat = ctx.executor().scheduleAtFixedRate(new HeartBeatTask(ctx), 0, 5000, TimeUnit.MILLISECONDS);
		} else if (message.getHeader() != null && message.getHeader().getType() == MessageType.HEARTBEAT_RESP.value()){
			logger.info("client receive server heartbeat message : {}", message);
		} else {
			ctx.fireChannelRead(msg);
		}
	}

	/**
	 * 发送心跳消息的任务线程
	 */
	private class HeartBeatTask implements Runnable {
		private final ChannelHandlerContext ctx;

		public HeartBeatTask(final ChannelHandlerContext ctx){
			this.ctx = ctx;
		}

		@Override
		public void run() {
			NettyMessage heartBeat = buildHeartBeat();
			logger.info("client send heartbeat message to server : {}", heartBeat);
			ctx.writeAndFlush(heartBeat);
		}

		private NettyMessage buildHeartBeat() {
			NettyMessage message = new NettyMessage();
			Header header = new Header();
			header.setType(MessageType.HEARTBEAT_REQ.value());
			message.setHeader(header);
			return message;
		}

	}
}
