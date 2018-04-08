/*
 * TaskExecutionWebServer.java 2018年4月7日
 * Copyright (c) 2015-2018, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.concurrent.practice.webserver;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * 基于线程池的web服务器
 * @ClassName: TaskExecutionWebServer 
 * @Description: TODO
 * @author jvbo
 * @date 2018年4月7日
 */
public class TaskExecutionWebServer {
    private static final int NTHREADS = 100;
    private static final Executor exec = Executors.newFixedThreadPool(NTHREADS);
    public static void main(String[] args) throws IOException {
        ServerSocket socket = new ServerSocket(80);
        while(true){
            final Socket connection = socket.accept();
            Runnable task = new Runnable(){

                @Override
                public void run() {
                    // TODO Auto-generated method stub
                    handleRequest(connection);
                }
                
            };
            exec.execute(task);
        }
    }
    
    protected static void handleRequest(Socket connection) {
        // TODO Auto-generated method stub
        
    }
}
