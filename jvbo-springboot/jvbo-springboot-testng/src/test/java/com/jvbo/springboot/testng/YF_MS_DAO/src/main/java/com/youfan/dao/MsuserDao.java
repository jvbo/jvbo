package com.youfan.dao;

import java.util.List;

import com.youfan.enity.Msmerchant;
import com.youfan.enity.Msuser;
import com.youfan.vo.msmerchant.MsmerchantVo;
import com.youfan.vo.msuser.MsuserVo;

public interface MsuserDao {
	public void insertUser(Msuser msuser);
	public Msuser queryMsuserByid(int id);
	public void updateMsuser(Msuser msuser);
	public void deleteMsuserbyid(int id);
	public List<Msuser> queryMsuserbyvo(MsuserVo msuserVo);
	public Msuser queryMsuserByuseraccount(String useraccount);
 }
