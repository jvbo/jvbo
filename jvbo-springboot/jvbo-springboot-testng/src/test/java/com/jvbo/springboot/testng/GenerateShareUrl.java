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
    
    //private static final String domain = "http://localhost:8080/";
    //private static final String domain = "http://t-api.heiyu.pro/hyc";
    private static final String domain = "http://api2.heiyu.pro/hyc";
    public List<JSONObject> redisData = new LinkedList<>();
    public List<String> phoneList = new LinkedList<>();
    public List<String> tokenList = new LinkedList<>();
    public List<String> codeList = new LinkedList<>();
    public Map<String, String> phoneMapUserId = new HashMap<>();
    
    @Before
    public void setUp(){
        phoneList.add("13141185544");//5221
        phoneList.add("15879373994");//0616
        phoneList.add("18507099839");//3675
        phoneList.add("13105323519");//7359
        phoneList.add("18262739463");//8078
        phoneList.add("15017764126");//0621
        phoneList.add("18943686320");//5437
        phoneList.add("18037859872");//7427
        phoneList.add("15763016992");//2698
        phoneList.add("17736282395");//1127
        phoneList.add("18055028010");//6923
        phoneList.add("18257154123");//1220
        phoneList.add("17665378175");//9742
        phoneList.add("13577874328");//2492
        phoneList.add("17607695820");//2273
        phoneList.add("18793058565");//6112
        phoneList.add("15047300695");//7840
        phoneList.add("15725607890");//1976
        phoneList.add("18185731080");//6997
        phoneList.add("13315608990");//1594
        phoneList.add("18955809779");//2714
        phoneList.add("13957796620");//9617
        
        codeList.add("5221");
        codeList.add("0616");
        codeList.add("3675");
        codeList.add("7359");
        codeList.add("8078");
        codeList.add("0621");
        codeList.add("5437");
        codeList.add("7427");
        codeList.add("2698");
        codeList.add("1127");
        codeList.add("6923");
        codeList.add("1220");
        codeList.add("9742");
        codeList.add("2492");
        codeList.add("2273");
        codeList.add("6112");
        codeList.add("7840");
        codeList.add("1976");
        codeList.add("6997");
        codeList.add("1594");
        codeList.add("2714");
        codeList.add("9617");
        
        //tokenList.add(UUID.randomUUID().toString().replaceAll("-", ""));
        tokenList.add("920a67ba478d424d9840c3f997ab73fe");
        tokenList.add("fc10db5bda7140a8ad3588cef2787a07");
        tokenList.add("5a7648ce27564d4fad2b67c8d10d271f");
        tokenList.add("9945aaba901148ceb49ff214901d80cc");
        tokenList.add("6202e71aeb6b4b25994346fc36184f23");
        tokenList.add("841c812bb0184dccadd2b9440fb56c16");
        tokenList.add("b5f93a5dff1b42f4933d0c28e27fd23f");
        tokenList.add("98e780801e6a4882a58370358050deec");
        tokenList.add("8bcc8c0a2fbd4eff9cd18bda588287e9");
        tokenList.add("79d90316b66a4b1baab3b17825d8ca2e");
        tokenList.add("13c1addf1c0b4ad1b28ff56342f645e3");
        tokenList.add("0f037744b3f548398ab09b70ce21e3fe");
        tokenList.add("070ecb19c1e94b279df8895a9c01ef0e");
        tokenList.add("0e40fb294a2f4fd09f82ba7c85fbeec6");
        tokenList.add("7b3ed367093c4e66aa707bcee8ab4af6");
        tokenList.add("10aec5ff248b427199429c02570dacbc");
        tokenList.add("90c06596e2ba4460bff68c979203f2ea");
        tokenList.add("afec6b8e006f4ba8a79260fdc0abbe71");
        tokenList.add("6eb7f64819134a4ba2ca43e79296a2de");
        tokenList.add("3a93d4cbcdc44ab390b77960a9072a25");
        tokenList.add("49a32aaf304e466c8c620d3fd4ae216a");
        tokenList.add("c18c96cfe1cf42d0a0c4a2fc574fa8f6");
        
        //tokenList.add("2e3601d21f734b32abf91c5bc9d7c112");
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
    }*/
    
    /*@Test
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
    public void testRedisGetSms(){
        Map<String, String> redisData = new HashMap<>();
        for (int i = 0, length = phoneList.size(); i < length; i++) {
            String phoneNo = phoneList.get(i);
            String key = "heiyushop.app.server.user.sms.code.register.".concat(phoneNo);
            String code = stringRedisTemplate.opsForValue().get(key);
            stringRedisTemplate.expire(key, 60, TimeUnit.MINUTES);
            redisData.put(key, code);
        }
        logger.info("redisGetSmsSuccess:{}", JSON.toJSONString(redisData));
    }*/
    
    /*@Test
    public void testRegister() throws Exception {
        Map<String, String> registerData = new HashMap<>();

        final String registerUrl = domain.concat("/user/register");
        final String inviteCode = "";
        final String fromType = "wechat_friend";
        for (int i = 0, length = phoneList.size(); i < length; i++) {
            String phoneNo = phoneList.get(i);
            String token = tokenList.get(i);
            String code = codeList.get(i);
            
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
