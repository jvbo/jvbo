/*
 * TimerServer.java 2018年7月25日
 * Copyright (c) 2015-2018, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.common.study.javaee.netty.bio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TimeServer {
    public static void main(String[] args) throws IOException {
        int port = 8080;
        ServerSocket server = null;
        try {
            server = new ServerSocket(port);
            System.out.println("time server start in port:" + port);
            Socket socket = null;
            TimeServerHandlerExecutePool singleExecutor = new TimeServerHandlerExecutePool(50, 1000);
            while (true){
                socket = server.accept();
                singleExecutor.execute(new TimeServerHandler(socket));
                //new Thread(new TimeServerHandler(socket)).start();
            }
        } finally {
            if(server != null){
                System.out.println("timer server close");
                server.close();
                server = null;
            }
        }
        
    }
}
