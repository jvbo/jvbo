package com.jvbo.common.study.javaee.netty.protocol.http.json.codec;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.jvbo.common.study.javaee.netty.protocol.http.pojo.Order;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageDecoder;

import java.nio.charset.Charset;

/**
 * @ClassName:
 * @Description: TODO
 * @author: jvbo
 * @date: 2018/7/31
 */
public abstract class AbstractHttpJsonDecoder<T> extends MessageToMessageDecoder<T> {
	private Class<?> clazz;
	private boolean isPrint;
	private final static Charset UTF_8 = Charset.forName("utf-8");

	public AbstractHttpJsonDecoder(Class<?> clazz){
		this(clazz, false);
	}

	public AbstractHttpJsonDecoder(Class<?> clazz, boolean isPrint){
		this.clazz = clazz;
		this.isPrint = isPrint;
	}

	protected Object decode0(ChannelHandlerContext ctx, ByteBuf body) throws Exception {
		String content = body.toString(UTF_8);
		if(isPrint){
			System.out.println("body is : " + content);
		}
		Order result = JSON.parseObject(content, new TypeReference<Order>(){});
		return result;
	}
}
