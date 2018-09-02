package com.jvbo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @ClassName:
 * @Description: TODO
 * @author: jvbo
 * @date: 2018/7/25
 */
@Component
public class ScheduleUse {
	private static final Logger logger = LoggerFactory.getLogger(ScheduleUse.class);

	@Scheduled(initialDelay=5000, fixedDelay = 5000)
	public void kline(){
		logger.info("1111111");
	}
}
