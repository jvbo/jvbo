package com.youfan.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

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

@Controller
@RequestMapping("msUserAction")
public class MsUserAction {
	
	@Autowired
	MsUserService msUserService;
	

	@RequestMapping("toadd")
	public String toadd(){
		return "user/add";
	}
	
	@RequestMapping(value = "add",method=RequestMethod.POST)
	public String add(Msuser msuser){
		msUserService.insertUser(msuser);
		System.out.println(msuser);
		return "redirect:querybyvo";
	}
	
	@RequestMapping("toupdate")
	public String toupdate(HttpServletRequest request,int id){
		Msuser user = msUserService.queryMsuserByid(id);
		request.setAttribute("msuser",user);
		return "user/update";
	}
	
	@RequestMapping(value="update",method=RequestMethod.POST)
	public String update(HttpServletRequest request,Msuser msuser){
		msUserService.updateMsuser(msuser);
		System.out.println(msuser);
		return "redirect:querybyvo";
	}
	
	@RequestMapping("del")
	public String del(HttpServletRequest request,int id){
		msUserService.deleteMsuserbyid(id);
		return "redirect:querybyvo";
	}
	
	@RequestMapping("querybyid")
	public String querybyid(HttpServletRequest request,int id){
		Msuser msuser = msUserService.queryMsuserByid(id);
		request.setAttribute("msuser", msuser);
		return "user/view";
	}
	
	@RequestMapping("querybyvo")
	public String querybyvo(HttpServletRequest request,MsuserVo msuserVo){
		List<Msuser> list = msUserService.queryMsuserbyvo(msuserVo);
		request.setAttribute("msuserlist", list);
		return "user/list";
	}
	
	
	
	
	
}
