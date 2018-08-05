package com.jvbo.common.study.javaee.netty.protocol.personal.server;

import com.jvbo.common.study.javaee.netty.protocol.personal.MessageType;
import com.jvbo.common.study.javaee.netty.protocol.personal.ResultType;
import com.jvbo.common.study.javaee.netty.protocol.personal.pojo.Header;
import com.jvbo.common.study.javaee.netty.protocol.personal.pojo.NettyMessage;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetSocketAddress;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @ClassName:
 * @Description: TODO
 * @author: jvbo
 * @date: 2018/8/1
 */
public class LoginAuthRespHandler extends ChannelHandlerAdapter {
	private static final Logger logger = LoggerFactory.getLogger(LoginAuthRespHandler.class);

	private Map<String, Boolean> nodeCheck = new ConcurrentHashMap<>(12);
	private String[] whiteList = {"127.0.0.1", "192.168.0.194"};

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		cause.printStackTrace();
		nodeCheck.remove(ctx.channel().remoteAddress().toString());
		ctx.close();
		ctx.fireExceptionCaught(cause);
	}

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		NettyMessage message = (NettyMessage) msg;
		// 如果是握手请求消息,处理,其他消息透传
		if(message.getHeader() != null && message.getHeader().getType() == MessageType.LOGIN_REQ.value()){
			String nodeIndex = ctx.channel().remoteAddress().toString();
			NettyMessage loginResp = null;
			// 重复登录,拒绝
			if(nodeCheck.containsKey(nodeIndex)){
				logger.error("");
				loginResp = buildResponse(ResultType.FAIL.value());
			}else{
				InetSocketAddress address = (InetSocketAddress) ctx.channel().remoteAddress();
				String ip = address.getAddress().getHostAddress();
				boolean isOk = false;
				for (String WIP : whiteList) {
					if(WIP.equals(ip)){
						isOk = true;
						break;
					}
				}
				loginResp = isOk ? buildResponse((byte)0) : buildResponse((byte)-1);
				if(isOk){
					nodeCheck.put(nodeIndex, true);
				}
			}
			logger.info("login response is : {}, body : {}", loginResp, loginResp.getBody());
			ctx.writeAndFlush(loginResp);
		}else{
			ctx.fireChannelRead(msg);
		}
	}

	private NettyMessage buildResponse(byte result) {
		NettyMessage message = new NettyMessage();
		Header header = new Header();
		header.setType(MessageType.LOGIN_RESP.value());
		message.setHeader(header);
		message.setBody(result);
		return message;
	}
}
