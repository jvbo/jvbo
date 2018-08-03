package com.jvbo.common.study.javaee.netty.protocol.http.json.codec;

import com.alibaba.fastjson.JSON;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageEncoder;

import java.nio.charset.Charset;

/**
 * @ClassName:
 * @Description: TODO
 * @author: jvbo
 * @date: 2018/7/31
 */
public abstract class AbstractHttpJsonEncoder<T> extends MessageToMessageEncoder<T> {
	private final static Charset UTF_8 = Charset.forName("utf-8");

	protected ByteBuf encode0(ChannelHandlerContext ctx, Object body) throws Exception {
		String jsonStr = JSON.toJSONString(body);
		ByteBuf encodeBuf = Unpooled.copiedBuffer(jsonStr, UTF_8);
		return encodeBuf;
	}
}
