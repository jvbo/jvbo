/*
 * Page.java 2016年10月15日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.springboot.practice.framework.mybatis.page;

import java.io.Serializable;

/**
 * 分页对象
 * @ClassName: Page 
 * @Description: TODO
 * @author jvbo
 * @date 2016年10月15日
 */
public final class Page implements Serializable {

	private static final long serialVersionUID = 1L;
	/**
	 * 分页查询开始记录位置
	 */
	private int begin;
	/**
	 * 分页查看下结束位置
	 */
	private int end;
	/**
	 * 每页显示记录数
	 */
	private int rows = 10;

	/**
	 * 查询结果总记录数
	 */
	private int totalRecords;
	/**
	 * 当前页码
	 */
	private int page;
	/**
	 * 总共页数
	 */
	private int pageCount;

	public Page() {}

	/**
	 * 构造函数
	 * @param begin
	 * @param length
	 */
	public Page(int begin, int rows) {
		this.begin = begin;
		this.rows = rows;
		this.end = this.begin + this.rows;
		this.page = (int) Math.floor((this.begin * 1.0d) / this.page) + 1;
	}

	/**
	 * @param begin
	 * @param length
	 * @param count
	 */
	public Page(int begin, int rows, int totalRecords) {
		this(begin, rows);
		this.totalRecords = totalRecords;
	}

	/**
	 * 设置页数，自动计算数据范围
	 * @param pageNo
	 */
	public Page(int page) {
		this.page = page;
		page = page > 0 ? page : 1;
		this.begin = this.rows * (page - 1);
		this.end = this.rows * page;
	}

	/**
	 * @return the begin
	 */
	public int getBegin() {
		return begin;
	}

	/**
	 * @return the end
	 */
	public int getEnd() {
		return end;
	}

	/**
	 * @param end
	 */
	public void setEnd(int end) {
		this.end = end;
	}

	/**
	 * @param begin
	 */
	public void setBegin(int begin) {
		this.begin = begin;
		if (this.rows != 0) {
			this.page = (int) Math.floor((this.begin * 1.0d) / this.rows) + 1;
		}
	}

	/**
	 * @return the length
	 */
	public int getRows() {
		return rows;
	}

	/**
	 * @param length
	 */
	public void setRows(int rows) {
		this.rows = rows;
		if (this.begin != 0) {
			this.page = (int) Math.floor((this.begin * 1.0d) / this.rows) + 1;
		}
	}

	/**
	 * @return the totalRecords
	 */
	public int getTotalRecords() {
		return totalRecords;
	}

	/**
	 * @param totalRecords
	 */
	public void setTotalRecords(int totalRecords) {
		this.totalRecords = totalRecords;
		this.pageCount = (int) Math.floor((this.totalRecords * 1.0d) / this.rows);
		if (this.totalRecords % this.rows != 0) {
			this.pageCount++;
		}
	}

	/**
	 * @return the pageNo
	 */
	public int getPage() {
		return page;
	}

	/**
	 * @param pageNo
	 */
	public void setPage(int page) {
		this.page = page;
		page = page > 0 ? page : 1;
		this.begin = this.rows * (page - 1);
		this.end = this.rows * page;
	}

	/**
	 * @return the pageCount
	 */
	public int getPageCount() {
		if (pageCount == 0) {
			return 1;
		}
		return pageCount;
	}

	/**
	 * @param pageCount
	 */
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	@Override
	public String toString() {
		final StringBuilder builder = new StringBuilder("begin=").append(begin).append(", end=")
				.append(end).append(", rows=").append(rows).append(", totalRecords=").append(
						totalRecords).append(", page=").append(page).append(", pageCount=")
				.append(pageCount);

		return builder.toString();
	}
}
