package com.jvbo.common.study.javaee.netty.protocol.personal.codec;

import com.jvbo.common.study.javaee.netty.protocol.personal.pojo.Header;
import com.jvbo.common.study.javaee.netty.protocol.personal.pojo.NettyMessage;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName:
 * @Description: TODO
 * @author: jvbo
 * @date: 2018/8/1
 */
public class NettyMessageDecoder extends LengthFieldBasedFrameDecoder {

	private MarshallingDecoder marshallingDecoder;

	public NettyMessageDecoder(int maxFrameLength, int lengthFieldOffset, int lengthFieldLength) throws IOException {
		super(maxFrameLength, lengthFieldOffset, lengthFieldLength);
		this.marshallingDecoder = new MarshallingDecoder();
	}

	@Override
	protected Object decode(ChannelHandlerContext ctx, ByteBuf in) throws Exception {
		ByteBuf frame = (ByteBuf) super.decode(ctx, in);
		if(frame == null){
			return null;
		}
		NettyMessage message = new NettyMessage();
		Header header = new Header();
		header.setCrcCode(frame.readInt());
		header.setLength(frame.readInt());
		header.setSessionID(frame.readLong());
		header.setType(frame.readByte());
		header.setPriority(frame.readByte());

		int size = frame.readInt();
		// 附件个数大于0,需要解码操作;
		if(size > 0){
			Map<String, Object> attch = new HashMap<>(size);
			int keySize = 0;
			byte[] keyArray = null;
			String key = null;
			for (int i = 0; i < size; i++){
				keySize = frame.readInt();
				keyArray = new byte[keySize];
				frame.readBytes(keyArray);
				key = new String(keyArray, "UTF-8");
				attch.put(key, this.marshallingDecoder.decode(frame));
			}
			keyArray = null;
			key = null;
			header.setAttachment(attch);
		}

		// 对于ByteBuf来说,读一个数据,就会少一个数据,所以读完header,剩下的是body
		// 大于4个字节,肯定有数据(4个字节是内容长度的占位)
		if(frame.readableBytes() > 4){
			message.setBody(this.marshallingDecoder.decode(frame));
		}
		message.setHeader(header);
		return message;
	}
}
