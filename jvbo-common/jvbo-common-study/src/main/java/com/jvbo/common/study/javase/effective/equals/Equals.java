/*
 * Equals.java 2018年1月30日
 * Copyright (c) 2015-2017, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.common.study.javase.effective.equals;

public class Equals {
    
    private final String s;
    
    public Equals(String s){
        if(s == null)
            throw new NullPointerException();
        this.s = s;
    }
    
    /*@Override
    public boolean equals(Object obj) {
        if(obj instanceof Equals)
            return s.equalsIgnoreCase(((Equals)obj).s);
        if(obj instanceof String)
            return s.equalsIgnoreCase((String)obj);
        return false;
    }*/
    
    @Override
    public boolean equals(Object obj) {
        return obj instanceof Equals && 
                ((Equals)obj).s.equals(s);
    }
    
}
