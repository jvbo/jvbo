/*
 * OkHttpUtil.java 2018年6月20日
 * Copyright (c) 2015-2018, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.springboot.catches.framework.util.okhttp;

import java.io.IOException;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class OkHttpUtil {
    public static final MediaType MEDIA_TYPE =  MediaType.parse("application/json; charset=utf-8");
    
    public static String get(String url) throws IOException{
        Request request = new Request.Builder()
                .url(url)
                .build();
        try(Response response = SingletonOkHttpClient.INSTANCE.getOkHttpClient().newCall(request).execute()){
            return response.body().string();
        }
    }
    
    public static String post(String url, String json) throws IOException{
        RequestBody requestBody = RequestBody.create(MEDIA_TYPE, json);
        Request request = new Request.Builder().url(url).post(requestBody).build();
        try(Response response = SingletonOkHttpClient.INSTANCE.getOkHttpClient().newCall(request).execute()){
            return response.body().string();
        }
    }
    
    public static void main(String[] args) throws IOException {
        String getResult = get("https://raw.githubusercontent.com/square/okhttp/master/README.md");
        System.out.println("getResult:" + getResult);
        
        JSONObject jo = new JSONObject();
        jo.put("winCondition", "HIGH_SCORE");
        jo.put("name", "Bowling");
        jo.put("round", 4);
        jo.put("lastSaved", "1367702411696");
        jo.put("dateStarted", "1367702378785");
        JSONArray ja = new JSONArray();
        for (int i = 0; i < 2; i++) {
            JSONObject Ijo = new JSONObject();
            Ijo.put("name", "winCondition");
            Ijo.put("history", new int[]{10,8,6,7,8});
            Ijo.put("color", -13388315);
            Ijo.put("total", 39);
            ja.add(Ijo);
        }
        jo.put("players", ja);
        String json = jo.toJSONString();
        String postResult = post("http://www.roundsapp.com/post", json);
        System.out.println("postResult:" + postResult);
    }
    
    private enum SingletonOkHttpClient {
        INSTANCE;
        
        private OkHttpClient okHttpClient;
        SingletonOkHttpClient(){
            okHttpClient = new OkHttpClient();
        }
        
        public OkHttpClient getOkHttpClient(){
            return okHttpClient;
        }
    }
}
