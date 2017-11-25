package net.ddns.endercypt.cs2dmap.library.map.obj.entity.type.env;

import net.ddns.endercypt.cs2dmap.library.map.obj.entity.Cs2dEntity;
import net.ddns.endercypt.cs2dmap.library.map.obj.entity.Cs2dEntityUtil;
import net.ddns.endercypt.cs2dmap.library.map.obj.entity.EntityType;
import net.ddns.endercypt.cs2dmap.library.raw.RawCs2dEntity;

@EntityType(23)
public class Env_Sound extends Cs2dEntity
{
	public Env_Sound()
	{
		super();
	}

	public Env_Sound(RawCs2dEntity rawCs2dEntity)
	{
		super(rawCs2dEntity);
	}

	public void setPlayOnlyWhenTriggered(boolean value)
	{
		setIntSetting(0, value ? 1 : 0);
	}

	public void setLoop(boolean value)
	{
		setIntSetting(1, value ? 0 : 1);
	}

	public void setPlayEverywhere(boolean value)
	{
		setIntSetting(2, value ? 1 : 0);
	}

	public void setSoundFilePath(String value)
	{
		setStringSetting(0, value);
	}

	public void setVolume(double value)
	{
		Cs2dEntityUtil.verifyOneRange(value);
		setStringSetting(0, String.valueOf(value));
	}
}
