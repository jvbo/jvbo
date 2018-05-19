package com.youfan.dao;

import java.util.List;

import com.youfan.enity.Msproductdetail;
import com.youfan.enity.Msproductinfo;
import com.youfan.vo.msproductinfo.MsProductVo;

public interface MsproductdetailDao {
	public void insertMsproductdetail(Msproductdetail msproductdetail);
	public Msproductdetail queryMsproductdetailByid(int productid);
	public void updateMsproductdetail(Msproductdetail msproductdetail);
}
