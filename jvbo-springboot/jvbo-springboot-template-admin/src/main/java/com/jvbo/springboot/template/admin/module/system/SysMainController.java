/*
 * SysMainController.java 2017年8月24日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.springboot.template.admin.module.system;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jvbo.springboot.template.admin.core.bo.AuthMenuBo;
import com.jvbo.springboot.template.admin.core.service.ISysMainService;
import com.jvbo.springboot.template.admin.core.util.constant.Constant;

/**  
 * 
 * @ClassName: SysMainController 
 * @Description: TODO
 * @author jvbo
 * @date 2017年8月24日
 */
@Controller
@RequestMapping("/sys")
public class SysMainController {
	
	private static Logger logger = LoggerFactory.getLogger(SysMainController.class);
	
	@Autowired
	private ISysMainService mainService;
	@Autowired
	//private ISysUserService userService;
	
	@RequestMapping("/index")
	public String index(){
		return "/sys/index";
	}
	
	@RequestMapping("/noLogin")
	public String noLogin(){
		return "sys/toLogin";
	}
	
	@RequestMapping(value="/login",method = RequestMethod.GET)
	public String login(){
		return "sys/login";
	}
	
	@RequestMapping(value="/hplusmain")
	public String hplusmain(){
		return "sys/hplusmain";
	}
	
	/*@ResponseBody
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
					session.setAttribute(Constant.AdminUser.ADMIN_USER, selectUser);
					session.setAttribute(Constant.AdminUser.ADMIN_USERID, selectUser.getId());
				}
			}
		}
		Map<String,Object> viewMap = new HashMap<String, Object>();
		viewMap.put("success", flag);
		viewMap.put("message", message);
		return viewMap;
	}*/
	
	@RequestMapping("/loginOut")
	public String loginOut(HttpSession session){
		session.removeAttribute(Constant.AdminUser.ADMIN_USER);
		session.removeAttribute(Constant.AdminUser.ADMIN_USERID);
		return "sys/login";
	}
	
	@ResponseBody
	@RequestMapping("/menuList")
	public Map<String,Object> menuList(HttpSession session){
		//1	admin	admin
		//String userId = session.getAttribute(Constant.AdminUser.ADMIN_USERID).toString();
		String userId = "1";
		logger.info("===================userId:{}======================", new Object[]{userId});
		List<AuthMenuBo> MenuBoList = mainService.findMenu(userId);
		Map<String,Object> viewMap = new HashMap<String, Object>();
		viewMap.put("menus", MenuBoList);
		return viewMap;
	}
	
}
