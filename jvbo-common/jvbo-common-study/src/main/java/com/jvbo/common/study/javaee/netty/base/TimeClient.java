package com.jvbo.common.study.javaee.netty.base;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;

/**
 * @ClassName:
 * @Description: TODO
 * @author: jvbo
 * @date: 2018/7/27
 */
public class TimeClient {

	public void connect(String host, int port){
		// 配置客户端NIO线程组
		EventLoopGroup group = new NioEventLoopGroup();
		Bootstrap b = new Bootstrap();
		try {
			b.group(group).channel(NioSocketChannel.class)
					.option(ChannelOption.TCP_NODELAY, true)
					.handler(new ChannelInitializer<SocketChannel>() {
						@Override
						protected void initChannel(SocketChannel ch) throws Exception {
							ch.pipeline().addLast(new LineBasedFrameDecoder(1024));
							ch.pipeline().addLast(new StringDecoder());
							ch.pipeline().addLast(new TimeClientHandler());
						}
					});

			// 发起异步连接操作
			ChannelFuture f = b.connect(host, port).sync();

			// 等待客户端链路关闭
			f.channel().closeFuture().sync();
		} catch (Exception e) {
			// 优雅退出,释放NIO线程组
			group.shutdownGracefully();
		}
	}

	public static void main(String[] args) {
		int port = 8080;
		new TimeClient().connect("127.0.0.1", port);
	}
}
