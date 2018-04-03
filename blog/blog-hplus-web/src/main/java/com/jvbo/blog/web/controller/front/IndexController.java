/*
 * FrontMainController.java 2016年11月10日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.blog.web.controller.front;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jvbo.blog.bo.BlogBo;
import com.jvbo.blog.service.front.blog.IFrontBlogService;
import com.jvbo.framework.utils.pageUtils.PageBean;
import com.jvbo.framework.utils.pageUtils.PageUtil;

@Controller
@RequestMapping("/front")
public class IndexController {
	
	@Autowired
	private IFrontBlogService blogService;
	
	/**
	 * 请求主页
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/index")
	public ModelAndView index(@RequestParam(value="page",required=false)String page,@RequestParam(value="typeId",required=false)String typeId,@RequestParam(value="releaseDateStr",required=false)String releaseDateStr,HttpServletRequest request)throws Exception{
		ModelAndView mav=new ModelAndView();
		if(StringUtils.isBlank(page)){
			page="1";
		}
		PageBean pageBean = new PageBean(Integer.parseInt(page),10);
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("start", pageBean.getStart());
		map.put("size", pageBean.getPageSize());
		map.put("typeId", typeId);
		map.put("releaseDateStr", releaseDateStr);
		List<BlogBo> blogList = blogService.list(map);
		for(BlogBo blog:blogList){
			List<String> imagesList=blog.getImagesList();
			String blogInfo=blog.getContent();
			Document doc=Jsoup.parse(blogInfo);
			Elements jpgs = doc.select("img[src$=.jpg]"); //　查找扩展名是jpg的图片
			for(int i=0;i<jpgs.size();i++){
				Element jpg=jpgs.get(i);
				imagesList.add(jpg.toString());
				if(i==2){
					break;
				}
			}
		}
		mav.addObject("blogList", blogList);
		StringBuffer param=new StringBuffer(); // 查询参数
		if(StringUtils.isNotBlank(typeId)){
			param.append("&typeId="+typeId);
		}
		if(StringUtils.isNotBlank(releaseDateStr)){
			param.append("&releaseDateStr="+releaseDateStr);
		}
		mav.addObject("pageCode",PageUtil.genPagination(request.getContextPath()+"/front/index.htm", blogService.getTotal(map), Integer.parseInt(page), 10, param.toString()));
		mav.addObject("mainPage", "front/blog/list.vm");
		mav.addObject("pageTitle","jvbo的个人博客");
		mav.setViewName("front/main");
		return mav;
	}
	
}
