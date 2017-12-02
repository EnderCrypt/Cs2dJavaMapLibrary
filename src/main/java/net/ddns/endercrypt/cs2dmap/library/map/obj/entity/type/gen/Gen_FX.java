package net.ddns.endercrypt.cs2dmap.library.map.obj.entity.type.gen;

import net.ddns.endercrypt.cs2dmap.library.map.obj.entity.Cs2dEntity;
import net.ddns.endercrypt.cs2dmap.library.map.obj.entity.Cs2dEntityUtil;
import net.ddns.endercrypt.cs2dmap.library.map.obj.entity.EntityType;
import net.ddns.endercrypt.cs2dmap.library.raw.RawCs2dEntity;

@EntityType(53)
public class Gen_FX extends Cs2dEntity
{
	public Gen_FX()
	{
		super();
	}

	public Gen_FX(RawCs2dEntity rawCs2dEntity)
	{
		super(rawCs2dEntity);
	}

	public void setEffectType(EffectType effectType)
	{
		setIntSetting(0, effectType);
	}

	public void setXRange(int min, int max)
	{
		setXMinRange(min);
		setXMaxRange(max);
	}

	public void setXMinRange(int value)
	{
		setIntSetting(1, value);
	}

	public void setXMaxRange(int value)
	{
		setIntSetting(2, value);
	}

	public void setYRange(int min, int max)
	{
		setYMinRange(min);
		setYMaxRange(max);
	}

	public void setYMinRange(int value)
	{
		setIntSetting(3, value);
	}

	public void setYMaxRange(int value)
	{
		setIntSetting(4, value);
	}

	public void setSpawnRate(int value)
	{
		Cs2dEntityUtil.verifyMinimum(value, 25);
		setIntSetting(5, value);
	}

	public static enum EffectType
	{
		WAVES,
		SMOKE,
		FIRE,
		STEAM;
	}
}
