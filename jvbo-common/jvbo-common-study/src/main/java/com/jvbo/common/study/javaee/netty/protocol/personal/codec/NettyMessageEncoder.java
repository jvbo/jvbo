package com.jvbo.common.study.javaee.netty.protocol.personal.codec;

import com.jvbo.common.study.javaee.netty.protocol.personal.pojo.NettyMessage;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @ClassName:
 * @Description: TODO
 * @author: jvbo
 * @date: 2018/8/1
 */
public class NettyMessageEncoder extends MessageToByteEncoder<NettyMessage> {

	private MarshallingEncoder marshallingEncoder;

	public NettyMessageEncoder() throws IOException {
		this.marshallingEncoder = new MarshallingEncoder();
	}

	@Override
	protected void encode(ChannelHandlerContext ctx, NettyMessage msg, ByteBuf sendBuf) throws Exception {
		if(msg == null || msg.getHeader() == null){
			throw new Exception("编码失败,没有数据信息");
		}
		sendBuf.writeInt(msg.getHeader().getCrcCode());// 校验码
		sendBuf.writeInt(msg.getHeader().getLength());// 总长度
		sendBuf.writeLong(msg.getHeader().getSessionID());// 会话id
		sendBuf.writeByte(msg.getHeader().getType());// 消息类型
		sendBuf.writeByte(msg.getHeader().getPriority());// 优先级
		// 对附件信息j进行编码
		// 规则:如果attachment的长度为0,表示没有可选附件,则将长度编码设置为0,如果长度大于0,则需要编码
		/**
		 * 具体规则:
		 * 1. 首先对附件的个数进行编码
		 * 2. 然后对key进行编码,先编码长度,然后再将它转化为byte数组之后编码内容
		 */
		// 1. 首先对附件的个数进行编码
		sendBuf.writeInt(msg.getHeader().getAttachment().size()); // 附件大小
		String key = null;
		byte[] keyArray = null;
		Object value = null;
		for (Map.Entry<String, Object> param : msg.getHeader().getAttachment().entrySet()) {
			key = param.getKey();
			keyArray = key.getBytes("UTF-8");
			sendBuf.writeInt(keyArray.length);// key的字符编码长度
			sendBuf.writeBytes(keyArray);
			value = param.getValue();
			this.marshallingEncoder.encode(value, sendBuf);
		}

		key = null;
		keyArray = null;
		value = null;

		// 如果body不为空,说明有数据
		if(msg.getBody() != null){
			this.marshallingEncoder.encode(msg.getBody(), sendBuf);
		}else{
			// 如果没有数据,则进行补位,方便后续decode操作
			sendBuf.writeInt(0);
		}
		// 最后要获取整个数据包的总长度,也就是header + body,进行对header length的设置
		// 这里必须要-8个字节,是因为要把CRC和长度本身占的减掉(LengthFieldBasedFrameDecoder中的lengthFieldOffset + lengthFieldLength)
		// 总长度是在header协议的第二个标记字段中
		// 第一个参数是长度属性的索引位置
		sendBuf.setInt(4, sendBuf.readableBytes() - 8);
	}
}
