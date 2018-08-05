package com.jvbo.common.study.javaee.netty.protocol.personal.codec;

import io.netty.buffer.ByteBuf;
import org.jboss.marshalling.ByteOutput;

import java.io.IOException;

/**
 * @ClassName:
 * @Description: TODO
 * @author: jvbo
 * @date: 2018/8/2
 */
public class ChannelBufferByteOutput implements ByteOutput {

	private final ByteBuf buffer;

	public ChannelBufferByteOutput(ByteBuf buffer) {
		this.buffer = buffer;
	}

	@Override
	public void write(int b) throws IOException {
		buffer.writeByte(b);
	}

	@Override
	public void write(byte[] b) throws IOException {
		buffer.writeBytes(b);
	}

	@Override
	public void write(byte[] b, int off, int len) throws IOException {
		buffer.writeBytes(b, off, len);
	}

	@Override
	public void close() throws IOException {
		// do nothing
	}

	@Override
	public void flush() throws IOException {
		// do nothing
	}

	ByteBuf getBuffer(){
		return buffer;
	}
}
