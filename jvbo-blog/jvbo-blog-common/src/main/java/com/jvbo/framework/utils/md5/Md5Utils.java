/*
 * Md5Utils.java 2016年10月17日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
/**  
 * @Title: Md5Utils.java
 * @Package com.jvbo.framework.utils.md5
 * @Description: TODO
 * @author jvbo
 * @date 2016年10月17日
 */
package com.jvbo.framework.utils.md5;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.DigestException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import com.jvbo.framework.utils.hex.HexUtils;

/**  
 * @ClassName: Md5Utils 
 * @Description: TODO
 * @author jvbo
 * @date 2016年10月17日
 */
public class Md5Utils {
	
	private Md5Utils() { }

    /**
     * 
    * Description:MD5实例
    * author: jason
    * @param @return 设定文件 
    * @return  MessageDigest 返回类型 
    * @throws
     */
    static MessageDigest getDigest() {
        try {
            return MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 
    * Description:把byte数组进行MD5加密，并返回byte数组
    * author: jason
    * @param @param data
    * @param @return 设定文件 
    * @return  byte[] 返回类型 
    * @throws
     */
    public static byte[] md5(byte[] data) {
        return getDigest().digest(data);
    }

    /**
     * 
    * Description:字符串进行MD5加密，并返回byte数组
    * author: jason
    * @param @param data
    * @param @return 设定文件 
    * @return  byte[] 返回类型 
    * @throws
     */
    public static byte[] md5(String data) {
        return md5(data.getBytes());
    }

    /**
     * 
    * Description:byte数组进行加密，并返回16进制串
    * author: jason
    * @param @param data
    * @param @return 设定文件 
    * @return  String 返回类型 
    * @throws
     */
    public static String md5Hex(byte[] data) {
        return HexUtils.toHexString(md5(data));
    }

    /**
     * 
    * Description:字符串进行加密，并返回16进制串
    * author: jason
    * @param @param data
    * @param @return 设定文件 
    * @return  String 返回类型 
    * @throws
     */
    public static String md5Hex(String data) {
        return HexUtils.toHexString(md5(data));
    }
    
 
    /**
     * Title: getFileMD5
     * Description: 获取文件MD5
     * Created On: 2014-3-20 上午9:40:48
     * @author lfg 
     * @param filePath
     * @return
     * @throws NoSuchAlgorithmException
     * @throws IOException
     * @throws DigestException 
     */
    public static String getFileMD5(String filePath) throws NoSuchAlgorithmException, IOException, DigestException{
        MessageDigest md=MessageDigest.getInstance("MD5");
        int length=0;
        byte[] buffer=new byte[1024];
        byte[] array=null;
        InputStream is=new FileInputStream(new File(filePath));
        while((length=is.read(buffer))!=-1){
            md.update(buffer,0,length);
        }
        array=md.digest();
        is.close();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < array.length; ++i) {
              sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1,3));
        }
         
        return sb.toString();
    }
	
	public static void main(String[] args) {
		String password="123456";
		System.out.println("Md5加密："+Md5Utils.md5Hex(password));
	}
}
