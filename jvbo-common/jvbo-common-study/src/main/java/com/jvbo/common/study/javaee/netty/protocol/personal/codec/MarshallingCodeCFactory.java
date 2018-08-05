package com.jvbo.common.study.javaee.netty.protocol.personal.codec;

import org.jboss.marshalling.*;

import java.io.IOException;

/**
 * @ClassName:
 * @Description: TODO
 * @author: jvbo
 * @date: 2018/8/2
 */
public class MarshallingCodeCFactory {


	/**
	 * 创建jboss marshalling编码对象
	 * @return
	 */
	public static Marshaller buildMarshalling() throws IOException {
		// 首先通过Marshalling工具类方法获取Marshalling实例对象, 参数serial标识创建的是java序列化工厂对象
		final MarshallerFactory marshallerFactory = Marshalling.getMarshallerFactory("serial");
		// 创建MarshallingConfiguration对象,配置版本号5
		final MarshallingConfiguration configuration = new MarshallingConfiguration();
		configuration.setVersion(5);
		Marshaller marshaller = marshallerFactory.createMarshaller(configuration);
		return marshaller;
	}

	/**
	 * 创建jboss unmarshalling解码对象
	 * @return
	 */
	public static Unmarshaller buildUnMarshalling() throws IOException {
		final MarshallerFactory marshallerFactory = Marshalling.getMarshallerFactory("serial");
		final MarshallingConfiguration configuration = new MarshallingConfiguration();
		configuration.setVersion(5);
		Unmarshaller unmarshaller = marshallerFactory.createUnmarshaller(configuration);
		return unmarshaller;
	}
}
