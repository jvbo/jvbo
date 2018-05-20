/*
 * GenerateShareUrl.java 2018年5月18日
 * Copyright (c) 2015-2018, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.springboot.testng;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootTestngApplication.class, webEnvironment = WebEnvironment.RANDOM_PORT)
public class GenerateShareUrl {
    private static final Logger logger = LoggerFactory.getLogger(GenerateShareUrl.class);

    @Autowired
    private TestRestTemplate testRestTemplate;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    
    //private static final String domain = "http://localhost:8080/";
    private static final String domain = "http://t-api.heiyu.pro/hyc";
    //private static final String domain = "http://api2.heiyu.pro/hyc";
    public List<JSONObject> redisData = new LinkedList<>();
    public List<String> phoneList = new LinkedList<>();
    public List<String> tokenList = new LinkedList<>();
    public Map<String, String> phoneMapUserId = new HashMap<>();
    
    @Before
    public void setUp(){
        phoneList.add("13200000006");
        
        //tokenList.add(UUID.randomUUID().toString().replaceAll("-", ""));
        // 
        tokenList.add("2e3601d21f734b32abf91c5bc9d7c112");
    }
    
    /*@Test
    public void testRedis(){
        Map<String, String> redisData = new HashMap<>();
        for (int i = 0, length = phoneList.size(); i < length; i++) {
            String phoneNo = phoneList.get(i);
            String token = tokenList.get(i);
            JSONObject jo = new JSONObject();
            jo.put("user_name", phoneNo);
            
            String key = "TOKEN_".concat(token);
            String value = jo.toJSONString();
            stringRedisTemplate.opsForValue().set(key, value, 1, TimeUnit.DAYS);
            String redisValue = stringRedisTemplate.opsForValue().get(key);
            redisData.put(key, redisValue);
        }
        
        logger.info("redisSuccess:{}", JSON.toJSONString(redisData));
    }
    
    @Test
    public void testSms() throws Exception {
        Map<String, String> smsData = new HashMap<>();
        final String smsUrl = domain.concat("/sms/send");
        for (int i = 0, length = phoneList.size(); i < length; i++) {
            String phoneNo = phoneList.get(i);
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
            MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
            params.add("phoneNo", phoneNo);
            HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<MultiValueMap<String, String>>(params, headers);
            
            JSONObject jo = testRestTemplate.exchange(smsUrl, HttpMethod.POST, requestEntity,JSONObject.class)
                    .getBody();
            
            smsData.put(phoneNo, jo.toJSONString());
        }
        logger.info("smsData:{}", JSON.toJSONString(smsData));
    }*/
    
    /*@Test
    public void testRegister() throws Exception {
        Map<String, String> registerData = new HashMap<>();

        final String registerUrl = domain.concat("/user/register");
        final String inviteCode = "GJaSYY";
        final String fromType = "wechat_friend";
        final String code = "1111";
        for (int i = 0, length = phoneList.size(); i < length; i++) {
            String phoneNo = phoneList.get(i);
            String token = tokenList.get(i);
            
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
            headers.set("Authorization", "Token ".concat(token));
            MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
            params.add("inviteCode", inviteCode);
            params.add("fromType", fromType);
            params.add("phoneNo", phoneNo);
            params.add("code", code);
            HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<MultiValueMap<String, String>>(params, headers);
            
            JSONObject jo = testRestTemplate.exchange(registerUrl, HttpMethod.POST, requestEntity,JSONObject.class)
                    .getBody();
            
            registerData.put(phoneNo, jo.toJSONString());
            
            if(jo.containsKey("info")){
                JSONObject infoJo = jo.getJSONObject("info");
                JSONObject dataJo = infoJo.getJSONObject("data");
                String userId = dataJo.getString("userId");
                phoneMapUserId.put(phoneNo, userId);
            }else{
                phoneMapUserId = null;
            }
        }
        logger.info("registerData:{}", JSON.toJSONString(registerData));
    }*/
    
    @Test
    public void testInviteCode(){
        Map<String, String> generateCodeData = new HashMap<>();
        final String loginUrl = domain.concat("/index/inviteCode");
        for (int i = 0, length = tokenList.size(); i < length; i++) {
            String token = tokenList.get(i);
            HttpHeaders headers = new HttpHeaders();
            headers.set("Authorization", "Token ".concat(token));
            MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
            HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<MultiValueMap<String, String>>(params, headers);
            
            JSONObject jo = testRestTemplate.exchange(loginUrl, HttpMethod.GET, requestEntity,JSONObject.class)
                    .getBody();
            
            if(jo.containsKey("info")){
                JSONObject infoJo = jo.getJSONObject("info");
                JSONObject dataJo = infoJo.getJSONObject("data");
                String inviteCodeData = dataJo.getString("inviteCode");
                generateCodeData.put(phoneList.get(i), inviteCodeData);
            }
        }
        logger.info("generateCodeData:{}", JSON.toJSONString(generateCodeData));
        
        Map<String, String> inviteUrlData = new HashMap<>();
        // http://hych5.heiyu.pro/h5_home/h5_home.html?inviteCode=GJaSYY&phoneNo=18322276200&fromType=other
        generateCodeData.forEach((k, v) -> {
            String phone = k;
            String genInviteCode = v;
            StringBuilder sb = new StringBuilder();
            sb.append("http://hych5.heiyu.pro/h5_home/h5_home.html?inviteCode=").append(genInviteCode)
            .append("&phoneNo=").append(phone).append("&fromType=other");
            inviteUrlData.put(phone, sb.toString());
        });
        
        logger.info("generateCodeData:{}", JSON.toJSONString(inviteUrlData));
    }
    
}
