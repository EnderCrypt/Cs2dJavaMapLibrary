package net.ddns.endercrypt.cs2dmap.library.raw.rawshort;

public class RawShort
{
	private int value;

	public RawShort(short value)
	{
		this(toInt(value));
	}

	public RawShort(int value)
	{
		set(value);
	}

	public short getShort()
	{
		return toShort(value);
	}

	public int getInt()
	{
		return value;
	}

	public void set(int value)
	{
		if ((value < 0) || (value > 65_535))
		{
			throw new IllegalArgumentException("value must be from 0 to 65'535");
		}
		this.value = value;
	}

	public static RawShort ZERO()
	{
		return new RawShort(0);
	}

	public static int toInt(short value)
	{
		return value & 0xFFFF;
	}

	public static byte toShort(int value)
	{
		if ((value < 0) || (value > 65_535))
		{
			throw new IllegalArgumentException("value must be from 0 to 65535, was: " + value);
		}
		return (byte) value;
	}

	@Override
	public String toString()
	{
		return "RawShort [U short=" + value + "]";
	}
}
