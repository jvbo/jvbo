package com.jvbo.springboot.practice.framework.exception;

public class ControllerException extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = -3614241293777645836L;
	
	private String code;

    public ControllerException(String message) {
        super(message);
    }

    public ControllerException(String code, String message) {
        super(message);
        this.code= code;
    }

    public String getCode() {
        return code;
    }

}
