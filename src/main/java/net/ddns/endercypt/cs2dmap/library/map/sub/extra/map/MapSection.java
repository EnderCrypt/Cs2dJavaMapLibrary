package net.ddns.endercypt.cs2dmap.library.map.sub.extra.map;

import net.ddns.endercypt.cs2dmap.library.map.obj.tile.Tile;

public class MapSection extends MapArray
{
	public MapSection(int width, int height)
	{
		super(width, height);
	}

	public MapSection(MapArray src, int x1, int y1, int x2, int y2)
	{
		super(x2 - x1 + 1, y2 - y1 + 1);

		src.iterate(x1, y1, x2, y2, new MapIterator()
		{
			@Override
			public void process(int x, int y, Tile tile)
			{
				int local_x = x - x1;
				int local_y = y - y1;

				MapSection.this.tile(local_x, local_y).copyFrom(tile);
			}
		});
	}

	public void centeredPasteInto(MapArray target, int x, int y)
	{
		x -= getWidth() / 2;
		y -= getHeight() / 2;

		pasteInto(target, x, y);
	}

	public void pasteInto(MapArray target, int x, int y)
	{
		iterate(new MapIterator()
		{
			@Override
			public void process(int local_x, int local_y, Tile tile)
			{
				int dest_x = x + local_x;
				int dest_y = y + local_y;

				if (target.isInBounds(dest_x, dest_y))
				{
					target.tile(dest_x, dest_y).copyFrom(tile);
				}
			}
		});
	}
}
