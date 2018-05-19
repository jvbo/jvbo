package com.youfan.dao;

import java.util.List;

import com.youfan.enity.Msproductinfo;
import com.youfan.vo.msproductinfo.MsProductVo;

public interface MsproductDao {
	public void applymsproduct(Msproductinfo msproductinfo);
	public List<Msproductinfo> listmsproduct(MsProductVo msProductVo);
	public Msproductinfo querymsproductByid(int id);
	public void deletemsproductByid(int id);
	public void updatemsproduct(Msproductinfo msproductinfo);
	public void updatemsproductstate(MsProductVo msProductVo);
}
