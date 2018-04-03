package com.jvbo.common.delaytask;

import java.util.concurrent.DelayQueue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DelayedService {
	
	private static Logger logger = LoggerFactory.getLogger(DelayedService.class);
	
    private boolean start;
    
    private Thread delayDaemonThread;
    
    public DelayQueue<BaseDelayed> delayQueue = new DelayQueue<BaseDelayed>();
      
    private OnDelayedListener listener;
    
    public static interface OnDelayedListener{
        public void onDelayedArrived(BaseDelayed baseDelayed);
    }
  
    public void start(OnDelayedListener listener){
    	if(start){
            return;
        }
        start = true;
        this.listener = listener;
        Runnable delayDaemon = new Runnable() {
        	@Override
            public void run() {
            	try{
                    while(true){
                    	BaseDelayed baseDelayed = delayQueue.take();
                    	logger.info("baseDelayed delayQueue.take()");
                        if(DelayedService.this.listener != null){
                        	DelayedService.this.listener.onDelayedArrived(baseDelayed);
                        }
                    }
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        };
        delayDaemonThread = new Thread(delayDaemon);
        delayDaemonThread.setDaemon(true);
        delayDaemonThread.setName("delay-daemon");
        delayDaemonThread.start();
        logger.info("DelayedService delay-daemon 启动...");
    }
      
    public void add(BaseDelayed baseDelayed){
    	logger.info("add(BaseDelayed baseDelayed)=============={}", baseDelayed.getValue());
        delayQueue.put(baseDelayed);
    }
    
    public void add(String orderId, long timeout){
    	logger.info("add(String orderId, long timeout)=============={}", orderId);
        delayQueue.put(new BaseDelayed(orderId, timeout));
    }

	public boolean remove(BaseDelayed baseDelayed){
		logger.info("remove(BaseDelayed baseDelayed)=============={}", baseDelayed.getValue());
		return delayQueue.remove(baseDelayed);
    }
	
	public void remove(String orderId){
		BaseDelayed[] array = delayQueue.toArray(new BaseDelayed[]{});
        if(array == null || array.length <= 0){
            return;
        }
        BaseDelayed target = null;
        for(BaseDelayed order : array){
            if(order.getValue() == orderId){
                target = order;
                break;
            }
        }
        if(target != null){
        	logger.info("remove(String orderId)=============={}", target);
            delayQueue.remove(target);
        }
    }
}
