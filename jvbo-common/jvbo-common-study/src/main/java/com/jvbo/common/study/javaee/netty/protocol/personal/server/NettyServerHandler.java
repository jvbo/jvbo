package com.jvbo.common.study.javaee.netty.protocol.personal.server;

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
 * @date: 2018/8/2
 */
public class NettyServerHandler extends ChannelHandlerAdapter {
	private static final Logger logger = LoggerFactory.getLogger(NettyServerHandler.class);

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		logger.error("异常:{}", cause.getMessage());
		cause.printStackTrace();
		ctx.close();
	}

	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		logger.info("------channel active------");
	}

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		NettyMessage reqMsg = (NettyMessage) msg;
		logger.info("server receive message from client : {}", reqMsg.getBody());
		NettyMessage respMsg = new NettyMessage();
		Header header = new Header();
		header.setSessionID(1001L);
		header.setPriority((byte) 2);
		respMsg.setHeader(header);
		respMsg.setBody("响应数据:" + reqMsg.getBody());
		ctx.writeAndFlush(respMsg);
	}

	@Override
	public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
		logger.info("----------read complete----------");
	}
}
