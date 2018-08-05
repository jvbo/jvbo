package com.jvbo.common.study.javaee.netty.protocol.personal.codec;

import io.netty.buffer.ByteBuf;
import org.jboss.marshalling.ByteInput;
import org.jboss.marshalling.Unmarshaller;

import java.io.IOException;

/**
 * @ClassName:
 * @Description: TODO
 * @author: jvbo
 * @date: 2018/8/1
 */
public class MarshallingDecoder {

	private Unmarshaller unmarshaller;

	public MarshallingDecoder() throws IOException {
		this.unmarshaller = MarshallingCodeCFactory.buildUnMarshalling();
	}

	public Object decode(ByteBuf in) throws IOException, ClassNotFoundException {
		try {
			// 1. 首先读取4个长度(实际body内容长度)
			int bodySize = in.readInt();
			// 2. 获取实际body的缓冲内容
			int readIndex = in.readerIndex();
			ByteBuf buf = in.slice(readIndex, bodySize);
			// 3. 转换
			ChannelBufferByteInput input = new ChannelBufferByteInput(buf);
			// 4. 读取
			this.unmarshaller.start(input);
			Object obj = this.unmarshaller.readObject();
			this.unmarshaller.finish();
			// 4. 读取完毕,更新当前读取起始位置
			// 由于使用slice方法,原buf的位置还在readIndex上,故需要将位置重新设置一下
			in.readerIndex(in.readerIndex() + bodySize);
			return obj;
		} finally {
			this.unmarshaller.close();
		}
	}
}
