/*
 * HexUtil.java 2016年10月17日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
/**  
 * @Title: HexUtil.java
 * @Package com.jvbo.framework.utils.hex
 * @Description: TODO
 * @author jvbo
 * @date 2016年10月17日
 */
package com.jvbo.framework.utils.hex;

/**  
 * @ClassName: HexUtil 
 * @Description: 16进制工具类
 * @author jvbo
 * @date 2016年10月17日
 */
public class HexUtils {
	
	private HexUtils() {}

    /**
     * 
    * Description:byte数组转换16进制字符串
    * author: jason
    * @param @param b
    * @param @return 设定文件 
    * @return  String 返回类型 
    * @throws
     */
    public static String toHexString(byte[] b) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < b.length; i++) {
            sb.append(HexUtils.HEX_CHARS.charAt(b[i] >>> 4 & 0x0F));
            sb.append(HexUtils.HEX_CHARS.charAt(b[i] & 0x0F));
        }
        return sb.toString();
    }

    /**
     * 
    * Description:16进制字符串转换byte数组
    * author: jason
    * @param @param s
    * @param @return 设定文件 
    * @return  byte[] 返回类型 
    * @throws
     */
    public static byte[] toByteArray(String s) {
        byte[] buf = new byte[s.length() / 2];
        int j = 0;
        for (int i = 0; i < buf.length; i++) {
            buf[i] = (byte) ((Character.digit(s.charAt(j++), 16) << 4) | Character
                    .digit(s.charAt(j++), 16));
        }
        return buf;
    }

    private static final String HEX_CHARS = "0123456789abcdef";
}
