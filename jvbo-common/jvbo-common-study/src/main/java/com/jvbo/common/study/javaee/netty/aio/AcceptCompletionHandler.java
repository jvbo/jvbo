package com.jvbo.common.study.javaee.netty.aio;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

/**
 * @ClassName:
 * @Description: TODO
 * @author: jvbo
 * @date: 2018/7/27
 */
public class AcceptCompletionHandler implements CompletionHandler<AsynchronousSocketChannel, AsyncTimeServerHandler> {
	@Override
	public void completed(AsynchronousSocketChannel result, AsyncTimeServerHandler attachment) {
		attachment.asynchronousServerSocketChannel.accept(attachment, this);
		ByteBuffer buffer = ByteBuffer.allocate(1024);
		result.read(buffer, buffer, new ReadCompletionHandler(result));
	}

	@Override
	public void failed(Throwable exc, AsyncTimeServerHandler attachment) {
		exc.printStackTrace();
		attachment.latch.countDown();
	}
}
