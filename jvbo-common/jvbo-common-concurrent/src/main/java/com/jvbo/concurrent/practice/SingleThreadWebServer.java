/*
 * SingleThreadWebServer.java 2018年4月6日
 * Copyright (c) 2015-2018, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.concurrent.practice;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 串行的web服务器
 * @ClassName: SingleThreadWebServer 
 * @Description: TODO
 * @author jvbo
 * @date 2018年4月6日
 */
public class SingleThreadWebServer {
    public static void main(String[] args) throws IOException {
        ServerSocket socket = new ServerSocket(80);
        while(true){
            Socket connection = socket.accept();
            handleRequest(connection);
        }
    }

    private static void handleRequest(Socket connection) {
        // TODO Auto-generated method stub
        
    }
}
