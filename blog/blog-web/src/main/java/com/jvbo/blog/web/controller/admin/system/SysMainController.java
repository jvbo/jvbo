/*
 * MainController.java 2016年10月25日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
/**  
 * @Title: MainController.java
 * @Package com.jvbo.blog.web.controller.admin.system
 * @Description: TODO
 * @author jvbo
 * @date 2016年10月25日
 */
package com.jvbo.blog.web.controller.admin.system;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.jvbo.blog.bo.BlogBo;
import com.jvbo.blog.bo.BlogTypeBo;
import com.jvbo.blog.framework.constant.Constants;
import com.jvbo.blog.model.Link;
import com.jvbo.blog.model.User;
import com.jvbo.blog.service.admin.system.ISysMainService;
import com.jvbo.blog.service.admin.system.ISysUserService;
import com.jvbo.blog.service.admin.system.bo.MenuBo;
import com.jvbo.blog.service.front.blog.IFrontBlogService;
import com.jvbo.blog.service.front.blogType.IFrontBlogTypeService;
import com.jvbo.blog.service.front.link.IFrontLinkService;

/**  
 * @ClassName: MainController 
 * @Description: TODO
 * @author jvbo
 * @date 2016年10月25日
 */
@Controller
@RequestMapping("/sys")
public class SysMainController {
	
	private static Logger logger = LoggerFactory.getLogger(SysDataDicController.class);
	
	@Autowired
	private ISysMainService mainService;
	@Autowired
	private ISysUserService userService;
	
	@Autowired
	private IFrontBlogService frontBlogService;
	@Autowired
	private IFrontBlogTypeService frontBlogTypeService;
	@Autowired
	private IFrontLinkService frontLinkService;
	
	@RequestMapping("/main")
	public String main(){
		return "sys/toLogin";
	}
	
	@RequestMapping("/index")
	public String index(){
		return "sys/index";
	}
	
	@RequestMapping("/noLogin")
	public String noLogin(){
		return "sys/toLogin";
	}
	
	@RequestMapping(value="/login",method = RequestMethod.GET)
	public String login(){
		return "sys/login";
	}
	
	@ResponseBody
	@RequestMapping(value="/login",method = RequestMethod.POST)
	public Map<String, Object> login(User user,HttpSession session){
		logger.info("用户名:{},密码{}", new Object[]{user.getLoginName(), user.getPassWord()});
		boolean flag = false;
		String message = null;
		if(StringUtils.isBlank(user.getLoginName())){
			message = "登录名不能为空";
		}else if(StringUtils.isBlank(user.getPassWord())){
			message = "密码不能为空";
		}else{
			User selectUser = userService.findByLoginName(user.getLoginName());
			if(selectUser==null){
				message = "登录名不存在";
			}else{
				if(!selectUser.getPassWord().equals(user.getPassWord())){
					message = "密码错误";
				}else{
					flag = true;
					session.setAttribute(Constants.USER, selectUser);
					session.setAttribute(Constants.USERID, selectUser.getId());
				}
			}
		}
		Map<String,Object> viewMap = new HashMap<String, Object>();
		viewMap.put("success", flag);
		viewMap.put("message", message);
		return viewMap;
	}
	
	// 2016-10-25 shiro+velocity后面需要整合
	/*@RequestMapping("login")
	public String login(ModelMap model , User user){
		UsernamePasswordToken token = new UsernamePasswordToken(user.getLoginName(), user.getPassWord());  
	    token.setRememberMe(true);
	    Subject subject = SecurityUtils.getSubject();
		try{
			subject.login(token); // 登录验证
			if(subject.isAuthenticated()){
				return index(model, null);
			}else{
				return "sys/login";
			}
		}catch(Exception e){
			e.printStackTrace();
			model.addAttribute("user", user);
			model.addAttribute("message", "用户名或密码错误！");
			return "sys/login";
		}
	}*/
	
	@RequestMapping("/loginOut")
	public String loginOut(HttpSession session){
		session.removeAttribute(Constants.USER);
		session.removeAttribute(Constants.USERID);
		return "sys/login";
	}
	
	@ResponseBody
	@RequestMapping("/menuList")
	public Map<String,Object> menuList(HttpSession session){
		String userId = session.getAttribute(Constants.USERID).toString();
		logger.info("===================userId:{}======================", new Object[]{userId});
		List<MenuBo> MenuBoList = mainService.findMenu(userId);
		Map<String,Object> viewMap = new HashMap<String, Object>();
		viewMap.put("menus", MenuBoList);
		return viewMap;
	}
	
	/**
	 * 刷新前台缓存
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("/refreshSystem")
	public Map<String, Object> refreshSystem(HttpServletResponse response,HttpServletRequest request)throws Exception{
		ServletContext application=RequestContextUtils.getWebApplicationContext(request).getServletContext();
		
		List<BlogBo> newBlogList = frontBlogService.newBlogList(); // 根据日期分组查询博客
		application.setAttribute("newBlogList", newBlogList);
		
		List<BlogTypeBo> blogTypeCountList=frontBlogTypeService.countList(); // 查询博客类别以及博客的数量
		application.setAttribute("blogTypeCountList", blogTypeCountList);
		
		List<BlogBo> blogCountList=frontBlogService.countList(); // 根据日期分组查询博客
		application.setAttribute("blogCountList", blogCountList);
		
		List<Link> linkList=frontLinkService.list(null); // 获取所有友情链接
		application.setAttribute("linkList", linkList);
		
		Map<String,Object> viewMap = new HashMap<String, Object>();
		viewMap.put("success", true);
		return viewMap;
	}
}
