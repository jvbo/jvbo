package site.jvbo.fun.okex.crawler.websocket;

import site.jvbo.fun.okex.crawler.websocket.service.IWebSocketService;

/**
 * @ClassName:
 * @Description: TODO
 * @author: jvbo
 * @date: 2018/10/18
 */
public class WebSoketClient extends WebSocketBase {
	public WebSoketClient(String url, IWebSocketService service){
		super(url, service);
	}
}
