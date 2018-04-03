/*
 * NoRepeat.java 2018年1月29日
 * Copyright (c) 2015-2017, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.common.study.javase.effective.norepeat;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * 避免创建重复的对象
 * 1. 当你应该重用现有对象的时候,请不要重复创建对象;
 * 与2. 当你应该创建新对象的时候,请不要重用现有的对象;相对应
 * @ClassName: NoRepeat 
 * @Description: TODO
 * @author jvbo
 * @date 2018年1月29日
 */
public class NoRepeat {

    public static void main(String[] args) {
        String s = new String("s"); // don't do this 不要这样写
        
        // 改进后
        String ss = "s";
        System.out.println(s);
    }
    
}

/**
 * 反模式例子
 * @ClassName: Person 
 * @Description: TODO
 * @author jvbo
 * @date 2018年1月29日
 */
/*class Person{
    private final Date birthDate = new Date();
    
    // don't do this 不要这样做
    public boolean isBabyBoomer(){
        Calendar gmtCal = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
        gmtCal.set(1946, Calendar.JANUARY, 1, 0, 0, 0);
        Date boomStart = gmtCal.getTime();
        gmtCal.set(1965, Calendar.JANUARY, 1, 0, 0, 0);
        Date boomEnd = gmtCal.getTime();
        return birthDate.compareTo(boomStart) >= 0 && birthDate.compareTo(boomEnd) < 0;
    }
}*/

/**
 * 正确做法
 * @ClassName: Person 
 * @Description: TODO
 * @author jvbo
 * @date 2018年1月29日
 */
class Person{
    private final Date birthDate;
    
    private static final Date BOOM_START;
    private static final Date BOOM_END;
    
    {
        birthDate = new Date();
    }
    
    static {
        Calendar gmtCal = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
        gmtCal.set(1946, Calendar.JANUARY, 1, 0, 0, 0);
        BOOM_START = gmtCal.getTime();
        gmtCal.set(1965, Calendar.JANUARY, 1, 0, 0, 0);
        BOOM_END = gmtCal.getTime();
    }
    
    // don't do this 不要这样做
    public boolean isBabyBoomer(){
        return birthDate.compareTo(BOOM_START) >= 0 && birthDate.compareTo(BOOM_END) < 0;
    }
    
    public static void main(String[] args) {
        Person person = new Person();
        System.out.println(person.isBabyBoomer());
    }
}
