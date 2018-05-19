package com.youfan.service;

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


public interface MsproductService {
	/**
	 * 申请秒杀商品
	 * @param msproductinfo
	 */
	public void applymsproduct(Msproductinfo msproductinfo);
	
	/**
	 * 秒杀商品列表
	 * @param msproductinfo
	 */
	public List<Msproductinfo> listmsproduct(MsProductVo msProductVo);
	
	/**
	 * 根据秒杀商品id查询秒杀商品
	 * @param msproductinfo
	 */
	public Msproductinfo querymsproductByid(int id);
	
	public void deletemsproductByid(int id);
	
	public void updatemsproduct(Msproductinfo msproductinfo);
	
	/**
	 * 跟新转态
	 * @param id
	 * @param state
	 */
	public void updatemsproductstate(int id,int state);
	
	
	
}
