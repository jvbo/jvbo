package com.youfan.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alibaba.dubbo.config.annotation.Reference;
import com.youfan.enity.Msmerchant;
import com.youfan.service.MsmerchantService;
import com.youfan.vo.msmerchant.MsmerchantVo;

@Controller
@RequestMapping("msmerchantAction")
public class MsmerchantAction {
	
	@Autowired
	MsmerchantService msmerchantService;
	

	@RequestMapping("toadd")
	public String toadd(){
		return "msmerchant/add";
	}
	
	@RequestMapping(value = "add",method=RequestMethod.POST)
	public String add(Msmerchant msmerchant){
		msmerchantService.insertMsmerchant(msmerchant);
		System.out.println(msmerchant);
		return "redirect:querybyvo";
	}
	
	@RequestMapping("toupdate")
	public String toupdate(HttpServletRequest request,int id){
		Msmerchant msmerchant = msmerchantService.queryMsmerchantByid(id);
		request.setAttribute("msmerchant", msmerchant);
		return "msmerchant/update";
	}
	
	@RequestMapping(value="update",method=RequestMethod.POST)
	public String update(HttpServletRequest request,Msmerchant msmerchant){
		msmerchantService.updateMsmerchant(msmerchant);
		return "redirect:querybyvo";
	}
	
	@RequestMapping("del")
	public String del(HttpServletRequest request,int id){
		msmerchantService.deleteMsmerchantbyid(id);
		return "redirect:querybyvo";
	}
	
	@RequestMapping("querybyid")
	public String querybyid(HttpServletRequest request,int id){
		Msmerchant msmerchant = msmerchantService.queryMsmerchantByid(id);
		request.setAttribute("msmerchant", msmerchant);
		return "msmerchant/view";
	}
	
	@RequestMapping("querybyvo")
	public String querybyvo(HttpServletRequest request,MsmerchantVo msmerchantVo){
		List<Msmerchant> list = msmerchantService.queryMsmerchantbyvo(msmerchantVo);
		request.setAttribute("msmerchantlist", list);
		return "msmerchant/list";
	}
	
	
	
	
	
}
