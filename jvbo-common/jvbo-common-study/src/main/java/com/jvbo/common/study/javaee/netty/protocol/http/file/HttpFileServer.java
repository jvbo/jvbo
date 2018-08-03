package com.jvbo.common.study.javaee.netty.protocol.http.file;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpRequestDecoder;
import io.netty.handler.codec.http.HttpResponseEncoder;
import io.netty.handler.stream.ChunkedWriteHandler;

/**
 * @ClassName:
 * @Description: TODO
 * @author: jvbo
 * @date: 2018/7/31
 */
public class HttpFileServer {

	private static final String DEFAULT_URL = "/jvbo-common/jvbo-common-study/src/main/java/com/jvbo/common/study/javaee/netty/";

	public void run(final int port, final String url) throws InterruptedException {
		EventLoopGroup bossGroup = new NioEventLoopGroup();
		EventLoopGroup workerGroup = new NioEventLoopGroup();

		try {
			ServerBootstrap b = new ServerBootstrap();
			b.group(bossGroup, workerGroup)
					.option(ChannelOption.SO_BACKLOG, 100)
					.channel(NioServerSocketChannel.class)
					.childHandler(new ChannelInitializer<SocketChannel>() {
						@Override
						protected void initChannel(SocketChannel ch) throws Exception {
							ch.pipeline().addLast("http-decoder", new HttpRequestDecoder());// 负责把字节解码成http请求
							ch.pipeline().addLast("http-aggregator", new HttpObjectAggregator(65536));// 负责把多个HttpMessage组装成一个完整的Http请求或者响应;
							ch.pipeline().addLast("http-encoder", new HttpResponseEncoder());// 负责把响应编码成字节
							ch.pipeline().addLast("http-chunked", new ChunkedWriteHandler());// 主要为了处理大文件传输的情形;
							ch.pipeline().addLast("fileServerHandler", new HttpFileServerHandler(url));
						}
					});

			ChannelFuture future = b.bind("192.168.0.193", port).sync();
			System.out.println("HTTP文件服务器启动,网址是:" + "http://192.168.0.193:" + port + url);
			future.channel().closeFuture().sync();
		} finally {
			bossGroup.shutdownGracefully();
			workerGroup.shutdownGracefully();
		}
	}

	public static void main(String[] args) throws InterruptedException {
		int port = 8080;
		String url = DEFAULT_URL;
		new HttpFileServer().run(port, url);
	}

}
