package site.jvbo.fun.upms.web.shiro;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import site.jvbo.fun.common.enums.PublicEnum;
import site.jvbo.fun.upms.dao.model.UpmsUser;
import site.jvbo.fun.upms.web.shiro.service.ShiroApiManager;

import java.util.Set;

/**
 * @ClassName:
 * @Description: TODO
 * @author: jvbo
 * @date: 2018/10/19
 */
public class UpmsRealm extends AuthorizingRealm {

	@Autowired
	private ShiroApiManager shiroApiManager;

	/**
	 * 认证
	 * @param authenticationToken
	 * @return
	 * @throws AuthenticationException
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
		// 调用doGetAuthenticationInfo()这里使用redis进行计数登录次数,调用一次,计数一次;
		// 例如一小时最多重试5次,进行账户的锁定,防止暴力破解
		UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
		String username = token.getUsername();
		String password = new String(token.getPassword());

		UpmsUser upmsUser = shiroApiManager.getUserByUsername(username);
		if (null == upmsUser) {
			throw new UnknownAccountException("用户不存在");
		}
		if (upmsUser.getIsLocked().intValue() == PublicEnum.TRUE.getCodeInt().intValue()) {
			throw new LockedAccountException("用户被锁定");
		}
		return new SimpleAuthenticationInfo(username, password, getName());
	}

	/**
	 * 授权
	 * @param principalCollection
	 * @return
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
		//String username = (String) super.getAvailablePrincipal(principalCollection);
		String username = (String) principalCollection.getPrimaryPrincipal();

		UpmsUser upmsUser = shiroApiManager.getUserByUsername(username);

		Long userId = upmsUser.getUserId();
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();

		Set<String> roles = shiroApiManager.getRolesByUserId(userId);
		authorizationInfo.setRoles(roles);
		roles.forEach(role -> {
			Set<String> permissions = shiroApiManager.getPermissionsByUserId(userId);
			authorizationInfo.addStringPermissions(permissions);
		});
		return authorizationInfo;
	}

	public static void main(String[] args) {
		String hashAlgorithName = "md5";
		String originPassword = "admin";
		int hashIterations = 1024;//加密次数
		/*RandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();
		String salt = randomNumberGenerator.nextBytes().toHex();*/
		String salt = "66f1b370c660445a8657bf8bf1794486";
		System.out.println("salt: " + salt);

		ByteSource credentialsSalt = ByteSource.Util.bytes(salt);
		String password = new SimpleHash(hashAlgorithName, originPassword, credentialsSalt, hashIterations).toHex();
		System.out.println("password: " + password);
	}
}
