package net.ddns.endercrypt.cs2dmap.library.file.write;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import net.ddns.endercrypt.cs2dmap.library.file.read.stream.Cs2dMapReadException;
import net.ddns.endercrypt.cs2dmap.library.file.stream.assist.Cs2dByteInfo;
import net.ddns.endercrypt.cs2dmap.library.file.write.stream.Cs2dByteWriter;
import net.ddns.endercrypt.cs2dmap.library.map.Cs2dMap;
import net.ddns.endercrypt.cs2dmap.library.raw.RawCs2dEntity;
import net.ddns.endercrypt.cs2dmap.library.raw.RawCs2dMap;
import net.ddns.endercrypt.cs2dmap.library.raw.rawbyte.RawByte;

public class Cs2dMapWriter
{
	public static void write(Cs2dMap cs2dMap, String file) throws FileNotFoundException, IOException
	{
		write(cs2dMap, new File(file));
	}

	public static void write(Cs2dMap cs2dMap, File file) throws FileNotFoundException, IOException
	{
		RawCs2dMap rawCs2dMap = cs2dMap.getRaw();

		try (Cs2dByteWriter writer = new Cs2dByteWriter(file)) // new Cs2dByteWriteCompare
		{
			// (1) HEADER
			writer.writeString(rawCs2dMap.header);

			// ----- 10 bytes for map settings / info
			writer.writeByte(rawCs2dMap.scroll_map_like_tiles);
			boolean use_modifiers_in_this_map = false;
			modifier_check_loop: for (int x = 0; x < rawCs2dMap.map_width + 1; x++)
			{
				for (int y = 0; y < rawCs2dMap.map_height + 1; y++)
				{
					if (rawCs2dMap.map[x][y].isUsingModifier())
					{
						use_modifiers_in_this_map = true;
						break modifier_check_loop;
					}
				}
			}
			//System.out.println("use_modifiers_in_this_map: " + use_modifiers_in_this_map);
			writer.writeByte(new RawByte(use_modifiers_in_this_map ? 1 : 0));
			writer.writeByte(rawCs2dMap.save_tile_heights_with_map);
			writer.writeByte(rawCs2dMap.use_64x64_pixel_tiles);
			writer.writeNulls(Cs2dByteInfo.BYTE, 6);

			// ----- 10 ints for map settings / info
			writer.writeInt(rawCs2dMap.uptime_of_system);
			writer.writeInt(rawCs2dMap.usgn_id_of_the_map_author);
			writer.writeInt(rawCs2dMap.map_daylight_time);
			writer.writeNulls(Cs2dByteInfo.INT, 7);

			// ----- 10 strings for map settings / info
			writer.writeString(rawCs2dMap.name_of_the_map_author);
			writer.writeString(rawCs2dMap.name_of_the_program_used_to_save_the_map);
			writer.writeNullStrings(8);

			// ----- More map settings
			writer.writeString((rawCs2dMap.map_width * rawCs2dMap.map_height) + "x" + rawCs2dMap.tile_count + "$" + rawCs2dMap.currentSystemTime + "%" + rawCs2dMap.systemUpTime);
			writer.writeString(rawCs2dMap.filename_of_the_tilset_image);
			writer.writeByte(RawByte.toByte(rawCs2dMap.tile_count));
			writer.writeInt(rawCs2dMap.map_width);
			writer.writeInt(rawCs2dMap.map_height);
			writer.writeString(rawCs2dMap.filename_of_map_background_image);
			writer.writeInt(rawCs2dMap.background_scroll_x_speed);
			writer.writeInt(rawCs2dMap.background_scroll_y_speed);
			writer.writeByte(rawCs2dMap.map_background_color_red);
			writer.writeByte(rawCs2dMap.map_background_color_green);
			writer.writeByte(rawCs2dMap.map_background_color_blue);

			// ----- Header Test
			writer.writeString(Cs2dByteInfo.REVERSE_UNREALSOFTWARE);

			// (2) Tile Modes
			for (int i = 0; i < rawCs2dMap.tile_count + 1; i++)
			{
				writer.writeByte(rawCs2dMap.tile_modes[i]);
			}

			// (3) Tile Heights
			switch (rawCs2dMap.save_tile_heights_with_map.getInt())
			{
			case 0:
				// ignore
				break;
			case 1: // If "save tile heights" is 1 (only used in 1.0.0.3 pre-release):
				for (int i = 0; i < rawCs2dMap.tile_count + 1; i++)
				{
					writer.writeInt(rawCs2dMap.tile_height_in_pixels[i]);
				}
				break;
			case 2: // Else If "save tile heights" is 2 (default since 1.0.0.3):
				for (int i = 0; i < rawCs2dMap.tile_count + 1; i++)
				{
					int height = rawCs2dMap.tile_height_in_pixels[i];
					writer.writeShort((short) height);
					writer.writeByte(rawCs2dMap.tile_3D_modifier[i]);
				}
				break;
			default:
				throw new Cs2dMapReadException("byte \"use modifiers in this map\" contained unknown value: " + rawCs2dMap.save_tile_heights_with_map.getByte());
			}

			// (4) Map
			for (int x = 0; x < rawCs2dMap.map_width + 1; x++)
			{
				for (int y = 0; y < rawCs2dMap.map_height + 1; y++)
				{
					writer.writeByte(rawCs2dMap.map[x][y].tile_index);
				}
			}
			if (use_modifiers_in_this_map)
			{
				for (int x = 0; x < rawCs2dMap.map_width + 1; x++)
				{
					for (int y = 0; y < rawCs2dMap.map_height + 1; y++)
					{
						rawCs2dMap.map[x][y].writeModifiers(writer);
					}
				}
			}

			// (5) Entities
			writer.writeInt(rawCs2dMap.entities.size());
			for (RawCs2dEntity entity : rawCs2dMap.entities)
			{
				entity.write(writer);
			}
		}
	}
}
