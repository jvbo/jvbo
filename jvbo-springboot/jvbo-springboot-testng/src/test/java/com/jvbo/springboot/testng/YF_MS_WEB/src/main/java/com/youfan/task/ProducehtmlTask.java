package com.youfan.task;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ProducehtmlTask
{
   
	public void producehtml(){
		String url = "http://127.0.0.1:8080/YF_MS_WEB/pagehomeAction/producehtml";
		
		CloseableHttpClient client = HttpClients.createDefault();
		 HttpGet httpGet = new HttpGet(url); 
		 CloseableHttpResponse response = null;

        try {
            //3.执行请求，获取响应
            response = client.execute(httpGet);
               

            //看请求是否成功，这儿打印的是http状态码
            System.out.println("ProducehtmlTask=="+response.getStatusLine().getStatusCode());
            
        }catch (Exception e) {  
            e.printStackTrace();  
        }  
	}
}
