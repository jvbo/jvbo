package site.jvbo.fun.zuul.shiro.mgt;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * @ClassName:
 * @Description: TODO
 * @author: jvbo
 * @date: 2018/9/16
 */
public class AuthToken implements AuthenticationToken {

    private String userId;
	private String username;
	private String loginName;
	private String password;
	private String systemId;

	public AuthToken(String loginName, String password) {
        this.loginName = loginName;
        this.password = password;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

	public String getSystemId() {
		return systemId;
	}

	public void setSystemId(String systemId) {
		this.systemId = systemId;
	}

    @Override
    public Object getPrincipal() {
        return username;
    }

    @Override
    public Object getCredentials() {
        return null;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public String getLoginName() {
        return loginName;
    }

    public String getPassword() {
        return password;
    }

}