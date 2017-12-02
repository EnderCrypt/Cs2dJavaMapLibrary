package net.ddns.endercrypt.cs2dmap.library.map.obj.entity.type.env;

import net.ddns.endercrypt.cs2dmap.library.map.obj.entity.Cs2dEntity;
import net.ddns.endercrypt.cs2dmap.library.map.obj.entity.Cs2dEntityUtil;
import net.ddns.endercrypt.cs2dmap.library.map.obj.entity.EntityType;
import net.ddns.endercrypt.cs2dmap.library.raw.RawCs2dEntity;

@EntityType(27)
public class Env_Hurt extends Cs2dEntity
{
	public Env_Hurt()
	{
		super();
	}

	public Env_Hurt(RawCs2dEntity rawCs2dEntity)
	{
		super(rawCs2dEntity);
	}

	public void setDamage(int value)
	{
		Cs2dEntityUtil.verifyMinimum(value, 0);
		setIntSetting(0, value);
	}

	public void setDamageOn(DamageOn value)
	{
		setIntSetting(1, value.ordinal());
	}

	public void setWidth(int value)
	{
		Cs2dEntityUtil.verifyMinimum(value, 1);
		setIntSetting(2, value);
	}

	public void setHeight(int value)
	{
		Cs2dEntityUtil.verifyMinimum(value, 1);
		setIntSetting(3, value);
	}

	public static enum DamageOn
	{
		TIME,
		MOVEMENT,
		BOTH;
	}
}
