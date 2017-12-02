package net.ddns.endercrypt.cs2dmap.library.map.obj.entity.type.info;

import net.ddns.endercrypt.cs2dmap.library.map.obj.entity.Cs2dEntity;
import net.ddns.endercrypt.cs2dmap.library.map.obj.entity.EntityType;
import net.ddns.endercrypt.cs2dmap.library.raw.RawCs2dEntity;

@EntityType(13)
public class Info_EscapePoint extends Cs2dEntity
{
	public Info_EscapePoint()
	{
		super();
	}

	public Info_EscapePoint(RawCs2dEntity rawCs2dEntity)
	{
		super(rawCs2dEntity);
	}
}
