package com.jvbo.common.base;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jvbo.common.base.DelayedService.OnDelayedListener;
import com.jvbo.common.base.DelayedService.OnStartListener;

public class DelayedServiceTest {
	
	private static Logger logger = LoggerFactory.getLogger(DelayedService.class);
	
	public static class DelayedOrder extends BaseDelayed<String>{
		public DelayedOrder(int timeout, String value) {
			super(timeout, value);
		}
		public String getValue(){
			return super.getValue();
		}
	}
	
	public static void main(String[] args) {
		DelayedService service = new DelayedService();
		service.start(new OnStartListener(){
			@Override
			public void onStart() {
				logger.info("启动完成");
			}
		}, 
		new OnDelayedListener(){
			@Override
			public <T extends BaseDelayed<?>> void onDelayedArrived(T delayed) {
				logger.info("[onDelayedArrived]"+delayed.toString());
			}
		});
		service.add(new DelayedOrder(60,"66666666"));
		service.add(new DelayedOrder(20,"2222222222"));
		service.add(new DelayedOrder(10,"1111111111"));
	}
}
