package com.jvbo.common.study.javaee.netty.protocol.personal.client;

import com.jvbo.common.study.javaee.netty.protocol.personal.MessageType;
import com.jvbo.common.study.javaee.netty.protocol.personal.ResultType;
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
public class LoginAuthReqHandler extends ChannelHandlerAdapter {
	private static final Logger logger = LoggerFactory.getLogger(LoginAuthReqHandler.class);

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		ctx.fireExceptionCaught(cause);
	}

	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		logger.info("channel active, 握手请求验证");
		ctx.writeAndFlush(buildLoginReq());
	}

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		NettyMessage message = (NettyMessage) msg;
		// 如果是握手应答消息,需要判断是否认证成功
		if(message.getHeader() != null && message.getHeader().getType() == MessageType.LOGIN_RESP.value()){
			byte loginResult = (byte)message.getBody();
			if(loginResult != ResultType.SUCCESS.value()){
				// 握手失败,关闭连接
				ctx.close();
			}else{
				System.out.println("login is ok : " + message);
				ctx.fireChannelRead(msg);
			}
		}else{
			ctx.fireChannelRead(msg);
		}

	}

	/**
	 * 客户端与服务端建立了连接之后,由客户端发送握手请求消息,握手请求消息定义:
	 * 1. 消息头的type=3;
	 * 2. 可选附件个数=0;
	 * 3. 消息体空;
	 * 4. 握手消息的的长度为22个字节;
	 * @return
	 */
	private Object buildLoginReq() {
		NettyMessage message = new NettyMessage();
		Header header = new Header();
		header.setType(MessageType.LOGIN_REQ.value());
		message.setHeader(header);
		return message;
	}
}
