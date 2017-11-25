package net.ddns.endercypt.cs2dmap.library.map.obj.entity.type.info;

import net.ddns.endercypt.cs2dmap.library.map.obj.entity.Cs2dEntity;
import net.ddns.endercypt.cs2dmap.library.map.obj.entity.Cs2dEntityUtil;
import net.ddns.endercypt.cs2dmap.library.map.obj.entity.EntityType;
import net.ddns.endercypt.cs2dmap.library.raw.RawCs2dEntity;

@EntityType(5)
public class Info_BombSpot extends Cs2dEntity
{
	public Info_BombSpot()
	{
		super();
	}

	public Info_BombSpot(RawCs2dEntity rawCs2dEntity)
	{
		super(rawCs2dEntity);
	}

	/**
	 * @param value (pixels)
	 */
	public void setExplosionRange(int value)
	{
		Cs2dEntityUtil.verifyMinimum(value, 0);
		setIntSetting(0, value);
	}
}
