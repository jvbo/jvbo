package com.jvbo.springboot.netty.websocket.market;

import com.jvbo.springboot.netty.websocket.market.service.IWebSocketService;

public class WebSoketClient extends WebSocketBase {
	public WebSoketClient(String url, IWebSocketService service){
		super(url, service);
	}
}
