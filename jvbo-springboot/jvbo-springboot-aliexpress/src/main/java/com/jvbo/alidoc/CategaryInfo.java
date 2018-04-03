/*
 * CategaryInfo.java 2017年8月7日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.alidoc;

import java.util.ArrayList;
import java.util.List;

public class CategaryInfo {
	private Long categoryID;
	private String name;
	private Boolean isLeaf;
	private List<CategaryInfo> childIDs = new ArrayList<CategaryInfo>();
	
	public Long getCategoryID() {
		return categoryID;
	}
	public void setCategoryID(Long categoryID) {
		this.categoryID = categoryID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Boolean getIsLeaf() {
		return isLeaf;
	}
	public void setIsLeaf(Boolean isLeaf) {
		this.isLeaf = isLeaf;
	}
	public List<CategaryInfo> getChildIDs() {
		return childIDs;
	}
	public void setChildIDs(List<CategaryInfo> childIDs) {
		this.childIDs = childIDs;
	}
}
