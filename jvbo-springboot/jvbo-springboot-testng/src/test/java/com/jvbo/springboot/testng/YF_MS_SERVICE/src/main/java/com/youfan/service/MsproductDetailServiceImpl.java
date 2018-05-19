package com.youfan.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.youfan.dao.MsmerchantDao;
import com.youfan.dao.MsproductDao;
import com.youfan.dao.MsproductdetailDao;
import com.youfan.dao.MsuserDao;
import com.youfan.enity.Msmerchant;
import com.youfan.enity.Msproductdetail;
import com.youfan.enity.Msproductinfo;
import com.youfan.enity.Msuser;
import com.youfan.vo.msmerchant.MsmerchantVo;
import com.youfan.vo.msproductinfo.ConstomProduct;
import com.youfan.vo.msproductinfo.MsProductVo;
import com.youfan.vo.msuser.MsuserVo;

@Service
public class MsproductDetailServiceImpl implements MsproductDetailService{
	
	@Autowired
	MsproductdetailDao msproductdetailDao;
	
	public void insertMsproductdetail(Msproductdetail msproductdetail){
		msproductdetailDao.insertMsproductdetail(msproductdetail);
	}
	public Msproductdetail queryMsproductdetailByid(int productid){
		return msproductdetailDao.queryMsproductdetailByid(productid);
	}
	public void updateMsproductdetail(Msproductdetail msproductdetail){
		msproductdetailDao.updateMsproductdetail(msproductdetail);
	}
	
}
