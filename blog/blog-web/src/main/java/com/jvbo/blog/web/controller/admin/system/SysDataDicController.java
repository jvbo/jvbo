/*
 * DataDicController.java 2016年10月24日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.blog.web.controller.admin.system;

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

import com.jvbo.blog.model.DataDic;
import com.jvbo.blog.service.admin.system.ISysDataDicService;
import com.jvbo.framework.easyui.datagrid.DataGrid;
import com.jvbo.framework.mybatis.pageplugin.Page;
import com.jvbo.framework.utils.str.Str;

@Controller
@RequestMapping("/sys/dic")
public class SysDataDicController {
	
	private static final Logger logger = LoggerFactory.getLogger(SysDataDicController.class);
	
	@Autowired
	private ISysDataDicService dataDicService;
	
	@RequestMapping(value="/index",method=RequestMethod.GET)
	public String index(){
		return "sys/dic/dic_list";
	}
	
	@ResponseBody
	@RequestMapping(value="/index",method=RequestMethod.POST)
	public DataGrid<DataDic> index(@RequestParam(required = false, defaultValue = "1") Integer page,
            @RequestParam(required = false, defaultValue = "10") Integer rows, String dataKey){
		Page pageVo = new Page();
		pageVo.setPage(page);
		pageVo.setRows(rows);
		DataGrid<DataDic> dataDicDataGrid = dataDicService.list(dataKey,pageVo);
		return dataDicDataGrid;
	}
	
	@RequestMapping(value="/modify",method = RequestMethod.GET)
	public String modify(ModelMap modelMap, String id, String mark){
		if(StringUtils.isNotBlank(id)){
			DataDic dataDic = dataDicService.findById(id);
			modelMap.addAttribute("vo", dataDic);
		}
		modelMap.addAttribute("mark", mark);
		return "sys/dic/dic_modify";
	}
	
	@ResponseBody
	@RequestMapping(value="/modify",method = RequestMethod.POST)
	public Map<String, Object> modify(DataDic dataDic){
		boolean flag=false;
		String mark="0";
		if(StringUtils.isNotBlank(dataDic.getId())){
			flag = dataDicService.update(dataDic);
		}else{
			dataDic.setId(Str.getUUID());
			dataDic.setAddUserId("1");
			dataDic.setAddTime(new Date());
			flag = dataDicService.save(dataDic);
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
		boolean flag = dataDicService.batchDel(ids);
		viewMap.put("success", flag);
		return viewMap;
	}
}
