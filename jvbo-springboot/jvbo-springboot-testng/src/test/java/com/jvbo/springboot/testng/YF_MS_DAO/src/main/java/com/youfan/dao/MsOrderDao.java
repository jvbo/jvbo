package com.youfan.dao;

import java.util.Date;
import java.util.List;

import com.youfan.enity.Msorder;
import com.youfan.vo.order.MsorderVo;

public interface MsOrderDao {
	public void insertMsOrder(Msorder msorder);
	public List<Msorder> queryorderbyuserid(int userid);
	public void updateorderpaystatusbyid(MsorderVo msorderVo);
	public void updateorderbytrnumber(MsorderVo msorderVo);
	public List<Msorder> queryorderbymerchantid(int merchantid);
}
