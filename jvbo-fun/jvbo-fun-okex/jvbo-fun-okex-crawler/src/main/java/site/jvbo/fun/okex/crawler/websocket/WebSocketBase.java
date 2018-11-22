package site.jvbo.fun.okex.crawler.websocket;

import com.alibaba.fastjson.JSON;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.http.DefaultHttpHeaders;
import io.netty.handler.codec.http.HttpClientCodec;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.handler.codec.http.websocketx.WebSocketClientHandshakerFactory;
import io.netty.handler.codec.http.websocketx.WebSocketVersion;
import io.netty.handler.ssl.SslContext;
import io.netty.handler.ssl.SslContextBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import site.jvbo.fun.okex.crawler.websocket.service.IWebSocketService;

import java.net.URI;
import java.util.*;

/**
 * @ClassName:
 * @Description: TODO
 * @author: jvbo
 * @date: 2018/10/18
 */
public abstract class WebSocketBase {
    private static final Logger logger = LoggerFactory.getLogger(WebSocketBase.class);

	private IWebSocketService service = null;
	private Timer timerTask = null;
	private MoniterTask moniter = null;
	private EventLoopGroup group = null;
	private Bootstrap bootstrap = null;
	private Channel channel = null;
	private String url = null;
	private ChannelFuture future = null;
	private boolean isAlive = false;
	private Set<Object> subscribChannel = Collections.synchronizedSet(new HashSet<>());

	public WebSocketBase(String url, IWebSocketService serivce) {
		this.url = url;
		this.service = serivce;
	}

	public void start() {
		if (url == null) {
		    logger.info("WebSocketClient start error  url can not be null");
			return;
		}
		if (service == null) {
		    logger.info("WebSocketClient start error  WebSocketService can not be null");
			return;
		}
		moniter = new MoniterTask(this);
		this.connect();
		timerTask = new Timer();
		timerTask.schedule(moniter, 1000, 5000);
	}

	public void setStatus(boolean flag) {
		this.isAlive = flag;
	}

	public void addChannel(Object params) {
		if (params == null) {
			return;
		}
		String dataMsg = JSON.toJSONString(params);
		this.sendMessage(dataMsg);
		subscribChannel.add(params);

	}

	private void connect() {
		try {
			final URI uri = new URI(url);
			group = new NioEventLoopGroup(1);
			bootstrap = new Bootstrap();
			final SslContext sslCtx = SslContextBuilder.forClient().build();
			final WebSocketClientHandler handler = new WebSocketClientHandler(
					WebSocketClientHandshakerFactory.newHandshaker(uri,
							WebSocketVersion.V13, null, false,
							new DefaultHttpHeaders(), Integer.MAX_VALUE),
					service, moniter);
			bootstrap.group(group).option(ChannelOption.TCP_NODELAY, true)
					.channel(NioSocketChannel.class)
					.handler(new ChannelInitializer<SocketChannel>() {
						protected void initChannel(SocketChannel ch) {
							ChannelPipeline p = ch.pipeline();
							if (sslCtx != null) {
								p.addLast(sslCtx.newHandler(ch.alloc(),
										uri.getHost(), uri.getPort()));
							}
							p.addLast(new HttpClientCodec(),
									new HttpObjectAggregator(8192), handler);
						}
					});

			future = bootstrap.connect(uri.getHost(), uri.getPort());
//			future.addListener(new ChannelFutureListener() {
//				public void operationComplete(final ChannelFuture future)
//						throws Exception {
//				}
//			});
			channel = future.sync().channel();
			handler.handshakeFuture().sync();
			this.setStatus(true);
		} catch (Exception e) {
			logger.error("WebSocketClient start error, 异常:{}, 详情:{} ", e.getMessage(), JSON.toJSONString(e));
			group.shutdownGracefully();
			this.setStatus(false);
		}
	}

	private void sendMessage(String message) {
		if (!isAlive) {
		    logger.error("WebSocket is not Alive addChannel error");
		}
		channel.writeAndFlush(new TextWebSocketFrame(message));
	}

	public void sentPing() {
		String dataMsg = "{'event':'ping'}";
		this.sendMessage(dataMsg);
	}

	public void reConnect() {
		try {
			this.group.shutdownGracefully();
			this.group = null;
			this.connect();
			if (future.isSuccess()) {
				this.setStatus(true);
				this.sentPing();
				Iterator<Object> it = subscribChannel.iterator();
				while (it.hasNext()) {
					Object channel = it.next();
					this.addChannel(channel);
				}

			}

		} catch (Exception e) {
			logger.error("WebSocketClient reConnect error, 异常:{}, 详情:{} ", e.getMessage(), JSON.toJSONString(e));
			e.printStackTrace();
		}
	}
}

class MoniterTask extends TimerTask {
    private static final Logger logger = LoggerFactory.getLogger(MoniterTask.class);

	private long startTime = System.currentTimeMillis();
	private int checkTime = 5000;
	private WebSocketBase client = null;

	public void updateTime() {
	    //logger.info("startTime is update");
		startTime = System.currentTimeMillis();
	}

	public MoniterTask(WebSocketBase client) {
		this.client = client;
		//logger.info("TimerTask is starting.... ");
	}

	public void run() {
		if (System.currentTimeMillis() - startTime > checkTime) {
			client.setStatus(false);
			//logger.info("Moniter reconnect....... ");
			client.reConnect();
		}
		client.sentPing();
		//logger.info("Moniter ping data sent.... ");
	}
}
