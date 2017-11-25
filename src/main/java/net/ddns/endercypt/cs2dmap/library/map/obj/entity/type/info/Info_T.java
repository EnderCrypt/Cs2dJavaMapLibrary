package net.ddns.endercypt.cs2dmap.library.map.obj.entity.type.info;

import net.ddns.endercypt.cs2dmap.library.map.obj.entity.Cs2dEntity;
import net.ddns.endercypt.cs2dmap.library.map.obj.entity.Cs2dEntityUtil;
import net.ddns.endercypt.cs2dmap.library.map.obj.entity.EntityType;
import net.ddns.endercypt.cs2dmap.library.raw.RawCs2dEntity;

@EntityType(0)
public class Info_T extends Cs2dEntity
{
	public Info_T()
	{
		super();
	}

	public Info_T(RawCs2dEntity rawCs2dEntity)
	{
		super(rawCs2dEntity);
	}

	public void setSpawnRotation(int value)
	{
		Cs2dEntityUtil.verifyAngle(value);
		setIntSetting(0, value);
	}
}
