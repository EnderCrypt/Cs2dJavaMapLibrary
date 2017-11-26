package net.ddns.endercypt.cs2dmap.library.map.obj.entity.type.trigger;

import net.ddns.endercypt.cs2dmap.library.map.obj.entity.Cs2dEntity;
import net.ddns.endercypt.cs2dmap.library.map.obj.entity.Cs2dEntityUtil;
import net.ddns.endercypt.cs2dmap.library.map.obj.entity.EntityType;
import net.ddns.endercypt.cs2dmap.library.raw.RawCs2dEntity;

@EntityType(94)
public class Trigger_Delay extends Cs2dEntity
{
	public Trigger_Delay()
	{
		super();
	}

	public Trigger_Delay(RawCs2dEntity rawCs2dEntity)
	{
		super(rawCs2dEntity);
	}

	// TODO: test that milliseconds/seconds are detected properly
	/**
	 * @param value (seconds)
	 */
	public void setDelay(double value)
	{
		Cs2dEntityUtil.verifyMinimum(value, 0);
		int milliseconds = (int) (value * 1000);
		if (milliseconds % 1000 == 0)
		{// second
			setIntSetting(0, (int) value);
			setIntSetting(1, 0);
		}
		else
		{ // millisecond
			setIntSetting(0, 0);
			setIntSetting(1, milliseconds);
		}
	}
}
