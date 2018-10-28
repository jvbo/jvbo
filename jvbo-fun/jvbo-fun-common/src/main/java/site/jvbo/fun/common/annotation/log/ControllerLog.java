/*
 * ControllerLog.java 2016年4月21日
 * Copyright (c) 2015-2018, Jv Bo (programmer_jv_bo@163.com).
 */
package site.jvbo.fun.common.annotation.log;

import java.lang.annotation.*;

@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ControllerLog {
    
    /**
     * 日志操作的描述
     * @Description: TODO
     * @param @return   
     * @return String  
     * @throws
     * @author jvbo
     * @date 2016年4月21日
     */
    String value()  default "";
}
