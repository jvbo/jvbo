/*
 * DateUtil.java 2018年4月24日
 * Copyright (c) 2015-2018, Jv Bo (programmer_jv_bo@163.com).
 */
package site.jvbo.fun.common.util;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;

public class DateUtil {
    
    /**
     * 某日期开始时间
     * @Description: TODO
     * @param @param date
     * @param @return   
     * @return long  
     * @throws
     * @author jvbo
     * @date 2018年4月24日
     */
    public static long getStartOfDay(Date date){
        LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(date.getTime()), ZoneId.systemDefault());  
        LocalDateTime startOfDay = localDateTime.with(LocalTime.MIN);  
        return startOfDay.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli(); 
    }
    
    /**
     * 某日期结束时间
     * @Description: TODO
     * @param @param date
     * @param @return   
     * @return long  
     * @throws
     * @author jvbo
     * @date 2018年4月24日
     */
    public static long getEndOfDay(Date date){
        LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(date.getTime()), ZoneId.systemDefault());;  
        LocalDateTime endOfDay = localDateTime.with(LocalTime.MAX);  
        return endOfDay.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
    }
}
