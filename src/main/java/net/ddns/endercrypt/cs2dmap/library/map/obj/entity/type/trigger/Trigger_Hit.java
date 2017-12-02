package net.ddns.endercrypt.cs2dmap.library.map.obj.entity.type.trigger;

import net.ddns.endercrypt.cs2dmap.library.map.obj.entity.Cs2dEntity;
import net.ddns.endercrypt.cs2dmap.library.map.obj.entity.EntityType;
import net.ddns.endercrypt.cs2dmap.library.raw.RawCs2dEntity;

@EntityType(92)
public class Trigger_Hit extends Cs2dEntity
{
	public Trigger_Hit()
	{
		super();
	}

	public Trigger_Hit(RawCs2dEntity rawCs2dEntity)
	{
		super(rawCs2dEntity);
	}

	public void setTeam(Team value)
	{
		setIntSetting(0, value);
	}

	public static enum Team
	{
		EVERYONE,
		TERRORISTS,
		COUNTER_TERRORISTS;
	}
}
