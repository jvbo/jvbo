/*
 * NumberRange.java 2018年4月4日
 * Copyright (c) 2015-2018, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.concurrent.practice;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 此类并不足以保护它的不变形条件(不要这么做)
 * @ClassName: NumberRange 
 * @Description: TODO
 * @author jvbo
 * @date 2018年4月4日
 */
public class NumberRange {
    // 不变形条件: lower <= upper
    private final AtomicInteger lower = new AtomicInteger(0);
    private final AtomicInteger upper = new AtomicInteger(0);
    
    public void setLower(int i){
        // 注意:不安全的"先检查后执行"
        if(i > upper.get())
            throw new IllegalArgumentException("can not set lower to " + i + "> upper");
        lower.set(i);
    }
    
    public void setUpper(int i ){
        // 注意:不安全的"先检查后执行"
        if(i < lower.get())
            throw new IllegalArgumentException("can not set upper to " + i + "< lower");
        upper.set(i);
    }
    
    public boolean isInRange(int i){
        return (i >= lower.get() && i <= upper.get());
    }

}
