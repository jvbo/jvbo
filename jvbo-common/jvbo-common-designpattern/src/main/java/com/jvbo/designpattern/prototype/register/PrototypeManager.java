/*
 * ProtorypeManager.java 2017年11月2日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.designpattern.prototype.register;

import java.util.HashMap;
import java.util.Map;

/**
 * 原型管理器角色
 * @ClassName: PrototypeManager 
 * @Description: TODO
 * @author jvbo
 * @date 2017年11月2日
 */
public class PrototypeManager {
	
	//用来记录原型编号和原型实例的对应关系
	private static Map<String, Prototype> map = new HashMap<String, Prototype>();
	
	private PrototypeManager(){}
	
	//向原型管理器添加/修改某个原型注册
	public synchronized static void setPrototype(String prototypeId, Prototype prototype){
		map.put(prototypeId, prototype);
	}
	
	//删除
	public synchronized static void removePrototype(String prototypeId){
		map.remove(prototypeId);
	}
	
	public synchronized static Prototype getPrototype(String prototypeId) throws Exception{
		Prototype prototype = map.get(prototypeId);
		if(prototype == null){
			throw new Exception("原型未注册或已销毁");
		}
		return prototype;
	}
	
	
}
