/*
 * BaseServiceInitApplicationReadyListener.java 2018年4月12日
 * Copyright (c) 2015-2018, Jv Bo (programmer_jv_bo@163.com).
 */
package site.jvbo.fun.common.spring.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import site.jvbo.fun.common.annotation.base.BaseService;
import site.jvbo.fun.common.base.BaseInterface;

import java.lang.reflect.Method;
import java.util.Map;

public class BaseServiceInitApplicationReadyListener implements ApplicationListener<ApplicationReadyEvent> {
    private static Logger logger = LoggerFactory.getLogger(BaseServiceInitApplicationReadyListener.class);

    @Override
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        if(null == applicationReadyEvent.getApplicationContext().getParent()) {
            logger.debug(">>>>> spring初始化完毕 <<<<<");
            // spring初始化完毕后，通过反射调用所有使用BaseService注解的initDaoMapper方法
            Map<String, Object> baseServices = applicationReadyEvent.getApplicationContext().getBeansWithAnnotation(BaseService.class);
            for(Object service : baseServices.values()) {
                logger.debug(">>>>> {}.initDaoMapper()", service.getClass().getName());
                try {
                    Method initDaoMapper = service.getClass().getMethod("initDaoMapper");
					initDaoMapper.invoke(service);
                } catch (Exception e) {
                    logger.error("初始化BaseService的initDaoMapper方法异常", e);
                    e.printStackTrace();
                }
            }

            // 系统入口初始化
            Map<String, BaseInterface> baseInterfaceBeans = applicationReadyEvent.getApplicationContext().getBeansOfType(BaseInterface.class);
            for(Object service : baseInterfaceBeans.values()) {
                logger.debug(">>>>> {}.init()", service.getClass().getName());
                try {
                    Method init = service.getClass().getMethod("init");
                    init.invoke(service);
                } catch (Exception e) {
                    logger.error("初始化BaseInterface的init方法异常", e);
                    e.printStackTrace();
                }
            }

        }
    }
}
