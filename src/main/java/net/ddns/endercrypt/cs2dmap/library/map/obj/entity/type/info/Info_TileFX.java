package net.ddns.endercrypt.cs2dmap.library.map.obj.entity.type.info;

import net.ddns.endercrypt.cs2dmap.library.map.obj.entity.Cs2dEntity;
import net.ddns.endercrypt.cs2dmap.library.map.obj.entity.Cs2dEntityUtil;
import net.ddns.endercrypt.cs2dmap.library.map.obj.entity.EntityType;
import net.ddns.endercrypt.cs2dmap.library.raw.RawCs2dEntity;

@EntityType(10)
public class Info_TileFX extends Cs2dEntity
{
	public Info_TileFX()
	{
		super();
	}

	public Info_TileFX(RawCs2dEntity rawCs2dEntity)
	{
		super(rawCs2dEntity);
	}

	public void setFrame(int value)
	{
		Cs2dEntityUtil.verifyFrame(value);
		setIntSetting(0, value);
	}

	public void setEffect(Effect value)
	{
		setIntSetting(1, value.ordinal());
	}

	public Effect getEffect()
	{
		return Effect.values()[getIntSetting(1)];
	}

	public void setXSpeed(int value)
	{
		setIntSetting(2, value);
	}

	public int getXSpeed()
	{
		return getIntSetting(2);
	}

	public void setYSpeed(int value)
	{
		setIntSetting(3, value);
	}

	public int getYSpeed()
	{
		return getIntSetting(3);
	}

	public static enum Effect
	{
		SCROLLING,
		DISTORTION_1,
		DISTORTION_2,
		DISTORTION_3,
		WAVES_1,
		WAVES_2,
		WAVES_3;
	}
}
