/*
 * Person.java 2017年7月14日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.common.study.javase.collection;

public class Person {
	private String id;
	private String name;
	
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + "]";
	}
	
	public Person() {}
	
	public Person(String id, String name) {
		this.id = id;
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
