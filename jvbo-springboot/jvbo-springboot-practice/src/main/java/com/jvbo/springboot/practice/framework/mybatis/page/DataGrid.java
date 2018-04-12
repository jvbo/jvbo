/*
 * @(#) DataGrid.java 2016-2-26
 *
 * Copyright (c) 2016, ZuiQiang Technology. All Rights Reserved.
 * ZuiQiang  Technology. CONFIDENTIAL
 */
package com.jvbo.springboot.practice.framework.mybatis.page;

import java.io.Serializable;
import java.util.List;

/**
 * DataGrid分页实体封装
 * @Description: TODO
 * @author jv.bo
 * @version 1.0
 * @since 2016-2-26
 */
public class DataGrid<T> implements Serializable {

	/**
	 * <code>serialVersionUID</code>
	 */
	private static final long serialVersionUID = -6921510328300596912L;
	
	private long total = 0;// 总记录数
	private List<T> rows;// 每页记录
	private int pages = 0;//总页数
	private Object info;//附加信息
	private int page = 1;//当前页

	public List<T> getRows() {
		return rows;
	}
	public int getPages() {
		return pages;
	}
	public void setRows(List<T> rows) {
		this.rows = rows;
	}
	public void setPages(int pages) {
		this.pages = pages;
	}
	public long getTotal() {
		return total;
	}
	public void setTotal(long total) {
		this.total = total;
	}
	public Object getInfo() {
		return info;
	}
	public void setInfo(Object info) {
		this.info = info;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
}