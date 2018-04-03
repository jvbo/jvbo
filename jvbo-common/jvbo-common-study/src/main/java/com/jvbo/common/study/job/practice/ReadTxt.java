/*
 * ReadTxt.java 2018年3月26日
 * Copyright (c) 2015-2018, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.common.study.job.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 写一个类，读一个txt文件，从中找到aliy这个词，并记录该字符串所在的行数和每一行中的位置
 * @ClassName: ReadTxt 
 * @Description: TODO
 * @author jvbo
 * @date 2018年3月26日
 */
public class ReadTxt {

    public static void main(String[] args) throws NumberFormatException, IOException {
        int[] dataArray = new int[10];
        int maxData = 0, minData = 0;
        InputStreamReader stdIn = new InputStreamReader(System.in);
        BufferedReader bufferIn = new BufferedReader(stdIn);
        for (int i = 0; i < dataArray.length; i++) {
            System.out.println("第" + i +"个");
            dataArray[i] = Integer.valueOf(bufferIn.readLine()).intValue();
        }
        maxData = minData = dataArray[0];
        for (int i = 0; i < dataArray.length; i++) {
            if(maxData < dataArray[i])
                maxData = dataArray[i];
            if(minData > dataArray[i])
                minData = dataArray[i];
        }
        System.out.println("最大值:" + maxData);
        System.out.println("最小值:" + minData);
    }

}
