/*
 * FrontBloggerController.java 2016年11月10日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.blog.web.controller.front;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jvbo.blog.service.front.blogger.IFrontBloggerService;

@Controller
@RequestMapping("/front/blogger")
public class FrontBloggerController {
	
	@Autowired
	private IFrontBloggerService bloggerService;
	
	/**
	 * 关于
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/aboutMe")
	public ModelAndView aboutMe()throws Exception{
		ModelAndView mav=new ModelAndView();
		mav.addObject("blogger",bloggerService.find());
		mav.addObject("mainPage", "front/blogger/info.vm");
		mav.addObject("pageTitle","关于博主");
		mav.setViewName("front/main");
		return mav;
	}
}
