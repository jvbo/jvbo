/*
 * Aliexpress.java 2017年6月9日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.aliexpress.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.openapi.sdk.aeopenapi.ApiFacade;
import com.alibaba.openapi.sdk.aeopenapi.param.AeopAeProductSKUs;
import com.alibaba.openapi.sdk.aeopenapi.param.ApiEditAeProductParam;
import com.alibaba.openapi.sdk.aeopenapi.param.ApiEditAeProductResult;
import com.alibaba.openapi.sdk.aeopenapi.param.ApiEditProductCategoryAttributesParam;
import com.alibaba.openapi.sdk.aeopenapi.param.ApiEditProductCategoryAttributesResult;
import com.alibaba.openapi.sdk.aeopenapi.param.ApiEditProductCidAttIdSkuParam;
import com.alibaba.openapi.sdk.aeopenapi.param.ApiEditProductCidAttIdSkuResult;
import com.alibaba.openapi.sdk.aeopenapi.param.ApiEditSimpleProductFiledParam;
import com.alibaba.openapi.sdk.aeopenapi.param.ApiEditSimpleProductFiledResult;
import com.alibaba.openapi.sdk.aeopenapi.param.ApiEditSingleSkuPriceParam;
import com.alibaba.openapi.sdk.aeopenapi.param.ApiEditSingleSkuPriceResult;
import com.alibaba.openapi.sdk.aeopenapi.param.ApiEditSingleSkuStockParam;
import com.alibaba.openapi.sdk.aeopenapi.param.ApiEditSingleSkuStockResult;
import com.alibaba.openapi.sdk.aeopenapi.param.ApiFindProductInfoListQueryParam;
import com.alibaba.openapi.sdk.aeopenapi.param.ApiFindProductInfoListQueryResult;
import com.alibaba.openapi.sdk.aeopenapi.param.ApiGetPhotoBankInfoResult;
import com.alibaba.openapi.sdk.aeopenapi.param.ApiGetProductGroupListResult;
import com.alibaba.openapi.sdk.aeopenapi.param.ApiListGroupParam;
import com.alibaba.openapi.sdk.aeopenapi.param.ApiListGroupResult;
import com.alibaba.openapi.sdk.aeopenapi.param.ApiOfflineAeProductParam;
import com.alibaba.openapi.sdk.aeopenapi.param.ApiOfflineAeProductResult;
import com.alibaba.openapi.sdk.aeopenapi.param.ApiOnlineAeProductParam;
import com.alibaba.openapi.sdk.aeopenapi.param.ApiOnlineAeProductResult;
import com.alibaba.openapi.sdk.aeopenapi.param.ApiPostAeProductParam;
import com.alibaba.openapi.sdk.aeopenapi.param.ApiPostAeProductResult;
import com.alibaba.openapi.sdk.aeopenapi.param.ApiUploadImage4SDKParam;
import com.alibaba.openapi.sdk.aeopenapi.param.ApiUploadImage4SDKResult;
import com.alibaba.openapi.sdk.aeopenapi.param.ApiUploadTempImage4SDKParam;
import com.alibaba.openapi.sdk.aeopenapi.param.ApiUploadTempImage4SDKResult;
import com.jvbo.alidoc.api.ApiCallService;
import com.jvbo.alidoc.auth.AuthService;
import com.jvbo.alidoc.auth.ClientAuthService;
import com.jvbo.alidoc.util.CommonUtil;


@Controller
@RequestMapping(value = "/aliexpress")
@ResponseBody
public class AliexpressController {
	
	public static final String host = "gw.api.alibaba.com";
	public static final String site = "aliexpress";
	public static final String client_id = "47657290";
	public static final String appSecret = "JsaMdYrjUA";
	public static final String redirect_uri = "http://localhost:7900/aliexpress/findToken2Ae";
	
	@RequestMapping(value = "/findAuthUrl2Ae", method = {RequestMethod.POST,RequestMethod.GET})
	public String findAuthUrl2Ae(@RequestParam(value = "storeId", defaultValue = "店铺id") String storeId, 
			@RequestParam(value = "platformId", defaultValue = "1") int platformId, 
			@RequestParam(value = "storeName", defaultValue = "店铺名称") String storeName){
		String userId = "用户id";
		StringBuilder sb = new StringBuilder();
		sb.append(userId).append(";").append(storeId).append(";").append(storeName).append(";").append(platformId);
		
		String state = sb.toString();
		Map<String, String> params = new HashMap<String, String>();
		params.put("site", site);
		params.put("client_id", client_id);
		params.put("redirect_uri", redirect_uri);
		params.put("state", state);
		String getCodeForClientResult = ClientAuthService.getClientAuthUrl(host, params, appSecret);
		System.out.println("请在浏览器中访问如下地址并输入网站用户名密码进行授权: " + getCodeForClientResult);
		return getCodeForClientResult;
	}
	
	@RequestMapping(value = "/findToken2Ae", method = {RequestMethod.POST,RequestMethod.GET})
	public String findToken2Ae(@RequestParam("code") String code){
		Map<String, String> params = new HashMap<String, String>();
		params.put("client_id", client_id);
		params.put("client_secret", appSecret);
		params.put("redirect_uri", redirect_uri);
		params.put("code", code);
		String token = AuthService.getToken(host, params, true);
		/*getToken返回结果：{"refresh_token_timeout":"20171219194526000-0800","aliId":"2026530386","resource_owner":"cn1520683634miml","expires_in":"36000","refresh_token":"91f6afc4-2f29-4945-8527-09a6e7234226","access_token":"83609a8f-3363-4716-bd51-c06c9c9d2bc0"}*/
		return token;
	}
	
	@RequestMapping(value = "/refreshToken2Ae", method = {RequestMethod.POST,RequestMethod.GET})
	public String refreshToken2Ae(@RequestParam("refresh_token") String refresh_token){
		Map<String, String> params = new HashMap<String, String>();
		params.put("client_id", client_id);
		params.put("client_secret", appSecret);
		params.put("redirect_uri", redirect_uri);
		params.put("refresh_token", refresh_token);
		String refreshToken = AuthService.refreshToken(host, params);
		/*返回结果类似getToken返回结果：{"refresh_token_timeout":"20171219194526000-0800","aliId":"2026530386","resource_owner":"cn1520683634miml","expires_in":"36000","refresh_token":"91f6afc4-2f29-4945-8527-09a6e7234226","access_token":"83609a8f-3363-4716-bd51-c06c9c9d2bc0"}*/
		return refreshToken;
	}
	
	// TODO 获取指定类目下子类目信息(cateId=0时，获得第一级类目列表)
	@RequestMapping(value = "/findChildrenPostCategoryById2Ae", method = {RequestMethod.POST, RequestMethod.GET})
	public String findChildrenPostCategoryById2Ae(@RequestParam("accessToken")String accessToken,
			@RequestParam(value = "cateId", defaultValue = "0")int cateId){
		String result = null;
		Map<String, String> params = new HashMap<String, String>();
		String urlHead = "https://" + host + "/openapi/";
		String namespace = "aliexpress.open";
		String name = "api.getChildrenPostCategoryById";
		int version = 1;
		String protocol = "param2";
		String appKey = client_id;
		params.put("cateId", new String(cateId+""));
		params.put("access_token", accessToken);
		String urlPath = CommonUtil.buildInvokeUrlPath(namespace, name, version, protocol, appKey);

		//返回结果:类目信息
		result = ApiCallService.callApiTest(urlHead, urlPath, null, params);
		return result.toString();
	}
	
	// TODO 获取单个类目信息
	@RequestMapping(value = "findPostCategoryById2Ae", method = {RequestMethod.GET, RequestMethod.POST})
	public String findPostCategoryById2Ae(@RequestParam("accessToken")String accessToken,
			@RequestParam("cateId")int cateId){
		String result = null;
		Map<String, String> params = new HashMap<String, String>();
		String urlHead = "https://" + host + "/openapi/";
		String namespace = "aliexpress.open";
		String name = "api.getPostCategoryById";
		int version = 1;
		String protocol = "param2";
		String appKey = client_id;
		params.put("cateId", new String(cateId+""));
		params.put("access_token", accessToken);
		String urlPath = CommonUtil.buildInvokeUrlPath(namespace, name, version, protocol, appKey);

		//返回结果:单个类目信息
		result = ApiCallService.callApiTest(urlHead, urlPath, null, params);
		return result.toString();
	}
	
	// TODO 获取单个产品信息
	@RequestMapping(value = "findAeProductById2Ae", method = {RequestMethod.GET, RequestMethod.POST})
	public String findAeProductById2Ae(@RequestParam("accessToken")String accessToken,
			@RequestParam("productId")Long productId){
		String result = null;
		Map<String, String> params = new HashMap<String, String>();
		String urlHead = "https://" + host + "/openapi/";
		String namespace = "aliexpress.open";
		String name = "findAeProductById";
		int version = 1;
		String protocol = "param2";
		String appKey = client_id;
		params.put("productId", new String(productId+""));
		params.put("access_token", accessToken);	
		String urlPath = CommonUtil.buildInvokeUrlPath(namespace, name, version, protocol, appKey);

		//返回结果:商品的类目属性、SKU属性、商品详描
		result = ApiCallService.callApiTest(urlHead, urlPath, null, params);
		return result;
	}

	/*  1. 获取发布类目的类目属性和 SKU 属性，以便填写产品的类目属性和 SKU
		属性。
		2. 为产品上传主图、 SKU 图(可选)。主图和 SKU 图可以直接引用图片银行中
		的图片。
		3. 如果产品需要尺码模版，现阶段需要通过卖家后台来创建尺码模版。
		4. 发布商品*/
	
	//商品发布流程
	// TODO 1.根据发布类目id、父属性路径（可选）获取子属性信息(类目属性、SKU属性)
	@RequestMapping(value = "findChildAttributesResultByPostCateIdAndPath2Ae", method = {RequestMethod.GET, RequestMethod.POST})
	public String findChildAttributesResultByPostCateIdAndPath2Ae(@RequestParam("access_token")String accessToken,
			@RequestParam("cateId") int cateId){
		String result = null;
		Map<String, String> params = new HashMap<String, String>();
		String urlHead = "https://" + host + "/openapi/";
        String namespace = "aliexpress.open";
        String name = "getChildAttributesResultByPostCateIdAndPath";
        int version = 1;
        String protocol = "param2";
        String appKey = client_id;
        params.put("cateId", new String(cateId+""));
        params.put("access_token", accessToken);	
        String urlPath = CommonUtil.buildInvokeUrlPath(namespace, name, version, protocol, appKey);
        
        //返回结果:类目属性、SKU属性
        result = ApiCallService.callApiTest(urlHead, urlPath, null, params);
        return result;
	}
	
	// TODO 编辑产品类目、属性、sku
	@RequestMapping(value = "editProductCidAttIdSku2Ae", method = {RequestMethod.GET, RequestMethod.POST})
	public String editProductCidAttIdSku2Ae(@RequestParam("accessToken")String accessToken){
		ApiFacade facade = new ApiFacade();
		facade.setAppKey(client_id);
		facade.setSigningKey(appSecret);
		ApiEditProductCidAttIdSkuParam request = new ApiEditProductCidAttIdSkuParam();
		
		ApiEditProductCidAttIdSkuResult result = facade.apiEditProductCidAttIdSku(request, accessToken);
		return result.toString();
	}
	
	// TODO 编辑商品类目属性,用给定的类目属性覆盖原有的类目属性
	@RequestMapping(value = "editProductCategoryAttribute2Ae", method = {RequestMethod.GET, RequestMethod.POST})
	public String editProductCategoryAttribute2Ae(@RequestParam("accessToken")String accessToken,
			@RequestParam("productId")Long productId){
		ApiFacade facade = new ApiFacade();
		facade.setAppKey(client_id);
		facade.setSigningKey(appSecret);
		
		ApiEditProductCategoryAttributesParam request = new ApiEditProductCategoryAttributesParam();
		ApiEditProductCategoryAttributesResult result = facade.apiEditProductCategoryAttributes(request, accessToken);
		return result.toString();
	}
	
	// TODO 编辑SKU的可售库存(单个商品的一个或者多个SKU可售库存)
	@RequestMapping(value = "editMutilpleSkuStock2Ae", method = {RequestMethod.GET, RequestMethod.POST})
	public String editMutilpleSkuStock2Ae(@RequestParam("accessToken")String accessToken,
			@RequestParam("productId")Long productId,
			@RequestParam("skuStocks")Map<String,Long> skuStocks){
		//将要修改的SKU的库存值保存在skuStocks参数中(Map类型数据)，其中key为SKU ID(字符串), value为对应的库存值(Long型)。
		String result = null;
		Map<String, String> params = new HashMap<String, String>();
		String urlHead = "https://" + host + "/openapi/";
        String namespace = "aliexpress.open";
        String name = "editMutilpleSkuStocks";
        int version = 1;
        String protocol = "param2";
        String appKey = client_id;
        params.put("productId", new String(productId+""));
        params.put("skuStocks", skuStocks.toString());
        params.put("access_token", accessToken);
        String urlPath = CommonUtil.buildInvokeUrlPath(namespace, name, version, protocol, appKey);
        
        //返回结果:待编辑的产品ID、修改的产品数
        result = ApiCallService.callApiTest(urlHead, urlPath, null, params);
        return result;
	}
	
	// TODO 编辑商品单个SKU库存
	@RequestMapping(value = "editSingleSkuStock2Ae", method = {RequestMethod.GET, RequestMethod.POST})
	public String editSingleSkuStock2Ae(@RequestParam("accessToken")String accessToken,
			@RequestParam("productId")Long productId,
			@RequestParam("skuId")String skuId,
			@RequestParam("ipmSkuStock")Long ipmSkuStockf){
		ApiFacade facade = new ApiFacade();
		facade.setAppKey(client_id);
		facade.setSigningKey(appSecret);
		
		ApiEditSingleSkuStockParam request = new ApiEditSingleSkuStockParam();
		//返回结果：修改的产品ID、修改的产品数
		ApiEditSingleSkuStockResult result = facade.apiEditSingleSkuStock(request, accessToken);
		return result.toString();
	}
	
	// TODO 编辑商品单个SKU价格 
	@RequestMapping(value = "editSingleSkuPrice2Ae", method = {RequestMethod.GET, RequestMethod.POST})
	public String editSingleSkuPrice2Ae(@RequestParam("accessToken")String accessToken,
			@RequestParam("productId")Long productId,
			@RequestParam("skuId")String skuId,
			@RequestParam("skuPrice")String skuPrice){
		ApiFacade facade = new ApiFacade();
		facade.setAppKey(client_id);
		facade.setSigningKey(appSecret);
		
		ApiEditSingleSkuPriceParam request = new ApiEditSingleSkuPriceParam();
		//返回结果：产品ID、修改的产品数
		ApiEditSingleSkuPriceResult result = facade.apiEditSingleSkuPrice(request, accessToken);
		return result.toString();
	}
	
	// TODO 上传图片到临时目录(推荐使用)
	@RequestMapping(value = "uploadTempImage4SDK2Ae", method = {RequestMethod.GET, RequestMethod.POST})
	public String uploadTempImage4SDK2Ae(@RequestParam("accessToken")String accessToken,
			@RequestParam("files") MultipartFile file){
		ApiFacade facade = new ApiFacade();
		facade.setAppKey(client_id);
		facade.setSigningKey(appSecret);
		
		ApiUploadTempImage4SDKParam request = new ApiUploadTempImage4SDKParam();
		request.setSrcFileName(file.getOriginalFilename());
		try {
			request.setFileData(file.getBytes());
		} catch (IOException e) {
			// TODO　
			
		}
		ApiUploadTempImage4SDKResult result = facade.apiUploadTempImage4SDK(request, accessToken);
		return result.toString();
	}
	
	// TODO 查询图片银行分组信息(不填groupId则返回所有图片组信息)
	@RequestMapping(value = "listGroup2Ae", method = {RequestMethod.GET, RequestMethod.POST})
	public String listGroup2Ae(@RequestParam("accessToken")String accessToken){
		ApiFacade facade = new ApiFacade();
		facade.setAppKey(client_id);
		facade.setSigningKey(appSecret); 
		
		ApiListGroupParam request = new ApiListGroupParam();
		ApiListGroupResult result = facade.apiListGroup(request, accessToken);
		return result.toString();
	}
	
	// TODO 上传图片到图片银行(推荐使用) groupId为空，则图片保存在Other组中 
	@RequestMapping(value = "uploadImage4SDK2Ae", method = {RequestMethod.GET, RequestMethod.POST})
	public String uploadImage4SDK2Ae(@RequestParam("accessToken")String accessToken,
			@RequestParam("files") MultipartFile file){
		ApiFacade facade = new ApiFacade();
		facade.setAppKey(client_id);
		facade.setSigningKey(appSecret);
		ApiUploadImage4SDKParam request = new ApiUploadImage4SDKParam();
		request.setFileName(file.getOriginalFilename());//上传文件名称，长度不要超过256个字符。
		try {
			request.setImageBytes(file.getBytes());//图片文件的字节流 图片大小限制：3MB
		} catch (IOException e) {
			// TODO Auto-generated catch block
		}
		ApiUploadImage4SDKResult result = facade.apiUploadImage4SDK(request, accessToken);
		return result.toString();
	}
	
	// TODO 获取图片银行信息
	@RequestMapping(value = "findPhotoBankInfo2Ae", method = {RequestMethod.GET, RequestMethod.POST})
	public String findPhotoBankInfo2Ae(@RequestParam("accessToken")String accessToken){
		ApiFacade facade = new ApiFacade();
		facade.setAppKey(client_id);
		facade.setSigningKey(appSecret);
		//返回结果：capicity：图片银行总容量，单位字节；useage：图片银行已使用量，单位字节
		ApiGetPhotoBankInfoResult result = facade.apiGetPhotoBankInfo(accessToken);
		return result.toString();
	}
	
	// TODO　获取当前会员的产品分组
	@RequestMapping(value = "findGoodGroupList2Ae", method = {RequestMethod.POST,RequestMethod.GET})
	public String findGoodGroupList2Ae(@RequestParam("accessToken")String accessToken){
		ApiFacade facade = new ApiFacade();
		facade.setAppKey(client_id);
		facade.setSigningKey(appSecret);
		ApiGetProductGroupListResult result = facade.apiGetProductGroupList(accessToken);
		return result.toString();
	}
	
	// TODO 商品列表查询
	@RequestMapping(value = "findGoodInfoListQuery2Ae", method = RequestMethod.POST)
	public String findGoodInfoListQuery2Ae(@RequestParam("accessToken")String accessToken, 
			@RequestParam("productStatusType")String productStatusType){
		ApiFacade facade = new ApiFacade();
		facade.setAppKey(client_id);
		facade.setSigningKey(appSecret);

		ApiFindProductInfoListQueryParam request = new ApiFindProductInfoListQueryParam();
		//商品业务状态，目前提供4种，输入参数分别是：上架:onSelling ；下架:offline ；审核中:auditing ；审核不通过:editingRequired。
		request.setProductStatusType(productStatusType);
		ApiFindProductInfoListQueryResult result = facade.apiFindProductInfoListQuery(request, accessToken);
		return result.toString();
	}
	
	// TODO 编辑商品单个字段(注：不支持商品分组、商品属性、SKU、服务模板的修改)
	@RequestMapping(value = "editSimpleGoodFiled2Ae", method = RequestMethod.POST)
	public String editSimpleGoodFiled2Ae(@RequestParam("goodId") Long goodId, 
			@RequestParam("filedName") String filedName, 
			@RequestParam("jsonParamStr") String jsonParamStr,
			@RequestParam("accessToken") String accessToken){
		ApiFacade facade = new ApiFacade();
		facade.setAppKey(client_id);
		facade.setSigningKey(appSecret);
		
		ApiEditSimpleProductFiledParam request = new ApiEditSimpleProductFiledParam();
		request.setProductId(goodId);
		request.setFiedName(filedName);
		request.setFiedvalue(jsonParamStr);
		ApiEditSimpleProductFiledResult result = facade.apiEditSimpleProductFiled(request, accessToken);
		return result.toString();
	}
	
	// TODO 发布产品信息
	@RequestMapping(value = "postGood2Ae", method = RequestMethod.POST)
	public String postGood2Ae(@RequestParam("detail")String detail,
			@RequestParam("aeopAeProductSKUs") AeopAeProductSKUs [] aeopAeProductSKUs,
			@RequestParam("accessToken")String accessToken){
		ApiFacade facade = new ApiFacade();
		facade.setAppKey(client_id);
		facade.setSigningKey(appSecret);
		
		ApiPostAeProductParam request = new ApiPostAeProductParam();
		request.setDetail(detail);
		request.setAeopAeProductSKUs(aeopAeProductSKUs);
		ApiPostAeProductResult result = facade.apiPostAeProduct(request, accessToken);
		return result.toString();
	}
	
	// TODO 修改编辑商品信息
	@RequestMapping(value = "editGood2Ae", method = RequestMethod.POST)
	public String editGood2Ae(@RequestParam("accessToken")String accessToken){
		ApiFacade facade = new ApiFacade();
		facade.setAppKey(client_id);
		facade.setSigningKey(appSecret);
		
		ApiEditAeProductParam request = new ApiEditAeProductParam();
		ApiEditAeProductResult result = facade.apiEditAeProduct(request, accessToken);
		return result.toString();
	}
	
	// TODO 商品上架
	@RequestMapping(value = "/onlineGood2Ae", method = RequestMethod.POST)
	public String onlineGood2Ae(@RequestParam("goodIds") String goodIds,
			@RequestParam("accessToken") String accessToken){
		ApiFacade facade = new ApiFacade();
		facade.setAppKey(client_id);
		facade.setSigningKey(appSecret);
		
		ApiOnlineAeProductParam request = new ApiOnlineAeProductParam();
		request.setProductIds(goodIds);
		ApiOnlineAeProductResult result = facade.apiOnlineAeProduct(request, accessToken);
		return result.toString();
	}
	
	// TODO 商品下架
	@RequestMapping(value = "offlineGood2Ae", method = RequestMethod.POST)
	public String offlineGood2Ae(@RequestParam("goodIds") String goodIds,
			@RequestParam("accessToken") String accessToken){
		ApiFacade facade = new ApiFacade();
		facade.setAppKey(client_id);
		facade.setSigningKey(appSecret);
		
		ApiOfflineAeProductParam request = new ApiOfflineAeProductParam();
		request.setProductIds(goodIds);
		ApiOfflineAeProductResult result = facade.apiOfflineAeProduct(request, accessToken);
		return result.toString();
	}
}
