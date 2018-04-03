/*
 * FrontBlogController.java 2016年11月10日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.blog.web.controller.front;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jvbo.blog.bo.BlogBo;
import com.jvbo.blog.framework.lucene.BlogIndex;
import com.jvbo.blog.service.front.blog.IFrontBlogService;
import com.jvbo.blog.service.front.comment.IFrontCommentService;

@Controller
@RequestMapping("/front/blog")
public class FrontBlogController {
	
	@Autowired
	private IFrontBlogService blogService;
	
	@Autowired
	private IFrontCommentService commentService;
	
	// 博客索引
	private BlogIndex blogIndex = new BlogIndex();
	
	/**
	 * 请求博客详细信息
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/articles/{id}")
	public ModelAndView details(@PathVariable("id") String id,HttpServletRequest request)throws Exception{
		ModelAndView mav=new ModelAndView();
		BlogBo blog=blogService.findById(id);
		String keyWords=blog.getKeyWord();
		if(StringUtils.isNotBlank(keyWords)){
			String arr[]=keyWords.split(" ");
			mav.addObject("keyWords",Arrays.asList(arr));			
		}else{
			mav.addObject("keyWords",null);			
		}
		mav.addObject("blog", blog);
		blog.setClickNum(blog.getClickNum()+1); // 博客点击次数加1
		blogService.update(blog);
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("blogId", blog.getId());
		map.put("state", 1); // 查询审核通过的评论
		mav.addObject("commentList", commentService.list(map)); 
		mav.addObject("pageCode", this.genUpAndDownPageCode(blogService.getLastBlog(id),blogService.getNextBlog(id),request.getContextPath()));
		mav.addObject("mainPage", "front/blog/view.vm");
		mav.addObject("pageTitle",blog.getTitle());
		mav.setViewName("front/main");
		return mav;
	}
	
	/**
	 * 根据关键字查询相关博客信息
	 * @param search
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/search")
	public ModelAndView search(@RequestParam(value="searchKeyWord",required=false)String searchKeyWord,@RequestParam(value="page",required=false)String page,HttpServletRequest request)throws Exception{
		if(StringUtils.isBlank(page)){
			page="1";
		}
		ModelAndView mav=new ModelAndView();
		mav.addObject("mainPage", "front/blog/result.vm");
		List<BlogBo> blogList=blogIndex.searchBlog(searchKeyWord.trim());
		Integer toIndex=blogList.size()>=Integer.parseInt(page)*10?Integer.parseInt(page)*10:blogList.size();
		mav.addObject("blogList",blogList.subList((Integer.parseInt(page)-1)*10, toIndex));
		mav.addObject("pageCode",this.genUpAndDownPageCode(Integer.parseInt(page), blogList.size(), searchKeyWord,10,request.getContextPath()));
		mav.addObject("searchKeyWord",searchKeyWord);
		mav.addObject("resultTotal",blogList.size());
		mav.addObject("pageTitle","搜索关键字'"+searchKeyWord+"'结果页面");
		mav.setViewName("front/main");
		return mav;
	}
	
	/**
	 * 获取下一篇博客和下一篇博客代码
	 * @param lastBlog
	 * @param nextBlog
	 * @return
	 */
	private String genUpAndDownPageCode(BlogBo lastBlog,BlogBo nextBlog,String projectContext){
		StringBuffer pageCode=new StringBuffer();
		if(lastBlog==null || lastBlog.getId()==null){
			pageCode.append("<p>上一篇：没有了</p>");
		}else{
			pageCode.append("<p>上一篇：<a href='"+projectContext+"/front/blog/articles/"+lastBlog.getId()+".htm'>"+lastBlog.getTitle()+"</a></p>");
		}
		if(nextBlog==null || nextBlog.getId()==null){
			pageCode.append("<p>下一篇：没有了</p>");
		}else{
			pageCode.append("<p>下一篇：<a href='"+projectContext+"/front/blog/articles/"+nextBlog.getId()+".htm'>"+nextBlog.getTitle()+"</a></p>");
		}
		return pageCode.toString();
	}
	
	/**
	 * 获取上一页，下一页代码 查询博客用到
	 * @param page 当前页
	 * @param totalNum 总记录数
	 * @param q 查询关键字
	 * @param pageSize 每页大小
	 * @param projectContext
	 * @return
	 */
	private String genUpAndDownPageCode(Integer page,Integer totalNum,String searchKeyWord,Integer pageSize,String projectContext){
		long totalPage=totalNum%pageSize==0?totalNum/pageSize:totalNum/pageSize+1;
		StringBuffer pageCode=new StringBuffer();
		if(totalPage==0){
			return "";
		}else{
			pageCode.append("<nav>");
			pageCode.append("<ul class='pager' >");
			if(page>1){
				pageCode.append("<li><a href='"+projectContext+"/front/blog/search.htm?page="+(page-1)+"&searchKeyWord="+searchKeyWord+"'>上一页</a></li>");
			}else{
				pageCode.append("<li class='disabled'><a href='#'>上一页</a></li>");
			}
			if(page<totalPage){
				pageCode.append("<li><a href='"+projectContext+"/front/blog/search.htm?page="+(page+1)+"&searchKeyWord="+searchKeyWord+"'>下一页</a></li>");				
			}else{
				pageCode.append("<li class='disabled'><a href='#'>下一页</a></li>");				
			}
			pageCode.append("</ul>");
			pageCode.append("</nav>");
		}
		return pageCode.toString();
	}
	
	@RequestMapping("/archives")
	public ModelAndView aboutMe()throws Exception{
		ModelAndView mav=new ModelAndView();
		mav.addObject("blogArchiveBoList",blogService.archives());
		mav.addObject("mainPage", "front/blog/archives.vm");
		mav.addObject("pageTitle","归档");
		mav.setViewName("front/main");
		return mav;
	}
}
