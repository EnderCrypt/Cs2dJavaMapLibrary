package net.ddns.endercrypt.cs2dmap.library.map.obj.entity.type.env;

import net.ddns.endercrypt.cs2dmap.library.map.obj.entity.Cs2dEntity;
import net.ddns.endercrypt.cs2dmap.library.map.obj.entity.Cs2dEntityUtil;
import net.ddns.endercrypt.cs2dmap.library.map.obj.entity.EntityType;
import net.ddns.endercrypt.cs2dmap.library.raw.RawCs2dEntity;

@EntityType(22)
public class Env_Sprite extends Cs2dEntity
{
	public Env_Sprite()
	{
		super();
	}

	public Env_Sprite(RawCs2dEntity rawCs2dEntity)
	{
		super(rawCs2dEntity);
	}

	public void setXSize(int value)
	{
		setIntSetting(0, value);
	}

	public void setYSize(int value)
	{
		setIntSetting(1, value);
	}

	public void setXOffset(int value)
	{
		setIntSetting(2, value);
	}

	public void setYOffset(int value)
	{
		setIntSetting(3, value);
	}

	public void setRotation(int value)
	{
		Cs2dEntityUtil.verifyAngle(value);
		setIntSetting(4, value);
	}

	public void setRed(int value)
	{
		Cs2dEntityUtil.verifyColor(value);
		setIntSetting(5, value);
	}

	public void setGreen(int value)
	{
		Cs2dEntityUtil.verifyColor(value);
		setIntSetting(6, value);
	}

	public void setBlue(int value)
	{
		Cs2dEntityUtil.verifyColor(value);
		setIntSetting(7, value);
	}

	public void setFxMode(int value)
	{
		setIntSetting(8, value);
	}

	public void setBlendMode(BlendMode value)
	{
		setIntSetting(9, value.ordinal() + 1);
	}

	public void setImageFilePath(String value)
	{
		setStringSetting(0, value);
	}

	public void setTransparency(double value)
	{
		Cs2dEntityUtil.verifyOneRange(value);
		setStringSetting(1, String.valueOf(value));
	}

	public void setMask(int value)
	{
		setStringSetting(2, String.valueOf(value));
	}

	public void setRotationSpeed(int value)
	{
		setStringSetting(3, String.valueOf(value));
	}

	public void setSpriteCoversPlayers(boolean value)
	{
		setStringSetting(4, value ? "1" : "");
	}

	public void setHideIfNightvision(boolean value)
	{
		setStringSetting(5, value ? "1" : "");
	}

	public static enum BlendMode
	{
		SOLID,
		MASKED,
		LIGHT,
		SHADE,
		AUTO,
		GRAYSCALE;
	}
}
