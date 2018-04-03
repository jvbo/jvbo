package com.jvbo.common.delaytask;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.time.DateUtils;

import com.jvbo.common.delaytask.DelayedService.OnDelayedListener;
import com.jvbo.common.util.thread.ThreadPoolUtil;

public class DelayedServiceTest {
	
	public static void main(String[] args) throws Exception {
		DelayedService service = new DelayedService();
		service.start(new OnDelayedListener(){
			@Override
			public void onDelayedArrived(BaseDelayed baseDelayed) {
				//删除
				service.remove(baseDelayed);
			}
		});
		
		List<ProRe> proReList = new ArrayList<ProRe>();
		ProRe proRe = null;
		for (int i = 0; i < 5; i++) {
			proRe = new ProRe("id"+i, 
					DateUtils.parseDate("2017-06-01 23:12:"+i+"0", "yyyy-MM-dd HH:mm:ss").getTime(), 
					DateUtils.parseDate("2017-06-01 23:14:"+i+"0", "yyyy-MM-dd HH:mm:ss").getTime());
			proReList.add(proRe);
		}
		
		for (ProRe proRes : proReList) {
			long timeout = proRes.getEndTime() - new Date().getTime();
			String id = proRes.getId();
			ThreadPoolUtil.execute(new Runnable(){  
	            public void run(){  
	            	BaseDelayed baseDelayed = new BaseDelayed(id, timeout);
	    			service.add(baseDelayed);
	            }  
	        });
		}
		
	}
}
