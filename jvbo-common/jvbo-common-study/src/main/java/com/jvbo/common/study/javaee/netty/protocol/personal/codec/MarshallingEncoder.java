package com.jvbo.common.study.javaee.netty.protocol.personal.codec;

import io.netty.buffer.ByteBuf;
import org.jboss.marshalling.Marshaller;

import java.io.IOException;

/**
 * @ClassName:
 * @Description: TODO
 * @author: jvbo
 * @date: 2018/8/1
 */
public class MarshallingEncoder {

	//空白占位:用于预留设置body的数据包长度
	private static final byte[] LENGTH_PLACEHOLDER = new byte[4];
	private Marshaller marshaller;

	public MarshallingEncoder() throws IOException {
		this.marshaller = MarshallingCodeCFactory.buildMarshalling();
	}

	protected void encode(Object msg, ByteBuf out) throws IOException {
		try {
			// 必须要知道当前的数据位置是哪:起始数据位置
			int lengthPos = out.writerIndex();
			// 占位写操作:先写一个4字节的空的内容,记录在起始数据位置,用于设置内容长度
			out.writeBytes(LENGTH_PLACEHOLDER);
			ChannelBufferByteOutput output= new ChannelBufferByteOutput(out);
			this.marshaller.start(output);
			this.marshaller.writeObject(msg);
			this.marshaller.finish();
			//  总长度(结束位置) - 初始化长度(起始位置) - 预留位置 = body数据长度
			int endPos = out.writerIndex();
			out.setInt(lengthPos, endPos - lengthPos - 4);
		} finally {
			this.marshaller.close();
		}
	}
}
