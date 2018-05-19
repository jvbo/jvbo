package com.youfan.action;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alibaba.dubbo.config.annotation.Reference;
import com.youfan.enity.Msproductinfo;
import com.youfan.service.MsproductService;
import com.youfan.service.cache.MsproductCacheService;
import com.youfan.service.redis.MsproductRedisService;
import com.youfan.vo.msproductinfo.ConstomProduct;
import com.youfan.vo.msproductinfo.MsProductVo;

@Controller
@RequestMapping("msproductAction")
public class MsproductAction {
	
	@Autowired
	private MsproductService msproductService;
	
	@Autowired
	private MsproductRedisService msproductRedisService;
	
	@RequestMapping(value="toApplymsproduct")
	public String toApplymsproduct(){
		return "msproductinfo/applymsproduct";
	}
	
	@RequestMapping(value="applymsproduct",method=RequestMethod.POST)
	public String applymsproduct(Msproductinfo msproductinfo){
		msproductService.applymsproduct(msproductinfo);
		return "redirect:listmsproduct";
	}
	
	@RequestMapping(value="listmsproduct")
	public String listmsproduct(HttpServletRequest req,MsProductVo msProductVo){
		List<Msproductinfo> list =  msproductService.listmsproduct(msProductVo);
		req.setAttribute("list", list);
		return "msproductinfo/list";
	}
	
	
	@RequestMapping(value="querymsproductByid")
	public String querymsproductByid(HttpServletRequest req,int id){
		Msproductinfo  msproductinfo =  msproductRedisService.querymsproductByid(id);
		req.setAttribute("msproductinfo", msproductinfo);
		return "msproductinfo/view";
	}
	
	@RequestMapping(value="deletemsproductByid")
	public String deletemsproductByid(HttpServletRequest req,int id){
		msproductService.deletemsproductByid(id);
		return "redirect:listmsproduct";
	}
	
	@RequestMapping(value="toupdatemsproduct")
	public String toupdatemsproduct(HttpServletRequest req,int id){
		Msproductinfo  msproductinfo = msproductService.querymsproductByid(id);
		Date starttime = msproductinfo.getStarttime();
		Date endtime = msproductinfo.getEndtime();
		String starttimestring = "";
		String endtimestring = "";
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		if(starttime != null){
			starttimestring = dateFormat.format(starttime);
		}
		if(endtime != null){
			endtimestring = dateFormat.format(endtime);
		}
		
		req.setAttribute("msproductinfo", msproductinfo);
		req.setAttribute("starttimestring", starttimestring);
		req.setAttribute("endtimestring", endtimestring);
		return "msproductinfo/updatemsproduct";
	}
	
	@RequestMapping(value="updatemsproduct",method=RequestMethod.POST)
	public String updatemsproduct(HttpServletRequest req,Msproductinfo msproductinfo){
		msproductService.updatemsproduct(msproductinfo);
		return "redirect:listmsproduct";
	}
	
	@RequestMapping(value="toupdatemsproductstate")
	public String toupdatemsproductstate(HttpServletRequest req,int id){
		Msproductinfo  msproductinfo = msproductService.querymsproductByid(id);
		Date starttime = msproductinfo.getStarttime();
		Date endtime = msproductinfo.getEndtime();
		String starttimestring = "";
		String endtimestring = "";
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		if(starttime != null){
			starttimestring = dateFormat.format(starttime);
		}
		if(endtime != null){
			endtimestring = dateFormat.format(endtime);
		}
		
		req.setAttribute("msproductinfo", msproductinfo);
		req.setAttribute("starttimestring", starttimestring);
		req.setAttribute("endtimestring", endtimestring);
		return "msproductinfo/auditmsproduct";
	}
	
	
	@RequestMapping(value="updatemsproductstate",method=RequestMethod.POST)
	public String updatemsproductstate(HttpServletRequest req,int id,int state){
		msproductService.updatemsproductstate(id,state);
		return "redirect:listmsproduct";
	}

}
