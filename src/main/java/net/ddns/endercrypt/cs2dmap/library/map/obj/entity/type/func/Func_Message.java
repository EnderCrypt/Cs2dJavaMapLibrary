package net.ddns.endercrypt.cs2dmap.library.map.obj.entity.type.func;

import net.ddns.endercrypt.cs2dmap.library.map.obj.entity.Cs2dEntity;
import net.ddns.endercrypt.cs2dmap.library.map.obj.entity.Cs2dEntityUtil;
import net.ddns.endercrypt.cs2dmap.library.map.obj.entity.EntityType;
import net.ddns.endercrypt.cs2dmap.library.raw.RawCs2dEntity;

@EntityType(72)
public class Func_Message extends Cs2dEntity
{
	public Func_Message()
	{
		super();
	}

	public Func_Message(RawCs2dEntity rawCs2dEntity)
	{
		super(rawCs2dEntity);
	}

	public void setDisplayTime(int value)
	{
		Cs2dEntityUtil.verifyMinimum(value, 0);
		setIntSetting(0, value);
	}

	public void setPosition(Position value)
	{
		setIntSetting(1, value);
	}

	public void setRed(int value)
	{
		Cs2dEntityUtil.verifyColor(value);
		setIntSetting(2, value);
	}

	public void setGreen(int value)
	{
		Cs2dEntityUtil.verifyColor(value);
		setIntSetting(3, value);
	}

	public void setBlue(int value)
	{
		Cs2dEntityUtil.verifyColor(value);
		setIntSetting(4, value);
	}

	public void setMessage(String value)
	{
		setStringSetting(0, value);
	}

	public static enum Position
	{
		CENTER,
		LEFT_CHAT;
	}

}
