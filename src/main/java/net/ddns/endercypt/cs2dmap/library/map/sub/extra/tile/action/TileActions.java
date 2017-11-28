package net.ddns.endercypt.cs2dmap.library.map.sub.extra.tile.action;

import net.ddns.endercypt.cs2dmap.library.map.obj.tile.Tile;
import net.ddns.endercypt.cs2dmap.library.map.obj.tile.modifier.DisableTileModifiers;
import net.ddns.endercypt.cs2dmap.library.map.obj.tile.modifier.TileModifier;

public abstract class TileActions
{
	public static TileAction setFrame(int frame)
	{
		return new TileAction()
		{
			@Override
			public void process(Tile tile)
			{
				tile.setFrame(frame);
			}
		};
	}

	public static TileAction clear()
	{
		return new TileAction()
		{
			@Override
			public void process(Tile tile)
			{
				tile.setTileModifier(new DisableTileModifiers());
				tile.setFrame(0);
			}
		};
	}

	public static TileAction removeModifier()
	{
		return setModifier(new DisableTileModifiers());
	}

	public static TileAction setModifier(TileModifier... tileModifiers)
	{
		return new TileAction()
		{
			@Override
			public void process(Tile tile)
			{
				tile.setTileModifier(tileModifiers);
			}
		};
	}

	public static TileAction copyFrom(Tile tile)
	{
		return new TileAction()
		{
			@Override
			public void process(Tile targetTile)
			{
				targetTile.copyFrom(tile);
			}
		};
	}
}
