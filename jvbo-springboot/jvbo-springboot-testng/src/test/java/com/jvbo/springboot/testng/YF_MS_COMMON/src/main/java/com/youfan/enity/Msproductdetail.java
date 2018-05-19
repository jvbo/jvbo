package com.youfan.enity;

import java.io.Serializable;

/**
 * 商品详情表
 * @author Administrator
 *
 */
public class Msproductdetail implements Serializable{
	private int id;//主键
	private int productid;//秒杀商品id
	private int merchantid;//商家id
	private String productplace;//商品产地
	private String productname;//商品名称
	private String brandname;//商品品牌
	private String productweight;//商品重量
	private String specification;//规格和包装
	private String productdetailpicture;//详情图片地址
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getProductid() {
		return productid;
	}
	public void setProductid(int productid) {
		this.productid = productid;
	}
	public int getMerchantid() {
		return merchantid;
	}
	public void setMerchantid(int merchantid) {
		this.merchantid = merchantid;
	}
	public String getProductplace() {
		return productplace;
	}
	public void setProductplace(String productplace) {
		this.productplace = productplace;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public String getBrandname() {
		return brandname;
	}
	public void setBrandname(String brandname) {
		this.brandname = brandname;
	}
	public String getProductweight() {
		return productweight;
	}
	public void setProductweight(String productweight) {
		this.productweight = productweight;
	}
	public String getSpecification() {
		return specification;
	}
	public void setSpecification(String specification) {
		this.specification = specification;
	}
	public String getProductdetailpicture() {
		return productdetailpicture;
	}
	public void setProductdetailpicture(String productdetailpicture) {
		this.productdetailpicture = productdetailpicture;
	}
	
	
}
