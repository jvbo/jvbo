/*
 * Context.java 2017年11月13日
 * Copyright (c) 2015-2017, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.designpattern.interpreter;

import java.util.HashMap;
import java.util.Map;

/**
 * 环境(Context)类定义出从变量到布尔值的一个映射
 * @ClassName: Context 
 * @Description: TODO
 * @author jvbo
 * @date 2017年11月13日
 */
public class Context {
	private Map<Variable,Boolean> map = new HashMap<Variable,Boolean>();

	public void assign(Variable var , boolean value){
        map.put(var, new Boolean(value));
    }
    
    public boolean lookup(Variable var) throws IllegalArgumentException{
        Boolean value = map.get(var);
        if(value == null){
            throw new IllegalArgumentException();
        }
        return value.booleanValue();
    }


}
