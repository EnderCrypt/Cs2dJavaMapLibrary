package net.ddns.endercrypt.cs2dmap.library.map.obj.entity.type.env;

import net.ddns.endercrypt.cs2dmap.library.map.obj.entity.Cs2dEntity;
import net.ddns.endercrypt.cs2dmap.library.map.obj.entity.Cs2dEntityUtil;
import net.ddns.endercrypt.cs2dmap.library.map.obj.entity.EntityType;
import net.ddns.endercrypt.cs2dmap.library.raw.RawCs2dEntity;

@EntityType(33)
public class Env_Light extends Cs2dEntity
{
	public Env_Light()
	{
		super();
	}

	public Env_Light(RawCs2dEntity rawCs2dEntity)
	{
		super(rawCs2dEntity);
	}

	public void setLightRange(int value)
	{
		Cs2dEntityUtil.verifyRange(value, 0, 300);
		setIntSetting(0, value);
	}

	public void setRed(int value)
	{
		Cs2dEntityUtil.verifyColor(value);
		setIntSetting(1, value);
	}

	public void setGreen(int value)
	{
		Cs2dEntityUtil.verifyColor(value);
		setIntSetting(2, value);
	}

	public void setBlue(int value)
	{
		Cs2dEntityUtil.verifyColor(value);
		setIntSetting(3, value);
	}

	// TODO: implement Int[7] and Int[8]

	public void setStartAngle(int value)
	{
		Cs2dEntityUtil.verifyRange(value, 0, 359);
		setIntSetting(4, value);
	}

	public void setEndAngle(int value)
	{
		Cs2dEntityUtil.verifyRange(value, 0, 359);
		setIntSetting(5, value);
	}

	public void setRotationSpeed(int value)
	{
		setIntSetting(6, value);
	}

	public void setAdditive(double value)
	{
		Cs2dEntityUtil.verifyOneRange(value);
		setStringSetting(0, String.valueOf(value));
	}

	public void setXOffset(int value)
	{
		setStringSetting(1, String.valueOf(value));
	}

	public void setYOffset(int value)
	{
		setStringSetting(2, String.valueOf(value));
	}

	public void setRotationOffset(int value)
	{
		setStringSetting(3, String.valueOf(value));
	}
}
