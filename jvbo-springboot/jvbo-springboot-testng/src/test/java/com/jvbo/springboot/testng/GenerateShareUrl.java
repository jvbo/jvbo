/*
 * GenerateShareUrl.java 2018年5月18日
 * Copyright (c) 2015-2018, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.springboot.testng;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
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
    
    public List<JSONObject> redisData = new LinkedList<>();
    public List<String> phoneList = new LinkedList<>();
    public List<String> tokenList = new LinkedList<>();
    public List<Long> userIdList = new LinkedList<>();
    public Map<String, String> data = new HashMap<>();
    
    @Before
    public void setUp(){
        phoneList.add("13200000001");
        tokenList.add(UUID.randomUUID().toString().replaceAll("-", ""));
    }
    
    @Test
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
            data.put(phoneNo, token);
        }
        
        logger.info("redisSuccess:{}", JSON.toJSONString(redisData));
        logger.info("data:{}", JSON.toJSONString(data));
    }
    
    @Test
    public void testSms() throws Exception {
        Map<String, String> smsData = new HashMap<>();
        final String smsUrl = "http://t-api.heiyu.pro/hyc/sms/send";
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
    }
    
    @Test
    public void testRegister() throws Exception {
        Map<String, String> registerData = new HashMap<>();

        final String registerUrl = "http://t-api.heiyu.pro/hyc/user/register";
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
        }
        logger.info("registerData:{}", JSON.toJSONString(registerData));
    }
    
    /*@Test
    public void testLogin() throws Exception {
        Map<String, String> loginData = new HashMap<>();

        final String loginUrl = "http://t-api.heiyu.pro/hyc/user/login?deviceId={1}";
        for (int i = 0, length = tokenList.size(); i < length; i++) {
            String token = tokenList.get(i);
            String deviceId = UUID.randomUUID().toString();
            
            HttpHeaders headers = new HttpHeaders();
            //headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
            headers.set("Authorization", "Token ".concat(token));
            MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
            params.add("deviceId", deviceId);
            HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<MultiValueMap<String, String>>(params, headers);
            
            JSONObject jo = testRestTemplate.exchange(loginUrl, HttpMethod.GET, requestEntity,JSONObject.class, deviceId)
                    .getBody();
            
            loginData.put(phoneList.get(i), jo.toJSONString());
        }
        
        logger.info("loginData:{}", JSON.toJSONString(loginData));
    }*/
}
