package net.ddns.endercypt.cs2dmap.library.raw;

import java.util.ArrayList;
import java.util.List;

import net.ddns.endercypt.cs2dmap.library.raw.rawbyte.BooleanByte;
import net.ddns.endercypt.cs2dmap.library.raw.rawbyte.RawByte;
import net.ddns.endercypt.cs2dmap.library.raw.rawbyte.RawByteFlags;

public class RawCs2dMap
{
	public static final String HEADER = "Unreal Software's Counter-Strike 2D Map File (max)";

	// (1) HEADER
	public String header;

	// ----- 10 bytes for map settings / info
	public BooleanByte scroll_map_like_tiles;
	public RawByte save_tile_heights_with_map;
	public BooleanByte use_64x64_pixel_tiles;

	// ----- 10 ints for map settings / info
	public int uptime_of_system;
	public int usgn_id_of_the_map_author; // +51
	public int map_daylight_time;

	// ----- 10 strings for map settings / info
	public String name_of_the_map_author;
	public String name_of_the_program_used_to_save_the_map;

	// ----- More map settings
	public int tile_count;
	public int currentSystemTime;
	public long systemUpTime;
	public String filename_of_the_tilset_image;
	//public RawByte number_of_tiles_required_from_this_tileset;
	public int map_width; // is 1 lower than actual map size
	public int map_height; // is 1 lower than actual map size
	public String filename_of_map_background_image;
	public int background_scroll_x_speed;
	public int background_scroll_y_speed;
	public RawByte map_background_color_red;
	public RawByte map_background_color_green;
	public RawByte map_background_color_blue;

	// (2) Tile Modes
	public RawByte[] tile_modes;

	// (3) Tile Heights

	// If "save tile heights" is 1 (only used in 1.0.0.3 pre-release):
	public int[] tile_height_in_pixels;
	// Else If "save tile heights" is 2 (default since 1.0.0.3) also do:
	public RawByteFlags[] tile_3D_modifier; // tile 3d modifier not yet implemented

	// (4) Map
	public RawCs2dTile[][] map;

	// (5) Entities
	public final List<RawCs2dEntity> entities;

	public RawCs2dMap()
	{
		// (1) HEADER
		header = HEADER;

		// ----- 10 bytes for map settings / info
		scroll_map_like_tiles = BooleanByte.FALSE();
		save_tile_heights_with_map = new RawByte((byte) 2);
		use_64x64_pixel_tiles = BooleanByte.FALSE();

		// ----- 10 ints for map settings / info
		uptime_of_system = 0; // no idea what i should put here
		usgn_id_of_the_map_author = 51;
		map_daylight_time = 270;

		// ----- 10 strings for map settings / info
		name_of_the_map_author = "Player";
		name_of_the_program_used_to_save_the_map = "EnderCrypt's CS2D Java map library (USGN: 5783) https://github.com/EnderCrypt/Cs2dJavaMapLibrary";

		// ----- More map settings
		tile_count = 80;
		currentSystemTime = 0; // ????
		systemUpTime = System.currentTimeMillis(); // ????
		filename_of_the_tilset_image = "dust.bmp";
		//number_of_tiles_required_from_this_tileset = new RawByte((byte) 80);
		map_width = 15; // is 1 lower than actual map size
		map_height = 15; // is 1 lower than actual map size
		filename_of_map_background_image = "dust.png";
		background_scroll_x_speed = 0;
		background_scroll_y_speed = 0;
		map_background_color_red = new RawByte((byte) 0);
		map_background_color_green = new RawByte((byte) 0);
		map_background_color_blue = new RawByte((byte) 0);

		// (2) Tile Modes
		tile_modes = new RawByte[tile_count + 1];
		for (int i = 0; i < tile_count + 1; i++)
		{
			tile_modes[i] = new RawByte((byte) 0);
		}

		// (3) Tile Heights
		tile_height_in_pixels = new int[tile_count + 1];
		tile_3D_modifier = new RawByteFlags[tile_count + 1];
		for (int i = 0; i < tile_count + 1; i++)
		{
			tile_height_in_pixels[i] = 0;
			tile_3D_modifier[i] = RawByteFlags.EMPTY();
		}

		// (4) Map
		map = new RawCs2dTile[map_width + 1][map_height + 1];
		for (int x = 0; x < map_width + 1; x++)
		{
			for (int y = 0; y < map_height + 1; y++)
			{
				map[x][y] = new RawCs2dTile((byte) 0);
			}
		}

		// (5) Entities
		entities = new ArrayList<>();
	}
}
