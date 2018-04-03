package com.jvbo.springboot.template.admin.core.util.exception;

import com.jvbo.springboot.template.admin.core.util.controller.Response;

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

    public Response.Status getStatus() {
        return status;
    }

}
