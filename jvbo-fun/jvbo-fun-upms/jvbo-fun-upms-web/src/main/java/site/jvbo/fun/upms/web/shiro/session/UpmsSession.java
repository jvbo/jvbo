package site.jvbo.fun.upms.web.shiro.session;

import org.apache.shiro.session.mgt.SimpleSession;

/**
 * @ClassName:
 * @Description: TODO
 * @author: jvbo
 * @date: 2018/10/26
 */
public class UpmsSession extends SimpleSession {

	public enum OnlineStatus {
		/**
		 * 在线
		 */
		ON_LINE("在线"),

		/**
		 * 离线
		 */
		OFF_LINE("离线"),

		/**
		 * 强制退出
		 */
		FORCE_LOGOUT("强制退出");

		private final String info;

		OnlineStatus(String info) {
			this.info = info;
		}

		public String getInfo() {
			return info;
		}
	}

	private String userAgent;

	private OnlineStatus status = OnlineStatus.OFF_LINE;

	public String getUserAgent() {
		return userAgent;
	}

	public void setUserAgent(String userAgent) {
		this.userAgent = userAgent;
	}

	public OnlineStatus getStatus() {
		return status;
	}

	public void setStatus(OnlineStatus status) {
		this.status = status;
	}
}
