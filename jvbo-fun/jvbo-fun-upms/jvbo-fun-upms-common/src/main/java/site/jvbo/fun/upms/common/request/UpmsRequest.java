package site.jvbo.fun.upms.common.request;

import site.jvbo.fun.common.base.BaseRequest;

public class UpmsRequest extends BaseRequest {
	public UpmsRequest(Long timestamp, String token, String channel) {
		super(timestamp, token, channel);
	}
}
