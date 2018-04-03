/*
 * MenuController.java 2016年11月2日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
/**  
 * @Title: MenuController.java
 * @Package com.jvbo.blog.web.controller.admin.system
 * @Description: TODO
 * @author jvbo
 * @date 2016年11月2日
 */
package com.jvbo.blog.web.controller.admin.system;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import com.jvbo.blog.model.Menu;
import com.jvbo.blog.service.admin.system.ISysMenuService;
import com.jvbo.framework.easyui.datagrid.DataGrid;
import com.jvbo.framework.mybatis.pageplugin.Page;
import com.jvbo.framework.utils.str.Str;

/**  
 * @ClassName: MenuController 
 * @Description: TODO
 * @author jvbo
 * @date 2016年11月2日
 */
@Controller
@RequestMapping("sys/menu")
public class SysMenuController {
	
	private static final Logger logger = LoggerFactory.getLogger(SysMenuController.class);
	
	@Autowired
	private ISysMenuService menuService;
	
	@RequestMapping(value = "/index",method = RequestMethod.GET)
	public String index(){
		return "sys/menu/menu_list";
	}
	
	@ResponseBody
	@RequestMapping(value = "/index", method = RequestMethod.POST)
	public DataGrid<Menu> index(@RequestParam(required = false, defaultValue = "1") Integer page,
            @RequestParam(required = false, defaultValue = "10") Integer rows, String menuName){
		Page pageVo = new Page();
		pageVo.setPage(page);
		pageVo.setRows(rows);
		DataGrid<Menu> menuDataGrid = menuService.list(menuName,pageVo);
		return menuDataGrid;
	}
	
	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public String modify(ModelMap modelMap, String id, String mark){
		if(StringUtils.isNotBlank(id)){
			Menu menu = menuService.findById(id);
			modelMap.addAttribute("vo", menu);
		}
		List<Menu> parentMenuList = menuService.findParentMenuList();
		modelMap.addAttribute("mark", mark);
		modelMap.addAttribute("parentMenuList", parentMenuList);
		return "sys/menu/menu_modify";
	}
	
	@ResponseBody
	@RequestMapping(value="/modify", method = RequestMethod.POST)
	public Map<String, Object> modify(Menu menu){
		boolean flag=false;
		String mark="0";
		if(StringUtils.isNotBlank(menu.getId())){
			flag = menuService.update(menu);
		}else{
			menu.setId(Str.getUUID());
			menu.setAddUserId("1");
			menu.setAddTime(new Date());
			flag = menuService.save(menu);
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
		boolean flag = menuService.batchDel(ids);
		viewMap.put("success", flag);
		return viewMap;
	}
	
}
