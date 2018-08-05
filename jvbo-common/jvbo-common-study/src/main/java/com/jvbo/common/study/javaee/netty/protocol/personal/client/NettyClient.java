package com.jvbo.common.study.javaee.netty.protocol.personal.client;

import com.jvbo.common.study.javaee.netty.protocol.personal.NettyConstant;
import com.jvbo.common.study.javaee.netty.protocol.personal.codec.NettyMessageDecoder;
import com.jvbo.common.study.javaee.netty.protocol.personal.codec.NettyMessageEncoder;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.timeout.ReadTimeoutHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetSocketAddress;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName:
 * @Description: TODO
 * @author: jvbo
 * @date: 2018/8/1
 */
public class NettyClient {
	private static final Logger logger = LoggerFactory.getLogger(NettyClient.class);

	private ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);
	EventLoopGroup group = new NioEventLoopGroup();// 工作线程组

	public void connect(String host, int port) throws InterruptedException {
		// 配置客户端NIO线程组
		try {
			Bootstrap b = new Bootstrap();
			b.group(group)
					.channel(NioSocketChannel.class)
					.option(ChannelOption.TCP_NODELAY, true)
					.handler(new ChannelInitializer<SocketChannel>() {
						@Override
						protected void initChannel(SocketChannel ch) throws Exception {
							ch.pipeline().addLast("MessageDecoder", new NettyMessageDecoder(1024 * 1024, 4, 4));
							ch.pipeline().addLast("MessageEncoder", new NettyMessageEncoder());
							ch.pipeline().addLast("readTimeoutHandler", new ReadTimeoutHandler(20));
							ch.pipeline().addLast("LoginAuthHandler", new LoginAuthReqHandler());
							ch.pipeline().addLast("HeartBeatHandler", new HeartBeatReqHandler());
							ch.pipeline().addLast(new NettyClientHandler());
						}
					});

			// 发起异步连接操作
			ChannelFuture future = b.connect(new InetSocketAddress(host, port),
					new InetSocketAddress(NettyConstant.LOCALIP, NettyConstant.LOCAL_PORT)).sync();
			future.channel().closeFuture().sync();
		} finally {
			// 所有资源释放完成之后,清空资源,再次发起重连操作
			executorService.execute(new Runnable() {
				@Override
				public void run() {
					try {
						TimeUnit.SECONDS.sleep(5);
						logger.info("发起重连");
						connect(NettyConstant.REMOTEIP, NettyConstant.PORT);// 发起重连操作
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			});
		}
	}

	public static void main(String[] args) throws InterruptedException {
		new NettyClient().connect(NettyConstant.REMOTEIP, NettyConstant.PORT);
	}

}
