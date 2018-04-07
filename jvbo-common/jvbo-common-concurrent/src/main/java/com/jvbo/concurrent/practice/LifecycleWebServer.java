/*
 * LifecycleWebServer.java 2018年4月7日
 * Copyright (c) 2015-2018, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.concurrent.practice;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;

import org.omg.CORBA.Request;

/**
 * 支持关闭操作的Web服务器
 * @ClassName: LifecycleWebServer 
 * @Description: TODO
 * @author jvbo
 * @date 2018年4月7日
 */
public class LifecycleWebServer {
    private static final int NTHREADS = 100;
    private static final ExecutorService exec = Executors.newFixedThreadPool(NTHREADS);
    
    public static void start() throws IOException{
        ServerSocket socket = new ServerSocket(80);
        while(!exec.isShutdown()){
            try {
                final Socket connection = socket.accept();
                exec.execute(new Runnable(){

                    @Override
                    public void run() {
                        // TODO Auto-generated method stub
                        handleRequest(connection);
                    }
                    
                });
            } catch (RejectedExecutionException e) {
                if(!exec.isShutdown())
                    System.out.println("task submission rejected, exception:" + e);
            }
        }
    }
    
    public static void stop(){
        exec.shutdown();
    }
    
    protected static void handleRequest(Socket connection) {
        Request req = readRequest(connection);
        if(isShutdownRequest(req))
            stop();
        else
            dispatcheRequest(req);
    }

    private static void dispatcheRequest(Request req) {
        // TODO Auto-generated method stub
        
    }

    private static boolean isShutdownRequest(Request req) {
        // TODO Auto-generated method stub
        return false;
    }

    private static Request readRequest(Socket connection) {
        // TODO Auto-generated method stub
        return null;
    }
    
    public static void main(String[] args) {
        
    }
}
