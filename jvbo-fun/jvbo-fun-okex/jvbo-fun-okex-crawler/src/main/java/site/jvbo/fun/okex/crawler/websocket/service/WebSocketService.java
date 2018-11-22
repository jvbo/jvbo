package site.jvbo.fun.okex.crawler.websocket.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import site.jvbo.fun.common.enums.PublicEnum;
import site.jvbo.fun.okex.crawler.manager.future.FutureTickerManager;
import site.jvbo.fun.okex.crawler.manager.spot.SpotTickerManager;
import site.jvbo.fun.okex.dao.model.*;
import site.jvbo.fun.okex.service.IOkexChannelService;
import site.jvbo.fun.okex.service.IOkexFutureTickerService;
import site.jvbo.fun.okex.service.IOkexSpotTickerService;

import java.math.BigDecimal;
import java.time.Instant;

/**
 * @ClassName:
 * @Description: TODO
 * @author: jvbo
 * @date: 2018/10/18
 */
@Component
public class WebSocketService implements IWebSocketService{
    private static final Logger logger = LoggerFactory.getLogger(WebSocketService.class);

	@Autowired
	private SpotTickerManager spotTickerManager;
	@Autowired
	private FutureTickerManager futureTickerManager;

	@Override
	public void receiveSpotTicker(String msg) {
		JSONObject msgJo = JSON.parseObject(msg);
		String channel = msgJo.getString("channel");
		String data = msgJo.getString("data");
		Long timestamp = msgJo.getJSONObject("data").getLong("timestamp");
		boolean bsFlag = spotTickerManager.spotTickerBs(timestamp, channel, data);
		if(!bsFlag){
			logger.error("receiveSpotTicker - 接收消息成功, bs处理消息失败, channel:{}, data:{}", channel, data);
		}
		boolean originFlag = spotTickerManager.spotTickerOrigin(timestamp, channel, data);
		if(!originFlag){
			logger.error("receiveSpotTicker - 接收消息成功, origin处理消息失败, channel:{}, data:{}", channel, data);
		}
	}

	@Override
	public void receiveFutureTicker(String msg) {
		JSONObject msgJo = JSON.parseObject(msg);
		String channel = msgJo.getString("channel");
		String data = msgJo.getString("data");
		Long timestamp = Instant.now().toEpochMilli();
		boolean bsFlag = futureTickerManager.futureTickerBs(timestamp, channel, data);
		if(!bsFlag){
			logger.error("receiveFutureTicker - 接收消息成功, bs处理消息失败, channel:{}, data:{}", channel, data);
		}
		boolean originFlag = futureTickerManager.futureTickerOrigin(timestamp, channel, data);
		if(!originFlag){
			logger.error("receiveFutureTicker - 接收消息成功, origin处理消息失败, channel:{}, data:{}", channel, data);
		}
	}
}
