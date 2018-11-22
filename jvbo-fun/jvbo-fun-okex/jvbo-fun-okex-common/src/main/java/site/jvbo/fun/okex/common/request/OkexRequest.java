package site.jvbo.fun.okex.common.request;

import site.jvbo.fun.common.base.BaseRequest;

public class OkexRequest extends BaseRequest{
	public OkexRequest(Long timestamp, String token, String channel) {
		super(timestamp, token, channel);
	}
}
