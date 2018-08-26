package com.jvbo.springboot.netty;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.util.CollectionUtils;

import com.jvbo.springboot.netty.websocket.market.WebSoketClient;
import com.jvbo.springboot.netty.websocket.market.service.IWebSocketService;

@SpringBootApplication
public class SpringBootNettyApplication implements CommandLineRunner {
    
    private static final String websocketUrl = "wss://ws.gateio.io/v3/";
    
    @Autowired
    private IWebSocketService webSocketService;
	
	public static void main(String[] args) {
	    SpringApplicationBuilder builder = new SpringApplicationBuilder(SpringBootNettyApplication.class).web(WebApplicationType.NONE);
	    builder.run(args);
	}

    @Override
    public void run(String... args) throws Exception {
        WebSoketClient tickerClient = new WebSoketClient(websocketUrl, webSocketService);
        tickerClient.start();
        // 添加订阅所有的行情
        List<String> listStr = new LinkedList<>();
        listStr.add("BTC_USDT");
        tickerClient.tickerChannel(listStr);
        
        // 添加订阅k线, 市场-币币
        /*String symbol = "BTC_USDT";
        Object[] params = new Object[2];
        params[0] = symbol;
        params[1] = 300;
        WebSoketClient klineClient = new WebSoketClient(websocketUrl, webSocketService);
        klineClient.start();
        klineClient.klineChannel(params);*/
    }
    
}
