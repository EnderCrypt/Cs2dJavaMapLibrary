package net.ddns.endercrypt.cs2dmap.library.map.sub;

import net.ddns.endercrypt.cs2dmap.library.map.Cs2dDataProvider;
import net.ddns.endercrypt.cs2dmap.library.map.obj.tile.Tile;
import net.ddns.endercrypt.cs2dmap.library.map.sub.extra.map.MapArray;
import net.ddns.endercrypt.cs2dmap.library.map.sub.extra.map.MapIterator;
import net.ddns.endercrypt.cs2dmap.library.raw.RawCs2dMap;
import net.ddns.endercrypt.cs2dmap.library.raw.RawCs2dTile;

public class Cs2dMapArray extends MapArray implements Cs2dDataProvider
{
	public Cs2dMapArray(RawCs2dMap rawCs2dMap)
	{
		super(rawCs2dMap.map_width + 1, rawCs2dMap.map_height + 1);

		iterate(new MapIterator()
		{
			@Override
			public void process(int x, int y, Tile tile)
			{
				tile.getRaw().copyFrom(rawCs2dMap.map[x][y]);
			}
		});
	}

	@Override
	public void provide(RawCs2dMap rawCs2dMap)
	{
		rawCs2dMap.map_width = getWidth() - 1;
		rawCs2dMap.map_height = getHeight() - 1;

		rawCs2dMap.map = new RawCs2dTile[getWidth()][getHeight()];
		iterate(new MapIterator()
		{
			@Override
			public void process(int x, int y, Tile tile)
			{
				rawCs2dMap.map[x][y] = tile(x, y).getRaw();
			}
		});
	}
}
