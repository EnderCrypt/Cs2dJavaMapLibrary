package net.ddns.endercypt.cs2dmap.library.raw;

import java.io.IOException;

import net.ddns.endercypt.cs2dmap.library.file.read.stream.Cs2dByteReader;
import net.ddns.endercypt.cs2dmap.library.file.write.stream.Cs2dByteWriter;
import net.ddns.endercypt.cs2dmap.library.raw.rawbyte.RawByte;
import net.ddns.endercypt.cs2dmap.library.raw.rawbyte.RawByteFlags;

public class RawCs2dTile
{
	public RawByte tile_index;
	public RawByteFlags tile_modifier = RawByteFlags.EMPTY();

	public String unused;
	public RawByte frame_for_tile_modification = RawByte.ZERO();
	public RawByte tile_color_red = RawByte.ZERO();
	public RawByte tile_color_green = RawByte.ZERO();
	public RawByte tile_color_blue = RawByte.ZERO();
	public RawByte tile_overlay_frame = RawByte.ZERO();

	public RawCs2dTile(int frame)
	{
		this.tile_index = new RawByte(frame);
	}

	public RawCs2dTile(Cs2dByteReader reader) throws IOException
	{
		tile_index = reader.readByte();
	}

	public void copyFrom(RawCs2dTile src)
	{
		tile_index.set(src.tile_index.getInt());
		tile_modifier.copyFrom(src.tile_modifier);

		unused = src.unused;
		frame_for_tile_modification.set(src.frame_for_tile_modification.getInt());
		tile_color_red.set(src.tile_color_red.getInt());
		tile_color_green.set(src.tile_color_green.getInt());
		tile_color_blue.set(src.tile_color_blue.getInt());
		tile_overlay_frame.set(src.tile_overlay_frame.getInt());
	}

	public boolean isUsingModifier()
	{
		boolean bit_64 = tile_modifier.getNumericFlag(64);
		boolean bit_128 = tile_modifier.getNumericFlag(128);
		return (bit_64 || bit_128);
	}

	public void readModifiers(Cs2dByteReader reader) throws IOException
	{
		tile_modifier = reader.readRawByteFlags();

		boolean bit_64 = tile_modifier.getNumericFlag(64);
		boolean bit_128 = tile_modifier.getNumericFlag(128);

		//System.out.println("read: " + tile_modifier.getInt() + " bit_64: " + bit_64 + " 128: " + bit_128);

		if (isUsingModifier())
		{
			//System.out.println(tile_modifier);
			if (bit_64 && bit_128)
			{
				unused = reader.readString();
			}
			if (bit_64 && bit_128 == false)
			{
				frame_for_tile_modification = reader.readByte();
			}
			if (bit_64 == false && bit_128)
			{
				tile_color_red = reader.readByte();
				tile_color_green = reader.readByte();
				tile_color_blue = reader.readByte();
				tile_overlay_frame = reader.readByte();
			}
		}
	}

	public void writeModifiers(Cs2dByteWriter writer) throws IOException
	{
		writer.writeByte(tile_modifier);

		boolean bit_64 = tile_modifier.getNumericFlag(64);
		boolean bit_128 = tile_modifier.getNumericFlag(128);

		if (bit_64 || bit_128)
		{
			if (bit_64 && bit_128)
			{
				writer.writeString(unused);
			}
			else
			{
				if (bit_64 && bit_128 == false)
				{
					writer.writeByte(frame_for_tile_modification);
				}
				else
				{
					if (bit_64 == false && bit_128)
					{
						writer.writeByte(tile_color_red);
						writer.writeByte(tile_color_green);
						writer.writeByte(tile_color_blue);
						writer.writeByte(tile_overlay_frame);
					}
				}
			}
		}
	}
}
