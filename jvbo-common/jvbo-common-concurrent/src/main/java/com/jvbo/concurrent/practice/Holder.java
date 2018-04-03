/*
 * Holder.java 2018年4月3日
 * Copyright (c) 2015-2018, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.concurrent.practice;

/**
 * 由于未被正确的发布,因此这个可能出现故障
 * @ClassName: Holder 
 * @Description: TODO
 * @author jvbo
 * @date 2018年4月3日
 */
public class Holder {
    
    private int n;
    
    public Holder(int n){
        this.n = n;
    }
    
    public void assertSanity(){
        if(n != n)
            throw new AssertionError("this statement is false.");
    }

}
