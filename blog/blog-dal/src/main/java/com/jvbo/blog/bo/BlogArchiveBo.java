/*
 * BlogArchiveBo.java 2016年11月19日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.blog.bo;

import java.util.ArrayList;
import java.util.List;

import com.jvbo.blog.bo.BlogBo;

public class BlogArchiveBo {
	private Integer year;
	private Integer blogNum;
	private List<BlogBo> blogBoList = new ArrayList<BlogBo>();
	
	public List<BlogBo> getBlogBoList() {
		return blogBoList;
	}
	public void setBlogBoList(List<BlogBo> blogBoList) {
		this.blogBoList = blogBoList;
	}
	public Integer getBlogNum() {
		return blogNum;
	}
	public void setBlogNum(Integer blogNum) {
		this.blogNum = blogNum;
	}
	public Integer getYear() {
		return year;
	}
	public void setYear(Integer year) {
		this.year = year;
	}
	
}
