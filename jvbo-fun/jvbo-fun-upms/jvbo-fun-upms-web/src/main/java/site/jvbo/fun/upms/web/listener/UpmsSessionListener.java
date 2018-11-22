package site.jvbo.fun.upms.web.listener;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.SessionListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @ClassName:
 * @Description: TODO
 * @author: jvbo
 * @date: 2018/10/26
 */
public class UpmsSessionListener implements SessionListener {
    private static final Logger logger = LoggerFactory.getLogger(UpmsSessionListener.class);

    @Override
    public void onStart(Session session) {
		logger.debug("会话创建：" + session.getId());
    }

    @Override
    public void onStop(Session session) {
		logger.debug("会话停止：" + session.getId());
    }

    @Override
    public void onExpiration(Session session) {
		logger.debug("会话过期：" + session.getId());
    }

}
