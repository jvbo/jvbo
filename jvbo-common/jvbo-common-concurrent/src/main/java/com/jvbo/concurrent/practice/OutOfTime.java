/*
 * OutOfTime.java 2018年4月7日
 * Copyright (c) 2015-2018, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.concurrent.practice;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

/**
 * 错误的Timer行为
 * @ClassName: OutOfTime 
 * @Description: TODO
 * @author jvbo
 * @date 2018年4月7日
 */
public class OutOfTime {
    public static void main(String[] args) throws InterruptedException {
        Timer timer = new Timer();
        timer.schedule(new ThrowTask(), 1);
        TimeUnit.SECONDS.sleep(1);
        timer.schedule(new ThrowTask(), 1);
        TimeUnit.SECONDS.sleep(5);
    }
    
    static class ThrowTask extends TimerTask {
        public void run(){
            throw new RuntimeException();
        }
    }
}
