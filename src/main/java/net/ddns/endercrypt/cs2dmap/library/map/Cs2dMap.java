package net.ddns.endercrypt.cs2dmap.library.map;

import net.ddns.endercrypt.cs2dmap.library.map.sub.Cs2dBackground;
import net.ddns.endercrypt.cs2dmap.library.map.sub.Cs2dEntities;
import net.ddns.endercrypt.cs2dmap.library.map.sub.Cs2dMapArray;
import net.ddns.endercrypt.cs2dmap.library.map.sub.Cs2dMetadata;
import net.ddns.endercrypt.cs2dmap.library.map.sub.Cs2dTiles;
import net.ddns.endercrypt.cs2dmap.library.raw.RawCs2dMap;
import net.ddns.endercrypt.cs2dmap.library.raw.RawData;

public class Cs2dMap implements RawData<RawCs2dMap>
{
	private RawCs2dMap rawCs2dMap;

	public Cs2dMap()
	{
		this(new RawCs2dMap());
	}

	public Cs2dMap(RawCs2dMap rawCs2dMap)
	{
		this.rawCs2dMap = rawCs2dMap;
	}

	@Override
	public RawCs2dMap getRaw()
	{
		return rawCs2dMap;
	}

	public void update(Cs2dDataProvider cs2dMapDataContainer)
	{
		cs2dMapDataContainer.provide(getRaw());
	}

	public Cs2dMetadata getMetadata()
	{
		return new Cs2dMetadata(getRaw());
	}

	public Cs2dBackground getBackground()
	{
		return new Cs2dBackground(getRaw());
	}

	public Cs2dMapArray getMapArray()
	{
		return new Cs2dMapArray(getRaw());
	}

	public Cs2dEntities getEntities()
	{
		return new Cs2dEntities(getRaw());
	}

	public Cs2dTiles getTiles()
	{
		return new Cs2dTiles(getRaw());
	}
}
