package net.ddns.endercypt.cs2dmap.library.map.obj.entity.type.info;

import net.ddns.endercypt.cs2dmap.library.map.obj.entity.Cs2dEntity;
import net.ddns.endercypt.cs2dmap.library.map.obj.entity.EntityType;
import net.ddns.endercypt.cs2dmap.library.raw.RawCs2dEntity;

@EntityType(6)
public class Info_NoFOW extends Cs2dEntity
{
	public Info_NoFOW()
	{
		super();
	}

	public Info_NoFOW(RawCs2dEntity rawCs2dEntity)
	{
		super(rawCs2dEntity);
	}
}
