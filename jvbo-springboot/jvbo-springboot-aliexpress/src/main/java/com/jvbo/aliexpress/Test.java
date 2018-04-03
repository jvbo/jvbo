/*
 * Test.java 2017年8月21日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.aliexpress;

import java.util.List;

import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.util.LinkedList;
 
import org.apache.http.Consts;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSON;
 
/**
 * 模拟登陆
 */
public class Test {
 
  public static void main(String[] args) throws java.text.ParseException {
    String name = "fff";
    String password = "111111";
     
    // 全局请求设置
    RequestConfig globalConfig = RequestConfig.custom().setCookieSpec(CookieSpecs.STANDARD).build();
    // 创建cookie store的本地实例
    CookieStore cookieStore = new BasicCookieStore();
    // 创建HttpClient上下文
    HttpClientContext context = HttpClientContext.create();
    context.setCookieStore(cookieStore);
 
    // 创建一个HttpClient
    CloseableHttpClient httpClient = HttpClients.custom().setDefaultRequestConfig(globalConfig)
        .setDefaultCookieStore(cookieStore).build();
 
    CloseableHttpResponse res = null;
 
    // 创建本地的HTTP内容
    try {
      try {
        // 创建一个get请求用来获取必要的Cookie，如_xsrf信息
        HttpGet get = new HttpGet("http://edobee.com/");
 
        res = httpClient.execute(get, context);
        // 获取常用Cookie
        System.out.println("获取未登录时Cookie:===============");
        for (Cookie c : cookieStore.getCookies()) {
          System.out.println(c.getName() + ": " + c.getValue());
        }
        res.close();
 
        // 构造post数据
        List<NameValuePair> valuePairs = new LinkedList<NameValuePair>();
        valuePairs.add(new BasicNameValuePair("username", name));
        valuePairs.add(new BasicNameValuePair("password", password));
        UrlEncodedFormEntity entity = new UrlEncodedFormEntity(valuePairs, Consts.UTF_8);
        entity.setContentType("application/x-www-form-urlencoded");
 
        // 创建一个post请求
        HttpPost post = new HttpPost("http://edobee.com/ajaxLogin");
        // 注入post数据
        post.setEntity(entity);
        res = httpClient.execute(post, context);
 
        // 打印响应信息，查看是否登陆是否成功
        /*System.out.println("打印响应信息===========");
        System.out.println(JSON.toJSONString(res));*/
        res.close();
 
        System.out.println("登陆成功后,新的Cookie:===============");
        for (Cookie c : context.getCookieStore().getCookies()) {
          System.out.println(c.getName() + ": " + c.getValue());
        }
 
        // 构造一个新的get请求，用来测试登录是否成功
        HttpGet newGet = new HttpGet("http://edobee.com/myInformation");
        res = httpClient.execute(newGet, context);
        String content = EntityUtils.toString(res.getEntity());
        System.out.println("登陆成功后访问的页面===============");
        System.out.println(content);
        res.close();
        
        //post判断是否成功
        HttpPost postAgain = new HttpPost("http://edobee.com/currentUser");
        // 注入post数据
        res = httpClient.execute(postAgain, context);
        System.out.println("打印响应信息===========");
        System.out.println(JSON.toJSONString(res));
      } finally {
        httpClient.close();
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
