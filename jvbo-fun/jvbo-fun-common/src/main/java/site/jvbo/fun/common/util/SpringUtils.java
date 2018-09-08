package site.jvbo.fun.common.util;

import org.springframework.context.ApplicationContext;
import site.jvbo.fun.common.enums.ResponseCodeEnum;
import site.jvbo.fun.common.exception.BaseRuntimeException;

import java.util.Map;

/**
 * SpringUtils
 */
public class SpringUtils {

    private SpringUtils() {
    }

    private static ApplicationContext applicationContext = null;

    public static void setApplicationContext(ApplicationContext applicationContext) {
        if (SpringUtils.applicationContext == null) {
            SpringUtils.applicationContext = applicationContext;
        }
    }

    /***
     * 根据一个bean的id获取配置文件中相应的bean
     */
    public static <T> T getBean(String beanId, Class<T> requiredType) {
        return getBean(beanId, requiredType, false);
    }

    /***
     * 根据一个bean的id获取配置文件中相应的bean
     */
    public static <T> T getBean(String beanId, Class<T> requiredType, boolean throwIfNotContain) {
        if (applicationContext.containsBean(beanId)) {
            return applicationContext.getBean(beanId, requiredType);
        } else if (throwIfNotContain) {
            throw new BaseRuntimeException(ResponseCodeEnum.INTERNAL_SERVER_ERROR.getCode(), "不存在bean的配置:" + beanId);
        }
        return null;
    }

    /***
     * 根据一个bean的类型获取配置文件中相应的bean
     */
    public static <T> T getBeanByClass(Class<T> requiredType) {
        return applicationContext.getBean(requiredType);
    }

    /**
     * 如果BeanFactory包含一个与所给名称匹配的bean定义，则返回true
     */
    public static boolean containsBean(String name) {
        return applicationContext.containsBean(name);
    }
    
    /**
     * 根据名称获取bean
     * @param beanName
     * @return
     */
    public static Object getBean(String beanName) {
        return applicationContext.getBean(beanName);
    }

    /**
     * 根据类型获取bean
     * @param clazz
     * @return
     */
    public static <T> T getBean(Class<T> clazz) {
        T t = null;
        Map<String, T> map = applicationContext.getBeansOfType(clazz);
        for (Map.Entry<String, T> entry : map.entrySet()) {
            t = entry.getValue();
        }
        return t;
    }

    /**
     * 是否是单例
     * @param beanName
     * @return
     */
    public static boolean isSingleton(String beanName) {
        return applicationContext.isSingleton(beanName);
    }

    /**
     * bean的类型
     * @param beanName
     * @return
     */
    @SuppressWarnings("rawtypes")
    public static Class getType(String beanName) {
        return applicationContext.getType(beanName);
    }

    public static ApplicationContext getApplicationContext() {
        return SpringUtils.applicationContext;
    }
}
