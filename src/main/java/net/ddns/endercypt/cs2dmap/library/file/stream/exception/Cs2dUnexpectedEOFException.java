package net.ddns.endercypt.cs2dmap.library.file.stream.exception;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;

import net.ddns.endercypt.cs2dmap.library.file.read.stream.Cs2dMapReadException;
import net.ddns.endercypt.cs2dmap.library.raw.rawbyte.RawByte;

public class Cs2dUnexpectedEOFException extends Cs2dMapReadException
{
	private static final int COLUMNS = 16;

	private String debugByteString;

	public Cs2dUnexpectedEOFException(String message, int startIndex, byte[] bytes)
	{
		super(message);
		// byte array
		RepresentableByte[] representableArray = new RepresentableByte[bytes.length];
		for (int i = 0; i < bytes.length; i++)
		{
			representableArray[i] = new RepresentableByte(bytes[i]);
		}
		// buid debug message
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < representableArray.length; i++)
		{
			RepresentableByte representable = representableArray[i];
			if (i % COLUMNS == 0)
			{
				if (i > 0)
				{
					sb.append('|');
					for (int ii = i - COLUMNS; ii < i; ii++)
					{
						sb.append(representableArray[ii].getCharacterOrDefault());
					}
					sb.append('|');
					sb.append('\n');
				}
				sb.append(new RepresentableByte(startIndex + i).getNumberWithLength(8)).append("| ");
			}
			sb.append(representable.getNumberWithLength(5));

		}
		debugByteString = sb.toString();
	}

	public String getDebugByteString()
	{
		return debugByteString;
	}

	public void saveDebugByteString(File file) throws IOException
	{
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(file)))
		{
			writer.write(getDebugByteString());
		}
	}

	public void printDebugByteString()
	{
		printDebugByteString(System.err);
	}

	public void printDebugByteString(PrintStream printStream)
	{
		printStream.print(getDebugByteString());
	}

	private static class RepresentableByte
	{
		private int value;

		public RepresentableByte(int value)
		{
			this.value = value;
		}

		public RepresentableByte(byte value)
		{
			this(RawByte.toInt(value));
		}

		public int getValue()
		{
			return value;
		}

		public String getNumberWithLength(int minLength)
		{
			StringBuilder sb = new StringBuilder();
			sb.append(getValue());
			int length = minLength - getNumberLength();
			for (int i = 0; i < length; i++)
			{
				sb.append(' ');
			}
			return sb.toString();
		}

		public int getNumberLength()
		{
			int length = 0;
			int num = 0;
			while (num <= getValue())
			{
				length++;
				num = (int) Math.pow(10, length);
			}
			return length;
		}

		public boolean hasCharacter()
		{
			return ((getValue() >= 33) && (getValue() <= 126));
		}

		public char getCharacter()
		{
			return (char) getValue();
		}

		public char getCharacterOrDefault()
		{
			return hasCharacter() ? getCharacter() : ' ';
		}
	}
}
