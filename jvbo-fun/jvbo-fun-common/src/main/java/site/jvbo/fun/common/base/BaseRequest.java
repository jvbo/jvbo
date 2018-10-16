package site.jvbo.fun.common.base;

/**
 * @ClassName:
 * @Description: TODO
 * @author: jvbo
 * @date: 2018/10/16
 */
public class BaseRequest {

	/**
	 * 时间戳
	 */
	private Long timestamp;

	/**
	 * Token
	 */
	private String token;

	/**
	 * 通道
	 */
	private String channel;

	public BaseRequest(Long timestamp, String token, String channel) {
		this.timestamp = timestamp;
		this.token = token;
		this.channel = channel;
	}

	public Long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}
}
