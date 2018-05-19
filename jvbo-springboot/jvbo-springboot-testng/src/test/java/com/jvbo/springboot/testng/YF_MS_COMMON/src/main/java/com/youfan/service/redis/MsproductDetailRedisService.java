package com.youfan.service.redis;

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


public interface MsproductDetailRedisService {
	
	public Msproductdetail queryMsproductdetailByid(int productid);
	
}
