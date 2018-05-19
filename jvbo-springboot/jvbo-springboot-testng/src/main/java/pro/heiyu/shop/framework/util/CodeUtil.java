package pro.heiyu.shop.framework.util;

import java.util.Date;
import java.util.Random;
import java.util.UUID;

import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;

public class CodeUtil {

	/**
	 * 生成数字验证码
	 * 
	 * @param length
	 * @return
	 */
	public static String genCode(int length) {
		StringBuilder code = new StringBuilder();

		for (int i = 0; i < length; i++) {
			code.append(RandomUtils.nextInt(0, 10));
		}
		return code.toString();
	}
	
	/**
	 * yyyyMMddHHmmssSSS时间开头的 32 位 int Id
	 * @return
	 */
	public static String genIntId32() {
		StringBuilder id = new StringBuilder();
		
		id.append(DateFormatUtils.format(new Date(), "yyyyMMddHHmmssSSS"));
		id.append(genCode(15));
		
		return id.toString();
	}
	
	/**
     * 生成 32 位 uuid
     * @return
     */
	public static String genUUID32() {
        return UUID.randomUUID().toString().replace("-", "");
    }
	
	/**
	 * 使用uuid生成令牌
	 * @return
	 */
	public static String token() {
		return UUID.randomUUID().toString().replace("-", "");
	}




	/** 自定义进制(0,1没有加入,容易与o,l混淆) */
	private static final char[] r=new char[]{'F', 'L', 'G', 'W', '5', 'X', 'C', '3', '9', 'Z', 'M', '6', '7', 'Y', 'R', 'T', '2', 'H', 'S', '8', 'D', 'V', 'E', 'J', '4', 'K', 'Q', 'P', 'U', 'A', 'N', 'B'};

	/** 定义一个字符用来补全邀请码长度（该字符前面是计算出来的邀请码，后面是用来补全用的） */
	private static final char b='a';

	/** 进制长度 */
	private static final int binLen=r.length;

	/** 邀请码长度 */
	private static final int s=6;

	/**
	 * 根据ID生成随机码
	 * @param id ID
	 * @return 随机码
	 */
	public static String toSerialCode(long id) {
		char[] buf=new char[32];
		int charPos=32;
		while((id / binLen) > 0) {
			int ind=(int)(id % binLen);
			buf[--charPos]=r[ind];
			id /= binLen;
		}
		buf[--charPos]=r[(int)(id % binLen)];
		String str=new String(buf, charPos, (32 - charPos));
		// 不够长度的自动随机补全
		if(str.length() < s) {
			StringBuilder sb=new StringBuilder();
			sb.append(b);
			Random rnd=new Random();
			for(int i=1; i < s - str.length(); i++) {
				sb.append(r[rnd.nextInt(binLen)]);
			}
			str+=sb.toString();
		}
		return str;
	}

	/**
	 * 根据随机码生成ID
	 * @param code
	 * @return
	 */
	public static long codeToId(String code) {
		char chs[]=code.toCharArray();
		long res=0L;
		for(int i=0; i < chs.length; i++) {
			int ind=0;
			for(int j=0; j < binLen; j++) {
				if(chs[i] == r[j]) {
					ind=j;
					break;
				}
			}
			if(chs[i] == b) {
				break;
			}
			if(i > 0) {
				res=res * binLen + ind;
			} else {
				res=ind;
			}
		}
		return res;
	}

	public static String repacePhoneMiddle(String phoneNo){
		String before = StringUtils.substring(phoneNo, 0, 3);
		String after = StringUtils.substring(phoneNo, phoneNo.length() - 4, phoneNo.length());
		return new StringBuilder(before).append("****").append(after).toString();
	}

	public static void main(String[] args) {
		System.out.println(toSerialCode(1));
		System.out.println(codeToId(toSerialCode(1)));
		System.out.println(repacePhoneMiddle("15665407656"));
	}
}
