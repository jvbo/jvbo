/*
 * MenuBo.java 2016年10月27日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.blog.service.admin.system.bo;

import java.util.List;

public class MenuBo implements java.io.Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2382501490989653189L;
	private String id;
	private String icon;
	private String name;
    private String url;
    private Integer sort;
	private String parentMenu;
	private List<MenuBo> childenManus;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Integer getSort() {
		return sort;
	}
	public void setSort(Integer sort) {
		this.sort = sort;
	}
	public List<MenuBo> getChildenManus() {
		return childenManus;
	}
	public void setChildenManus(List<MenuBo> childenManus) {
		this.childenManus = childenManus;
	}
	public String getParentMenu() {
		return parentMenu;
	}
	public void setParentMenu(String parentMenu) {
		this.parentMenu = parentMenu;
	}
	
}
