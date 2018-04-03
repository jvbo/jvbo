/*
 * RoleController.java 2016年11月2日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.blog.web.controller.admin.system;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jvbo.blog.model.Role;
import com.jvbo.blog.model.RoleMenu;
import com.jvbo.blog.service.admin.system.ISysRoleMenuService;
import com.jvbo.blog.service.admin.system.ISysRoleService;
import com.jvbo.framework.easyui.datagrid.DataGrid;
import com.jvbo.framework.mybatis.pageplugin.Page;
import com.jvbo.framework.utils.str.Str;

@Controller
@RequestMapping("/sys/role")
public class SysRoleController {
	
	private static final Logger logger = LoggerFactory.getLogger(SysRoleController.class);
	
	@Autowired
	private ISysRoleService roleService;
	@Autowired
	private ISysRoleMenuService roleMenuService;
	
	
	@RequestMapping(value= "/index", method = RequestMethod.GET)
	public String index(){
		return "sys/role/role_list";
	}
	
	@ResponseBody
	@RequestMapping(value="/index", method = RequestMethod.POST)
	public DataGrid<Role> index(@RequestParam(required = false, defaultValue = "1") Integer page,
            @RequestParam(required = false, defaultValue = "10") Integer rows, String roleName){
		Page pageVo = new Page();
		pageVo.setPage(page);
		pageVo.setRows(rows);
		DataGrid<Role> roleDataGrid = roleService.list(roleName,pageVo);
		return roleDataGrid;
	}
	
	@RequestMapping(value="/modify", method = RequestMethod.GET)
	public String modify(ModelMap modelMap, String id, String mark){
		if(StringUtils.isNoneBlank(id)){
			Role role = roleService.findById(id);
			modelMap.addAttribute("vo", role);
		}
		modelMap.addAttribute("mark", mark);
		return "sys/role/role_modify";
	}
	
	@ResponseBody
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public Map<String, Object> modify(Role role){
		String mark = "0";
		boolean flag = false;
		if(StringUtils.isNotBlank(role.getId())){
			flag = roleService.update(role);
		}else{
			role.setId(Str.getUUID());
			role.setAddUserId("1");
			role.setAddTime(new Date());
			flag = roleService.save(role);
		}
		Map<String, Object> viewMap = new HashMap<String, Object>();
		viewMap.put("mark", mark);
		viewMap.put("success", flag);
		return viewMap;
	}
	
	@ResponseBody
	@RequestMapping("/remove")
	public Map<String, Object> remove(@RequestParam("ids[]") String[] ids){
		logger.info("/remove parameter ids:{}",new Object[]{ids});
		Map<String, Object> viewMap = new HashMap<String, Object>();
		boolean flag = roleService.batchDel(ids);
		viewMap.put("success", flag);
		return viewMap;
	}
	
	@RequestMapping(value = "/menuTree", method = RequestMethod.GET)
	public String menuTree(){
		return "sys/role/menu_tree";
	}
	
	@ResponseBody
	@RequestMapping(value = "/menuTree", method = RequestMethod.POST)
	public List<Map<String, Object>> menuTree(String menuId, String roleId){
		//TODO
		System.out.println("menuId:"+menuId+"===roleId:"+roleId);
		Map<String, Object> mapParams = new HashMap<String, Object>();
		if(StringUtils.isNotBlank(menuId)){
			mapParams.put("id", menuId);
		}else{
			mapParams.put("id", null);
		}
		mapParams.put("roleId", roleId);
		List<Map<String, Object>> viewListMap = roleMenuService.findRoleMenuTree(mapParams);
		return viewListMap;
	}
	
	@ResponseBody
	@RequestMapping(value = "/roleMenu", method = RequestMethod.POST)
	public Map<String, Object> roleMenu(@RequestParam(value = "ids[]", required = false)String[] ids, String roleId){
		boolean flag = false;
		List<RoleMenu> roleMenuList = new ArrayList<RoleMenu>();
		if(ArrayUtils.isNotEmpty(ids)){
			for (String id : ids) {
				RoleMenu roleMenu = new RoleMenu();
				roleMenu.setId(Str.getUUID());
				roleMenu.setAddUserId(roleMenu.getId());
				roleMenu.setRoleId(roleId);
				roleMenu.setMenuId(id);
				roleMenuList.add(roleMenu);
			}
			flag = roleMenuService.saveRoleMenuTree(roleMenuList);
		}else{
			// 根据角色(roleId) delFlag 全部置为0
			// TODO
			flag = roleMenuService.delFalseByRoleId(roleId);
		}
		Map<String, Object> viewMap = new HashMap<String, Object>();
		viewMap.put("success", flag);
		return viewMap;
	}
}
