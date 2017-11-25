package net.ddns.endercypt.cs2dmap.library.map.obj.entity.type.env;

import net.ddns.endercypt.cs2dmap.library.map.obj.entity.Cs2dEntity;
import net.ddns.endercypt.cs2dmap.library.map.obj.entity.Cs2dEntityUtil;
import net.ddns.endercypt.cs2dmap.library.map.obj.entity.EntityType;
import net.ddns.endercypt.cs2dmap.library.raw.RawCs2dEntity;

@EntityType(26)
public class Env_Explode extends Cs2dEntity
{
	public Env_Explode()
	{
		super();
	}

	public Env_Explode(RawCs2dEntity rawCs2dEntity)
	{
		super(rawCs2dEntity);
	}

	public void setExplosionRange(int value)
	{
		Cs2dEntityUtil.verifyMinimum(value, 0);
		setIntSetting(0, value);
	}

	public void setExplosionPower(int value)
	{
		Cs2dEntityUtil.verifyMinimum(value, 0);
		setIntSetting(1, value);
	}

	public void setExplodeOnMovement(boolean value)
	{
		setIntSetting(2, value ? 0 : 1);
	}
}
