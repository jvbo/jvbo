/*
 * OkHttpUtil.java 2018年6月26日
 * Copyright (c) 2015-2018, Jv Bo (programmer_jv_bo@163.com).
 */
package site.jvbo.fun.common.util.okhttp;

import com.alibaba.fastjson.JSON;
import okhttp3.*;
import org.apache.commons.collections4.MapUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class OkHttpUtils {
    private static final Logger logger = LoggerFactory.getLogger(OkHttpUtils.class);
    
    private static final MediaType MEDIA_TYPE =  MediaType.parse("application/json; charset=utf-8");
    private static final int MAX_RETRY = 3;
    private static final int SC_OK = 200;

    public static String get(String url, Map<String, String> params) {
        String getUrl = attachGetParams(url, params);
        int retry = 0;
        boolean flag = false;
        String result = null;
        logger.info("getUrl:{}", getUrl);
        for (int i = 0; i < MAX_RETRY; i++) {
            if(retry > 0){
                logger.info("重试-retry:{} , requestUrl:{}", retry, getUrl);
            }
            Request request = new Request.Builder()
                    .url(getUrl)
                    .build();
            try(Response response = OkHttpClientSingleton.INSTANCE.getOkHttpClient().newCall(request).execute()){
                if(response.code() == SC_OK){
                    flag = true;
                    result = response.body().string();
                }else{
                	if(response.code() == 400){
						// 400 错误的请求,存在这种情况,忽略
                		flag = true;
						result = response.body().string();
					}
                    logger.error("get-error-requestUrl:{}, response:{}", getUrl, JSON.toJSONString(response));
                }
            } catch (Exception e) {
                logger.error("request error, 异常:{}, 详情:{}", e.getMessage(), JSON.toJSONString(e));
            }
            if(flag){
                break;
            }
            if(!flag && retry >=MAX_RETRY ){
                logger.error("重试 - {} - 次后还未获取到数据, requestUrl:{}", MAX_RETRY, getUrl);
                break;
            }
            try {
                retry += 1;
                Thread.sleep(7000);
            } catch (InterruptedException e) {
                logger.error("request error, 异常:{}, 详情:{}", e.getMessage(), JSON.toJSONString(e));
                Thread.currentThread().interrupted();
            }
        }
        return result;
    }
    
    public static String post(String url, String json) {
        RequestBody requestBody = RequestBody.create(MEDIA_TYPE, json);
        Request request = new Request.Builder().url(url).post(requestBody).build();
        String result = null;
        try(Response response = OkHttpClientSingleton.INSTANCE.getOkHttpClient().newCall(request).execute()){
            if(response.code() == SC_OK){
                result = response.body().string();
            }else{
                logger.error("response error, response:{}", JSON.toJSONString(response.body()));
            }
        } catch (IOException e) {
            logger.error("request error, 异常:{}, 详情:{}", e.getMessage(), JSON.toJSONString(e));
            Thread.currentThread().interrupted();
        }
        
        return result;
    }

    private static String attachGetParams(String url, Map<String,String> params){
        if(MapUtils.isNotEmpty(params)){
            Iterator<String> keys = params.keySet().iterator();
            Iterator<String> values = params.values().iterator();
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("?");
            for (int i = 0; i < params.size(); i++ ) {
                stringBuffer.append(keys.next()+"="+values.next());
                if (i!=params.size()-1) {
                    stringBuffer.append("&");
                }
            }
            return url.concat(stringBuffer.toString());
        }
        return url;
    }
    
    private enum OkHttpClientSingleton {
        INSTANCE;

        private OkHttpClient okHttpClient;

        OkHttpClientSingleton(){
            okHttpClient = new OkHttpClient.Builder()
                    //.proxy(new Proxy(Proxy.Type.HTTP, new InetSocketAddress("127.0.0.1", 1080)))
                    .connectTimeout(10, TimeUnit.SECONDS)
                    .readTimeout(10, TimeUnit.SECONDS)
                    .writeTimeout(10, TimeUnit.SECONDS).build();
        }

        public OkHttpClient getOkHttpClient(){
            return this.okHttpClient;
        }

    }

    public static void main(String[] args) {
        System.out.println("");
    }
}
