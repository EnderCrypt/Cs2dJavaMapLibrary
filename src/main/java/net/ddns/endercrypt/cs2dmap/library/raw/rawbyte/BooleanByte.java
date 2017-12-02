package net.ddns.endercrypt.cs2dmap.library.raw.rawbyte;

public class BooleanByte
{
	public boolean value;

	public BooleanByte(boolean value)
	{
		this.value = value;
	}

	public BooleanByte(RawByte value)
	{
		if (value.getInt() == 1)
		{
			this.value = true;
			return;
		}
		if (value.getInt() == 0)
		{
			this.value = false;
			return;
		}
		throw new IllegalArgumentException("BooleanByte must be created using true/false 1/0 but was int: " + value.getInt());
	}

	public byte getByteValue()
	{
		return (byte) (value ? 1 : 0);
	}

	@Override
	public String toString()
	{
		return "BooleanByte [value=" + value + "]";
	}

	public static BooleanByte TRUE()
	{
		return new BooleanByte(true);
	}

	public static BooleanByte FALSE()
	{
		return new BooleanByte(false);
	}
}
