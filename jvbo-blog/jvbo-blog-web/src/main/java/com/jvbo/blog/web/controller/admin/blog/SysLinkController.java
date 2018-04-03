/*
 * LinkController.java 2016年11月9日
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

import com.jvbo.blog.model.Link;
import com.jvbo.blog.service.admin.blog.ISysLinkService;
import com.jvbo.blog.web.controller.admin.system.SysMenuController;
import com.jvbo.framework.easyui.datagrid.DataGrid;
import com.jvbo.framework.mybatis.pageplugin.Page;
import com.jvbo.framework.utils.str.Str;

@Controller
@RequestMapping("sys/link")
public class SysLinkController {
	private static final Logger logger = LoggerFactory.getLogger(SysMenuController.class);
	
	@Autowired
	private ISysLinkService linkService;
	
	@RequestMapping(value = "/index",method = RequestMethod.GET)
	public String index(){
		return "sys/link/link_list";
	}
	
	@ResponseBody
	@RequestMapping(value = "/index", method = RequestMethod.POST)
	public DataGrid<Link> index(@RequestParam(required = false, defaultValue = "1") Integer page,
            @RequestParam(required = false, defaultValue = "10") Integer rows, String linkName){
		Page pageVo = new Page();
		pageVo.setPage(page);
		pageVo.setRows(rows);
		DataGrid<Link> linkDataGrid = linkService.list(linkName,pageVo);
		return linkDataGrid;
	}
	
	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public String modify(ModelMap modelMap, String id, String mark){
		if(StringUtils.isNotBlank(id)){
			Link link = linkService.findById(id);
			modelMap.addAttribute("vo", link);
		}
		modelMap.addAttribute("mark", mark);
		return "sys/link/link_modify";
	}
	
	@ResponseBody
	@RequestMapping(value="/modify", method = RequestMethod.POST)
	public Map<String, Object> modify(Link link){
		boolean flag=false;
		String mark="0";
		if(StringUtils.isNotBlank(link.getId())){
			flag = linkService.update(link);
		}else{
			link.setId(Str.getUUID());
			link.setAddUserId("1");
			link.setAddTime(new Date());
			flag = linkService.save(link);
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
		boolean flag = linkService.batchDel(ids);
		viewMap.put("success", flag);
		return viewMap;
	}
}
