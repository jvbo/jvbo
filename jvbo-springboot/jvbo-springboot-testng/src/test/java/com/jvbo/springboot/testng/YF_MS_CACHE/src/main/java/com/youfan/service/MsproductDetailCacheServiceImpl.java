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
import com.youfan.dao.MsproductdetailDao;
import com.youfan.dao.MsuserDao;
import com.youfan.enity.Msmerchant;
import com.youfan.enity.Msproductdetail;
import com.youfan.enity.Msproductinfo;
import com.youfan.enity.Msuser;
import com.youfan.service.cache.MsproductDetailCacheService;
import com.youfan.vo.msmerchant.MsmerchantVo;
import com.youfan.vo.msproductinfo.ConstomProduct;
import com.youfan.vo.msproductinfo.MsProductVo;
import com.youfan.vo.msuser.MsuserVo;


public class MsproductDetailCacheServiceImpl implements MsproductDetailCacheService{
	
	@Autowired
	private MsproductDetailService msproductDetailService;
	
	@Cacheable(value="MS_Cache", key="'productdetail:' + #productid")
	public Msproductdetail queryMsproductdetailByid(int productid){
		System.out.println("come into queryMsproductdetailByid");
		return msproductDetailService.queryMsproductdetailByid(productid);
	}
	
}
