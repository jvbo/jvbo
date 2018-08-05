package com.jvbo.common.study.javaee.netty.protocol.personal.server;

import com.jvbo.common.study.javaee.netty.protocol.personal.MessageType;
import com.jvbo.common.study.javaee.netty.protocol.personal.pojo.Header;
import com.jvbo.common.study.javaee.netty.protocol.personal.pojo.NettyMessage;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @ClassName:
 * @Description: TODO
 * @author: jvbo
 * @date: 2018/8/1
 */
public class HeartBeatRespHandler extends ChannelHandlerAdapter {
	private static final Logger logger = LoggerFactory.getLogger(HeartBeatRespHandler.class);

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		NettyMessage message = (NettyMessage) msg;
		// 返回心跳响应消息
		if(message.getHeader() != null && message.getHeader().getType() == MessageType.HEARTBEAT_REQ.value()){
			logger.info("receive client heartbeat message : {}", message);
			NettyMessage heartBeat = buildHeartBeat();
			logger.info("send heartbeat response message to client : {}", heartBeat);
			ctx.writeAndFlush(heartBeat);
		}else{
			ctx.fireChannelRead(msg);
		}
	}

	private NettyMessage buildHeartBeat() {
		NettyMessage message = new NettyMessage();
		Header header = new Header();
		header.setType(MessageType.HEARTBEAT_RESP.value());
		message.setHeader(header);
		return message;
	}
}
