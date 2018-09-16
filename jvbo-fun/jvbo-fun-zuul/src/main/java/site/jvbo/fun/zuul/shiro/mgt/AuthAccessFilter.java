package site.jvbo.fun.zuul.shiro.mgt;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.shiro.web.filter.AccessControlFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName:
 * @Description: TODO
 * @author: jvbo
 * @date: 2018/9/16
 */
public class AuthAccessFilter extends AccessControlFilter {

    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
    	// TODO
        return true;
    }


    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
    	// TODO
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        httpResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        httpResponse.setHeader("Content-type", "text/html;charset=UTF-8");
        httpResponse.setCharacterEncoding("UTF-8");

		JSONObject responseObject = new JSONObject();
        httpResponse.getWriter().write(JSON.toJSONString(responseObject));
        return false;
    }
}