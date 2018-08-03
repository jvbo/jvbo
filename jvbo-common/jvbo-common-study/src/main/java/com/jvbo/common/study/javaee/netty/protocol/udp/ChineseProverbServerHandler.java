package com.jvbo.common.study.javaee.netty.protocol.udp;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.socket.DatagramPacket;
import io.netty.util.CharsetUtil;
import io.netty.util.internal.ThreadLocalRandom;

/**
 * @ClassName:
 * @Description: TODO
 * @author: jvbo
 * @date: 2018/8/1
 */
public class ChineseProverbServerHandler extends SimpleChannelInboundHandler<DatagramPacket> {
	private static final String[] DICTIONARY = {"啊啊啊啊啊啊", "哦哦哦哦哦哦", "呃呃呃呃呃呃", "喔喔喔喔喔喔"};

	private String nextQuote(){
		int quoteId = ThreadLocalRandom.current().nextInt(DICTIONARY.length);
		return DICTIONARY[quoteId];
	}

	@Override
	protected void messageReceived(ChannelHandlerContext ctx, DatagramPacket msg) throws Exception {
		String req = msg.content().toString(CharsetUtil.UTF_8);
		System.out.println(req);
		if("哈哈".equals(req)){
			ctx.writeAndFlush(new DatagramPacket(Unpooled.copiedBuffer("结果: " + nextQuote(), CharsetUtil.UTF_8), msg.sender()));
		}
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		cause.printStackTrace();
		ctx.close();
	}
}
