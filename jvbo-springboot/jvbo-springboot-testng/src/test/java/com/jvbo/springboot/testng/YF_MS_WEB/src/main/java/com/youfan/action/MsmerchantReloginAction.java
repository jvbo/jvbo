package com.youfan.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alibaba.dubbo.config.annotation.Reference;
import com.youfan.enity.Msmerchant;
import com.youfan.enity.Msuser;
import com.youfan.service.MsUserService;
import com.youfan.service.MsmerchantService;
import com.youfan.vo.msmerchant.MsmerchantVo;
import com.youfan.vo.msuser.MsuserVo;

/**
 * 商家注册登录模块
 * @author Administrator
 *
 */
@Controller
@RequestMapping("msmerchantReloginAction")
public class MsmerchantReloginAction {
	
	@Autowired
	MsmerchantService msmerchantService;
	
	@RequestMapping(value = "toregiter")
	public String toregiter(){
		return "msmerchant/toregiter";
	}
	
	@RequestMapping(value = "regiter",method=RequestMethod.POST)
	public String regiter(HttpServletRequest req,Msmerchant msmerchant){
		msmerchantService.insertMsmerchant(msmerchant);
		HttpSession sess = req.getSession();
		sess.setAttribute("msmerchant", msmerchant);
		return "adminpagehome/homepage";
	}
	
	@RequestMapping(value = "tologin")
	public String tologin(HttpServletRequest req,Msuser msuser){
		
		return "msmerchant/tologin";
	}
	
	@RequestMapping(value = "login",method=RequestMethod.POST)
	public String login(HttpServletRequest req,Msuser msuser){
		String returnurl = "adminpagehome/error";
		String account = msuser.getUseraccount();
		String password = msuser.getUserpassword();
		Msmerchant msmerchant = msmerchantService.queryMsmerchantByaccount(account);
		if(msmerchant == null ){
			System.out.println("无此商家");
			req.setAttribute("errorinfo", "无此商家");
		}else if(!msmerchant.getMerchantpassword().equals(password)){
			System.out.println("商家密码错误");
			req.setAttribute("errorinfo", "商家密码错误");
		}else{
			HttpSession sess = req.getSession();
			sess.setAttribute("msmerchant", msmerchant);
			returnurl = "adminpagehome/homepage";
		}
		return returnurl;
	}
	
	@RequestMapping(value = "exit")
	public String exit(HttpServletRequest req){
		HttpSession sess = req.getSession();
		sess.removeAttribute("msmerchant");
		return "adminpagehome/homepage";
	}
	
	
	
	
	
}
