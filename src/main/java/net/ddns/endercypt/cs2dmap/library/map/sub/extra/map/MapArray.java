package net.ddns.endercypt.cs2dmap.library.map.sub.extra.map;

import java.awt.Dimension;

import net.ddns.endercypt.cs2dmap.library.map.obj.tile.Tile;
import net.ddns.endercypt.cs2dmap.library.map.sub.extra.tile.action.TileAction;
import net.ddns.endercypt.cs2dmap.library.raw.RawCs2dTile;

public class MapArray
{
	private int width;
	private int height;

	private Tile[][] map;

	public MapArray(int width, int height)
	{
		this.width = width;
		this.height = height;

		this.map = new Tile[getWidth()][getHeight()];
		for (int x = 0; x < getWidth(); x++)
		{
			for (int y = 0; y < getHeight(); y++)
			{
				map[x][y] = new Tile((byte) 0);
			}
		}
	}

	public Dimension getSize()
	{
		return new Dimension(getWidth(), getHeight());
	}

	public int getWidth()
	{
		return width;
	}

	public int getHeight()
	{
		return height;
	}

	public Tile tile(int x, int y)
	{
		return map[x][y];
	}

	public void resizeMap(int new_width, int new_height)
	{
		Tile[][] newMap = new Tile[new_width][new_height];
		// copy tiles
		for (int x = 0; x < Math.min(width, new_width); x++)
		{
			for (int y = 0; y < Math.min(height, new_height); y++)
			{
				newMap[x][y] = map[x][y];
			}
		}
		// fill null's
		for (int x = 0; x < new_width; x++)
		{
			for (int y = 0; y < new_height; y++)
			{
				if (newMap[x][y] == null)
				{
					newMap[x][y] = new Tile(new RawCs2dTile((byte) 0));
				}
			}
		}
		// set
		width = new_width;
		height = new_height;
		map = newMap;
	}

	public boolean isInBounds(int x1, int y1, int x2, int y2)
	{
		return (isInBounds(x1, y1) && isInBounds(x2, y2));
	}

	public boolean isInBounds(int x, int y)
	{
		return ((x >= 0) && (y >= 0) && (x <= getWidth()) && (y <= getHeight()));
	}

	public void circle(int x1, int y1, int x2, int y2, TileAction tileAction)
	{
		double xc = (x2 - x1) / 2;
		double yc = (y2 - y1) / 2;

		double rxc = x1 + xc;
		double ryc = y1 + yc;

		for (int x = x1; x < x2 + 1; x++)
		{
			for (int y = y1; y < y2 + 1; y++)
			{
				if (isInBounds(x, y))
				{
					double xoffset = 1.0 / xc * Math.abs(x - rxc);
					double yoffset = 1.0 / yc * Math.abs(y - ryc);
					double dist = Math.hypot(xoffset, yoffset);
					if (dist <= 1.0)
					{
						tileAction.process(tile(x, y));
					}
				}
			}
		}
	}

	public void rectangle(int x1, int y1, int x2, int y2, TileAction tileAction)
	{
		for (int x = x1; x < x2 + 1; x++)
		{
			for (int y = y1; y < y2 + 1; y++)
			{
				if (isInBounds(x, y))
				{
					tileAction.process(tile(x, y));
				}
			}
		}
	}

	public void fill(TileAction tileAction)
	{
		iterate(new MapIterator()
		{
			@Override
			public void process(int x, int y, Tile tile)
			{
				tileAction.process(tile);
			}
		});
	}

	public void replace(int frame, TileAction tileAction)
	{
		iterate(new MapIterator()
		{
			@Override
			public void process(int x, int y, Tile tile)
			{
				if (tile.getFrame() == frame)
				{
					tileAction.process(tile);
				}
			}
		});
	}

	public void iterate(MapIterator mapIterator)
	{
		iterate(0, 0, getWidth(), getHeight(), mapIterator);
	}

	public void iterate(int x1, int y1, int x2, int y2, MapIterator mapIterator)
	{
		// limit to inside map
		x1 = Math.max(x1, 0);
		y1 = Math.max(y1, 0);
		x2 = Math.min(x2, getWidth() - 1);
		y2 = Math.min(y2, getHeight() - 1);

		// iterate
		for (int x = x1; x < x2 + 1; x++)
		{
			for (int y = y1; y < y2 + 1; y++)
			{
				mapIterator.process(x, y, tile(x, y));
			}
		}
	}

	public MapSection copy(int x1, int y1, int x2, int y2)
	{
		return new MapSection(this, x1, y1, x2, y2);
	}
}
