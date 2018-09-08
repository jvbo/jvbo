package site.jvbo.fun.common.annotation.version;

import java.lang.annotation.*;

/**
 * @ClassName:
 * @Description: TODO
 * @author: jvbo
 * @date: 2018/7/30
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ApiVersion {

	String value() default "";

}