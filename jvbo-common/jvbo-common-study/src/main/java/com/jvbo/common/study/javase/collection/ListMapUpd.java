/*
 * ListMapUpd.java 2017年6月7日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.common.study.javase.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.common.collect.Lists;

public class ListMapUpd {
	public static void main(String[] args) {
		//updateListMapElement();
		
		//CollectionsSort();
		updateListElement();
	}
	
	public static void CollectionsSort() {
		List<Person> personList = new ArrayList<Person>();
		personList.add(new Person("5", "05"));
		personList.add(new Person("3", "03"));
		personList.add(new Person("4", "04"));
		personList.add(new Person("1", "01"));
		personList.add(new Person("2", "02"));
		
		for (Person person : personList) {
			System.out.println(person.toString());
		}
		Collections.sort(personList, Comparator.comparing(Person::getName));
		for (Person person : personList) {
			System.out.println(person.toString());
		}
	}

	/**
	 * 测试修改List<Map>中map的值
	 * @Description: TODO
	 * @param    
	 * @return void  
	 * @throws
	 * @author jvbo
	 * @date 2017年6月8日
	 */
	private static void updateListMapElement(){
		List<Map<String, Object>> listMap = new ArrayList<Map<String, Object>>();
		Map<String, Object> map1 = new HashMap<String, Object>();
		Map<String, Object> map2 = new HashMap<String, Object>();
		Map<String, Object> map3 = new HashMap<String, Object>();
		Map<String, Object> map4 = new HashMap<String, Object>();
		map1.put("tid", "a");
		map1.put("tablename", "上海");
		listMap.add(map1);
		map2.put("tid", "b");
		map2.put("tablename", "北京");
		listMap.add(map2);
		map3.put("tid", "c");
		map3.put("tablename", "浙江");
		listMap.add(map3);
		map4.put("tid", "d");
		map4.put("tablename", "深圳");
		listMap.add(map4);
		
		
		for (Map<String, Object> map : listMap) {
			if("浙江".equals(map.get("tablename"))) {
				map.put("tablename","杭州");
			}
		}
		/*for(int i = 0; i < listMap.size(); i++) {
			  Map<String, Object> map = (HashMap<String, Object>) listMap.get(i);
			  if("浙江".equals(map.get("tablename"))) {
				  map.put("tablename","杭州");
			  }
		}*/
		
		
		for (Map<String, Object> map : listMap) {
    		System.out.println(map.get("tid")+""+map.get("tablename"));
		}
	}
	
	public static List<Person> updateListElement(){
		List<Person> personList = Lists.newArrayList();
		personList.add(new Person("1", "name1"));
		personList.add(new Person("2", "name2"));
		personList.add(new Person("3", "name3"));
		
		for (Person person : personList) {
			person.setName("name");
			break;
		}
		
		for (Person person : personList) {
			System.out.println(person.getId() + ":" +person.getName());
		}
		return personList;
	}
}
