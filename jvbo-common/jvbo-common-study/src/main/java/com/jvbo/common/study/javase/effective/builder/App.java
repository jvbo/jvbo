/*
 * App.java 2018年1月29日
 * Copyright (c) 2015-2017, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.common.study.javase.effective.builder;

/**
 * test
 * @ClassName: App 
 * @Description: TODO
 * @author jvbo
 * @date 2018年1月29日
 */
public class App {
    public static void main(String[] args) {
        NutritionFacts n = new NutritionFacts.Builder(222, 1)
                .calories(1)
                .build();
    }
}
