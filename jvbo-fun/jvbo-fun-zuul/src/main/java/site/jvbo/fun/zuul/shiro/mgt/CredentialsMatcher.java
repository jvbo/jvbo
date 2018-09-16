package site.jvbo.fun.zuul.shiro.mgt;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

/**
 * @ClassName:
 * @Description: TODO
 * @author: jvbo
 * @date: 2018/9/16
 */
public class CredentialsMatcher extends SimpleCredentialsMatcher {

    @Override
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
    	// TODO
        if(token == null || info == null || info.getCredentials() == null) {
            return false;
        }
        AuthToken authToken = (AuthToken)token;
        String password = new SimpleHash("md5", authToken.getPassword(), ByteSource.Util.bytes(authToken.getLoginName())).toHex();
        return StringUtils.equals(password, info.getCredentials().toString());
    }

}