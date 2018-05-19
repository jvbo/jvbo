package com.youfan.redis;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.youfan.enity.Msmerchant;
import com.youfan.enity.Msorder;
import com.youfan.enity.Msproductinfo;
import com.youfan.enity.Msuser;
import com.youfan.service.cache.MsproductCacheService;
import com.youfan.service.redis.MsproductRedisService;
import com.youfan.service.redis.OrderRedisService;
import com.youfan.util.DateUtils;
import com.youfan.vo.msmerchant.MsmerchantVo;
import com.youfan.vo.msproductinfo.ConstomProduct;
import com.youfan.vo.msproductinfo.MsProductVo;
import com.youfan.vo.msuser.MsuserVo;
import com.youfan.vo.order.ConstomOrder;


public class OrderRedisServiceImpl implements OrderRedisService{
	
	
	@Autowired
	private RedisUtil redisUtil;
	
	@Autowired
	private AmqpTemplate amqpTemplate;

	public Map<String,Object> seckill(int userid, int productid,ConstomOrder msorder) {
		Map<String,Object> resultmap = new HashMap<String,Object>(); 
	    int stockcount = msorder.getStockcount();//ø‚¥Ê◊‹ ˝
	    if(redisUtil.getkeylistsize(productid+"")> stockcount){
	    	System.out.println("√Î…± ß∞‹");
	    	resultmap.put("success", false);
	    }
	    redisUtil.pushlist(productid+"", userid+"");
	    System.out.println("√Î…±≥…π¶");
	    String key = "userid:"+userid+"==productid:"+productid;
	    String value = "";
	    
	    String createtimestring = DateUtils.transferdate(new Date(), "yyyy-MM-dd HH:mm:ss");
	    String merchantid = msorder.getMerchantid()+"";
	    String payamount = msorder.getPayamount()+"";
	    String receivingadress = msorder.getReceivingadress();
	    String receivingname = msorder.getReceivingname();
	    String receivingphone = msorder.getReceivingphone();
	    String stockcountnum = msorder.getStockcount()+"";
	    String tradeserialnumber = createtimestring+UUID.randomUUID();
	    String paystatus = "1";
	    value += paystatus+"=="+tradeserialnumber+"=="+createtimestring+"=="+merchantid+"=="+payamount+"=="+receivingadress+"=="+receivingname+"=="+receivingphone+"=="+stockcountnum;
	    redisUtil.set(key, value);
	    Map<String,String> datamap = new HashMap<String,String>();
	    datamap.put("createtime", createtimestring);
	    datamap.put("merchantid", merchantid);
	    datamap.put("payamount", payamount);
	    datamap.put("receivingadress", receivingadress);
	    datamap.put("receivingname", receivingname);
	    datamap.put("receivingphone", receivingphone);
	    datamap.put("stockcountnum", stockcountnum);
	    datamap.put("tradeserialnumber", tradeserialnumber);
	    datamap.put("paystatus", paystatus);
	    datamap.put("productid", productid+"");
	    datamap.put("userid", userid+"");
	    
	    amqpTemplate.convertAndSend("ms_exchange", "orderinfomation", datamap);
	    
	    resultmap.put("success", true);
	    resultmap.put("datamap", datamap);
		return resultmap;
	}
	
	public boolean payorder(int paytype,int userid,int productid,int merchantid,String tradeserialnumber, int payamount){
		String key = "userid:"+userid+"==productid:"+productid;
		String value = (String) redisUtil.get(key);
		String[] splitvalues = value.split("==");
		splitvalues[0] = "2";
		value = "";
		for(String temp:splitvalues){
			value += temp+"==";
		}
		boolean issuccess = redisUtil.set(key, value);
		Map<String,String> datamap = new HashMap<String,String>();
		datamap.put("tradeserialnumber", tradeserialnumber);
		datamap.put("paystatus", "2");
		String paytimestring = DateUtils.transferdate(new Date(), "yyyy-MM-dd HH:mm:ss");
		datamap.put("paytimestring", paytimestring);
		datamap.put("paytype",paytype+"");
		amqpTemplate.convertAndSend("ms_exchange", "payinfomation", datamap);
		return issuccess;
	}
	
	public List<Msorder> queryorderbyuserid(int userid){
		List<Msorder> listmsorder = new ArrayList<Msorder>();
		Set<String> keys = redisUtil.getkeys("userid:"+userid);
		for(String key :keys){
			String[] prusers = key.split("==");
			if(prusers.length <= 1){
				continue;
			}
			String productid = prusers[1].split(":")[1]; 
			String useridstring = prusers[0].split(":")[1]; 
			String value = (String) redisUtil.get(key);
			String[] valuearray = value.split("==");
			String paystatus = valuearray[0];
			String tradeserialnumber = valuearray[1];
			String createtimestring= valuearray[2];
			String merchantid = valuearray[3];
			String payamount = valuearray[4];
			String receivingadress= valuearray[5];
			String receivingname= valuearray[6];
			String receivingphone= valuearray[7];
			String stockcountnum= valuearray[8];
			Msorder msorder = new Msorder();
			msorder.setCreatetime(DateUtils.transferdate(createtimestring, "yyyy-MM-dd HH:mm:ss"));
			msorder.setPayamount(Integer.valueOf(payamount));
			msorder.setMerchantid(Integer.valueOf(merchantid));
			msorder.setReceivingadress(receivingadress);
			msorder.setReceivingname(receivingname);
			msorder.setProductid(Integer.valueOf(productid));
			msorder.setReceivingphone(receivingphone);
			msorder.setTradeserialnumber(tradeserialnumber);
			msorder.setUserid(userid);
			msorder.setNum(1);
			msorder.setPaystatus(Integer.valueOf(paystatus));
			listmsorder.add(msorder);
		}
		return listmsorder;
	}
	
}
