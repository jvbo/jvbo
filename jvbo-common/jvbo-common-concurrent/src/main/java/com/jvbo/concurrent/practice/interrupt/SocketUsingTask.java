/*
 * SocketUsingTask.java 2018年4月8日
 * Copyright (c) 2015-2018, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.concurrent.practice.interrupt;

import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RunnableFuture;

import com.jvbo.concurrent.practice.annotation.GuardedBy;

public abstract class SocketUsingTask<T> implements CancellableTask<T> {
    @GuardedBy("this")
    private Socket socket;
    
    protected synchronized void setSocket(Socket socket){
        this.socket = socket;
    }

    @Override
    public synchronized void cancel(){
        try {
            if(socket != null){
                socket.close();
            }
        } catch (IOException e) { }
    }
    
    @Override
    public RunnableFuture<T> newTask() {
        return new FutureTask<T>(this){
            @SuppressWarnings("finally")
            public boolean cancel(boolean mayInterruptIfRunning){
                try {
                    SocketUsingTask.this.cancel();
                } finally {
                    return super.cancel(mayInterruptIfRunning);
                }
            }
        };
    }

}
