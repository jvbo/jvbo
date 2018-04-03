package com.jvbo.framework.utils.file;

import java.io.File;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class GenerateDirAndFileName {

	Log log = LogFactory.getLog(this.getClass());
	
	/** 
	 * 为上传文件自动分配文件名称
	 */
	public String generateFileName(String filename) {
		// 获取当前时间
		DateFormat format = new SimpleDateFormat("yyMMddHHmmss");
		// 转换为字符串
		String formatDate = format.format(new Date());
		// 随机生成编号
		int random = new Random().nextInt(10000);
		// 获得文件后缀名称
		int position = filename.lastIndexOf(".");
		String extendsion = filename.substring(position);
		// 返回一个新名称
		return formatDate + random + extendsion;
	}
	
	/** 
	 * 根据相应的目录，判断是否存在目录，并生成
	 */
	public String createDir(String dir){
		  if(dir == null) return null;
		try{
			String[] dirs = dir.split("\\\\");
			String path = "";
			for(int i=0;i<dirs.length;i++){
			  if(dirs[i].length()>0){	
				if(i!=0){
					path += "\\";
				} 
				path+=dirs[i];
				File fileDir = new File(path);
				if(!fileDir.exists()){
					if(fileDir.mkdir()){
						log.info(" create dir sucess ,has created dir :"+path);
					}else{
						log.debug(" create dir "+path+" error,please check your authro");
					}
				}
			  }
			}
			return dir;
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	public String getIpAddr(HttpServletRequest request) throws UnknownHostException {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }

        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip=InetAddress.getLocalHost().getHostAddress();
        }
        if (ip != null && ip.contains(",")) {
            log.info("servlet process from client host contain proxy :" + ip);
            ip = ip.substring(0, ip.indexOf(","));
        }
        return ip;
    }
}
