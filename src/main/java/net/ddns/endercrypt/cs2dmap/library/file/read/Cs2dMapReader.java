package net.ddns.endercrypt.cs2dmap.library.file.read;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import net.ddns.endercrypt.cs2dmap.library.file.read.stream.Cs2dByteReader;
import net.ddns.endercrypt.cs2dmap.library.file.read.stream.Cs2dMapReadException;
import net.ddns.endercrypt.cs2dmap.library.file.stream.assist.Cs2dByteInfo;
import net.ddns.endercrypt.cs2dmap.library.file.stream.exception.Cs2dUnexpectedEOFException;
import net.ddns.endercrypt.cs2dmap.library.map.Cs2dMap;
import net.ddns.endercrypt.cs2dmap.library.raw.RawCs2dEntity;
import net.ddns.endercrypt.cs2dmap.library.raw.RawCs2dMap;
import net.ddns.endercrypt.cs2dmap.library.raw.RawCs2dTile;
import net.ddns.endercrypt.cs2dmap.library.raw.rawbyte.RawByte;
import net.ddns.endercrypt.cs2dmap.library.raw.rawbyte.RawByteFlags;

public class Cs2dMapReader
{
	public static Cs2dMap read(String file) throws FileNotFoundException, IOException
	{
		return read(new File(file));
	}

