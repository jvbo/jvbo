package com.youfan.service.redis;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import com.youfan.enity.Msmerchant;
import com.youfan.enity.Msproductinfo;
import com.youfan.enity.Msuser;
import com.youfan.vo.msmerchant.MsmerchantVo;
import com.youfan.vo.msproductinfo.ConstomProduct;
import com.youfan.vo.msproductinfo.MsProductVo;
import com.youfan.vo.msuser.MsuserVo;


public interface MsproductRedisService {
	
	/**
	 * 根据秒杀商品id查询秒杀商品
	 * @param msproductinfo
	 */
	public Msproductinfo querymsproductByid(int id);
	
	
	
	
	
}
