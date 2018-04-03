/*
 * BloggerController.java 2016年11月9日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.blog.web.controller.admin.blog;

import java.util.Date;
import java.util.HashMap;
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

import com.jvbo.blog.model.Blogger;
import com.jvbo.blog.service.admin.blog.ISysBloggerService;
import com.jvbo.blog.web.controller.admin.system.SysMenuController;
import com.jvbo.framework.easyui.datagrid.DataGrid;
import com.jvbo.framework.mybatis.pageplugin.Page;
import com.jvbo.framework.utils.str.Str;

@Controller
@RequestMapping("sys/blogger")
public class SysBloggerController {
	private static final Logger logger = LoggerFactory.getLogger(SysMenuController.class);
	
	@Autowired
	private ISysBloggerService bloggerService;
	
	@RequestMapping(value = "/index",method = RequestMethod.GET)
	public String index(){
		return "sys/blogger/blogger_list";
	}
	
	@ResponseBody
	@RequestMapping(value = "/index", method = RequestMethod.POST)
	public DataGrid<Blogger> index(@RequestParam(required = false, defaultValue = "1") Integer page,
            @RequestParam(required = false, defaultValue = "10") Integer rows, String userName){
		Page pageVo = new Page();
		pageVo.setPage(page);
		pageVo.setRows(rows);
		DataGrid<Blogger> bloggerDataGrid = bloggerService.list(userName,pageVo);
		return bloggerDataGrid;
	}
	
	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public String modify(ModelMap modelMap, String id, String mark){
		if(StringUtils.isNotBlank(id)){
			Blogger blogger = bloggerService.findById(id);
			modelMap.addAttribute("vo", blogger);
		}
		modelMap.addAttribute("mark", mark);
		return "sys/blogger/blogger_modify";
	}
	
	@ResponseBody
	@RequestMapping(value="/modify", method = RequestMethod.POST)
	public Map<String, Object> modify(Blogger blogger){
		boolean flag=false;
		String mark="0";
		if(StringUtils.isNotBlank(blogger.getId())){
			flag = bloggerService.update(blogger);
		}else{
			blogger.setId(Str.getUUID());
			blogger.setAddUserId("1");
			blogger.setAddTime(new Date());
			flag = bloggerService.save(blogger);
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
		boolean flag = bloggerService.batchDel(ids);
		viewMap.put("success", flag);
		return viewMap;
	}
}