	public static Cs2dMap read(File file) throws FileNotFoundException, IOException
	{
		RawCs2dMap rawCs2dMap = new RawCs2dMap();

		try (Cs2dByteReader reader = new Cs2dByteReader(file))
		{
			// (1) HEADER
			String header = reader.readString();
			switch (header)
			{
			case "Unreal Software's CS2D Map File":
			case "Unreal Software's CS2D Map File (max)":
			case "Unreal Software's Counter-Strike 2D Map File":
			case "Unreal Software's Counter-Strike 2D Map File (max)":
				header = RawCs2dMap.HEADER;
				break;
			default:
				throw new Cs2dMapReadException("Unknon map header: " + header);
			}
			rawCs2dMap.header = header;

			// ----- 10 bytes for map settings / info
			rawCs2dMap.scroll_map_like_tiles = reader.readBooleanByte();
			boolean use_modifiers_in_this_map = reader.readBooleanByte().value;
			rawCs2dMap.save_tile_heights_with_map = reader.readByte();
			rawCs2dMap.use_64x64_pixel_tiles = reader.readBooleanByte();
			reader.skip(Cs2dByteInfo.BYTE, 6);

			// ----- 10 ints for map settings / info
			rawCs2dMap.uptime_of_system = reader.readInt();
			rawCs2dMap.usgn_id_of_the_map_author = reader.readInt();
			rawCs2dMap.map_daylight_time = reader.readInt();
			reader.skip(Cs2dByteInfo.INT, 7);

			// ----- 10 strings for map settings / info
			rawCs2dMap.name_of_the_map_author = reader.readString();
			rawCs2dMap.name_of_the_program_used_to_save_the_map = reader.readString();
			reader.skipStringNulls(8);

			// ----- More map settings
			String[] tempStringArray = split(reader.readString(), new char[] { 'x', '$', '%' });
			int map_xy_size = Integer.parseInt(tempStringArray[0]);
			rawCs2dMap.tile_count = Integer.parseInt(tempStringArray[1]);
			rawCs2dMap.currentSystemTime = Integer.parseInt(tempStringArray[2]);
			rawCs2dMap.systemUpTime = Long.parseLong(tempStringArray[3]);
			rawCs2dMap.filename_of_the_tilset_image = reader.readString();
			//rawCs2dMap.number_of_tiles_required_from_this_tileset = reader.readByte();
			reader.readByte(); // skip number_of_tiles_required_from_this_tileset as its auto-generated during write
			rawCs2dMap.map_width = reader.readInt();
			rawCs2dMap.map_height = reader.readInt();
			if (rawCs2dMap.map_width * rawCs2dMap.map_height != map_xy_size)
			{
				throw new Cs2dMapReadException("(map_xsize (in tiles) * map_ysize (in tiles)) = " + map_xy_size + " of the map file is inconsistant with the map width/height (" + rawCs2dMap.map_width + "," + rawCs2dMap.map_height + "=" + (rawCs2dMap.map_width * rawCs2dMap.map_height) + ")");
			}
			rawCs2dMap.filename_of_map_background_image = reader.readString();
			rawCs2dMap.background_scroll_x_speed = reader.readInt();
			rawCs2dMap.background_scroll_y_speed = reader.readInt();
			rawCs2dMap.map_background_color_red = reader.readByte();
			rawCs2dMap.map_background_color_green = reader.readByte();
			rawCs2dMap.map_background_color_blue = reader.readByte();

			// ----- Header Test
			if (reader.readString().equals(Cs2dByteInfo.REVERSE_UNREALSOFTWARE) == false)
			{
				throw new Cs2dMapReadException("header check failed: " + Cs2dByteInfo.REVERSE_UNREALSOFTWARE);
			}

			// (2) Tile Modes
			rawCs2dMap.tile_modes = new RawByte[rawCs2dMap.tile_count + 1];
			for (int i = 0; i < rawCs2dMap.tile_count + 1; i++)
			{
				rawCs2dMap.tile_modes[i] = reader.readByte();
			}

			// (3) Tile Heights
			switch (rawCs2dMap.save_tile_heights_with_map.getInt())
			{
			case 0:
				// READ (ignore)
				// UPGRADE TO MODE 2
				rawCs2dMap.save_tile_heights_with_map.set(2);
				rawCs2dMap.tile_height_in_pixels = new int[rawCs2dMap.tile_count + 1];
				rawCs2dMap.tile_3D_modifier = new RawByteFlags[rawCs2dMap.tile_count + 1];
				for (int i = 0; i < rawCs2dMap.tile_count + 1; i++)
				{
					rawCs2dMap.tile_height_in_pixels[i] = 0;
					rawCs2dMap.tile_3D_modifier[i] = RawByteFlags.EMPTY();
				}
				break;
			case 1: // If "save tile heights" is 1 (only used in 1.0.0.3 pre-release):
				// READ
				rawCs2dMap.tile_height_in_pixels = new int[rawCs2dMap.tile_count + 1];
				for (int i = 0; i < rawCs2dMap.tile_count + 1; i++)
				{
					rawCs2dMap.tile_height_in_pixels[i] = reader.readInt();
				}
				// UPGRADE TO MODE 2
				rawCs2dMap.save_tile_heights_with_map.set(2);
				rawCs2dMap.tile_3D_modifier = new RawByteFlags[rawCs2dMap.tile_count + 1];
				for (int i = 0; i < rawCs2dMap.tile_count + 1; i++)
				{
					rawCs2dMap.tile_3D_modifier[i] = RawByteFlags.EMPTY();
				}
				break;
			case 2: // Else If "save tile heights" is 2 (default since 1.0.0.3):
				// READ
				rawCs2dMap.tile_height_in_pixels = new int[rawCs2dMap.tile_count + 1];
				rawCs2dMap.tile_3D_modifier = new RawByteFlags[rawCs2dMap.tile_count + 1];
				for (int i = 0; i < rawCs2dMap.tile_count + 1; i++)
				{
					rawCs2dMap.tile_height_in_pixels[i] = reader.readShort() & 0xFFFF;
					rawCs2dMap.tile_3D_modifier[i] = reader.readRawByteFlags();
				}
				break;
			default:
				throw new Cs2dMapReadException("byte \"use modifiers in this map\" contained unknown value: " + rawCs2dMap.save_tile_heights_with_map.getByte());
			}

			// (4) Map
			rawCs2dMap.map = new RawCs2dTile[rawCs2dMap.map_width + 1][rawCs2dMap.map_height + 1];
			for (int x = 0; x < rawCs2dMap.map_width + 1; x++)
			{
				for (int y = 0; y < rawCs2dMap.map_height + 1; y++)
				{
					rawCs2dMap.map[x][y] = new RawCs2dTile(reader);
				}
			}
			if (use_modifiers_in_this_map)
			{
				for (int x = 0; x < rawCs2dMap.map_width + 1; x++)
				{
					for (int y = 0; y < rawCs2dMap.map_height + 1; y++)
					{
						rawCs2dMap.map[x][y].readModifiers(reader);
					}
				}
			}

			// (5) Entities
			int entity_count = reader.readInt();
			for (int i = 0; i < entity_count; i++)
			{
				rawCs2dMap.entities.add(new RawCs2dEntity(reader));
			}

			// (6) End of file
			if (reader.available() > 0)
			{
				throw new Cs2dUnexpectedEOFException("read a total of " + reader.getPosition() + " bytes and expected EOF but found ~" + reader.available() + " residual bytes!", reader.getPosition(), reader.dumpStream());
			}
		}

		return new Cs2dMap(rawCs2dMap);
	}

	private static String[] split(String string, char[] pattern)
	{
		List<String> array = new ArrayList<>();
		for (int i = 0; i < pattern.length; i++)
		{
			char patternCharacter = pattern[i];
			int location = string.indexOf(patternCharacter);
			if (location == -1)
			{
				throw new Cs2dMapReadException("unable to find pattern " + patternCharacter + " in string " + string);
			}
			String element = string.substring(0, location);
			array.add(element);
			string = string.substring(location + 1);
		}
		array.add(string);
		return array.stream().toArray(String[]::new);
	}
}
