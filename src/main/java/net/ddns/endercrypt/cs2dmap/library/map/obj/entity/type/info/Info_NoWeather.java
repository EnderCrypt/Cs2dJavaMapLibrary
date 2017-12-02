package net.ddns.endercrypt.cs2dmap.library.map.obj.entity.type.info;

import net.ddns.endercrypt.cs2dmap.library.map.obj.entity.Cs2dEntity;
import net.ddns.endercrypt.cs2dmap.library.map.obj.entity.Cs2dEntityUtil;
import net.ddns.endercrypt.cs2dmap.library.map.obj.entity.EntityType;
import net.ddns.endercrypt.cs2dmap.library.raw.RawCs2dEntity;

@EntityType(80)
public class Info_NoWeather extends Cs2dEntity
{
	public Info_NoWeather()
	{
		super();
	}

	public Info_NoWeather(RawCs2dEntity rawCs2dEntity)
	{
		super(rawCs2dEntity);
	}

	public void setWidth(int value)
	{
		Cs2dEntityUtil.verifyMinimum(value, 1);
		setIntSetting(0, value);
	}

	public void setHeight(int value)
	{
		Cs2dEntityUtil.verifyMinimum(value, 1);
		setIntSetting(1, value);
	}
}
