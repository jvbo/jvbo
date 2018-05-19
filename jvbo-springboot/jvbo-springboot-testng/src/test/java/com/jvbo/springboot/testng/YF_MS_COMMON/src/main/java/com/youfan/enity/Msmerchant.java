package com.youfan.enity;

import java.io.Serializable;

/**
 * 商家实体
 * @author Administrator
 *
 */
public class Msmerchant implements Serializable{
	
	private int id;//主键
	private String merchantname;//商家的姓名
	private String merchantaccount;//商家账号
	private String merchantpassword;//商家密码
	private String merchantscope;//商家经营范围
	private String merchantshopname;//商家的店铺名称
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMerchantname() {
		return merchantname;
	}
	public void setMerchantname(String merchantname) {
		this.merchantname = merchantname;
	}
	public String getMerchantaccount() {
		return merchantaccount;
	}
	public void setMerchantaccount(String merchantaccount) {
		this.merchantaccount = merchantaccount;
	}
	public String getMerchantpassword() {
		return merchantpassword;
	}
	public void setMerchantpassword(String merchantpassword) {
		this.merchantpassword = merchantpassword;
	}
	public String getMerchantscope() {
		return merchantscope;
	}
	public void setMerchantscope(String merchantscope) {
		this.merchantscope = merchantscope;
	}
	public String getMerchantshopname() {
		return merchantshopname;
	}
	public void setMerchantshopname(String merchantshopname) {
		this.merchantshopname = merchantshopname;
	}
	
	@Override
	public String toString() {
		return "Msmerchant [id=" + id + ", merchantname=" + merchantname + ", merchantaccount=" + merchantaccount
				+ ", merchantpassword=" + merchantpassword + ", merchantscope=" + merchantscope + ", merchantshopname="
				+ merchantshopname + "]";
	}
	
	
}
