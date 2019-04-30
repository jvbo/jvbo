package com.jvbo.common.study.javase.apachecommon;


import org.apache.commons.lang3.time.DateUtils;

import java.text.ParseException;
import java.util.Date;

/**
 * @ClassName:
 * @Description: TODO
 * @author: jvbo
 * @date: 2019/4/30
 */
public class DateApp {
    public static void main(String[] args) throws ParseException {
        Date a = new Date();
        Date b = DateUtils.parseDate("2019-04-01", "yyyy-MM-dd");
        if(a.compareTo(b) > 0){
            System.out.println("a > b");
        }
        if(a.compareTo(b) == 0){
            System.out.println("a == b");
        }
        if(a.compareTo(b) < 0){
            System.out.println("a < b");
        }

    }
}
