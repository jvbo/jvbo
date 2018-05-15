package com.jvbo.springcloud.eureka.hystrix;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

public class HystrixUserBs {
    /**
     * dubbo通过serviceMock的方式实现服务降级
     */
    
    private static final Logger logger = LoggerFactory.getLogger(HystrixUserBs.class);
    
    @Autowired
    private RestTemplate restTemplate;
    
    @HystrixCommand(fallbackMethod = "demotion")
    public String rmiOrder(){
        // TODO 依赖隔离时,semaphorn不能设置超时和实现异步访问,服务高可靠时使用
        String url = "http://jvbo-springcloud-eureka-client-order/order/findAll";
        logger.info("url:{}", url);
        return restTemplate.getForObject(url, String.class);
    }
    
    public String demotion(){
        // TODO 降级业务逻辑
        /**
         * 1. 快照时间窗:
         *  断路器确定是否打开需要统计一些请求和错误数据,
         *  而统计的时间范围就是快照时间窗,默认为最近的10秒;
         * 2. 请求总数下限:在快照时间窗内,必须满足请求总数下限才有资格根据熔断;
         *  默认为20,意味着在10秒内,如果该hystrix命令的调用此时不足20次,
         *  即时所有的请求都超时或其他原因失败,断路器都不会打开;
         * 3. 错误百分比下限:
         *  当请求总数在快照时间窗内超过了下限,比如发生了30次调用,
         *  如果在这30次调用中,有16次发生了超时异常,也就是超过50%的错误百分比,
         *  在默认设定50%下限情况下,这时候就会将断路器打开;
         */
        return "fallback";
    }
}
