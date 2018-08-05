package com.jvbo.common.study.javaee.netty.protocol.personal.server;

import com.jvbo.common.study.javaee.netty.protocol.personal.NettyConstant;
import com.jvbo.common.study.javaee.netty.protocol.personal.codec.NettyMessageDecoder;
import com.jvbo.common.study.javaee.netty.protocol.personal.codec.NettyMessageEncoder;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.handler.timeout.ReadTimeoutHandler;

/**
 * @ClassName:
 * @Description: TODO
 * @author: jvbo
 * @date: 2018/8/1
 */
public class NettyServer {

	public void bind() throws InterruptedException {
		// 配置服务端NIO线程组
		// 1. 用于接收客户端连接的线程工作组
		EventLoopGroup bossGroup = new NioEventLoopGroup();
		// 2. 用于对接收客户端连接读写操作的线程工作组
		EventLoopGroup workerGroup = new NioEventLoopGroup();
		try {
			// 3. 辅助类,用于帮助创建Netty服务
			ServerBootstrap b = new ServerBootstrap();
			b.group(bossGroup, workerGroup)// 绑定两个工作线程组
					.channel(NioServerSocketChannel.class) // 设置nio模式
					.option(ChannelOption.SO_BACKLOG, 1024) // 设置tcp缓冲区
					.option(ChannelOption.SO_RCVBUF, 32 * 1024) //设置接收数据的缓存大小
					.option(ChannelOption.SO_KEEPALIVE, Boolean.TRUE) // 设置保持连接
					.option(ChannelOption.SO_SNDBUF, 32 * 1024)
					.handler(new LoggingHandler(LogLevel.INFO))
					.childHandler(new ChannelInitializer<SocketChannel>() { // 初始化绑定服务通道
						@Override
						protected void initChannel(SocketChannel ch) throws Exception {
							ch.pipeline().addLast(new NettyMessageDecoder(5 * 1024 * 1024, 4, 4));
							ch.pipeline().addLast(new NettyMessageEncoder());
							ch.pipeline().addLast("readTimeoutHandler", new ReadTimeoutHandler(20));
							ch.pipeline().addLast("LoginAuthHandler", new LoginAuthRespHandler());
							ch.pipeline().addLast("HeartBeatHandler", new HeartBeatRespHandler());
							ch.pipeline().addLast(new NettyServerHandler());
						}
					});

			// 绑定端口, 同步等待成功
			ChannelFuture future = b.bind(NettyConstant.REMOTEIP, NettyConstant.PORT).sync();
			System.out.println("netty server start ok : " + (NettyConstant.REMOTEIP + ":" + NettyConstant.PORT));

			future.channel().closeFuture().sync();
		} finally {
			// 优雅退出,释放线程池资源
			bossGroup.shutdownGracefully();
			workerGroup.shutdownGracefully();
		}
	}

	public static void main(String[] args) throws InterruptedException {
		new NettyServer().bind();
	}
}
