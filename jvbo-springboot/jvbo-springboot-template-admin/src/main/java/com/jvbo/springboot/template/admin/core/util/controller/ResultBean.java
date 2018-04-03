/*
 * ResultBean.java 2017年9月12日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.springboot.template.admin.core.util.controller;

import java.io.Serializable;

import lombok.Data;

@Data
public class ResultBean<T> implements Serializable {
	private static final long serialVersionUID = 1L;
	public static final int SUCCESS = 0;
	public static final int FAIL = 1;
	public static final int NO_PERMISSION = 2;
	private String msg = "success";
	private int code = SUCCESS;
	private T data;
	public ResultBean() {
		super();
	}
	public ResultBean(T data) {
		super();
		this.data = data;
	}
	public ResultBean(Throwable e) {
		super();
		this.msg = e.toString();
		this.code = FAIL ;
	}
}