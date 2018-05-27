/*
 * MockTest.java 2018年5月17日
 * Copyright (c) 2015-2018, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.springboot.testng.sample;

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
import com.jvbo.springboot.testng.SpringBootTestngApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootTestngApplication.class, webEnvironment = WebEnvironment.RANDOM_PORT)
public class DataTemplateTest {

    private static final Logger logger = LoggerFactory.getLogger(DataTemplateTest.class);

    @Autowired
    private TestRestTemplate testRestTemplate;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    
    public List<JSONObject> redisData = new LinkedList<>();
    public List<String> phoneList = new LinkedList<>();
    public List<String> tokenList = new LinkedList<>();
    public Map<String, String> data = new HashMap<>();
    
    @Before
    public void setUp(){
        /*phoneList.add("13000000001");
        phoneList.add("13000000002");
        phoneList.add("13000000003");
        phoneList.add("13000000004");
        phoneList.add("13000000005");
        phoneList.add("13000000006");
        phoneList.add("13000000007");
        phoneList.add("13000000008");
        phoneList.add("13000000009");
        phoneList.add("13000000010");
        phoneList.add("13000000011");
        phoneList.add("13000000012");
        phoneList.add("13000000013");
        phoneList.add("13000000014");
        phoneList.add("13000000015");
        phoneList.add("13000000016");
        phoneList.add("13000000017");
        phoneList.add("13000000018");
        phoneList.add("13000000019");
        phoneList.add("13000000020");*/
        
        /*tokenList.add("fb01923b9b2a49e69ab25302619e4827");
        tokenList.add("75eed505aac04fd3b45c6a4c2878032b");
        tokenList.add("cc977b63b6c245c5bde693586c737519");
        tokenList.add("fd2e57661a674a5f93eaf27dd1764312");
        tokenList.add("3bcd1331ba3448fa9bd16f98d8a75857");
        tokenList.add("4c0d6d22fe164b29bf1e2d096e5695ad");
        tokenList.add("ed41301e7b4b4b379f1a6b903cd7b6a2");
        tokenList.add("a1cf95732d40459a82813bab52404aeb");
        tokenList.add("e5281c8486a34ea39f9e64bb9b892c62");
        tokenList.add("6134c1d295c74f5bbb42ca835b3c895c");
        tokenList.add("9449f895ccac43fbb0c53ddf73476ca4");
        tokenList.add("14a0101e4f6444b6be0651bc8a755481");
        tokenList.add("58961f6d102e47e8b52a0dd13e7744ed");
        tokenList.add("80866746de054879bd6e7ae0d2b9d2c9");
        tokenList.add("e5300e42eb8e427a9062d3e72bf9d06c");
        tokenList.add("269e3088d9ea4fbfbff213df574d8729");
        tokenList.add("41bb355649c54cd8bc5da1bd635e0172");
        tokenList.add("41bb355649c54cd8bc5da1bd635e0172");
        tokenList.add("a8a22ee5d44949b1ba04f22f77d49bcd");
        tokenList.add("810d335a29b842028f24bb68199116f3");*/
        
        phoneList.add("13500000001");
        phoneList.add("13500000002");
        phoneList.add("13500000003");
        
        tokenList.add("a5e0d7ec4b424ea59b2be4b5f8edd692");
        tokenList.add("bf28241eb35b42a7b521c57613000b6d");
        tokenList.add("9b825a529c614c608fded9a18e64179c");
        /*tokenList.add(UUID.randomUUID().toString().replaceAll("-", ""));
        tokenList.add(UUID.randomUUID().toString().replaceAll("-", ""));
        tokenList.add(UUID.randomUUID().toString().replaceAll("-", ""));*/
    }
    
    /*@Test
    public void testRedis(){
        Map<String, String> redisData = new HashMap<>();
        for (int i = 0, length = tokenList.size(); i < length; i++) {
            String token = tokenList.get(i);
            String phoneNo = phoneList.get(i);
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
    }*/
    
    /*@Test
    public void testRegister() throws Exception {
        Map<String, String> registerData = new HashMap<>();

        final String registerUrl = "http://t-api.heiyu.pro/hyc/user/register";
        final String inviteCode = "GZaHNY";
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
    }*/
    
    @Test
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
    }
}
