package net.ddns.endercrypt.cs2dmap.library.map.sub.extra.map;

import net.ddns.endercrypt.cs2dmap.library.map.obj.tile.Tile;

@FunctionalInterface
public interface MapIterator
{
	public void process(int x, int y, Tile tile);
}
