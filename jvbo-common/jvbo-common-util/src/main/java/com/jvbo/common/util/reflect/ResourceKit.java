/*
 * @(#) PropertiesUtil.java 2016-7-2
 *
 * Copyright © 2009-2016 hzluang.cn All Rights Reserved.
 * hzluang.cn
 */
package com.jvbo.common.util.reflect;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * 资源文件解析工具
 * ClassName: PropertiesUtil 
 * @Description: TODO
 * @author jv.bo
 * @date 2016-7-2
 */
public class ResourceKit {  
  
    private Properties props;  
    private URI uri;
    
    public ResourceKit(String fileName){  
        readProperties(fileName);  
    }  
    private void readProperties(String fileName) {  
        try {  
            props = new Properties();  
            InputStream fis =new FileInputStream(new File(this.getClass().getResource(fileName).toURI()));  
            props.load(fis);  
            uri = this.getClass().getResource(fileName).toURI();
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
    }  
    /** 
     * 获取某个属性 
     */  
    public String getProperty(String key){  
        return props.getProperty(key);  
    }  
    /** 
     * 获取所有属性，返回一个map,不常用 
     * 可以试试props.putAll(t) 
     */  
    @SuppressWarnings({ "rawtypes", "unchecked" })
	public Map getAllProperty(){  
        Map map=new HashMap();  
        Enumeration enu = props.propertyNames();  
        while (enu.hasMoreElements()) {  
            String key = (String) enu.nextElement();  
            String value = props.getProperty(key);  
            map.put(key, value);  
        }  
        return map;  
    }  
    /** 
     * 在控制台上打印出所有属性，调试时用。 
     */  
    public void printProperties(){  
        props.list(System.out);  
    }  
    /** 
     * 写入properties信息 
     */  
    public void writeProperties(String key, String value) {  
        try {  
        	OutputStream fos = new FileOutputStream(new File(uri));  
            props.setProperty(key, value);  
            // 将此 Properties 表中的属性列表（键和元素对）写入输出流  
            props.store(fos, "『comments』Update key：" + key);  
        } catch (Exception e) {  
        	e.printStackTrace();
        }  
    }     
    
    
    public static void main(String[] args) {  
        ResourceKit util=new ResourceKit("/dbConfig.properties");  
        String str = util.getProperty("jdbcUrl");
        System.out.println(str);
    }      
}