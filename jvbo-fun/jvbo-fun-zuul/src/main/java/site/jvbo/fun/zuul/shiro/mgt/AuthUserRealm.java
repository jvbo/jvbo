package site.jvbo.fun.zuul.shiro.mgt;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

/**
 * @ClassName:
 * @Description: TODO
 * @author: jvbo
 * @date: 2018/9/16
 */
public class AuthUserRealm extends AuthorizingRealm {

	public boolean supports(AuthenticationToken token) {
        // TODO
        return token instanceof AuthToken;
    }

    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
    	// TODO
        String username = (String) principals.getPrimaryPrincipal();
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        authorizationInfo.addRole("admin");
        return authorizationInfo;
    }


    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		// TODO
        return new SimpleAuthenticationInfo("", "", "");
    }

}
