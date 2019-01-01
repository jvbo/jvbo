/*
 * JvboClassLoader.java 2017年10月17日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.common.study.javase.jvm.classloader.myself;

import java.io.*;

public class JvboClassLoader extends ClassLoader{
	private String root;

	protected Class<?> findClass(String name) throws ClassNotFoundException {
		byte[] classData = loadClassData(name);
		if (classData == null) {
			throw new ClassNotFoundException();
		} else {
			return defineClass(name, classData, 0, classData.length);
		}
	}

	private byte[] loadClassData(String className) {
		String fileName = root + File.separatorChar
				+ className.replace('.', File.separatorChar) + ".class";
		try {
			InputStream ins = new FileInputStream(fileName);
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			int bufferSize = 1024;
			byte[] buffer = new byte[bufferSize];
			int length = 0;
			while ((length = ins.read(buffer)) != -1) {
				baos.write(buffer, 0, length);
			}
			return baos.toByteArray();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public String getRoot() {
		return root;
	}

	public void setRoot(String root) {
		this.root = root;
	}

	public static void main(String[] args)  {

		JvboClassLoader classLoader = new JvboClassLoader();
		classLoader.setRoot("E:\\temp");

		Class<?> testClass = null;
		try {
			testClass = classLoader.loadClass("com.jvbo.common.study.javase.jvm.classloader.myself.LoaderDemo");
			Object object = testClass.newInstance();
			System.out.println(object.getClass().getClassLoader());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}
}
