package net.ddns.endercrypt.cs2dmap.library.raw.rawbyte;

public class RawByte
{
	private int value;

	public RawByte(byte value)
	{
		this(toInt(value));
	}

	public RawByte(int value)
	{
		set(value);
	}

	public byte getByte()
	{
		return toByte(value);
	}

	public int getInt()
	{
		return value;
	}

	public void set(int value)
	{
		if ((value < 0) || (value > 255))
		{
			throw new IllegalArgumentException("value must be from 0 to 256");
		}
		this.value = value;
	}

	public static RawByte ZERO()
	{
		return new RawByte(0);
	}

	public static int toInt(byte value)
	{
		return value & 0xFF;
	}

	public static byte toByte(int value)
	{
		if ((value < 0) || (value > 255))
		{
			throw new IllegalArgumentException("value must be from 0 to 256, was: " + value);
		}
		return (byte) value;
	}

	@Override
	public String toString()
	{
		return "RawByte [U byte=" + value + "]";
	}
}
