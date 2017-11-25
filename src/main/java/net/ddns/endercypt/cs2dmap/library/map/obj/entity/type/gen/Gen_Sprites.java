package net.ddns.endercypt.cs2dmap.library.map.obj.entity.type.gen;

import net.ddns.endercypt.cs2dmap.library.map.obj.entity.Cs2dEntity;
import net.ddns.endercypt.cs2dmap.library.map.obj.entity.Cs2dEntityUtil;
import net.ddns.endercypt.cs2dmap.library.map.obj.entity.EntityType;
import net.ddns.endercypt.cs2dmap.library.raw.RawCs2dEntity;

@EntityType(51)
public class Gen_Sprites extends Cs2dEntity
{
	public Gen_Sprites()
	{
		super();
	}

	public Gen_Sprites(RawCs2dEntity rawCs2dEntity)
	{
		super(rawCs2dEntity);
	}

	public void setFrame(int value)
	{
		Cs2dEntityUtil.verifyRange(value, 0, 15); // gfx/fragmets.bmp 4x4
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

	public void setXSpeed(int min, int max)
	{
		setXSpeedMin(min);
		setXSpeedMax(max);
	}

	public void setXSpeedMin(int value)
	{
		setIntSetting(4, value);
	}

	public void setXSpeedMax(int value)
	{
		setIntSetting(5, value);
	}

	public void setYSpeed(int min, int max)
	{
		setYSpeedMin(min);
		setYSpeedMax(max);
	}

	public void setYSpeedMin(int value)
	{
		setIntSetting(6, value);
	}

	public void setYSpeedMax(int value)
	{
		setIntSetting(7, value);
	}

	public void setSpriteType(int value)
	{
		// TODO: limitation
		setIntSetting(8, value);
	}

	public void setTransparency(double value)
	{
		Cs2dEntityUtil.verifyOneRange(value);
		setStringSetting(0, String.valueOf(value));
	}
}
