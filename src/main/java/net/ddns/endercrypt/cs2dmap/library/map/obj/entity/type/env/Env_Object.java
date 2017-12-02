package net.ddns.endercrypt.cs2dmap.library.map.obj.entity.type.env;

import net.ddns.endercrypt.cs2dmap.library.map.obj.entity.Cs2dEntity;
import net.ddns.endercrypt.cs2dmap.library.map.obj.entity.Cs2dEntityUtil;
import net.ddns.endercrypt.cs2dmap.library.map.obj.entity.EntityType;
import net.ddns.endercrypt.cs2dmap.library.raw.RawCs2dEntity;

@EntityType(29)
public class Env_Object extends Cs2dEntity
{
	public Env_Object()
	{
		super();
	}

	public Env_Object(RawCs2dEntity rawCs2dEntity)
	{
		super(rawCs2dEntity);
	}

	public void setObjectType(ObjectType value)
	{
		setIntSetting(0, value.ordinal());
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

	public void setRotation(int value)
	{
		Cs2dEntityUtil.verifyAngle(value);
		setIntSetting(4, value);
	}

	public void setSize(double value)
	{
		Cs2dEntityUtil.verifyRange(value, 0.1, 2.0);
		setStringSetting(0, String.valueOf(value));
	}

	public void setTransparency(double value)
	{
		Cs2dEntityUtil.verifyOneRange(value);
		setStringSetting(1, String.valueOf(value));
	}

	public static enum ObjectType
	{
		PALM,
		TREE,
		ALARM,
		SINK,
		TOILET,
		STREET_LIGHT,
		STREET_LIGHT_FLICKER;
	}
}
