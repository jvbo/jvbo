package com.jvbo.springboot.practice.framework.listener;

import org.springframework.boot.context.event.ApplicationPreparedEvent;
import org.springframework.context.ApplicationListener;

import com.jvbo.springboot.practice.framework.util.SpringUtils;

public class SpringUtilsApplicationPreparedListener implements ApplicationListener<ApplicationPreparedEvent> {

    @Override
    public void onApplicationEvent(ApplicationPreparedEvent event) {
        SpringUtils.setApplicationContext(event.getApplicationContext());
    }
}
