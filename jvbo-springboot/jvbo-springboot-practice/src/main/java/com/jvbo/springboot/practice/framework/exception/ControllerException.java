package com.jvbo.springboot.practice.framework.exception;

import com.jvbo.springboot.practice.framework.response.Response;
import com.jvbo.springboot.practice.framework.response.Response.Status;

public class ControllerException extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = -3614241293777645836L;
	
	private Response.Status status;

    public ControllerException(String message) {
        super(message);
    }

    public ControllerException(Response.Status status, String message) {
        super(message);
        this.status = status;
    }

    public Status getStatus() {
        return status;
    }

}
