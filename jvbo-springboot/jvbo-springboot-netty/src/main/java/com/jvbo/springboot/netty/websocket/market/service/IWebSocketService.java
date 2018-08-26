package com.jvbo.springboot.netty.websocket.market.service;


public interface IWebSocketService {
	void onReceive(String msg);

	void receiveTicker(String msg);

	void receiveKline(String msg);
}
