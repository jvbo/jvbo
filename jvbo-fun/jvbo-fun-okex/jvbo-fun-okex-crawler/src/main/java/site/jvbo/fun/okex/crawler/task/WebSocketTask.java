package site.jvbo.fun.okex.crawler.task;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.ListUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import site.jvbo.fun.common.enums.PublicEnum;
import site.jvbo.fun.okex.crawler.websocket.WebSoketClient;
import site.jvbo.fun.okex.crawler.websocket.service.IWebSocketService;
import site.jvbo.fun.okex.dao.model.OkexChannel;
import site.jvbo.fun.okex.dao.model.OkexChannelExample;
import site.jvbo.fun.okex.service.IOkexChannelService;

import java.util.ArrayList;
import java.util.List;


/**
 * @ClassName:
 * @Description: TODO
 * @author: jvbo
 * @date: 2018/10/18
 */
@Component
public class WebSocketTask implements Task {
	private static final Logger logger = LoggerFactory.getLogger(WebSocketTask.class);

	private static final String WEBSOCKET_URL = "wss://okexcomreal.bafang.com:10441/websocket";
	private static final int ONCE_CHANNEL_MAX_COUNT = 50;

	private Thread thread;
	@Autowired
	private IOkexChannelService okexChannelService;
	@Autowired
	private IWebSocketService webSocketService;

	@Override
	public void doTask() {
		this.thread = Thread.currentThread();
		List<JSONObject> msgList = new ArrayList<>();

		OkexChannelExample okexChannelExample = new OkexChannelExample();
		okexChannelExample.createCriteria().andIsDeletedEqualTo(PublicEnum.FALSE.getCodeInt())
				.andIsOnlinedEqualTo(PublicEnum.TRUE.getCodeInt());
		List<OkexChannel> okexChannels = okexChannelService.selectByExample(okexChannelExample);
		if(CollectionUtils.isNotEmpty(okexChannels)){
			okexChannels.forEach(item -> {
				// spotTicker
				// 现货 {'event':'addChannel','channel':'ok_sub_spot_X_ticker'} X为币对比
				// 合约 {'event':'addChannel','channel':'ok_sub_futureusd_X_ticker_Y'} X为币,Y:this_week, next_week, quarter
				String channel = item.getChannel();
				JSONObject msgJo = new JSONObject();
				msgJo.put("event", "addChannel");
				msgJo.put("channel", channel);
				msgList.add(msgJo);
			});
		}

		if(CollectionUtils.isNotEmpty(msgList)){
			WebSoketClient client = new WebSoketClient(WEBSOCKET_URL, webSocketService);
			client.start();
			// 分批次,一次50个
			int allChannelCount = msgList.size();
			int mod = allChannelCount % ONCE_CHANNEL_MAX_COUNT;
			int result = allChannelCount / ONCE_CHANNEL_MAX_COUNT;
			if(mod > 0){
				result += 1;
			}
			List<List<JSONObject>> partitionList = ListUtils.partition(msgList, result);
			partitionList.forEach(item -> client.addChannel(item));
		}
	}

	@Override
	public Thread executeThread() {
		return this.thread;
	}

	@Override
	public void run() {
		this.doTask();
	}
}
