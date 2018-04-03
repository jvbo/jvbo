/*
 * Period.java 2018年3月12日
 * Copyright (c) 2015-2018, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.common.study.javase.effective.safe;

import java.util.Date;

/**
 * 第39条:必要时进行保护性拷贝
 * @ClassName: Period 
 * @Description: TODO
 * @author jvbo
 * @date 2018年3月12日
 */
public final class Period {
    private final Date start;
    private final Date end;
    
    /**
     * 
     * @param start
     * @param end
     * @throws NullPointerException if start or end is null
     */
    /*public Period(Date start, Date end){
        if(start.compareTo(end) > 0){
            throw new IllegalArgumentException(start + " after " + end);
        }
        this.start = start;
        this.end = end;
    }
    
    public Date start(){
        return start;
    }
    
    public Date end(){
        return end;
    }*/
    
    public Period(Date start, Date end){
        this.start = new Date(start.getTime());
        this.end = new Date(end.getTime());
        if(this.start.compareTo(this.end) > 0){
            throw new IllegalArgumentException(start + " after " + end);
        }
    }
    
    public Date start(){
        return new Date(start.getTime());
    }
    
    public Date end(){
        return new Date(end.getTime());
    }
}
