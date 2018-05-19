package com.youfan.enity;


import java.io.Serializable;
import java.util.Date;

/**
 * 秒杀订单
 * @author Administrator
 *
 */
public class Msorder implements Serializable{
	private int id;//主键
	private int productid;//秒杀商品id
	private int payamount;//支付金额
	private int userid;//用户id
	private int merchantid;//商家id
	private Date createtime;//创建时间
	private Date paytime;//支付时间
	private int paystatus;//支付转态  1,未支付 2,已支付，3，退款成功,4。用户发起退款申请 5，退款失败
	private String receivingadress;//收货人地址
	private String receivingname;//收货人姓名
	private String receivingphone;//收货人电话
	private String tradeserialnumber;//交易流水号
	private int num;//数量
	private int paytype;//1代表支付宝  2代表微信  3代表银联
	
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
	public int getPayamount() {
		return payamount;
	}
	public void setPayamount(int payamount) {
		this.payamount = payamount;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getMerchantid() {
		return merchantid;
	}
	public void setMerchantid(int merchantid) {
		this.merchantid = merchantid;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	public Date getPaytime() {
		return paytime;
	}
	public void setPaytime(Date paytime) {
		this.paytime = paytime;
	}
	public int getPaystatus() {
		return paystatus;
	}
	public void setPaystatus(int paystatus) {
		this.paystatus = paystatus;
	}
	public String getReceivingadress() {
		return receivingadress;
	}
	public void setReceivingadress(String receivingadress) {
		this.receivingadress = receivingadress;
	}
	public String getReceivingname() {
		return receivingname;
	}
	public void setReceivingname(String receivingname) {
		this.receivingname = receivingname;
	}
	public String getReceivingphone() {
		return receivingphone;
	}
	public void setReceivingphone(String receivingphone) {
		this.receivingphone = receivingphone;
	}
	public String getTradeserialnumber() {
		return tradeserialnumber;
	}
	public void setTradeserialnumber(String tradeserialnumber) {
		this.tradeserialnumber = tradeserialnumber;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getPaytype() {
		return paytype;
	}
	public void setPaytype(int paytype) {
		this.paytype = paytype;
	}
	
	
	
	
}
