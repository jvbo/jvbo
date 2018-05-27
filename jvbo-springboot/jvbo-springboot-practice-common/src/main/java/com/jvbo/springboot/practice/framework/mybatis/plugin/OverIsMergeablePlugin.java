/*
 * OverIsMergeablePlugin.java 2017年10月12日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.springboot.practice.framework.mybatis.plugin;

import java.util.List;

import org.mybatis.generator.api.GeneratedXmlFile;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;

import java.lang.reflect.Field;

/**
 * 修正Mybatis每次重新generator，mapper的xml文件都不断追加的问题而用的插件
 * @ClassName: OverIsMergeablePlugin 
 * @Description: TODO
 * @author jvbo
 * @date 2017年10月12日
 */
public class OverIsMergeablePlugin extends PluginAdapter {
    
    public boolean validate(List<String> warnings) {
        return true;
    }

    public boolean sqlMapGenerated(GeneratedXmlFile sqlMap, IntrospectedTable introspectedTable) {
        try {
            Field field = sqlMap.getClass().getDeclaredField("isMergeable");
            field.setAccessible(true);
            field.setBoolean(sqlMap, false);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
}
