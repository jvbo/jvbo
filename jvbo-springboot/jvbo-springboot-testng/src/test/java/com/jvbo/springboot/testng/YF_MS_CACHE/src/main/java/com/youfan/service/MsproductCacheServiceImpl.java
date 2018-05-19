package com.youfan.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.youfan.dao.MsmerchantDao;
import com.youfan.dao.MsproductDao;
import com.youfan.dao.MsuserDao;
import com.youfan.enity.Msmerchant;
import com.youfan.enity.Msproductinfo;
import com.youfan.enity.Msuser;
import com.youfan.service.cache.MsproductCacheService;
import com.youfan.vo.msmerchant.MsmerchantVo;
import com.youfan.vo.msproductinfo.ConstomProduct;
import com.youfan.vo.msproductinfo.MsProductVo;
import com.youfan.vo.msuser.MsuserVo;


public class MsproductCacheServiceImpl implements MsproductCacheService{
	
	@Autowired
	private MsproductService msproductService;
	
	/**
	 * 根据秒杀商品id查询秒杀商品
	 * @param msproductinfo
	 */
	@Cacheable(value="MS_Cache", key="'product:' + #id")
	public Msproductinfo querymsproductByid(int id){
		System.out.println("come into querymsproductByid");
		
		return msproductService.querymsproductByid(id);
	}
	
	
	
}
