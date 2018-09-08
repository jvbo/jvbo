package site.jvbo.fun.common.util;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import site.jvbo.fun.common.enums.EnCodingEnum;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Map;

public class SignUtil {
	
	private static final Logger logger = LoggerFactory.getLogger(SignUtil.class);

	private SignUtil() {

	}

	/**
	 * 校验签名,签名方式为MD5,签名内容为所有参数拼接，例如：param1value1param2value2，最后拼接secret
	 * @param params
	 * @param secret
	 * @return
	 * @throws IOException
	 */
	public static boolean checkSign(Map<String, String[]> params, String secret) throws IOException {
		String sign = null;
		
		// 第一步：检查参数是否已经排序
		String[] keys = params.keySet().toArray(new String[0]);
		Arrays.sort(keys);

		// 第二步：把所有参数名和参数值串在一起
		StringBuilder query = new StringBuilder();
		for (String key : keys) {
			String[] values = params.get(key);
			if (StringUtils.isNotBlank(key)) {
				if(StringUtils.equals("sign", key)) {
					sign = values[0];
				} else {
					for(String value : values) {
						query.append(key).append(StringUtils.trimToEmpty(value));
					}
				}
			}
		}
		
		query.append(secret);

		// 第三步：使用MD5摘要
		byte[] bytes = encryptMD5(query.toString());
		String serverSign = byte2hex(bytes);

		// 第四步：把二进制转化为大写的十六进制
		logger.debug("服务器签名:{},客户端签名:{},签名字符串:{}",serverSign,sign,query);
		return StringUtils.equals(serverSign, sign);
	}

	/**
	 * 对字符串采用UTF-8编码后，用HmacSHA256进行摘要。
	 * @param data
	 * @param secret
	 * @return
	 * @throws IOException
	 */
	@SuppressWarnings("unused")
	private static byte[] encryptHMACSHA256(String data, String secret) throws IOException {
		byte[] bytes = null;
		try {
			SecretKey secretKey = new SecretKeySpec(secret.getBytes(EnCodingEnum.UTF8.getCode()), "HmacSHA256");
			Mac mac = Mac.getInstance(secretKey.getAlgorithm());
			mac.init(secretKey);
			bytes = mac.doFinal(data.getBytes(EnCodingEnum.UTF8.getCode()));
		} catch (GeneralSecurityException gse) {
			throw new IOException(gse.toString());
		}
		return bytes;
	}

	/**
	 * 对字符串采用UTF-8编码后，用HmacMD5进行摘要。
	 * @param data
	 * @param secret
	 * @return
	 * @throws IOException
	 */
	@SuppressWarnings("unused")
	private static byte[] encryptHMAC(String data, String secret) throws IOException {
		byte[] bytes = null;
		try {
			SecretKey secretKey = new SecretKeySpec(secret.getBytes(EnCodingEnum.UTF8.getCode()), "HmacMD5");
			Mac mac = Mac.getInstance(secretKey.getAlgorithm());
			mac.init(secretKey);
			bytes = mac.doFinal(data.getBytes(EnCodingEnum.UTF8.getCode()));
		} catch (GeneralSecurityException gse) {
			throw new IOException(gse.toString());
		}
		return bytes;
	}

	/**
	 * 对字符串采用UTF-8编码后，用MD5进行摘要。
	 */
	public static byte[] encryptMD5(String data) throws IOException {
		return encryptMD5(data.getBytes(EnCodingEnum.UTF8.getCode()));
	}

	/**
	 * 对字节流进行MD5摘要。
	 */
	public static byte[] encryptMD5(byte[] data) throws IOException {
		byte[] bytes = null;
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			bytes = md.digest(data);
		} catch (GeneralSecurityException gse) {
			throw new IOException(gse.toString());
		}
		return bytes;
	}

	/**
	 * 把字节流转换为十六进制表示方式。
	 */
	public static String byte2hex(byte[] bytes) {
		StringBuilder sign = new StringBuilder();
		for (int i = 0; i < bytes.length; i++) {
			String hex = Integer.toHexString(bytes[i] & 0xFF);
			if (hex.length() == 1) {
				sign.append("0");
			}
			sign.append(hex.toUpperCase());
		}
		return sign.toString();
	}
}
