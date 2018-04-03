/*
 * BlogController.java 2016年11月9日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.blog.web.controller.admin.blog;

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

import com.jvbo.blog.bo.BlogBo;
import com.jvbo.blog.model.BlogType;
import com.jvbo.blog.model.SysBlogBlogType;
import com.jvbo.blog.service.admin.blog.ISysBlogService;
import com.jvbo.blog.service.admin.blog.ISysBlogTypeService;
import com.jvbo.blog.web.controller.admin.system.SysMenuController;
import com.jvbo.framework.easyui.datagrid.DataGrid;
import com.jvbo.framework.mybatis.pageplugin.Page;
import com.jvbo.framework.utils.str.Str;

@Controller
@RequestMapping("sys/blog")
public class SysBlogController {
	private static final Logger logger = LoggerFactory.getLogger(SysMenuController.class);
	
	@Autowired
	private ISysBlogService blogService;
	@Autowired
	private ISysBlogTypeService blogTypeService;
	
	@RequestMapping(value = "/index",method = RequestMethod.GET)
	public String index(){
		return "sys/blog/blog_list";
	}
	
	@ResponseBody
	@RequestMapping(value = "/index", method = RequestMethod.POST)
	public DataGrid<SysBlogBlogType> index(@RequestParam(required = false, defaultValue = "1") Integer page,
            @RequestParam(required = false, defaultValue = "10") Integer rows, String title){
		Page pageVo = new Page();
		pageVo.setPage(page);
		pageVo.setRows(rows);
		DataGrid<SysBlogBlogType> blogBoDataGrid = blogService.list(title,pageVo);
		return blogBoDataGrid;
	}
	
	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public String modify(ModelMap modelMap, String id, String mark){
		if(StringUtils.isNotBlank(id)){
			SysBlogBlogType blogBlogType = blogService.findById(id);
			modelMap.addAttribute("vo", blogBlogType);
		}
		List<BlogType> blogTypeList = blogTypeService.findBlogTypeList();
		modelMap.addAttribute("blogTypeList", blogTypeList);
		modelMap.addAttribute("mark", mark);
		return "sys/blog/blog_modify";
	}
	
	@ResponseBody
	@RequestMapping(value="/modify", method = RequestMethod.POST)
	public Map<String, Object> modify(BlogBo blogBo){
		boolean flag=false;
		String mark="0";
		if(StringUtils.isNotBlank(blogBo.getId())){
			flag = blogService.update(blogBo);
		}else{
			blogBo.setId(Str.getUUID());
			blogBo.setAddUserId("1");
			blogBo.setAddTime(new Date());
			flag = blogService.save(blogBo);
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
		boolean flag = blogService.batchDel(ids);
		viewMap.put("success", flag);
		return viewMap;
	}
}
