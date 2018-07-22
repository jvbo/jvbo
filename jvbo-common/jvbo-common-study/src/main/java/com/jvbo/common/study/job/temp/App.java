/*
 * App.java 2018年6月7日
 * Copyright (c) 2015-2018, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.common.study.job.temp;

import java.time.Instant;
import java.util.Date;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;

public class App {
    
    private static final String pattern = "yyyy-MM-dd HH:mm:ss"; 
    
    public static void main(String[] args) {
        before();
    }
    
    public static void before(){
        // 当前时间
        long now = Instant.now().toEpochMilli();
        // 结束时间
        long expireDate = 1529239968975L;
        // 开始时间
        long startDate = DateUtils.addDays(new Date(expireDate), -30).getTime();
        // 目前生成的矿块数
        int hasCount = 506;
        // 目前应该生成的矿块数
        int totalCount = normalNuggetCount(now - startDate);
        // 上一次时间
        long prevDate = now;
        // 下一次时间
        long nextDate = startDate + (totalCount + 1) * 60 * 60 * 1000L;

        System.out.println("now:" + DateFormatUtils.format(now, pattern));
        System.out.println("expireDate:" + DateFormatUtils.format(expireDate, pattern));
        System.out.println("startDate:" + DateFormatUtils.format(startDate, pattern));
        System.out.println("prevDate:" + DateFormatUtils.format(prevDate, pattern));
        System.out.println("nextDate:" + DateFormatUtils.format(nextDate, pattern));
        
        System.out.println("hasCount:" + hasCount);
        System.out.println("totalCount:" + totalCount);
    }
    
    public static final int normalNuggetCount(long compareTime){
        long hour = compareTime / (1000 * 60 * 60);
        return Long.valueOf(hour).intValue();
    }
}
