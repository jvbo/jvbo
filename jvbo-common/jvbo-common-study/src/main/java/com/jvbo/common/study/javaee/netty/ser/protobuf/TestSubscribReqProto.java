package com.jvbo.common.study.javaee.netty.ser.protobuf;

import com.google.protobuf.InvalidProtocolBufferException;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName:
 * @Description: TODO
 * @author: jvbo
 * @date: 2018/7/30
 */
public class TestSubscribReqProto {
	private static byte[] encode(SubscribeReqProto.SubscribeReq req){
		return req.toByteArray();
	}

	private static SubscribeReqProto.SubscribeReq decode(byte[] body) throws InvalidProtocolBufferException {
		return SubscribeReqProto.SubscribeReq.parseFrom(body);
	}

	private static SubscribeReqProto.SubscribeReq createSubscribeReq(){
		SubscribeReqProto.SubscribeReq.Builder builder = SubscribeReqProto.SubscribeReq.newBuilder();
		builder.setSubReqID(1);
		builder.setUserName("jvbo");
		builder.setProductName("产品三国志一本");
		List<String> address = new ArrayList<>();
		address.add("1");
		address.add("2");
		address.add("3");
		builder.addAllAddress(address);
		return builder.build();
	}

	public static void main(String[] args) throws InvalidProtocolBufferException {
		SubscribeReqProto.SubscribeReq req = createSubscribeReq();
		System.out.println("before encode : " + req.toString());

		SubscribeReqProto.SubscribeReq req1 = decode(encode(req));
		System.out.println("after decode : " + req.toString());
		System.out.println("assert : " + req1.equals(req));
	}

}
