package net.ddns.endercypt.cs2dmap.library.map.obj.entity.type.env;

import net.ddns.endercypt.cs2dmap.library.map.obj.entity.Cs2dEntity;
import net.ddns.endercypt.cs2dmap.library.map.obj.entity.Cs2dEntityUtil;
import net.ddns.endercypt.cs2dmap.library.map.obj.entity.EntityType;
import net.ddns.endercypt.cs2dmap.library.raw.RawCs2dEntity;

@EntityType(21)
public class Env_Item extends Cs2dEntity
{
	public Env_Item()
	{
		super();
	}

	public Env_Item(RawCs2dEntity rawCs2dEntity)
	{
		super(rawCs2dEntity);
	}

	// TODO: enum for all items

	public void setItem(int value)
	{
		Cs2dEntityUtil.verifyRange(value, 0, 100);
		setIntSetting(0, value);
	}

	public void setSpawnMode(SpawnMode value)
	{
		setIntSetting(1, value.ordinal());
	}

	public void setSpawnDelay(int value)
	{
		if (getIntSetting(1) != SpawnMode.EVERY_X_SECONDS.ordinal())
		{
			throw new IllegalArgumentException(SpawnMode.class.getSimpleName() + " needs to be set to " + SpawnMode.EVERY_X_SECONDS);
		}
		setIntSetting(2, value);
	}

	public static enum SpawnMode
	{
		NO_TIME,
		INSTANT_INFINITE,
		EVERY_X_SECONDS,
		ON_TRIGGER_ONLY;
	}
}
