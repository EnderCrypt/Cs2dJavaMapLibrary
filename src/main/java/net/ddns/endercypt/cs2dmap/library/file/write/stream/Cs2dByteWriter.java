package net.ddns.endercypt.cs2dmap.library.file.write.stream;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Objects;
import java.util.function.Consumer;

import net.ddns.endercypt.cs2dmap.library.file.stream.Cs2dAbstractIOStream;
import net.ddns.endercypt.cs2dmap.library.file.stream.assist.Cs2dByteInfo;
import net.ddns.endercypt.cs2dmap.library.raw.rawbyte.BooleanByte;
import net.ddns.endercypt.cs2dmap.library.raw.rawbyte.RawByte;
import net.ddns.endercypt.cs2dmap.library.raw.rawbyte.RawByteFlags;

public class Cs2dByteWriter extends Cs2dAbstractIOStream<BufferedOutputStream>
{
	public Cs2dByteWriter(File file) throws FileNotFoundException
	{
		super(new BufferedOutputStream(new FileOutputStream(file)));
	}

	protected void write(int size, Consumer<ByteBuffer> supplier) throws IOException
	{
		ByteBuffer bb = ByteBuffer.allocate(size);
		bb.order(Cs2dByteInfo.ENDIAN);
		supplier.accept(bb);
		getStream().write(bb.array(), 0, bb.array().length);
		advancePosition(bb.array().length);
	}

	public void writeNulls(int size, int count) throws IOException
	{
		int length = size * count;
		write(length, new Consumer<ByteBuffer>() // redundant, but implemented anyways
		{
			@Override
			public void accept(ByteBuffer bb)
			{
				for (int i = 0; i < length; i++)
				{
					bb.put((byte) 0);
				}
			}
		});
	}

	public void writeByte(RawByteFlags value) throws IOException
	{
		Objects.requireNonNull(value);
		writeByte(value.getByte());
	}

	public void writeByte(BooleanByte value) throws IOException
	{
		Objects.requireNonNull(value);
		writeByte(value.getByteValue());
	}

	public void writeByte(RawByte value) throws IOException
	{
		Objects.requireNonNull(value);
		writeByte(value.getByte());
	}

	public void writeByte(byte value) throws IOException
	{
		write(Cs2dByteInfo.BYTE, bb -> bb.put(value));
	}

	public void writeBytes(byte[] values) throws IOException
	{
		write(values.length, bb -> bb.put(values));
	}

	public void writeShort(short value) throws IOException
	{
		write(Cs2dByteInfo.SHORT, bb -> bb.putShort(value));
	}

	public void writeInt(int value) throws IOException
	{
		write(Cs2dByteInfo.INT, bb -> bb.putInt(value));
	}

	public void writeString(String value) throws IOException
	{
		byte[] bytes = new byte[value.length() + 2];
		int i = 0;
		for (char c : value.toCharArray())
		{
			bytes[i] = (byte) c;
			i++;
		}
		bytes[bytes.length - 2] = '\r';
		bytes[bytes.length - 1] = '\n';
		//System.out.println("(" + value.length() + ")" + value + ": " + Arrays.toString(bytes));
		writeBytes(bytes);
	}

	public void writeNullStrings(int count) throws IOException
	{
		byte[] bytes = new byte[count * 2];
		for (int i = 0; i < count; i++)
		{
			int index = i * 2;
			bytes[index] = '\r';
			bytes[index + 1] = '\n';
		}
		writeBytes(bytes);
	}
}
