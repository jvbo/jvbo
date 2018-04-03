/*
 * @(#) initServlet.java 2015年3月12日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.common.util.os;

import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import com.sun.management.OperatingSystemMXBean;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 系统环境相关
 * @Description: TODO
 * @author jv.bo
 * @version 1.0
 * @since 2015-3-12
 */
@SuppressWarnings("restriction")
public class ToolOS {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(ToolOS.class);

	public static final String java_version = "java.version"; // Java的运行环境版本
	public static final String java_vendo = "java.vendor"; // Java的运行环境供应商
	public static final String java_vendo_url = "java.vendor.url"; // Java供应商的URL
	public static final String java_home = "java.home"; // Java的安装路径
	public static final String java_vm_specification_version = "java.vm.specification.version"; // Java的虚拟机规范版本
	public static final String java_vm_specification_vendor = "java.vm.specification.vendor"; // Java的虚拟机规范供应商
	public static final String java_vm_specification_name = "java.vm.specification.name"; // Java的虚拟机规范名称
	public static final String java_vm_version = "java.vm.version"; // Java的虚拟机实现版本
	public static final String java_vm_vendor = "java.vm.vendor"; // Java的虚拟机实现供应商
	public static final String java_vm_name = "java.vm.name"; // Java的虚拟机实现名称
	public static final String java_specification_version = "java.specification.version"; // Java运行时环境规范版本
	public static final String java_specification_vender = "java.specification.vender"; // Java运行时环境规范供应商
	public static final String java_specification_name = "java.specification.name"; // Java运行时环境规范名称
	public static final String java_class_version = "java.class.version"; // Java的类格式版本
	public static final String java_class_path = "java.class.path"; // Java的类路径
	public static final String java_library_path = "java.library.path"; // 加载库时搜索的路径列表
	public static final String java_io_tmpdir = "java.io.tmpdir"; // 默认的临时文件
	public static final String java_ext_dirs = "java.ext.dirs"; // 一个或多个扩展目录的路径
	public static final String os_name = "os.name"; // 操作系统的名称
	public static final String os_arch = "os.arch"; // 操作系统的构成
	public static final String os_version = "os.version"; // 操作系统的版本
	public static final String file_separator = "file.separator"; // 文件分隔符
	public static final String path_separator = "path.separator"; // 路径分隔符
	public static final String line_separator = "line.separator"; // 行分隔符
	public static final String user_name = "user.name"; // 用户的账户名称
    public static final String user_home = "user.home"; // 用户的主目录
    public static final String user_dir = "user.dir"; //  用户的当前工作目录

	/**
	 * 系统bean
	 */
	private static final OperatingSystemMXBean osmxb;
	private static final List<GarbageCollectorMXBean> list;

	/**
	 * K转换M
	 */
	private static final long K2M = 1024l * 1024l;

	static {
		osmxb = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
		list = ManagementFactory.getGarbageCollectorMXBeans();
	}
	
	/**
	 * 获取java系统环境变量
	 * @Description: TODO
	 * @param @param key
	 * @param @return
	 * @return String
	 * @author jv.bo
	 * @version 1.0
	 * @since 2015-3-12
	 */
	public static String getOsSystemProperty(String key) {
		return System.getProperty(key);
	}

	/**
	 * 获取本机IP
	 * @Description: TODO
	 * @param @return
	 * @return String
	 * @author jv.bo
	 * @version 1.0
	 * @since 2015-3-12
	 */
	public static String getOsLocalHostIp() {
		InetAddress addr;
		String ip = null;
		try {
			addr = InetAddress.getLocalHost();
			ip = addr.getHostAddress();// 获得本机IP
		} catch (UnknownHostException e) {
			ip = "未知";
		}
		return ip;
	}

	/**
	 * 获取本机名称
	 * @Description: TODO
	 * @param @return
	 * @return String
	 * @author jv.bo
	 * @version 1.0
	 * @since 2015-3-12
	 */
	public static String getOsLocalHostName() {
		InetAddress addr;
		String name = null;
		try {
			addr = InetAddress.getLocalHost();
			name = addr.getHostName();// 获得本机名称
		} catch (UnknownHostException e) {
			name = "未知";
		}
		return name;
	}

