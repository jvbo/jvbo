package site.jvbo.fun.common.spring.listener;

import org.springframework.boot.context.event.ApplicationPreparedEvent;
import org.springframework.context.ApplicationListener;
import site.jvbo.fun.common.util.SpringUtils;

public class SpringUtilsApplicationPreparedListener implements ApplicationListener<ApplicationPreparedEvent> {

    @Override
    public void onApplicationEvent(ApplicationPreparedEvent event) {
        SpringUtils.setApplicationContext(event.getApplicationContext());
    }
}
