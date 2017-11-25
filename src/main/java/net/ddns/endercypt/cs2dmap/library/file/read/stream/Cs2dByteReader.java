package net.ddns.endercypt.cs2dmap.library.file.read.stream;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;

import net.ddns.endercypt.cs2dmap.library.file.stream.Cs2dAbstractIOStream;
import net.ddns.endercypt.cs2dmap.library.file.stream.assist.Cs2dByteInfo;
import net.ddns.endercypt.cs2dmap.library.raw.rawbyte.BooleanByte;
import net.ddns.endercypt.cs2dmap.library.raw.rawbyte.RawByte;
import net.ddns.endercypt.cs2dmap.library.raw.rawbyte.RawByteFlags;

public class Cs2dByteReader extends Cs2dAbstractIOStream<BufferedInputStream>
{
	public Cs2dByteReader(File file) throws FileNotFoundException
	{
		super(new BufferedInputStream(new FileInputStream(file)));
	}

	// PRIVATE

	private byte[] rawRead(int bytes) throws IOException
	{
		byte[] byteArray = new byte[bytes];
		for (int i = 0; i < bytes; i++)
		{
			int raw = getStream().read();
			if (raw == -1)
			{
				throw new Cs2dMapReadException("Reached end of stream unexpectedly");
			}
			byteArray[i] = (byte) raw;
		}
		advancePosition(bytes);
		return byteArray;
	}

	private ByteBuffer rawReadBytes(int bytes) throws IOException
	{
		byte[] byteArray = rawRead(bytes);
		ByteBuffer bb = ByteBuffer.allocate(bytes);
		bb.order(Cs2dByteInfo.ENDIAN);
		bb.put(byteArray);
		return bb;
	}

	// NULL

	public void skipCharacters(int count, byte[] pattern) throws IOException
	{
		for (int i = 0; i < count; i++)
		{
			byte[] bytes = rawRead(pattern.length);
			for (int ii = 0; ii < pattern.length; ii++)
			{
				byte expected = pattern[ii];
				byte got = bytes[ii];
				if (got != expected)
					throw new Cs2dMapReadException("recieved " + got + " (" + (char) got + ") when trying to skip characters, expected " + expected + " (" + (char) expected + ")");
			}
		}
	}

	public void skip(int size, int count) throws IOException
	{
		byte[] pattern = new byte[size];
		for (int i = 0; i < pattern.length; i++)
		{
			pattern[i] = '\00';
		}
		skipCharacters(count, pattern);
	}

	public void skipStringNulls(int count) throws IOException
	{
		skipCharacters(count, new byte[] { '\r', '\n' });
	}

	// BYTE

	public RawByte readByte() throws IOException
	{
		return new RawByte(rawReadBytes(Cs2dByteInfo.BYTE).get(0));
	}

	public BooleanByte readBooleanByte() throws IOException
	{
		return new BooleanByte(readByte());
	}

	public RawByteFlags readRawByteFlags() throws IOException
	{
		return new RawByteFlags(readByte());
	}

	// SHORT

	public short readShort() throws IOException
	{
		return rawReadBytes(Cs2dByteInfo.SHORT).getShort(0);
	}

	// INTEGER

	public int readInt() throws IOException
	{
		return rawReadBytes(Cs2dByteInfo.INT).getInt(0);
	}

	// LONG

	public long readLong() throws IOException
	{
		return rawReadBytes(Cs2dByteInfo.LONG).getLong(0);
	}

	// STRING

	public String readString() throws IOException
	{
		StringBuilder sb = new StringBuilder();
		int byteCharacter = 0;
		while ((byteCharacter = getStream().read()) != '\r')
		{
			sb.append((char) byteCharacter);
		}
		if (getStream().read() != '\n')
			throw new Cs2dMapReadException("Expected newline");
		advancePosition(sb.length() + 2);
		return sb.toString();
	}

	// EXTRA

	public int available() throws IOException
	{
		return getStream().available();
	}

	public byte[] dumpStream() throws IOException
	{
		// possibly replace with ioutils for copying streams or getting byte array
		ByteArrayOutputStream byteArray = new ByteArrayOutputStream((int) (available() * 1.1));
		int value = -1;
		while ((value = getStream().read()) != -1)
		{
			byteArray.write(value);
		}
		advancePosition(byteArray.size());
		return byteArray.toByteArray();
	}
}
