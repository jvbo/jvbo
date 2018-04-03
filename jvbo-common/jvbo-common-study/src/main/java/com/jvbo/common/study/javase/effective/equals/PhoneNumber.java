/*
 * PhoneNumber.java 2018年1月30日
 * Copyright (c) 2015-2017, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.common.study.javase.effective.equals;

public class PhoneNumber {
    private volatile int hashCode;
    
    private final short areaCode;
    private final short prefix;
    private final short lineNumber;
    
    public PhoneNumber(short areaCode, short prefix, short lineNumber){
        rangeCheck(areaCode, 999, "area code");
        rangeCheck(prefix, 999, "prefix");
        rangeCheck(lineNumber, 999, "line number");
        this.areaCode = areaCode;
        this.prefix = prefix;
        this.lineNumber = lineNumber;
    }

    private static void rangeCheck(short arg, int max, String name) {
        if(arg < 0 || arg > max)
            throw new IllegalArgumentException(name + ":" + arg);
    }

    /**
     * @Description: TODO
     * @param @param obj
     * @param @return   
     * @return  
     * @throws
     * @author jvbo
     * @date 2018年1月30日
     */
    @Override
    public boolean equals(Object obj) {
        if(obj == this)
            return true;
        if(!(obj instanceof PhoneNumber))
            return false;
        PhoneNumber pn = (PhoneNumber)obj;
        return pn.areaCode == areaCode
                && pn.prefix == prefix
                && pn.lineNumber == lineNumber;
    }

    /**
     * @Description: TODO
     * @param @return   
     * @return  
     * @throws
     * @author jvbo
     * @date 2018年1月30日
     */
    @Override
    public int hashCode() {
        int result = hashCode;
        if(result == 0){
            result = 31 * result + areaCode;
            result = 31 * result + prefix;
            result = 31 * result + lineNumber;
            hashCode = result;
        }
        return result;
    }

    /**
     * @Description: TODO
     * @param @return
     * @param @throws CloneNotSupportedException   
     * @return  
     * @throws
     * @author jvbo
     * @date 2018年1月30日
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return (PhoneNumber)super.clone();
    }
    
    
}
