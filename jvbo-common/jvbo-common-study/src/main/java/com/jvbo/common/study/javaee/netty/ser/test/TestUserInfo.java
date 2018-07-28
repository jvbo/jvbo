package com.jvbo.common.study.javaee.netty.ser.test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.ByteBuffer;
import java.time.Instant;

/**
 * @ClassName:
 * @Description: TODO
 * @author: jvbo
 * @date: 2018/7/27
 */
public class TestUserInfo {

	// 码流大小测试
	/*public static void main(String[] args) throws IOException {
		UserInfo info = new UserInfo();
		info.buildUserID(100).buildUserName("welcome to netty");
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ObjectOutputStream os = new ObjectOutputStream(bos);
		os.writeObject(info);
		os.flush();
		os.close();
		byte[] b = bos.toByteArray();
		System.out.println("the jdk serializable length is : " + b.length);
		bos.close();
		System.out.println("----------------------------------------");
		System.out.println("the byte array serializable length is : " + info.codeC().length);
	}*/

	// 编码性能测试
	public static void main(String[] args) throws IOException {
		UserInfo info = new UserInfo();
		info.buildUserID(100).buildUserName("welcome to netty");
		int loop = 1000000;
		ByteArrayOutputStream bos = null;
		ObjectOutputStream os = null;
		long startTime = Instant.now().toEpochMilli();
		for (int i = 0; i < loop; i++) {
			bos = new ByteArrayOutputStream();
			os = new ObjectOutputStream(bos);
			os.writeObject(info);
			os.flush();
			os.close();
			byte[] b = bos.toByteArray();
			bos.close();
		}
		long endTime = Instant.now().toEpochMilli();
		System.out.println("the jdk serializable cose time is : " + (endTime - startTime) + "ms");
		System.out.println("----------------------------------------");

		ByteBuffer buffer = ByteBuffer.allocate(1024);
		startTime = Instant.now().toEpochMilli();
		for (int i = 0; i < loop; i++) {
			byte[] b = info.codeC(buffer);
		}
		endTime = Instant.now().toEpochMilli();
		System.out.println("the jdk serializable cose time is : " + (endTime - startTime) + "ms");
	}
}
