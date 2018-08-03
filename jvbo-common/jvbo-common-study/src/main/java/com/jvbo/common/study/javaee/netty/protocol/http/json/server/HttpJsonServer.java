package com.jvbo.common.study.javaee.netty.protocol.http.json.server;

import com.jvbo.common.study.javaee.netty.protocol.http.json.codec.HttpJsonRequestDecoder;
import com.jvbo.common.study.javaee.netty.protocol.http.json.codec.HttpJsonResponseEncoder;
import com.jvbo.common.study.javaee.netty.protocol.http.pojo.Order;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpRequestDecoder;
import io.netty.handler.codec.http.HttpResponseEncoder;

import java.net.InetSocketAddress;

/**
 * @ClassName:
 * @Description: TODO
 * @author: jvbo
 * @date: 2018/7/31
 */
public class HttpJsonServer {

	public void run(final int port) throws InterruptedException {
		EventLoopGroup bossGroup = new NioEventLoopGroup();
		EventLoopGroup workerGroup = new NioEventLoopGroup();

		try {
			ServerBootstrap b = new ServerBootstrap();
			b.group(bossGroup, workerGroup).channel(NioServerSocketChannel.class)
					.childHandler(new ChannelInitializer<SocketChannel>() {
						@Override
						protected void initChannel(SocketChannel ch) throws Exception {
							ch.pipeline().addLast("http-decoder", new HttpRequestDecoder());
							ch.pipeline().addLast("http-aggregator", new HttpObjectAggregator(65536));
							ch.pipeline().addLast("json-decoder", new HttpJsonRequestDecoder(Order.class, true));
							ch.pipeline().addLast("http-encoder", new HttpResponseEncoder());
							ch.pipeline().addLast("json-encoder", new HttpJsonResponseEncoder());
							ch.pipeline().addLast(new HttpJsonServerHandler());
						}
					});

			ChannelFuture f = b.bind(new InetSocketAddress(port)).sync();

			f.channel().closeFuture().sync();
		} finally {
			// 优雅退出,释放线程池资源
			bossGroup.shutdownGracefully();
			workerGroup.shutdownGracefully();
		}
	}

	public static void main(String[] args) throws InterruptedException {
		int port = 8080;
		new HttpJsonServer().run(port);
	}

}
