package com.youfan.action.newpagehome;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.dubbo.config.annotation.Reference;
import com.youfan.enity.Msproductdetail;
import com.youfan.enity.Msproductinfo;
import com.youfan.enity.Msuser;
import com.youfan.service.MsoderService;
import com.youfan.service.MsproductDetailService;
import com.youfan.service.MsproductService;
import com.youfan.service.redis.MsproductDetailRedisService;
import com.youfan.service.redis.MsproductRedisService;
import com.youfan.vo.msproductinfo.ConstomProduct;
import com.youfan.vo.msproductinfo.MsProductVo;

@Controller
@RequestMapping("newpagehomeAction")
public class NewPagehomeAction {
	
	@Autowired
	private MsproductService msproductService;
	
	@Autowired
	private MsoderService msoderService;
	
	@Autowired
	private MsproductDetailService msproductDetailService;
	
	@Autowired
	private MsproductRedisService msproductRedisService;
	
	@Autowired
	private MsproductDetailRedisService msproductDetailRedisService;
	
	@RequestMapping("index")
	public String index(HttpServletRequest req){
		MsProductVo msProductVo = new MsProductVo();
		ConstomProduct constomProduct = new ConstomProduct();
		Date now = new Date();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String nowstring = dateFormat.format(now);
		constomProduct.setStartendtime(nowstring);
		constomProduct.setAuditstate(2);
		msProductVo.setConstomProduct(constomProduct);
//		private Date startstarttime;//秒杀开始时间查询范围开始时间
//		private Date endstarttime;//秒杀开始时间查询范围结束时间
		msProductVo.setConstomProduct(constomProduct);
		List<Msproductinfo> list = msproductService.listmsproduct(msProductVo);
		req.setAttribute("list", list);
		return "newhomepage/index";
}
	
	@RequestMapping("viewproductdetail")
	public String viewproductdetail(HttpServletRequest req,int id){
		Msproductinfo msproduct = msproductRedisService.querymsproductByid(id);
		Msproductdetail msproductdetail = msproductDetailRedisService.queryMsproductdetailByid(id);
		req.setAttribute("msproduct", msproduct);
		req.setAttribute("msproductdetail", msproductdetail);
		return "newhomepage/seckill-item";
	}
	
}
