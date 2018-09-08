package site.jvbo.fun.common.util;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName:
 * @Description: TODO
 * @author: jvbo
 * @date: 2018/5/21
 */
public class IpUtil {
	public static String findIpAddr(HttpServletRequest request){
		String ip = request.getHeader("X-Forwarded-For");
		if(StringUtils.isNotBlank(ip)){
			int index = ip.indexOf(",");
			if(index != -1){
				return ip.substring(0, index);
			}else{
				return ip;
			}
		}
		return request.getRemoteAddr();
	}
}
