package net.ddns.endercypt.cs2dmap.library.map.obj.tile.modifier;

import net.ddns.endercypt.cs2dmap.library.raw.RawCs2dTile;

public class ColorTileModifier implements TileModifier
{
	private int red;
	private int green;
	private int blue;
	private int overlayFrame;

	public ColorTileModifier(int red, int green, int blue, int overlayFrame)
	{
		this.red = red;
		this.green = green;
		this.blue = blue;
		this.overlayFrame = overlayFrame;
	}

	@Override
	public void update(RawCs2dTile rawCs2dTile)
	{
		rawCs2dTile.tile_modifier.setNumericFlag(128, true);

		rawCs2dTile.tile_color_red.set(red);
		rawCs2dTile.tile_color_green.set(green);
		rawCs2dTile.tile_color_blue.set(blue);
		rawCs2dTile.tile_overlay_frame.set(overlayFrame);
	}
}
