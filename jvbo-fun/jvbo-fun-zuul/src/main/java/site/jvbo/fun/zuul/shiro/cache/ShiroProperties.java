package site.jvbo.fun.zuul.shiro.cache;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @ClassName:
 * @Description: TODO
 * @author: jvbo
 * @date: 2018/9/16
 */
@ConfigurationProperties(prefix = "jvbo.fun.zuul.auth")
public class ShiroProperties {

    private String tokenSecret;

    private Integer expiresDate;

    public String getTokenSecret() {
        return tokenSecret;
    }

    public void setTokenSecret(String tokenSecret) {
        this.tokenSecret = tokenSecret;
    }

    public Integer getExpiresDate() {
        return expiresDate;
    }

    public void setExpiresDate(Integer expiresDate) {
        this.expiresDate = expiresDate;
    }
}
