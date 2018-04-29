/*
 * App.java 2018年3月25日
 * Copyright (c) 2015-2018, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.common.study.any;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.time.DateUtils;

import com.google.common.collect.Lists;

public class App {
    public static void main(String[] args) throws ParseException {
        System.out.println(BigDecimal.ZERO.setScale(6));
        
        List<Integer> iList = Lists.newArrayList();
        iList.add(1);
        iList.add(2);
        iList.add(3);
        iList.add(4);
        
        List<Integer> aList = iList;
        aList.add(5);
        
        for (Integer integer : aList) {
            System.out.println(integer);
        }
        
        String dateStr = "20180424".concat("000000");
        Date date = DateUtils.parseDate(dateStr, "yyyyMMddHHmmss");
        System.out.println(date);
    }
}
