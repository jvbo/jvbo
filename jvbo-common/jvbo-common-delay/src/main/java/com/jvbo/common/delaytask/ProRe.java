/*
 * ProRe.java 2017年6月1日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
/**  
 * @Title: ProRe.java
 * @Package com.jvbo.delaytask
 * @Description: TODO
 * @author jvbo
 * @date 2017年6月1日
 */
package com.jvbo.common.delaytask;

/**  
 * @ClassName: ProRe 
 * @Description: TODO
 * @author jvbo
 * @date 2017年6月1日
 */
public class ProRe {
	public String id;
	public long startTime;
	public long endTime;
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the startTime
	 */
	public long getStartTime() {
		return startTime;
	}
	/**
	 * @param startTime the startTime to set
	 */
	public void setStartTime(long startTime) {
		this.startTime = startTime;
	}
	/**
	 * @return the endTime
	 */
	public long getEndTime() {
		return endTime;
	}
	/**
	 * @param endTime the endTime to set
	 */
	public void setEndTime(long endTime) {
		this.endTime = endTime;
	}
	/**
	 * @Description: TODO
	 * @param @return   
	 * @return  
	 * @throws
	 * @author jvbo
	 * @date 2017年6月1日
	 */
	@Override
	public String toString() {
		return "ProRe [id=" + id + ", startTime=" + startTime + ", endTime=" + endTime + "]";
	}
	/**
	 * @param id
	 * @param startTime
	 * @param endTime
	 */
	public ProRe(String id, long startTime, long endTime) {
		super();
		this.id = id;
		this.startTime = startTime;
		this.endTime = endTime;
	}
	
}
