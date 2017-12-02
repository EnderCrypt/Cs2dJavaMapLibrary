package net.ddns.endercrypt.cs2dmap.library.map.sub.array.impl;

import java.util.Objects;

import net.ddns.endercrypt.cs2dmap.library.map.sub.array.ResizableArray;
import net.ddns.endercrypt.cs2dmap.library.map.sub.extra.tile.TileMode;
import net.ddns.endercrypt.cs2dmap.library.raw.RawCs2dMap;

public class TileModeArray extends ResizableArray<TileMode>
{
	public TileModeArray(RawCs2dMap rawCs2dMap)
	{
		super(TileMode[]::new, () -> TileMode.DEFAULT, rawCs2dMap);
	}

	@Override
	public TileMode supplyElement(RawCs2dMap rawCs2dMap, int index)
	{
		int mode = rawCs2dMap.tile_modes[index].getInt();
		return TileMode.lookup(mode).get();
	}

	@Override
	public void returnElement(RawCs2dMap rawCs2dMap, TileMode element, int index)
	{
		int mode = element.getMode();
		rawCs2dMap.tile_modes[index].set(mode);
	}

	@Override
	public void filter(TileMode element)
	{
		Objects.requireNonNull(element);
	}
}
