package com.jvbo.common.study.javaee.netty.aio;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.Date;

/**
 * @ClassName:
 * @Description: TODO
 * @author: jvbo
 * @date: 2018/7/27
 */
public class ReadCompletionHandler implements CompletionHandler<Integer, ByteBuffer> {
	private AsynchronousSocketChannel channel;

	public ReadCompletionHandler(AsynchronousSocketChannel channel) {
		if(this.channel == null){
			this.channel = channel;
		}
	}

	@Override
	public void completed(Integer result, ByteBuffer attachment) {
		attachment.flip();
		byte[] body = new byte[attachment.remaining()];
		attachment.get(body);
		try {
			String req = new String(body, "UTF-8");
			System.out.println("time server receive order : " + req);
			String currentTime = "QUERY TIME ORDER".equalsIgnoreCase(req) ?
					new Date(System.currentTimeMillis()).toString() : "BAD ORDER";
			doWrite(currentTime);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}

	private void doWrite(String currentTime) {
		if(currentTime != null && currentTime.trim().length() > 0){
			byte[] bytes = currentTime.getBytes();
			ByteBuffer writeBuffer = ByteBuffer.allocate(bytes.length);
			writeBuffer.put(bytes);
			writeBuffer.flip();
			channel.write(writeBuffer, writeBuffer, new CompletionHandler<Integer, ByteBuffer>() {
				@Override
				public void completed(Integer result, ByteBuffer attachment) {
					// 如果没有发送完成,继续发送
					if(attachment.hasRemaining()) channel.write(attachment, attachment, this);
				}

				@Override
				public void failed(Throwable exc, ByteBuffer attachment) {
					try {
						channel.close();
					} catch (IOException e) {
						// ignore
						// 实际中,如果是IOException,就关闭链路,释放资源,如果是其他异常,按实际业务处理
					}
				}
			});
		}
	}

	@Override
	public void failed(Throwable exc, ByteBuffer attachment) {
		try {
			this.channel.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
