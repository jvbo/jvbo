package com.jvbo.common.study.javase.jvm.classloader.app;

/**
 * @ClassName:
 * @Description: TODO
 * @author: jvbo
 * @date: 2018/12/21
 */
public class ClassLoaderTest {

	public static void main(String[] args) throws ClassNotFoundException {
		//printClassLoader();
		loadClass();
	}

	private static void printClassLoader(){
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		System.out.println(loader);
		System.out.println(loader.getParent());
		System.out.println(loader.getParent().getParent());
	}

	private static void loadClass() throws ClassNotFoundException {
		ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
		System.out.println(classLoader);

		// 使用ClassLoader.loaderClass()来加载,不会执行初始化块;
		classLoader.loadClass("com.jvbo.common.study.javase.jvm.classloader.myself.LoaderDemo");

		// 使用Class.forName()来加载类,默认会执行初始化块
		//Class.forName("com.jvbo.common.study.javase.jvm.classloader.myself.LoaderDemo");

		// 使用Class.forName()来加载类,并指定ClassLoader,初始化时不执行静态块;
		//Class.forName("com.jvbo.common.study.javase.jvm.classloader.myself.LoaderDemo", false, classLoader);

	}
}
