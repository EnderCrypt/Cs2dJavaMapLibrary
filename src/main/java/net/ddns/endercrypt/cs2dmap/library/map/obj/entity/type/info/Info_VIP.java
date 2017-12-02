package net.ddns.endercrypt.cs2dmap.library.map.obj.entity.type.info;

import net.ddns.endercrypt.cs2dmap.library.map.obj.entity.Cs2dEntity;
import net.ddns.endercrypt.cs2dmap.library.map.obj.entity.Cs2dEntityUtil;
import net.ddns.endercrypt.cs2dmap.library.map.obj.entity.EntityType;
import net.ddns.endercrypt.cs2dmap.library.raw.RawCs2dEntity;

@EntityType(2)
public class Info_VIP extends Cs2dEntity
{
	public Info_VIP()
	{
		super();
	}

	public Info_VIP(RawCs2dEntity rawCs2dEntity)
	{
		super(rawCs2dEntity);
	}

	public void setSpawnRotation(int value)
	{
		Cs2dEntityUtil.verifyAngle(value);
		setIntSetting(0, value);
	}

	public int getSpawnRotation()
	{
		return getIntSetting(0);
	}
}
