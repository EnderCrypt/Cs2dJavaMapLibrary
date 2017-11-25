package net.ddns.endercypt.cs2dmap.library.map.obj.entity.type.env;

import net.ddns.endercypt.cs2dmap.library.map.obj.entity.Cs2dEntity;
import net.ddns.endercypt.cs2dmap.library.map.obj.entity.Cs2dEntityUtil;
import net.ddns.endercypt.cs2dmap.library.map.obj.entity.EntityType;
import net.ddns.endercypt.cs2dmap.library.raw.RawCs2dEntity;

@EntityType(34)
public class Env_LightStripe extends Cs2dEntity
{
	public Env_LightStripe()
	{
		super();
	}

	public Env_LightStripe(RawCs2dEntity rawCs2dEntity)
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

	public void setDirection(Direction value)
	{
		setIntSetting(2, value.ordinal());
	}

	public void setRed(int value)
	{
		Cs2dEntityUtil.verifyColor(value);
		setIntSetting(3, value);
	}

	public void setGreen(int value)
	{
		Cs2dEntityUtil.verifyColor(value);
		setIntSetting(4, value);
	}

	public void setBlue(int value)
	{
		Cs2dEntityUtil.verifyColor(value);
		setIntSetting(5, value);
	}

	public static enum Direction
	{
		TOP,
		RIGHT,
		BOTTOM,
		LEFT;
	}
}
