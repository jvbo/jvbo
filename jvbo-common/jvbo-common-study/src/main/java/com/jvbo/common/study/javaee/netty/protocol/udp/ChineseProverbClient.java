package com.jvbo.common.study.javaee.netty.protocol.udp;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.DatagramPacket;
import io.netty.channel.socket.nio.NioDatagramChannel;
import io.netty.util.CharsetUtil;

import java.net.InetSocketAddress;

/**
 * @ClassName:
 * @Description: TODO
 * @author: jvbo
 * @date: 2018/8/1
 */
public class ChineseProverbClient {

	public void run(int port) throws InterruptedException {
		EventLoopGroup group = new NioEventLoopGroup();

		try {
			Bootstrap b = new Bootstrap();
			b.group(group).channel(NioDatagramChannel.class) // udp通信使用NioDatagramChannel
					.option(ChannelOption.SO_BROADCAST, true)
					.handler(new ChineseProverbClientHandler());

			Channel ch = b.bind(0).sync().channel();
			// 向网段内的所有机器广播UDP消息
			ch.writeAndFlush(new DatagramPacket(Unpooled.copiedBuffer("哈哈", CharsetUtil.UTF_8),
					new InetSocketAddress("255.255.255.255", port))).sync();
			if(!ch.closeFuture().await(15000)){
				System.out.println("查询超时");
			}
		} finally {
			group.shutdownGracefully();
		}
	}

	public static void main(String[] args) throws InterruptedException {
		int port = 8080;
		new ChineseProverbClient().run(port);
	}

}
