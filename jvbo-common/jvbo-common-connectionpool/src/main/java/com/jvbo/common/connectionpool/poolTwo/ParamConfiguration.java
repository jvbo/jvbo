/*
 * ParamConfiguration.java 2017年7月20日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.common.connectionpool.poolTwo;

import java.io.Serializable;

public class ParamConfiguration implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3015834265012209361L;
	
	public static final int MIN_CONNECTION = 5;
	public static final int MAX_CONNECTION = 50;
	public static final int MIN_IDLE = 5;
	public static final long MAX_WAIT = 30000;
	
	private ParamConfiguration(){}
}
