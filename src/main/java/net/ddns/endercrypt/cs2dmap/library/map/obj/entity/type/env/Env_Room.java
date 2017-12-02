package net.ddns.endercrypt.cs2dmap.library.map.obj.entity.type.env;

import net.ddns.endercrypt.cs2dmap.library.map.obj.entity.Cs2dEntity;
import net.ddns.endercrypt.cs2dmap.library.map.obj.entity.Cs2dEntityUtil;
import net.ddns.endercrypt.cs2dmap.library.map.obj.entity.EntityType;
import net.ddns.endercrypt.cs2dmap.library.raw.RawCs2dEntity;

@EntityType(32)
public class Env_Room extends Cs2dEntity
{
	public Env_Room()
	{
		super();
	}

	public Env_Room(RawCs2dEntity rawCs2dEntity)
	{
		super(rawCs2dEntity);
	}

	public void setWidth(int value)
	{
		setIntSetting(0, value);
	}

	public void setHeight(int value)
	{
		setIntSetting(1, value);
	}

	/**
	 * @param value (pixels)
	 */
	public void setShadowHeight(int value)
	{
		setIntSetting(2, value);
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

	public void setDaylightInfluencesColor(boolean value)
	{
		setIntSetting(6, value ? 1 : 0);
	}

	public void setDarkenAtEdges(boolean value)
	{
		setIntSetting(7, value ? 1 : 0);
	}

	public void setSharpRoomEdges(boolean value)
	{
		setIntSetting(8, value ? 1 : 0);
	}

	public void setShadowLayer(int value)
	{
		setIntSetting(9, value);
	}

	public void setOffsetX(int value)
	{
		setStringSetting(0, String.valueOf(value));
	}

	public void setOffsetY(int value)
	{
		setStringSetting(1, String.valueOf(value));
	}

	public void setTransparency(double value)
	{
		Cs2dEntityUtil.verifyOneRange(value);
		value = 1.0 - value; // cs2d reverses it (1 = 0 and 0 = 1) pressumably because of backwards compatibility
		setStringSetting(2, String.valueOf(value));
	}
}
