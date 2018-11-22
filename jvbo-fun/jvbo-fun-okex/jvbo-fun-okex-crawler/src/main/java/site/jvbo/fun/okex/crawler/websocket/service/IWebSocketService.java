package site.jvbo.fun.okex.crawler.websocket.service;

/**
 * @ClassName:
 * @Description: TODO
 * @author: jvbo
 * @date: 2018/10/18
 */
public interface IWebSocketService {
	void receiveSpotTicker(String msg);
	void receiveFutureTicker(String msg);
}
