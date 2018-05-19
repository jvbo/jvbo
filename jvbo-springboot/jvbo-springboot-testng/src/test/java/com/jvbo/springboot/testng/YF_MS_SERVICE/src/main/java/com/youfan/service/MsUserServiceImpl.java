package com.youfan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.youfan.dao.MsmerchantDao;
import com.youfan.dao.MsuserDao;
import com.youfan.enity.Msmerchant;
import com.youfan.enity.Msuser;
import com.youfan.vo.msmerchant.MsmerchantVo;
import com.youfan.vo.msuser.MsuserVo;

@Service
public class MsUserServiceImpl implements MsUserService{
	
	@Autowired
	MsuserDao msuserDao ;
	
	public void insertUser(Msuser msuser){
		msuserDao.insertUser(msuser);
	}
	
	public Msuser queryMsuserByid(int id){
		return msuserDao.queryMsuserByid(id);
	}
	
	public void updateMsuser(Msuser msuser){
		msuserDao.updateMsuser(msuser);
	}
	public void deleteMsuserbyid(int id){
		msuserDao.deleteMsuserbyid(id);
	}
	public List<Msuser> queryMsuserbyvo(MsuserVo msuserVo){
		return msuserDao.queryMsuserbyvo(msuserVo);
	}
	
	public Msuser queryMsuserByuseraccount(String useraccount){
		return msuserDao.queryMsuserByuseraccount(useraccount);
	}
	
}
