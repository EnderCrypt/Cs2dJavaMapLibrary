package net.ddns.endercrypt.cs2dmap.library.map.obj.entity.type.info;

import net.ddns.endercrypt.cs2dmap.library.map.obj.entity.Cs2dEntity;
import net.ddns.endercrypt.cs2dmap.library.map.obj.entity.EntityType;
import net.ddns.endercrypt.cs2dmap.library.raw.RawCs2dEntity;

@EntityType(14)
public class Info_Quake extends Cs2dEntity
{
	public Info_Quake()
	{
		super();
	}

	public Info_Quake(RawCs2dEntity rawCs2dEntity)
	{
		super(rawCs2dEntity);
	}

	public void setQuakePower(int value)
	{
		setIntSetting(0, value);
	}
}
