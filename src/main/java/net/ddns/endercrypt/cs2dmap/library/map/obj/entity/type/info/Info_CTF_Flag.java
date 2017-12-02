package net.ddns.endercrypt.cs2dmap.library.map.obj.entity.type.info;

import net.ddns.endercrypt.cs2dmap.library.map.obj.entity.Cs2dEntity;
import net.ddns.endercrypt.cs2dmap.library.map.obj.entity.EntityType;
import net.ddns.endercrypt.cs2dmap.library.raw.RawCs2dEntity;

@EntityType(15)
public class Info_CTF_Flag extends Cs2dEntity
{
	public Info_CTF_Flag()
	{
		super();
	}

	public Info_CTF_Flag(RawCs2dEntity rawCs2dEntity)
	{
		super(rawCs2dEntity);
	}

	public void setFlagTeam(Team value)
	{
		setIntSetting(0, value.ordinal());
	}

	public static enum Team
	{
		TERRORIST,
		COUNTER_TERRORIST;
	}
}
