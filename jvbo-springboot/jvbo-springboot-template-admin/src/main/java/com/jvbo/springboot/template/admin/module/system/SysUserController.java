/*
 * UserController.java 2016年11月2日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 
package com.jvbo.springboot.template.admin.module.system;

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

import com.jvbo.springboot.template.admin.core.model.AuthUserRole;
import com.jvbo.springboot.template.admin.core.model.User;
import com.jvbo.springboot.template.admin.core.service.ISysAuthUserRoleService;
import com.jvbo.springboot.template.admin.core.service.ISysUserService;
import com.jvbo.springboot.template.admin.core.util.collection.SampleMapBuilder;
import com.jvbo.springboot.template.admin.core.util.page.DataGrid;
import com.jvbo.springboot.template.admin.core.util.page.Page;
import com.jvbo.springboot.template.admin.core.util.uuid.UUIDUtil;

@Controller
@RequestMapping("/sys/user")
public class SysUserController {
	
	private static final Logger logger = LoggerFactory.getLogger(SysUserController.class);
	
	@Autowired
	private ISysUserService userService;
	@Autowired
	private ISysAuthUserRoleService userRoleService;
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index(ModelMap modelMap){
		return "sys/user/user_list";
	}
	
	@ResponseBody
	@RequestMapping(value="/index", method = RequestMethod.POST)
	public DataGrid<User> index(@RequestParam(required = false, defaultValue = "1") Integer page,
            @RequestParam(required = false, defaultValue = "10") Integer rows, String loginName){
		logger.info("page:{},rows:{}",page,rows);
		Page pageVo = new Page();
		pageVo.setPage(page);
		pageVo.setRows(rows);
		DataGrid<User> userDataGrid = userService.dataGridListByMap(SampleMapBuilder.with("loginName", loginName).build(),pageVo);
		return userDataGrid;
	}
	
	@RequestMapping(value="/modify", method = RequestMethod.GET)
	public String modify(ModelMap modelMap, String id, String mark){
		if(StringUtils.isNoneBlank(id)){
			User user = userService.findById(id);
			modelMap.addAttribute("vo", user);
		}
		modelMap.addAttribute("mark", mark);
		return "sys/user/user_modify";
	}
	
	@ResponseBody
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public Map<String, Object> modify(User user){
		String mark = "0";
		boolean flag = false;
		if(StringUtils.isNotBlank(user.getId())){
			flag = userService.update(user);
		}else{
			user.setId(UUIDUtil.generateUUID32());
			user.setAddUserId("1");
			user.setAddTime(new Date());
			flag = userService.save(user);
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
		boolean flag = userService.batchFalseDel(ids);
		viewMap.put("success", flag);
		return viewMap;
	}
	
	@RequestMapping(value = "/roleTree", method = RequestMethod.GET)
	public String roleTree(){
		return "sys/user/role_tree";
	}
	
	@ResponseBody
	@RequestMapping(value = "/roleTree", method = RequestMethod.POST)
	public List<AuthUserRole> roleTree(String userId){
		List<AuthUserRole> userRoleBoList = userRoleService.findUserRoleTree(userId);
		return userRoleBoList;
	}
	
	@ResponseBody
	@RequestMapping(value = "/userRole", method = RequestMethod.POST)
	public Map<String, Object> userRole(@RequestParam(value = "ids[]", required = false)String[] ids, String userId){
		boolean flag = false;
		List<AuthUserRole> userRoleList = new ArrayList<AuthUserRole>();
		if(ArrayUtils.isNotEmpty(ids)){
			for (String id : ids) {
				AuthUserRole userRole = new AuthUserRole();
				userRole.setId(UUIDUtil.generateUUID32());
				userRole.setUserId(userId);
				userRole.setRoleId(id);
				userRoleList.add(userRole);
			}
			flag = userRoleService.saveUserRoleTree(userRoleList);
		}else{
			// 根据用户(userId) delFlag 全部置为0
			flag = userRoleService.delFalseByUserId(userId);
		}
		Map<String, Object> viewMap = new HashMap<String, Object>();
		viewMap.put("success", flag);
		return viewMap;
	}
}
*/