package net.ddns.endercrypt.cs2dmap.library.map.obj.tile.modifier;

import net.ddns.endercrypt.cs2dmap.library.raw.RawCs2dTile;

public class FrameTileModifier implements TileModifier
{
	private int frame;

	public FrameTileModifier(int frame)
	{
		this.frame = frame;
	}

	@Override
	public void update(RawCs2dTile rawCs2dTile)
	{
		rawCs2dTile.frame_for_tile_modification.set(frame);
	}
}
