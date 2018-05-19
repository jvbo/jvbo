package com.youfan.service.impl;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Date;
import java.util.Map;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.beans.factory.annotation.Autowired;

import com.youfan.enity.Msorder;
import com.youfan.service.MsoderService;
import com.youfan.util.DateUtils;

public class PayinfoService implements MessageListener {
	
	@Autowired
	MsoderService msoderService;
	
    public void onMessage(Message message) {
    	
		try {
			byte[] messsagebyte = message.getBody();
			ByteArrayInputStream in = new ByteArrayInputStream(messsagebyte);
			ObjectInputStream obj;
			obj = new ObjectInputStream(in);
			Map<String,String> datamap = (Map<String, String>) obj.readObject();
			String tradeserialnumber = datamap.get("tradeserialnumber");
			String paystatus = datamap.get("paystatus");
			String paytimestring = datamap.get("paytimestring");
			String paytype = datamap.get("paytype");
			
			msoderService.updateorderbytrnumber(Integer.valueOf(paystatus), tradeserialnumber, Integer.valueOf(paytype), DateUtils.transferdate(paytimestring, "yyyy-MM-dd HH:mm:ss"));
			
	        System.out.println("消息消费者 = " + message.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
