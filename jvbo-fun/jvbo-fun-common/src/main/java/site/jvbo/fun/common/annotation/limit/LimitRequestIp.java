package site.jvbo.fun.common.annotation.limit;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

import java.lang.annotation.*;

/**
 * @ClassName:
 * @Description: TODO
 * @author: jvbo
 * @date: 2018/5/29
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
@Order(Ordered.HIGHEST_PRECEDENCE)
public @interface LimitRequestIp {

	/**
	 * 某ip时间段内可以访问次数
	 * @return
	 */
	int limitCount() default 300;

	/**
	 * 某ip时间段内可以访问次数
	 * @return
	 */
	int timeSecond() default 600;
}
