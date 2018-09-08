package site.jvbo.fun.common.exception;

import site.jvbo.fun.common.enums.ResponseCodeEnum;

/**
 * @ClassName:
 * @Description: TODO
 * @author: jvbo
 * @date: 2018/5/29
 */
public class LimitIPRequestException extends RuntimeException  {

	private static final long serialVersionUID = 1L;

	private String code;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public LimitIPRequestException(String code, String message, Throwable cause) {
		super(message, cause);
		this.code = code;
	}

	public LimitIPRequestException(String message) {
		this(ResponseCodeEnum.TOO_MANY_REQUESTS.getCode(), message, null);
	}

	public LimitIPRequestException(String code, String message) {
		this(code, message, null);
	}

	public LimitIPRequestException(String message, Throwable cause) {
		this(ResponseCodeEnum.TOO_MANY_REQUESTS.getCode(), message, cause);
	}

	public LimitIPRequestException(Throwable cause) {
		this(ResponseCodeEnum.TOO_MANY_REQUESTS.getCode(), "", cause);
	}
}
