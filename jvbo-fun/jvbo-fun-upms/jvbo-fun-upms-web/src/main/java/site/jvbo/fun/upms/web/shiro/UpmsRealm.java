package site.jvbo.fun.upms.web.shiro;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

/**
 * @ClassName:
 * @Description: TODO
 * @author: jvbo
 * @date: 2018/9/12
 */
public class UpmsRealm extends AuthorizingRealm {

	@Autowired
	private ShiroSessionDao shiroSessionDao;

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
		UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
		String username = token.getUsername();
		String password = shiroSessionDao.getPasswordByUsername(username);
		return new SimpleAuthenticationInfo(username, password, getName());
	}

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
		String username = (String) super.getAvailablePrincipal(principalCollection);
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		Set<String> roles = shiroSessionDao.getRolesByUsername(username);
		authorizationInfo.setRoles(roles);
		roles.forEach(role -> {
			Set<String> permissions = shiroSessionDao.getPermissionsByRole(role);
			authorizationInfo.addStringPermissions(permissions);
		});
		return authorizationInfo;
	}
}
