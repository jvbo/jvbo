package com.jvbo.springboot.netty.websocket.market;

import java.net.URI;
import java.time.Instant;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jvbo.springboot.netty.websocket.market.service.IWebSocketService;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
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

/**
 * @see #https://gateio.io/docs/websocket/index.html
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
	private Set<JSONObject> subscribChannel = new HashSet<>();

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


	/**
	 * 行情
	 * @param params
	 */
	public void tickerChannel(Object params) {
		if (params == null) {
			return;
		}
		// 所有行情
		/*{"id":1534144225000,"method":"ticker.subscribe","params":["BCH_BTC"]}*/
		JSONObject dataJo = new JSONObject();
		dataJo.put("method", "ticker.subscribe");
		dataJo.put("params", params);
		addChannel(dataJo);
	}

	/**
	 * kline
	 * @param params
	 */
	public void klineChannel(Object params){
	    if (params == null) {
            return;
        }
        // kline
		/*{"id":3966007,"method":"kline.subscribe","params":["BCH_BTC",300]}*/
		JSONObject dataJo = new JSONObject();
		dataJo.put("method", "kline.subscribe");
		dataJo.put("params", params);
		addChannel(dataJo);
	}

	public void addChannel(JSONObject params) {
        logger.info("addChannel:{}", params.toJSONString());
		if (params == null) {
			return;
		}
		params.put("id", Instant.now().toEpochMilli());
		String dataMsg = params.toJSONString();
		this.sendMessage(dataMsg);
		subscribChannel.add(params);
	}

	private void connect() {
		try {
			final URI uri = new URI(url);
			String scheme = uri.getScheme() == null ? "ws" : uri.getScheme();
			final String host = uri.getHost() == null ? "127.0.0.1" : uri.getHost();
			final int port;
			if (uri.getPort() == -1) {
				if ("ws".equalsIgnoreCase(scheme)) {
					port = 80;
				} else if ("wss".equalsIgnoreCase(scheme)) {
					port = 443;
				} else {
					port = -1;
				}
			} else {
				port = uri.getPort();
			}
			group = new NioEventLoopGroup(1);
			bootstrap = new Bootstrap();
			final SslContext sslCtx = SslContextBuilder.forClient().build();
			final WebSocketClientHandler handler = new WebSocketClientHandler(
					WebSocketClientHandshakerFactory.newHandshaker(uri,
							WebSocketVersion.V13, null, false,
							new DefaultHttpHeaders()),
					service, moniter);
			bootstrap.group(group).option(ChannelOption.TCP_NODELAY, true)
					.channel(NioSocketChannel.class)
					.handler(new ChannelInitializer<SocketChannel>() {
						protected void initChannel(SocketChannel ch) {
							ChannelPipeline p = ch.pipeline();
							if (sslCtx != null) {
								p.addLast(sslCtx.newHandler(ch.alloc(),
										host, port));
							}
							p.addLast(new HttpClientCodec(),
									new HttpObjectAggregator(8192), handler);
						}
					});

			future = bootstrap.connect(host, port);
			future.addListener(new ChannelFutureListener() {
				public void operationComplete(final ChannelFuture future)
						throws Exception {
				}
			});
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
		logger.info("message:{}", message);
		channel.writeAndFlush(new TextWebSocketFrame(message));
	}

	public void sentPing() {
	    JSONObject params = new JSONObject();
	    params.put("id", Instant.now().toEpochMilli());
        params.put("method", "server.ping");
        params.put("params", new Object[]{});
        String dataMsg = params.toJSONString();
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
				Iterator<JSONObject> it = subscribChannel.iterator();
				while (it.hasNext()) {
					JSONObject channel = it.next();
					this.addChannel(channel);
				}

			}

		} catch (Exception e) {
			logger.error("WebSocketClient reConnect error, 异常:{}, 详情:{} ", e.getMessage(), JSON.toJSONString(e));
			e.printStackTrace();
		}
	}

	public void setUrl(String url) {
		this.url = url;
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
