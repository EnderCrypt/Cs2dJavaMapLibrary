package net.ddns.endercrypt.cs2dmap.library.map.obj.entity.type.info;

import net.ddns.endercrypt.cs2dmap.library.map.obj.entity.Cs2dEntity;
import net.ddns.endercrypt.cs2dmap.library.map.obj.entity.Cs2dEntityUtil;
import net.ddns.endercrypt.cs2dmap.library.map.obj.entity.EntityType;
import net.ddns.endercrypt.cs2dmap.library.raw.RawCs2dEntity;

@EntityType(17)
public class Info_Dom_Point extends Cs2dEntity
{
	public Info_Dom_Point()
	{
		super();
	}

	public Info_Dom_Point(RawCs2dEntity rawCs2dEntity)
	{
		super(rawCs2dEntity);
	}

	public void setInitialState(InitialState value)
	{
		setIntSetting(0, value);
	}

	public void setPlayersRequiredToDominate(int value)
	{
		Cs2dEntityUtil.verifyRange(value, 1, 3);
		setIntSetting(1, value - 1);
	}

	public static enum InitialState
	{
		NOT_DOMINATED,
		TERRORIST_DOMINATED,
		COUNTER_TERRORIST_DOMINATED;
	}

}
