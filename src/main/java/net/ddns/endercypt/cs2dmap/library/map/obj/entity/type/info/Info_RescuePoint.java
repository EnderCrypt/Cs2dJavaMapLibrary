package net.ddns.endercypt.cs2dmap.library.map.obj.entity.type.info;

import net.ddns.endercypt.cs2dmap.library.map.obj.entity.Cs2dEntity;
import net.ddns.endercypt.cs2dmap.library.map.obj.entity.EntityType;
import net.ddns.endercypt.cs2dmap.library.raw.RawCs2dEntity;

@EntityType(4)
public class Info_RescuePoint extends Cs2dEntity
{
	public Info_RescuePoint()
	{
		super();
	}

	public Info_RescuePoint(RawCs2dEntity rawCs2dEntity)
	{
		super(rawCs2dEntity);
	}
}
