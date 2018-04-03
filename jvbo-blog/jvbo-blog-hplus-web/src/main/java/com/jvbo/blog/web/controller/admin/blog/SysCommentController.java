/*
 * CommentController.java 2016年11月9日
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

import com.jvbo.blog.model.Comment;
import com.jvbo.blog.service.admin.blog.ISysCommentService;
import com.jvbo.blog.web.controller.admin.system.SysMenuController;
import com.jvbo.framework.easyui.datagrid.DataGrid;
import com.jvbo.framework.mybatis.pageplugin.Page;
import com.jvbo.framework.utils.str.Str;

@Controller
@RequestMapping("sys/comment")
public class SysCommentController {
	private static final Logger logger = LoggerFactory.getLogger(SysMenuController.class);
	
	@Autowired
	private ISysCommentService commentService;
	
	@RequestMapping(value = "/index",method = RequestMethod.GET)
	public String index(){
		return "sys/comment/comment_list";
	}
	
	@ResponseBody
	@RequestMapping(value = "/index", method = RequestMethod.POST)
	public DataGrid<Comment> index(@RequestParam(required = false, defaultValue = "1") Integer page,
            @RequestParam(required = false, defaultValue = "10") Integer rows, String content){
		Page pageVo = new Page();
		pageVo.setPage(page);
		pageVo.setRows(rows);
		DataGrid<Comment> commentDataGrid = commentService.list(content,pageVo);
		return commentDataGrid;
	}
	
	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public String modify(ModelMap modelMap, String id, String mark){
		if(StringUtils.isNotBlank(id)){
			Comment comment = commentService.findById(id);
			modelMap.addAttribute("vo", comment);
		}
		modelMap.addAttribute("mark", mark);
		return "sys/comment/comment_modify";
	}
	
	@ResponseBody
	@RequestMapping(value="/modify", method = RequestMethod.POST)
	public Map<String, Object> modify(Comment comment){
		boolean flag=false;
		String mark="0";
		if(StringUtils.isNotBlank(comment.getId())){
			flag = commentService.update(comment);
		}else{
			comment.setId(Str.getUUID());
			comment.setAddUserId("1");
			comment.setAddTime(new Date());
			flag = commentService.save(comment);
		}
		Map<String, Object> viewMap = new HashMap<String, Object>();
		viewMap.put("mark", mark);
		viewMap.put("success", flag);
		return viewMap;
	}
	
	@ResponseBody
	@RequestMapping(value="/audit", method = RequestMethod.POST)
	public Map<String, Object> audit(String id){
		Comment comment = commentService.findById(id);
		if(comment.getState()==0){
			comment.setState(1);//0待审核==>1审核通过
		}else if(comment.getState()==1){
			comment.setState(2);//1审核通过==>2审核未通过
		}else{
			comment.setState(0);//2审核未通过==>0待审核
		}
		boolean flag = commentService.update(comment);
		Map<String, Object> viewMap = new HashMap<String, Object>();
		viewMap.put("success", flag);
		return viewMap;
	}
	
	@ResponseBody
	@RequestMapping("/remove")
	public Map<String, Object> remove(@RequestParam("ids[]") String[] ids){
		logger.info("/remove parameter ids:{}",new Object[]{ids});
		Map<String, Object> viewMap = new HashMap<String, Object>();
		boolean flag = commentService.batchDel(ids);
		viewMap.put("success", flag);
		return viewMap;
	}
}
