package net.ddns.endercrypt.cs2dmap.library.map.obj.entity.type.info;

import net.ddns.endercrypt.cs2dmap.library.map.obj.entity.Cs2dEntity;
import net.ddns.endercrypt.cs2dmap.library.map.obj.entity.Cs2dEntityUtil;
import net.ddns.endercrypt.cs2dmap.library.map.obj.entity.EntityType;
import net.ddns.endercrypt.cs2dmap.library.raw.RawCs2dEntity;

@EntityType(8)
public class Info_Animation extends Cs2dEntity
{
	public Info_Animation()
	{
		super();
	}

	public Info_Animation(RawCs2dEntity rawCs2dEntity)
	{
		super(rawCs2dEntity);
	}

	public void setStartFrame(int value)
	{
		Cs2dEntityUtil.verifyFrame(value);
		setIntSetting(0, value);
	}

	public void setEndFrame(int value)
	{
		Cs2dEntityUtil.verifyFrame(value);
		setIntSetting(1, value);
	}

	public void setAnimationSpeed(int value)
	{
		Cs2dEntityUtil.verifyMinimum(value, 1); // works with 0, but makes no sense, so im limiting it to min 1
		setIntSetting(2, value);
	}
}
