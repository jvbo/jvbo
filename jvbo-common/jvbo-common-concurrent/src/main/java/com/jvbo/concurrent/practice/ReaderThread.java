/*
 * ReaderThread.java 2018年4月8日
 * Copyright (c) 2015-2018, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.concurrent.practice;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class ReaderThread extends Thread {
    private final Socket socket;
    private final InputStream in;

    public ReaderThread(Socket socket) throws IOException{
        this.socket = socket;
        this.in = socket.getInputStream();
    }

    @Override
    public void interrupt(){
        try {
            socket.close();
        } catch (IOException e) {

        } finally {
            super.interrupt();
        }
    }

    @Override
    public void run(){
        try {
            byte[] buf = new byte[1024];
            while(true){
                int count = in.read(buf);
                if(count < 0){
                    break;
                }else if(count > 0){
                    processBuffer(buf, count);
                }
            }
        } catch (IOException e) {
            // 允许线程退出
        }
    }

    private void processBuffer(byte[] buf, int count) {
        // TODO Auto-generated method stub
        
    }

}
