package com.youfan.redis;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.youfan.enity.Msmerchant;
import com.youfan.enity.Msproductinfo;
import com.youfan.enity.Msuser;
import com.youfan.service.cache.MsproductCacheService;
import com.youfan.service.redis.MsproductRedisService;
import com.youfan.vo.msmerchant.MsmerchantVo;
import com.youfan.vo.msproductinfo.ConstomProduct;
import com.youfan.vo.msproductinfo.MsProductVo;
import com.youfan.vo.msuser.MsuserVo;


public class MsproductRedisServiceImpl implements MsproductRedisService{
	
	@Autowired
	private MsproductCacheService msproductCacheService;
	
	@Autowired
	private RedisUtil redisUtil;
	
	/**
	 * 根据秒杀商品id查询秒杀商品
	 * @param msproductinfo
	 */
	public Msproductinfo querymsproductByid(int id){
		Msproductinfo msproductinfo = null;
		Object value = redisUtil.get("product:"+id);
		if(value == null){
			msproductinfo = msproductCacheService.querymsproductByid(id);
			redisUtil.set("product:"+id, msproductinfo);
		}else{
			System.out.println("come into  redis --  querymsproductByid");
			msproductinfo = (Msproductinfo)value;
		}
		return msproductinfo;
	}
	
	
	
}
