package net.ddns.endercypt.cs2dmap.library.map.sub.array.impl;

import java.util.Objects;

import net.ddns.endercypt.cs2dmap.library.map.sub.array.ResizableArray;
import net.ddns.endercypt.cs2dmap.library.raw.RawCs2dMap;

public class TileHeightArray extends ResizableArray<Integer>
{
	public static final int MAX_HEIGHT = (int) Math.pow(2, 16) - 1; // length of unsigned short

	public TileHeightArray(RawCs2dMap rawCs2dMap)
	{
		super(Integer[]::new, () -> 0, rawCs2dMap);
	}

	@Override
	public Integer supplyElement(RawCs2dMap rawCs2dMap, int index)
	{
		return rawCs2dMap.tile_height_in_pixels[index];
	}

	@Override
	public void returnElement(RawCs2dMap rawCs2dMap, Integer element, int index)
	{
		rawCs2dMap.tile_height_in_pixels[index] = element;
	}

	@Override
	public void filter(Integer element)
	{
		Objects.requireNonNull(element);
		// 
		if (element < 0)
		{
			throw new IllegalArgumentException("size may not be less than 0");
		}
		if (element > MAX_HEIGHT) // limit to unsigned short
		{
			throw new IllegalArgumentException("size is limited to " + MAX_HEIGHT);
		}
	}
}
