package net.ddns.endercypt.cs2dmap.library.file.stream;

import java.io.Closeable;
import java.io.IOException;

public abstract class Cs2dAbstractIOStream<T extends Closeable> implements Closeable
{
	private T stream;
	private int position = 0;

	public Cs2dAbstractIOStream(T stream)
	{
		this.stream = stream;
	}

	protected void advancePosition(int by)
	{
		position += by;
	}

	public int getPosition()
	{
		return position;
	}

	public T getStream()
	{
		return stream;
	}

	@Override
	public void close() throws IOException
	{
		stream.close();
	}
}