	/**
	 * 获取操作系统路径类型
	 * @Description: TODO
	 * @param @return
	 * @return String
	 * @author jv.bo
	 * @version 1.0
	 * @since 2015-3-12
	 */
	public static String getOsPathType() {
		String osPathType = System.getProperty("file.separator");
		if (osPathType.equals("\\")) {
			return "\\\\";
		}
		if (osPathType.equals("/")) {
			return "/";
		}
		return null;
	}

	/**
	 * 获取操作系统类型名称
	 * @Description: TODO
	 * @param @return
	 * @return String
	 * @author jv.bo
	 * @version 1.0
	 * @since 2015-3-12
	 */
	public static String getOsName() {
		return osmxb.getName();// System.getProperty("os.name");
	}

	/**
	 * 操作系统的体系结构 x86
	 * @Description: TODO
	 * @param @return
	 * @return String
	 * @author jv.bo
	 * @version 1.0
	 * @since 2015-3-12
	 */
	public static String getOsArch() {
		return osmxb.getArch();// System.getProperty("os.arch");
	}

	/**
	 * 获取CPU数量
	 * @Description: TODO
	 * @param @return
	 * @return int
	 * @author jv.bo
	 * @version 1.0
	 * @since 2015-3-12
	 */
	public static int getOsCpuNumber() {
		return osmxb.getAvailableProcessors();// Runtime.getRuntime().availableProcessors();// 获取当前电脑CPU数量
	}
	
	/*public static double getOscpuRatio(){
		return osmxb.getSystemCpuLoad();
	}*/

	/**
	 * 物理内存，可使用，单位：M
	 * @return
	 */
	public static long getOsPhysicalMemory() {
		long totalMemorySize = osmxb.getTotalPhysicalMemorySize() / K2M; // M
		return totalMemorySize;
	}

	/**
	 * 物理内存，剩余，单位：M
	 * @return
	 */
	public static long getOsPhysicalFreeMemory() {
		long freePhysicalMemorySize = osmxb.getFreePhysicalMemorySize() / K2M; // M
		return freePhysicalMemorySize;
	}

	/**
	 * JVM内存，内存总量，单位：M
	 * @Description: TODO
	 * @param @return
	 * @return long
	 * @author jv.bo
	 * @version 1.0
	 * @since 2015-3-12
	 */
	public static long getJvmTotalMemory() {
		return Runtime.getRuntime().totalMemory() / K2M;
	}

	/**
	 * JVM内存，空闲内存量，单位：M
	 * @Description: TODO
	 * @param @return
	 * @return long
	 * @author jv.bo
	 * @version 1.0
	 * @since 2015-3-12
	 */
	public static long getJvmFreeMemory() {
		return Runtime.getRuntime().freeMemory() / K2M;
	}

	/**
	 * JVM内存，最大内存量，单位：M
	 * @Description: TODO
	 * @param @return
	 * @return long
	 * @author jv.bo
	 * @version 1.0
	 * @since 2015-3-12
	 */
	public static long getJvmMaxMemory() {
		return Runtime.getRuntime().maxMemory() / K2M;
	}

	/**
	 * 获取JVM GC次数
	 * @Description: TODO
	 * @param @return
	 * @return long
	 * @author jv.bo
	 * @version 1.0
	 * @since 2015-3-12
	 */
	public static long getJvmGcCount() {
		long count = 0;
		for (final GarbageCollectorMXBean garbageCollectorMXBean : list) {
			count += garbageCollectorMXBean.getCollectionCount();
		}
		return count;
	}

	/**
	 * 系统线程列表
	 * @Description: TODO
	 * @param @return
	 * @return List<Thread>
	 * @author jv.bo
	 * @version 1.0
	 * @since 2015-3-12
	 */
	public static List<Thread> getJvmThreads() {
		int activeCount = Thread.activeCount();
		Thread[] threads = new Thread[activeCount];
		Thread.enumerate(threads);
		return java.util.Arrays.asList(threads);
	}
}
