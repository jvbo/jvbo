/*
 * SysAuthUserRoleService.java 2017年8月29日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.springboot.template.admin.core.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.jvbo.springboot.template.admin.core.mapper.AuthUserRoleMapper;
import com.jvbo.springboot.template.admin.core.model.AuthUserRole;
import com.jvbo.springboot.template.admin.core.model.AuthUserRoleExample;
import com.jvbo.springboot.template.admin.core.service.ISysAuthUserRoleService;
import com.jvbo.springboot.template.admin.core.util.page.DataGrid;
import com.jvbo.springboot.template.admin.core.util.page.Page;

@Service
public class SysAuthUserRoleService implements ISysAuthUserRoleService {
	
	@Autowired
	private AuthUserRoleMapper authUserRoleDao;

	@Transactional(propagation=Propagation.REQUIRED)
	public boolean save(AuthUserRole record) {
		return authUserRoleDao.insertSelective(record)>0;
	}

	@Transactional(propagation=Propagation.REQUIRED)
	public boolean update(AuthUserRole record) {
		return authUserRoleDao.updateByPrimaryKeySelective(record)>0;
	}

	@Override
	public AuthUserRole findById(String id) {
		return authUserRoleDao.selectByPrimaryKey(id);
	}

	@Transactional(propagation=Propagation.REQUIRED)
	public boolean batchFalseDel(String[] ids) {
		boolean flag = true;
		AuthUserRole record = null;
		for (String string : ids) {
			record = new AuthUserRole();
			record.setId(string);
			record.setGmtModified(System.currentTimeMillis());
			record.setIsDeleted(1);
			flag = authUserRoleDao.updateByPrimaryKeySelective(record) > 0;
			if(!flag){
				break;
			}
		}
		/*if(!flag){
			throw new RuntimeException();
		}*/
		if(!flag){
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		}
		return flag;
	}

	@Override
	public List<AuthUserRole> list(AuthUserRole params) {
		AuthUserRoleExample example = new AuthUserRoleExample();
		AuthUserRoleExample.Criteria criteria = example.createCriteria();
		criteria.andIsDeletedEqualTo(0);
		if(params != null){
			if(StringUtils.isNotBlank(params.getUserId())){
				criteria.andUserIdEqualTo(params.getUserId());
			}
			if(StringUtils.isNotBlank(params.getRoleId())){
				criteria.andRoleIdEqualTo(params.getRoleId());
			}
		}
		List<AuthUserRole> authUserRoleList = authUserRoleDao.selectByExample(example);
		return authUserRoleList;
	}

	@Override
	public long count(AuthUserRole params) {
		AuthUserRoleExample example = new AuthUserRoleExample();
		AuthUserRoleExample.Criteria criteria = example.createCriteria();
		criteria.andIsDeletedEqualTo(0);
		if(params != null){
			if(StringUtils.isNotBlank(params.getUserId())){
				criteria.andUserIdEqualTo(params.getUserId());
			}
			if(StringUtils.isNotBlank(params.getRoleId())){
				criteria.andRoleIdEqualTo(params.getRoleId());
			}
		}
		return authUserRoleDao.countByExample(example);
	}

	@Override
	public DataGrid<AuthUserRole> dataGridList(AuthUserRole params, Page page) {
		AuthUserRoleExample example = new AuthUserRoleExample();
		AuthUserRoleExample.Criteria criteria = example.createCriteria();
		criteria.andIsDeletedEqualTo(0);
		if(params != null){
			if(StringUtils.isNotBlank(params.getUserId())){
				criteria.andUserIdEqualTo(params.getUserId());
			}
			if(StringUtils.isNotBlank(params.getRoleId())){
				criteria.andRoleIdEqualTo(params.getRoleId());
			}
		}
		page.setTotalRecords(Long.valueOf(count(params)).intValue());
		example.setPage(page);
		List<AuthUserRole> authUserRoleList = authUserRoleDao.selectByExample(example);
		DataGrid<AuthUserRole> dg = new DataGrid<AuthUserRole>();
		dg.setPages(page.getPageCount());
		dg.setTotal(page.getTotalRecords());
		dg.setRows(authUserRoleList);
		dg.setPage(page.getPage());
		return dg;
	}
	
	
	
	/**
	 * 查找用户权限树
	 * @Description: TODO
	 * @param @param userId
	 * @param @return   
	 * @return  
	 * @throws
	 * @author jvbo
	 * @date 2017年8月29日
	 */
	@Override
	public List<AuthUserRole> findUserRoleTree(String userId) {
		// TODO Auto-generated method stub
		/**
		 * select tr.id,tr.name text ,'open' state,
		case when tul.id is null then '' else 'checked' end checked
		from t_role tr
		left join t_user_role tul on tul.delFlag='1' and tul.roleId=tr.id and
		tul.userId=#{id}
		where tr.delFlag='1' 
		 */
		return null;
	}
	
	/**
	 * 保存用户权限树
	 * @Description: TODO
	 * @param @param userRoleList
	 * @param @return   
	 * @return  
	 * @throws
	 * @author jvbo
	 * @date 2017年8月29日
	 */
	@Override
	public boolean saveUserRoleTree(List<AuthUserRole> userRoleList) {
		AuthUserRoleExample example = new AuthUserRoleExample();
		AuthUserRoleExample.Criteria criteria = example.createCriteria();
		criteria.andUserIdEqualTo(userRoleList.get(0).getUserId());
		AuthUserRole updUserRole = new AuthUserRole();
		updUserRole.setIsDeleted(1);;
		int iRet = authUserRoleDao.updateByExampleSelective(updUserRole, example);
		boolean flag = true;
		if(iRet>=0){
			for (AuthUserRole userRole : userRoleList) {
				flag = authUserRoleDao.insertSelective(userRole)>0;
				if(!flag){
					break;
				}
			}
		}
		if(!flag){
			throw new RuntimeException();
		}
		return flag;
	}

	@Override
	public boolean delFalseByUserId(String userId) {
		AuthUserRoleExample example = new AuthUserRoleExample();
		AuthUserRoleExample.Criteria criteria = example.createCriteria();
		criteria.andUserIdEqualTo(userId);
		AuthUserRole userRole = new AuthUserRole();
		userRole.setIsDeleted(1);
		return authUserRoleDao.updateByExampleSelective(userRole, example)>0;
	}

}
