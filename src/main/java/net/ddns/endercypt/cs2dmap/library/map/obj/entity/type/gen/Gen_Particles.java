package net.ddns.endercypt.cs2dmap.library.map.obj.entity.type.gen;

import java.awt.Color;

import net.ddns.endercypt.cs2dmap.library.map.obj.entity.Cs2dEntity;
import net.ddns.endercypt.cs2dmap.library.map.obj.entity.EntityType;
import net.ddns.endercypt.cs2dmap.library.raw.RawCs2dEntity;

@EntityType(50)
public class Gen_Particles extends Cs2dEntity
{
	public Gen_Particles()
	{
		super();
	}

	public Gen_Particles(RawCs2dEntity rawCs2dEntity)
	{
		super(rawCs2dEntity);
	}

	public void setLifetime(int min, int max)
	{
		setMinLifetime(min);
		setMaxLifetime(max);
	}

	public void setMinLifetime(int value)
	{
		setIntSetting(0, value);
	}

	public void setMaxLifetime(int value)
	{
		setIntSetting(1, value);
	}

	public void setXSpeed(int min, int max)
	{
		setXSpeedMin(min);
		setXSpeedMax(max);
	}

	public void setXSpeedMin(int value)
	{
		setIntSetting(2, value);
	}

	public void setXSpeedMax(int value)
	{
		setIntSetting(3, value);
	}

	public void setYSpeed(int min, int max)
	{
		setYSpeedMin(min);
		setYSpeedMax(max);
	}

	public void setYSpeedMin(int value)
	{
		setIntSetting(4, value);
	}

	public void setYSpeedMax(int value)
	{
		setIntSetting(5, value);
	}

	public void setColor(Color value)
	{
		setStringSetting(0, String.valueOf(value.getRGB()));
	}
}
