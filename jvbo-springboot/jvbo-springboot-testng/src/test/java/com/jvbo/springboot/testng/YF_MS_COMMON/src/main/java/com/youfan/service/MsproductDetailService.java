package com.youfan.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.youfan.enity.Msmerchant;
import com.youfan.enity.Msproductdetail;
import com.youfan.enity.Msproductinfo;
import com.youfan.enity.Msuser;
import com.youfan.vo.msmerchant.MsmerchantVo;
import com.youfan.vo.msproductinfo.ConstomProduct;
import com.youfan.vo.msproductinfo.MsProductVo;
import com.youfan.vo.msuser.MsuserVo;


public interface MsproductDetailService {
	
	public void insertMsproductdetail(Msproductdetail msproductdetail);
	public Msproductdetail queryMsproductdetailByid(int productid);
	public void updateMsproductdetail(Msproductdetail msproductdetail);
	
}
