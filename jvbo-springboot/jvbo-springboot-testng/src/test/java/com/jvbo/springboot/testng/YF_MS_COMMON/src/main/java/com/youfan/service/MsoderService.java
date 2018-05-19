package com.youfan.service;

import java.util.Date;
import java.util.List;

import com.youfan.enity.Msorder;

public interface MsoderService {
	
	public void insertMsOrder(Msorder msorder);
	
	public List<Msorder> queryorderbyuserid(int userid);
	
	public List<Msorder> queryorderbymerchantid(int merchantid);
	
	public void updateorderpaystatusbyid(int paystatus,int id,int paytype);
	
	public void updateorderbytrnumber(int paystatus,String tradeserialnumber,int paytype,Date paytime);
}
