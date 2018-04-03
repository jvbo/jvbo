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
package com.jvbo.blog.service.admin.system.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Transformer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jvbo.blog.model.Menu;
import com.jvbo.blog.model.RoleMenu;
import com.jvbo.blog.model.UserRole;
import com.jvbo.blog.service.admin.system.ISysMainService;
import com.jvbo.blog.service.admin.system.ISysMenuService;
import com.jvbo.blog.service.admin.system.ISysRoleMenuService;
import com.jvbo.blog.service.admin.system.ISysUserRoleService;
import com.jvbo.blog.service.admin.system.bo.MenuBo;

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
	private ISysUserRoleService userRoleService;
	@Autowired
	private ISysRoleMenuService roleMenuService;
	@Autowired
	private ISysMenuService menuService;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<MenuBo> findMenu(String userId) {
		//查询用户所对应的角色id
		List<String> roleIdList = new ArrayList<String>();
		List<UserRole> userRoleList = userRoleService.findByUserId(userId);
		CollectionUtils.collect(userRoleList,new Transformer() {
			@Override
			public Object transform(Object input) {
				UserRole userRole = (UserRole)input;
				return userRole.getRoleId();
			}
		},roleIdList);
		//角色所对应的子菜单id
		List<String> childMenuIdList = new ArrayList<String>();
		List<RoleMenu> childMenuList = roleMenuService.findByRoleIdList(roleIdList);
		CollectionUtils.collect(childMenuList,new Transformer() {
			@Override
			public Object transform(Object input) {
				RoleMenu roleMenu = (RoleMenu)input;
				return roleMenu.getMenuId();
			}
		},childMenuIdList);

		//角色所对应的子菜单id的父菜单id，即parentMenu字段
		List<String> parentMenuIdList = new ArrayList<String>();
		List<Menu> parentMenuList = menuService.findByIds(childMenuIdList);
		CollectionUtils.collect(parentMenuList,new Transformer() {
			@Override
			public Object transform(Object input) {
				Menu menu = (Menu)input;
				return menu.getParentMenu();
			}
		},parentMenuIdList);

		//disjunction所有菜单id(menuIdList和parentMenuIdList)，交集的补集
		List<String> disjunctionMenuIdList = (List<String>) CollectionUtils.disjunction(childMenuIdList,parentMenuIdList);

		//根据所有菜单id查询出详细信息
		List<Menu> menusList = menuService.findByIds(disjunctionMenuIdList);
		//将子菜单整合到父菜单中
		List<MenuBo> menuBoList = integrationMenuTree(menusList);
		logger.info("------------------------用户菜单------------------------");
		return menuBoList;
	}
	
	/**
	 * 将子菜单整合到父菜单中
	 * @param menuList 
	 * @Description: TODO
	 * @param @return   
	 * @return List<Menu>  
	 * @throws
	 * @author jvbo
	 * @date 2016年10月26日
	 */
	private List<MenuBo> integrationMenuTree(List<Menu> menusList){
		//最终保存菜单
		List<MenuBo> menu = new ArrayList<MenuBo>();
		for(Menu vo:menusList){
			MenuBo bo = new MenuBo();
			try {
				BeanUtils.copyProperties(bo, vo);
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//父类才可查找
			if("0".equals(bo.getParentMenu())){
				String parentId=bo.getId();
				List<MenuBo> childMenu=new ArrayList<MenuBo>();
				//循环所有菜单
				for(Menu childVo:menusList){
					MenuBo childBo = new MenuBo();
					try {
						BeanUtils.copyProperties(childBo,childVo);
					} catch (IllegalAccessException | InvocationTargetException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					//不是父类才可添加
					if(!"0".equals(childBo.getParentMenu())){
						// 如果有自己的子菜单 就添加进去
						if(parentId.equals(childBo.getParentMenu())){
							childMenu.add(childBo);
						}
					}
				}
				bo.setChildenManus(childMenu);
				menu.add(bo);
			}
		}
		return menu;
	}

	public static void main(String[] args) {
		List<UserRole> userRoleList = new ArrayList<UserRole>();
		for (int i = 0; i < 5; i++) {
			UserRole userRole = new UserRole();
			userRole.setId(i+"");
			userRole.setRoleId(i+"");
			userRoleList.add(userRole);
		}
		System.out.println(userRoleList.toString());
		List<String> roleIdList = new ArrayList<String>();
		CollectionUtils.collect(userRoleList,new Transformer() {
			@Override
			public Object transform(Object input) {
				UserRole userRole = (UserRole)input;
				return userRole.getRoleId();
			}
		},roleIdList);
		System.out.println(roleIdList.toString());
	}

}
