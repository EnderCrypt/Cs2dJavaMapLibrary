package net.ddns.endercypt.cs2dmap.library.map.obj.entity.type.trigger;

import net.ddns.endercypt.cs2dmap.library.map.obj.entity.Cs2dEntity;
import net.ddns.endercypt.cs2dmap.library.map.obj.entity.EntityType;
import net.ddns.endercypt.cs2dmap.library.raw.RawCs2dEntity;

@EntityType(91)
public class Trigger_Move extends Cs2dEntity
{
	public Trigger_Move()
	{
		super();
	}

	public Trigger_Move(RawCs2dEntity rawCs2dEntity)
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
