package net.ddns.endercypt.cs2dmap.library.map.sub;

import net.ddns.endercypt.cs2dmap.library.map.Cs2dDataProvider;
import net.ddns.endercypt.cs2dmap.library.map.sub.array.impl.TileHeightArray;
import net.ddns.endercypt.cs2dmap.library.map.sub.array.impl.TileModeArray;
import net.ddns.endercypt.cs2dmap.library.raw.RawCs2dMap;

public class Cs2dTiles implements Cs2dDataProvider
{
	private boolean use_64x64_pixel_tiles;
	private int tile_count;
	private String filename_of_the_tilset_image;

	private TileModeArray tileModes;
	private TileHeightArray tileHeights;
	// tile 3d modifier not yet implemented

	public Cs2dTiles(RawCs2dMap rawCs2dMap)
	{
		this.use_64x64_pixel_tiles = rawCs2dMap.use_64x64_pixel_tiles.value;
		this.tile_count = rawCs2dMap.tile_count;
		this.filename_of_the_tilset_image = rawCs2dMap.filename_of_the_tilset_image;

		// arrays
		tileModes = new TileModeArray(rawCs2dMap);
		tileHeights = new TileHeightArray(rawCs2dMap);
	}

	@Override
	public void provide(RawCs2dMap rawCs2dMap)
	{
		rawCs2dMap.use_64x64_pixel_tiles.value = use_64x64_pixel_tiles;
		rawCs2dMap.tile_count = tile_count;
		rawCs2dMap.filename_of_the_tilset_image = filename_of_the_tilset_image;

		tileModes.provide(rawCs2dMap);
		tileHeights.provide(rawCs2dMap);
	}

	public boolean isUsing64x64Tiles()
	{
		return use_64x64_pixel_tiles;
	}

	public void setUsing64x64Tiles(boolean value)
	{
		use_64x64_pixel_tiles = value;
	}

	public String getFilename()
	{
		return filename_of_the_tilset_image;
	}

	public void setFilename(String filename)
	{
		this.filename_of_the_tilset_image = filename;
	}

	/**
	 * the amount of tiles present in this tileset
	 * @return
	 */
	public int getTileCount()
	{
		return tile_count;
	}

	public void setTileCount(int tile_count)
	{
		this.tile_count = tile_count;

		tileModes.resize(tile_count);
		tileHeights.resize(tile_count);
	}

	// arrays

	public TileModeArray tileModes()
	{
		return tileModes;
	}

	public TileHeightArray tileHeights()
	{
		return tileHeights;
	}
}
