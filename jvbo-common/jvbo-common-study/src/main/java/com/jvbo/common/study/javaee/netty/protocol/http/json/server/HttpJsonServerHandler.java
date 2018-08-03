package com.jvbo.common.study.javaee.netty.protocol.http.json.server;

import com.jvbo.common.study.javaee.netty.protocol.http.json.codec.HttpJsonRequest;
import com.jvbo.common.study.javaee.netty.protocol.http.json.codec.HttpJsonResponse;
import com.jvbo.common.study.javaee.netty.protocol.http.pojo.Address;
import com.jvbo.common.study.javaee.netty.protocol.http.pojo.Order;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.*;
import io.netty.util.CharsetUtil;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;

import java.util.ArrayList;
import java.util.List;

import static io.netty.handler.codec.http.HttpHeaders.Names.CONTENT_TYPE;
import static io.netty.handler.codec.http.HttpHeaders.isKeepAlive;
import static io.netty.handler.codec.http.HttpResponseStatus.INTERNAL_SERVER_ERROR;

/**
 * @ClassName:
 * @Description: TODO
 * @author: jvbo
 * @date: 2018/7/31
 */
public class HttpJsonServerHandler extends SimpleChannelInboundHandler<HttpJsonRequest>{
	@Override
	protected void messageReceived(ChannelHandlerContext ctx, HttpJsonRequest msg) throws Exception {
		HttpRequest request = msg.getRequest();
		Order order = (Order) msg.getBody();
		System.out.println("http server receive request : " + order);
		dobusiness(order);
		ChannelFuture future = ctx.writeAndFlush(new HttpJsonResponse(null, order));
		if(!isKeepAlive(request)){
			future.addListener(new GenericFutureListener<Future<? super Void>>() {
				@Override
				public void operationComplete(Future<? super Void> future) throws Exception {
					ctx.close();
				}
			});
		}
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		cause.printStackTrace();
		if(ctx.channel().isActive()){
			sendError(ctx, INTERNAL_SERVER_ERROR);
		}
	}

	private void dobusiness(Order order){
		order.getCustomer().setFirstName("李");
		order.getCustomer().setLastName("四");
		List<String> midNames = new ArrayList<>();
		midNames.add("王二麻");
		Address address = order.getBillTo();
		address.setCity("合肥");
		address.setCountry("中国");
		address.setState("包公大道");
		address.setPostCode("222222");
		order.setBillTo(address);
		order.setShipTo(address);
	}

	private void sendError(ChannelHandlerContext ctx, HttpResponseStatus status) {
		FullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, status,
				Unpooled.copiedBuffer("失败" + status.toString() + "\r\n", CharsetUtil.UTF_8));
		response.headers().set(CONTENT_TYPE, "text/plain;charset=UTF-8");
		ctx.writeAndFlush(response).addListener(ChannelFutureListener.CLOSE);
	}

}
