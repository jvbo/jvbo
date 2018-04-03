/*
 * FrontCommentController.java 2016年11月10日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.blog.web.controller.front;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jvbo.blog.bo.BlogBo;
import com.jvbo.blog.bo.CommentBo;
import com.jvbo.blog.service.front.blog.IFrontBlogService;
import com.jvbo.blog.service.front.comment.IFrontCommentService;
import com.jvbo.framework.utils.str.Str;

@Controller
@RequestMapping("/front/comment")
public class FrontCommentController {
	@Autowired
	private IFrontCommentService commentService;
	
	@Autowired
	private IFrontBlogService blogService;
	
	/**
	 * 添加或者修改评论
	 * @param comment
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("/save")
	public Map<String, Object> save(CommentBo comment,HttpServletRequest request)throws Exception{
		Map<String, Object> result = new HashMap<String, Object>();
		int resultTotal=0; // 操作的记录条数
		String userIp=request.getRemoteAddr(); // 获取用户IP
		comment.setUserIp(userIp);
		if(comment.getId()==null){
			comment.setId(Str.getUUID());
			comment.setAddUserId("1");
			comment.setAddTime(new Date());
			comment.setCommentDate(new Date());
			comment.setState(0);//0待审核 1审核通过 2审核未通过
			resultTotal=commentService.add(comment);
			// 该博客的回复次数加1
			BlogBo blog=blogService.findById(comment.getBlogBo().getId());
			blog.setReplyNum(blog.getReplyNum()+1);
			blogService.update(blog);
		}else{
			
		}
		if(resultTotal>0){
			result.put("success", true);
		}else{
			result.put("success", false);
		}
		return result;
	}
}
