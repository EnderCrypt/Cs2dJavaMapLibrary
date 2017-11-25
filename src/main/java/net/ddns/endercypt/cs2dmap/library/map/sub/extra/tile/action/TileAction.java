package net.ddns.endercypt.cs2dmap.library.map.sub.extra.tile.action;

import net.ddns.endercypt.cs2dmap.library.map.obj.tile.Tile;

/**
 * if you want a quick TileAction, checkout {@link TileActions}
 * @author EnderCrypt
 */
@FunctionalInterface
public interface TileAction
{
	public void process(Tile tile);
}
