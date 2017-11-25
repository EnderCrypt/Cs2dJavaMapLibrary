package net.ddns.endercypt.cs2dmap.library.file.write.stream;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.function.Consumer;

import net.ddns.endercypt.cs2dmap.library.file.stream.assist.Cs2dByteInfo;
import net.ddns.endercypt.cs2dmap.library.raw.rawbyte.RawByte;

public class Cs2dByteWriteCompare extends Cs2dByteWriter
{
	private static final File compareOuputFile = new File("maps/compare.map");

	private BufferedInputStream inputStream;
	private File srcFile;

	public Cs2dByteWriteCompare(File file) throws FileNotFoundException
	{
		super(compareOuputFile);
		inputStream = new BufferedInputStream(new FileInputStream(file));
		srcFile = file;
	}

	@Override
	protected void write(int size, Consumer<ByteBuffer> supplier) throws IOException
	{
		super.write(size, supplier);

		ByteBuffer bb = ByteBuffer.allocate(size);
		bb.order(Cs2dByteInfo.ENDIAN);
		supplier.accept(bb);

		byte[] written = bb.array();
		int extraPosition = 0;
		for (byte got : written)
		{
			byte expected = (byte) inputStream.read();
			if (got != expected)
			{
				byte[] newWritten = Arrays.copyOf(written, extraPosition);
				super.write(extraPosition, ibb -> ibb.put(newWritten));
				throw new IllegalArgumentException(Cs2dByteWriteCompare.class.getSimpleName() + ": expected byte " + expected + " (U " + RawByte.toInt(expected) + ") but got " + got + " (U " + RawByte.toInt(got) + ") at position " + (getPosition() - written.length));
			}
			extraPosition++;
		}
	}

	@Override
	public void close() throws IOException
	{
		super.close();
		inputStream.close();

		if (srcFile.length() != compareOuputFile.length())
		{
			throw new IllegalArgumentException("written file has the size: " + compareOuputFile.length() + " but was expected to have " + srcFile.length() + " bytes");
		}
	}
}
