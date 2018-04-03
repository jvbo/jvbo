/*
 * Monkey.java 2017年11月7日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.designpattern.prototype.monkey;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;

/**
 * 猴子类
 * @ClassName: Monkey 
 * @Description: TODO
 * @author jvbo
 * @date 2017年11月7日
 */
public class Monkey implements Cloneable, Serializable {
	private int height;
	private int weight;
	private Date birthDate;
	private GoldRingedStaff staff;
	
	public Monkey(){
		this.birthDate = new Date();
		this.staff = new GoldRingedStaff();
	}
	
	//浅克隆
	@SuppressWarnings("finally")
	public Object clone(){
		Monkey temp = null;
		try {
			temp = (Monkey)super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			return temp;
		}
		
	}
	
	//深克隆
	public Object deepClone() throws IOException, ClassNotFoundException{
		//对象写到流里
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(bos);
		oos.writeObject(this);
		//从流里读出来
		ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
		ObjectInputStream ois = new ObjectInputStream(bis);
		return ois.readObject();
	}
	
	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public GoldRingedStaff getStaff() {
		return staff;
	}

	public void setStaff(GoldRingedStaff staff) {
		this.staff = staff;
	}
}
