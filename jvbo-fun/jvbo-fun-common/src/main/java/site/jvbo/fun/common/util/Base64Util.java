package site.jvbo.fun.common.util;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.StringUtils;

public class Base64Util {
    
	/**
	 * 加密
	 * @param s
	 * @return
	 */
	public static String encodeString(String s) {
		if (s == null) {
			return null;
		}
		return Base64.encodeBase64String(s.getBytes());
	}
	
	/**
     * 加密
     * @param b
     * @return
     */
    public static byte[] encodeByte(byte[] b) {
        if (b == null) {
            return null;
        }
        return Base64.encodeBase64(b);
    }

	/**
	 * 解密
	 * @param s
	 * @return
	 */
	public static String decodeString(String s) {
		if (s == null){
			return null;
		}
		return StringUtils.newStringUtf8(Base64.decodeBase64(s));
	}
    
    /**
     * 解密
     * @param b
     * @return
     */
    public static byte[] decodeByte(byte[] b) {
        if (b == null) {
            return null;
        }
        return Base64.decodeBase64(b);
    }

	public static void main(String[] args) {
        System.out.println(encodeString("111111"));
		System.out.println(decodeString(encodeString("111111")));
	}

}
