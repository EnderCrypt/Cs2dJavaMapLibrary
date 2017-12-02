package net.ddns.endercrypt.cs2dmap.library.map.obj.entity.type.env;

import net.ddns.endercrypt.cs2dmap.library.map.obj.entity.Cs2dEntity;
import net.ddns.endercrypt.cs2dmap.library.map.obj.entity.EntityType;
import net.ddns.endercrypt.cs2dmap.library.raw.RawCs2dEntity;

@EntityType(28)
public class Env_Image extends Cs2dEntity
{
	public Env_Image()
	{
		super();
	}

	public Env_Image(RawCs2dEntity rawCs2dEntity)
	{
		super(rawCs2dEntity);
	}

	public void setXOffset(int value)
	{
		setIntSetting(0, value);
	}

	public void setYOffset(int value)
	{
		setIntSetting(1, value);
	}

	public void setCoverPlayers(boolean value)
	{
		setIntSetting(2, value ? 1 : 0);
	}

	public void setImageFilePath(String value)
	{
		setStringSetting(0, value);
	}
}
