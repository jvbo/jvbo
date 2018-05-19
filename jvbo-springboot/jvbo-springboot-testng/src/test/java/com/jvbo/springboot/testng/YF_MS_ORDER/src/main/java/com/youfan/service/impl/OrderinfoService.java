package com.youfan.service.impl;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.HashMap;
import java.util.Map;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.beans.factory.annotation.Autowired;

import com.youfan.enity.Msorder;
import com.youfan.service.MsoderService;
import com.youfan.util.DateUtils;

public class OrderinfoService implements MessageListener {
	
	@Autowired
	MsoderService msoderService;
	
    public void onMessage(Message message) {
		try {
			byte[] messsagebyte = message.getBody();
			ByteArrayInputStream in = new ByteArrayInputStream(messsagebyte);
			ObjectInputStream obj = new ObjectInputStream(in);
			Map<String,String> datamap = (Map<String, String>) obj.readObject();
		    
			String createtime = datamap.get("createtime");
			String merchantid = datamap.get("merchantid");
			String payamount = datamap.get("payamount");
			String receivingadress = datamap.get("receivingadress");
			String receivingphone = datamap.get("receivingphone");
			String stockcountnum = datamap.get("stockcountnum");
			String receivingname = datamap.get("receivingname");
			String tradeserialnumber = datamap.get("tradeserialnumber");
			String paystatus = datamap.get("paystatus");
			String productid = datamap.get("productid");
			String userid= datamap.get("userid");
			Msorder msorder = new Msorder();
			msorder.setUserid(Integer.valueOf(userid));
			msorder.setProductid(Integer.valueOf(productid));
			msorder.setCreatetime(DateUtils.transferdate(createtime, "yyyy-MM-dd HH:mm:ss"));
			msorder.setTradeserialnumber(tradeserialnumber);
			msorder.setMerchantid(Integer.valueOf(merchantid));
			msorder.setNum(1);
			msorder.setPayamount(Integer.valueOf(payamount));
			msorder.setPaystatus(Integer.valueOf(paystatus));
			msorder.setReceivingadress(receivingadress);
			msorder.setReceivingname(receivingname);
			msorder.setReceivingphone(receivingphone);
			msoderService.insertMsOrder(msorder);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println("消息消费者 = " + message.toString());
    }
}
