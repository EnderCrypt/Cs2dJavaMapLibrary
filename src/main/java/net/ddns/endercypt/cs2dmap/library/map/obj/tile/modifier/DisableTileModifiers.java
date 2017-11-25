package net.ddns.endercypt.cs2dmap.library.map.obj.tile.modifier;

import net.ddns.endercypt.cs2dmap.library.raw.RawCs2dTile;

public class DisableTileModifiers implements TileModifier
{
	private boolean disableTileModFrame;
	private boolean disableColorMod;

	public DisableTileModifiers()
	{
		this(true, true);
	}

	public DisableTileModifiers(boolean disableTileModFrame, boolean disableColorMod)
	{
		this.disableTileModFrame = disableTileModFrame;
		this.disableColorMod = disableColorMod;
	}

	@Override
	public void update(RawCs2dTile rawCs2dTile)
	{
		if (disableTileModFrame)
		{
			rawCs2dTile.tile_modifier.setNumericFlag(64, false);
		}

		if (disableColorMod)
		{
			rawCs2dTile.tile_modifier.setNumericFlag(128, false);
		}
	}
}
