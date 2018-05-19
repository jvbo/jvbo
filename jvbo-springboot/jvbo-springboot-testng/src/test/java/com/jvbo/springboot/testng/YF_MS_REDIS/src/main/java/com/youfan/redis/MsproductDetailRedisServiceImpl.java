package com.youfan.redis;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.youfan.enity.Msmerchant;
import com.youfan.enity.Msproductdetail;
import com.youfan.enity.Msproductinfo;
import com.youfan.enity.Msuser;
import com.youfan.service.cache.MsproductDetailCacheService;
import com.youfan.service.redis.MsproductDetailRedisService;
import com.youfan.vo.msmerchant.MsmerchantVo;
import com.youfan.vo.msproductinfo.ConstomProduct;
import com.youfan.vo.msproductinfo.MsProductVo;
import com.youfan.vo.msuser.MsuserVo;


public class MsproductDetailRedisServiceImpl implements MsproductDetailRedisService{
	
	@Autowired
	private MsproductDetailCacheService msproductDetailCacheService;
	
	@Autowired
	private RedisUtil redisUtil;
	
	public Msproductdetail queryMsproductdetailByid(int productid){
		Msproductdetail msproductdetail = null;
		Object result = redisUtil.get("detail:"+productid);
		if(result == null){
			msproductdetail = msproductDetailCacheService.queryMsproductdetailByid(productid);
			redisUtil.set("detail:"+productid, msproductdetail);
		}else{
			System.out.println("come into redis -- queryMsproductdetailByid");
			msproductdetail = (com.youfan.enity.Msproductdetail)result ;
		}
		return msproductdetail;
	}
	
}
