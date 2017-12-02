package net.ddns.endercrypt.cs2dmap.library.raw;

import java.io.IOException;

import net.ddns.endercrypt.cs2dmap.library.file.read.stream.Cs2dByteReader;
import net.ddns.endercrypt.cs2dmap.library.file.write.stream.Cs2dByteWriter;
import net.ddns.endercrypt.cs2dmap.library.raw.rawbyte.RawByte;

public class RawCs2dEntity
{
	public static final int SETTINGS_COUNT = 10;

	public String entity_name;
	public RawByte entity_type;
	public int x;
	public int y;
	public String triggers;

	public int[] integerSettings = new int[SETTINGS_COUNT];
	public String[] stringSettings = new String[SETTINGS_COUNT];

	public RawCs2dEntity()
	{
		entity_name = "";
		entity_type = new RawByte((byte) -1);
		x = 0;
		y = 0;
		triggers = "";

		for (int i = 0; i < SETTINGS_COUNT; i++)
		{
			integerSettings[i] = 0;
			stringSettings[i] = "";
		}
	}

	public RawCs2dEntity(Cs2dByteReader reader) throws IOException
	{
		entity_name = reader.readString();
		entity_type = reader.readByte();
		x = reader.readInt();
		y = reader.readInt();
		triggers = reader.readString();

		for (int i = 0; i < SETTINGS_COUNT; i++)
		{
			integerSettings[i] = reader.readInt();
			stringSettings[i] = reader.readString();
		}
	}

	public void write(Cs2dByteWriter writer) throws IOException
	{
		writer.writeString(entity_name);
		writer.writeByte(entity_type);
		writer.writeInt(x);
		writer.writeInt(y);
		writer.writeString(triggers);

		for (int i = 0; i < SETTINGS_COUNT; i++)
		{
			writer.writeInt(integerSettings[i]);
			writer.writeString(stringSettings[i]);
		}
	}
}
