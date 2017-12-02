package net.ddns.endercrypt.cs2dmap.library.map.obj.entity.type.info;

import net.ddns.endercrypt.cs2dmap.library.map.obj.entity.Cs2dEntity;
import net.ddns.endercrypt.cs2dmap.library.map.obj.entity.Cs2dEntityUtil;
import net.ddns.endercrypt.cs2dmap.library.map.obj.entity.EntityType;
import net.ddns.endercrypt.cs2dmap.library.raw.RawCs2dEntity;

@EntityType(9)
public class Info_Storm extends Cs2dEntity
{
	public Info_Storm()
	{
		super();
	}

	public Info_Storm(RawCs2dEntity rawCs2dEntity)
	{
		super(rawCs2dEntity);
	}

	public void setDirection(int value)
	{
		Cs2dEntityUtil.verifyAngle(value);
		setIntSetting(0, value);
	}

	public void setSpeed(int value)
	{
		setIntSetting(1, value);
	}

	public void setAnimationSpeed(int value)
	{
		Cs2dEntityUtil.verifyMinimum(value, 1); // works with 0, but makes no sense, so im limiting it to min 1
		setIntSetting(2, value);
	}
}
