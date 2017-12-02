package net.ddns.endercrypt.cs2dmap.library.map.obj.entity.type.env;

import net.ddns.endercrypt.cs2dmap.library.map.obj.entity.Cs2dEntity;
import net.ddns.endercrypt.cs2dmap.library.map.obj.entity.Cs2dEntityUtil;
import net.ddns.endercrypt.cs2dmap.library.map.obj.entity.EntityType;
import net.ddns.endercrypt.cs2dmap.library.raw.RawCs2dEntity;

@EntityType(25)
public class Env_Breakable extends Cs2dEntity
{
	public Env_Breakable()
	{
		super();
	}

	public Env_Breakable(RawCs2dEntity rawCs2dEntity)
	{
		super(rawCs2dEntity);
	}

	public void setFrame(int value)
	{
		Cs2dEntityUtil.verifyFrame(value);
		setIntSetting(0, value);
	}

	public void setHealth(int value)
	{
		Cs2dEntityUtil.verifyMinimum(value, 0);
		setIntSetting(1, value);
	}

	public void setMaterial(Material value)
	{
		setIntSetting(2, value.ordinal());
	}

	public void setExplode(boolean value)
	{
		setIntSetting(3, value ? 1 : 0);
	}

	public void setExplosionRange(int value)
	{
		Cs2dEntityUtil.verifyMinimum(value, 0);
		setIntSetting(4, value);
	}

	public void setExplosionPower(int value)
	{
		Cs2dEntityUtil.verifyMinimum(value, 0);
		setIntSetting(5, value);
	}

	public void setShadowType(ShadowType value)
	{
		setIntSetting(6, value.ordinal());
	}

	public void setTransparency(double value)
	{
		Cs2dEntityUtil.verifyOneRange(value);
		setStringSetting(0, String.valueOf(value));
	}

	public static enum Material
	{
		WOOD,
		STONE,
		METAL,
		FLESH,
		GLASS,
		NOTHING;
	}

	public static enum ShadowType
	{
		WALL,
		NONE,
		OBSTACLE;
	}
}
