package net.ddns.endercrypt.cs2dmap.library.map.obj.entity.type.trigger;

import net.ddns.endercrypt.cs2dmap.library.map.obj.entity.Cs2dEntity;
import net.ddns.endercrypt.cs2dmap.library.map.obj.entity.EntityType;
import net.ddns.endercrypt.cs2dmap.library.raw.RawCs2dEntity;

@EntityType(90)
public class Trigger_Start extends Cs2dEntity
{
	public Trigger_Start()
	{
		super();
	}

	public Trigger_Start(RawCs2dEntity rawCs2dEntity)
	{
		super(rawCs2dEntity);
	}
}
