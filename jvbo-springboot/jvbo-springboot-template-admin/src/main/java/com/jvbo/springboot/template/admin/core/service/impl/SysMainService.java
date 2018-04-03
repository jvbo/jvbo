/*
 * MainService.java 2016年10月26日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
/**  
 * @Title: MainService.java
 * @Package com.jvbo.blog.service.admin.system
 * @Description: TODO
 * @author jvbo
 * @date 2016年10月26日
 */
package com.jvbo.springboot.template.admin.core.service.impl;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Transformer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jvbo.springboot.template.admin.core.bo.AuthMenuBo;
import com.jvbo.springboot.template.admin.core.model.AuthMenu;
import com.jvbo.springboot.template.admin.core.model.AuthRoleMenu;
import com.jvbo.springboot.template.admin.core.model.AuthUserRole;
import com.jvbo.springboot.template.admin.core.service.ISysAuthMenuService;
import com.jvbo.springboot.template.admin.core.service.ISysAuthRoleMenuService;
import com.jvbo.springboot.template.admin.core.service.ISysAuthUserRoleService;
import com.jvbo.springboot.template.admin.core.service.ISysMainService;
import com.jvbo.springboot.template.admin.core.util.collection.SampleMapBuilder;

/**  
 * @ClassName: MainService 
 * @Description: TODO
 * @author jvbo
 * @date 2016年10月26日
 */
@Service
public class SysMainService implements ISysMainService {
	
	private static final Logger logger = LoggerFactory.getLogger(SysMainService.class);
	
	@Autowired
	private ISysAuthUserRoleService authUserRoleService;
	@Autowired
	private ISysAuthRoleMenuService authRoleMenuService;
	@Autowired
	private ISysAuthMenuService authMenuService;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<AuthMenuBo> findMenu(String userId) {
		logger.info("userId查找菜单：{}",userId);
		//查询用户所对应的角色id
		List<String> roleIdList = new ArrayList<String>();
		List<AuthUserRole> userRoleList = authUserRoleService.listByMap(SampleMapBuilder.with("userId", userId).build());
		CollectionUtils.collect(userRoleList,new Transformer() {
			@Override
			public Object transform(Object input) {
				AuthUserRole userRole = (AuthUserRole)input;
				return userRole.getRoleId();
			}
		},roleIdList);
		//角色所对应的所有菜单id
		List<String> allMenuIdList = new ArrayList<String>();
		List<AuthRoleMenu> allMenuList = authRoleMenuService.findByRoleIdList(roleIdList);
		CollectionUtils.collect(allMenuList,new Transformer() {
			@Override
			public Object transform(Object input) {
				AuthRoleMenu roleMenu = (AuthRoleMenu)input;
				return roleMenu.getMenuId();
			}
		},allMenuIdList);

		//角色所对应的所有菜单id的父菜单id，即parentMenu字段
		List<String> parentMenuIdList = new ArrayList<String>();
		List<AuthMenu> parentMenuList = authMenuService.findByIdList(allMenuIdList);
		CollectionUtils.collect(parentMenuList,new Transformer() {
			@Override
			public Object transform(Object input) {
				AuthMenu menu = (AuthMenu)input;
				return menu.getParentMenu();
			}
		},parentMenuIdList);

		//disjunction所有菜单id(menuIdList和parentMenuIdList)，交集的补集
		List<String> disjunctionMenuIdList = (List<String>) CollectionUtils.disjunction(allMenuIdList,parentMenuIdList);

		//根据所有菜单id查询出详细信息
		List<AuthMenu> menusList = authMenuService.findByIdList(disjunctionMenuIdList);
		//将子菜单整合到父菜单中
		List<AuthMenuBo> menuBoList = integrationMenuTree(menusList);
		logger.info("------------------------用户菜单------------------------");
		return menuBoList;
	}
	
	private String findUserOperate(){
		
		return "";
	}
	
	/**
	 * 将子菜单整合到父菜单中
	 * @Description: TODO
	 * @param @param menuList
	 * @param @return   
	 * @return List<AuthMenuBo>  
	 * @throws
	 * @author jvbo
	 * @date 2017年8月29日
	 */
	private List<AuthMenuBo> integrationMenuTree(List<AuthMenu> menuList){
		//最终保存菜单
		List<AuthMenuBo> menu = new ArrayList<AuthMenuBo>();
		for(AuthMenu vo:menuList){
			AuthMenuBo bo = new AuthMenuBo();
			BeanUtils.copyProperties(vo, bo);
			//父类才可查找
			if("0".equals(bo.getParentMenu())){
				String parentId=bo.getId();
				LinkedList<AuthMenuBo> childMenu=new LinkedList<AuthMenuBo>();
				//循环所有菜单
				for(AuthMenu childVo:menuList){
					AuthMenuBo childBo = new AuthMenuBo();
					BeanUtils.copyProperties(childVo, childBo);
					//不是父类才可添加
					if(!"0".equals(childBo.getParentMenu())){
						// 如果有自己的子菜单 就添加进去
						if(parentId.equals(childBo.getParentMenu())){
							childMenu.addLast(childBo);
						}
					}
				}
				bo.setChildenManus(childMenu);
				menu.add(bo);
			}
		}
		return menu;
	}

}
