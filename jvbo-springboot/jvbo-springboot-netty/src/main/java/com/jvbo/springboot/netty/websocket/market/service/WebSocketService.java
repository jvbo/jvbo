package com.jvbo.springboot.netty.websocket.market.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class WebSocketService implements IWebSocketService{
    private static final Logger logger = LoggerFactory.getLogger(WebSocketService.class);

    @Override
	public void onReceive(String msg){
        logger.info("WebSocket Client received message");
	}

	@Override
	public void receiveTicker(String msg) {
	    logger.error("接收消息成功, msg:{}", msg);
	}

	@Override
	public void receiveKline(String msg) {
        logger.error("接收消息成功, msg:{}", msg);
	}
}
