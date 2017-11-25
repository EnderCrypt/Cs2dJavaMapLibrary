package net.ddns.endercypt.cs2dmap.library.map.sub.extra.map;

import net.ddns.endercypt.cs2dmap.library.map.obj.tile.Tile;

public interface MapIterator
{
	public void process(int x, int y, Tile tile);
}
