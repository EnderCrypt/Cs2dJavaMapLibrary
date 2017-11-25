package net.ddns.endercypt.cs2dmap.library.map.sub;

import java.awt.Color;
import java.awt.Point;

import net.ddns.endercypt.cs2dmap.library.map.Cs2dDataProvider;
import net.ddns.endercypt.cs2dmap.library.raw.RawCs2dMap;
import net.ddns.endercypt.cs2dmap.library.raw.rawbyte.BooleanByte;
import net.ddns.endercypt.cs2dmap.library.raw.rawbyte.RawByte;

public class Cs2dBackground implements Cs2dDataProvider
{
	private BooleanByte scroll_map_like_tiles;
	private String filename_of_map_background_image;
	private int background_scroll_x_speed;
	private int background_scroll_y_speed;
	private RawByte map_background_color_red;
	private RawByte map_background_color_green;
	private RawByte map_background_color_blue;

	public Cs2dBackground(RawCs2dMap rawCs2dMap)
	{
		this.scroll_map_like_tiles = rawCs2dMap.scroll_map_like_tiles;
		this.filename_of_map_background_image = rawCs2dMap.filename_of_map_background_image;
		this.background_scroll_x_speed = rawCs2dMap.background_scroll_x_speed;
		this.background_scroll_y_speed = rawCs2dMap.background_scroll_y_speed;
		this.map_background_color_red = rawCs2dMap.map_background_color_red;
		this.map_background_color_green = rawCs2dMap.map_background_color_green;
		this.map_background_color_blue = rawCs2dMap.map_background_color_blue;
	}

	@Override
	public void provide(RawCs2dMap rawCs2dMap)
	{
		rawCs2dMap.filename_of_map_background_image = filename_of_map_background_image;
		rawCs2dMap.background_scroll_x_speed = background_scroll_x_speed;
		rawCs2dMap.background_scroll_y_speed = background_scroll_y_speed;
		rawCs2dMap.map_background_color_red = map_background_color_red;
		rawCs2dMap.map_background_color_green = map_background_color_green;
		rawCs2dMap.map_background_color_blue = map_background_color_blue;
	}

	public boolean isScrollingMapLikeTiles()
	{
		return scroll_map_like_tiles.value;
	}

	public void setScrollMapLikeTiles(boolean value)
	{
		this.scroll_map_like_tiles.value = value;
	}

	public String getFilename()
	{
		return filename_of_map_background_image;
	}

	public void setFilename(String filename)
	{
		this.filename_of_map_background_image = filename;
	}

	public void setScroll(Point point)
	{
		setScroll(point.x, point.y);
	}

	public Point getScroll()
	{
		return new Point(background_scroll_x_speed, background_scroll_y_speed);
	}

	public void setScroll(int x, int y)
	{
		this.background_scroll_x_speed = x;
		this.background_scroll_y_speed = y;
	}

	public Color getColor()
	{
		return new Color(map_background_color_red.getInt(), map_background_color_green.getInt(), map_background_color_blue.getInt());
	}

	public void setColor(Color color)
	{
		this.map_background_color_red = new RawByte(color.getRed());
		this.map_background_color_green = new RawByte(color.getGreen());
		this.map_background_color_blue = new RawByte(color.getBlue());
	}
}
