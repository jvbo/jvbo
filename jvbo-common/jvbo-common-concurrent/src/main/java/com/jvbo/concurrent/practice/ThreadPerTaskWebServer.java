/*
 * ThreadPerTaskWebServer.java 2018年4月6日
 * Copyright (c) 2015-2018, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.concurrent.practice;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 在web服务器中为每个请求启动一个新的线程(不要这么做)
 * @ClassName: ThreadPerTaskWebServer 
 * @Description: TODO
 * @author jvbo
 * @date 2018年4月6日
 */
public class ThreadPerTaskWebServer {

    public static void main(String[] args) throws IOException {
        ServerSocket socket = new ServerSocket(80);
        while(true){
            final Socket connection = socket.accept();
            Runnable task = new Runnable(){

                @Override
                public void run() {
                    handleRequest(connection);
                }
                
            };
            new Thread(task).start();
        }
    }

    private static void handleRequest(Socket connection) {
        // TODO Auto-generated method stub
        
    }

}
