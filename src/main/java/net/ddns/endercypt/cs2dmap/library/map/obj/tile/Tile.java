package net.ddns.endercypt.cs2dmap.library.map.obj.tile;

import net.ddns.endercypt.cs2dmap.library.map.obj.tile.modifier.TileModifier;
import net.ddns.endercypt.cs2dmap.library.raw.RawData;
import net.ddns.endercypt.cs2dmap.library.raw.RawCs2dTile;

public class Tile implements RawData<RawCs2dTile>
{
	private RawCs2dTile rawCs2dTile;

	public Tile(int frame)
	{
		this(new RawCs2dTile((byte) frame));
	}

	public Tile(RawCs2dTile rawCs2dTile)
	{
		this.rawCs2dTile = rawCs2dTile;
	}

	@Override
	public RawCs2dTile getRaw()
	{
		return rawCs2dTile;
	}

	public void copyFrom(Tile src)
	{
		getRaw().copyFrom(src.getRaw());
	}

	public int getFrame()
	{
		return rawCs2dTile.tile_index.getInt();
	}

	public void setFrame(int frame)
	{
		rawCs2dTile.tile_index.set(frame);
	}

	/**
	 * supply any of the following
	 * - NoTileModifier
	 * - FrameTileModifier
	 * - ColorTileModifier
	 * 
	 * @param tileModifiers
	 */
	public void setTileModifier(TileModifier... tileModifiers)
	{
		for (TileModifier tileModifier : tileModifiers)
		{
			tileModifier.update(getRaw());
		}
	}
}
