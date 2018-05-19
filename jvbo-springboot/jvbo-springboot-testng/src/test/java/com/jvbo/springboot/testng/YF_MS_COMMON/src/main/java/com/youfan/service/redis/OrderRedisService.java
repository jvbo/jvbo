package com.youfan.service.redis;

import java.util.List;
import java.util.Map;

import com.youfan.enity.Msorder;
import com.youfan.vo.order.ConstomOrder;

public interface OrderRedisService {
	public Map<String,Object> seckill(int userid, int productid,ConstomOrder msorder);
	
	public boolean payorder(int paytype,int userid,int productid,int merchantid,String tradeserialnumber, int payamount);
	
	public List<Msorder> queryorderbyuserid(int userid);
}
