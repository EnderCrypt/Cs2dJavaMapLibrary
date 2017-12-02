package net.ddns.endercrypt.cs2dmap.library.raw.rawbyte;

import java.nio.ByteOrder;

public class RawByteFlags
{
	private static final ByteOrder DEFAULT_ENDIAN = ByteOrder.BIG_ENDIAN;
	private static final int FLAGS = 8;
	private static final int[] VALUES = new int[FLAGS];

	static
	{
		int value = 1;
		for (int i = 0; i < FLAGS; i++)
		{
			VALUES[i] = value;
			value *= 2;
		}
	}

	private ByteOrder endian;
	private byte rawValue;

	public RawByteFlags(RawByte rawByte)
	{
		this(rawByte, DEFAULT_ENDIAN);
	}

	public RawByteFlags(RawByte rawByte, ByteOrder endian)
	{
		rawValue = rawByte.getByte();
		this.endian = endian;
	}

	public boolean getNumericFlag(int numericKey)
	{
		for (int i = 0; i < FLAGS; i++)
		{
			if (VALUES[i] == numericKey)
			{
				return getFlag(i);
			}
		}
		throw new IllegalArgumentException("must be a number like 1, 2, 4, 8, 16 etc (max: 256)");
	}

	public void setNumericFlag(int numericKey, boolean value)
	{
		for (int i = 0; i < FLAGS; i++)
		{
			if (VALUES[i] == numericKey)
			{
				setFlag(i, value);
				return;
			}
		}
		throw new IllegalArgumentException("must be a number like 1, 2, 4, 8, 16 etc (max: 256)");
	}

	private static void verifyPosition(int position)
	{
		if ((position < 0) || (position >= FLAGS))
		{
			throw new IllegalArgumentException("flag position must be ranging from 0 to 7");
		}
	}

	public boolean getFlag(int position)
	{
		if (endian == ByteOrder.LITTLE_ENDIAN)
		{
			position = FLAGS - 1 - position;
		}
		verifyPosition(position);
		return ((rawValue >> position) & 1) == 1;
	}

	public void setFlag(int position, boolean value)
	{
		if (endian == ByteOrder.LITTLE_ENDIAN)
		{
			position = FLAGS - 1 - position;
		}

		verifyPosition(position);

		if (value)
		{
			rawValue = (byte) (rawValue | (1 << position));
		}
		else
		{
			rawValue = (byte) (rawValue & ~(1 << position));
		}
	}

	public byte getByte()
	{
		return rawValue;
	}

	public int getInt()
	{
		int i = RawByte.toInt(rawValue);
		if (endian == ByteOrder.LITTLE_ENDIAN)
		{
			i = 256 - i;
		}
		return i;
	}

	public void copyFrom(RawByteFlags rawByteFlags)
	{
		this.rawValue = rawByteFlags.rawValue;
	}

	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < FLAGS; i++)
		{
			sb.append(getFlag(i) ? '1' : '0');
		}
		return "RawByteFlags [num=" + getInt() + " flags=" + sb.toString() + "]";
	}

	public static RawByteFlags EMPTY()
	{
		return new RawByteFlags(RawByte.ZERO());
	}

}
