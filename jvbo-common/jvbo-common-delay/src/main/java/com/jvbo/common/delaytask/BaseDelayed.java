package com.jvbo.common.delaytask;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class BaseDelayed implements Delayed {
	
	private String value;

	private long startTime;  
	
	public BaseDelayed(){ }
	
	public BaseDelayed(String value,long timeout){
		this.value = value;
		this.startTime = System.currentTimeMillis() + timeout;  
	}

	public long getStartTime() {
		return startTime;
	}
	
	public String getValue(){
		return this.value;
	}

	@Override
	public long getDelay(TimeUnit unit) {
		return unit.convert(this.getStartTime() - System.currentTimeMillis(), TimeUnit.MILLISECONDS);  
	}

	@Override
	public int compareTo(Delayed other) {
		if (other == this){  
            return 0;  
        }  
        if(other instanceof BaseDelayed){  
        	BaseDelayed otherRequest = (BaseDelayed)other;  
            return (int)(this.getStartTime() - otherRequest.getStartTime());  
        }  
        return 0;  
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (startTime ^ (startTime >>> 32));
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BaseDelayed other = (BaseDelayed) obj;
		if (startTime != other.startTime)
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "BaseDelayed [startTime=" + startTime + ", value="+getValue()+"]";
	}

}
