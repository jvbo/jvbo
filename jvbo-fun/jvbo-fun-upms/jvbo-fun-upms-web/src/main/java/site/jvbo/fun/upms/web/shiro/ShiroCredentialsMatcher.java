package site.jvbo.fun.upms.web.shiro;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import site.jvbo.fun.common.util.SpringUtils;
import site.jvbo.fun.upms.dao.model.UpmsUser;
import site.jvbo.fun.upms.web.shiro.service.ShiroApiManager;

/**
 * @ClassName:
 * @Description: TODO
 * @author: jvbo
 * @date: 2018/10/22
 */
public class ShiroCredentialsMatcher extends SimpleCredentialsMatcher {

	@Override
	public boolean doCredentialsMatch(AuthenticationToken authenticationToken, AuthenticationInfo authenticationInfo) {
		if(authenticationToken == null) {
			return false;
		}
		UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
		String username = token.getUsername();
		String inputPassword = new String(token.getPassword());

		ShiroApiManager shiroApiManager = SpringUtils.getBean(ShiroApiManager.class);
		UpmsUser upmsUser = shiroApiManager.getUserByUsername(username);
		String salt = upmsUser.getSalt();
		String dpPassword = upmsUser.getPassword();

		ByteSource credentialsSalt = ByteSource.Util.bytes(salt);
		String shiroEnctyptPassword = new SimpleHash("md5", inputPassword, credentialsSalt, 1024).toHex();
		return StringUtils.equals(dpPassword, shiroEnctyptPassword);
	}
}