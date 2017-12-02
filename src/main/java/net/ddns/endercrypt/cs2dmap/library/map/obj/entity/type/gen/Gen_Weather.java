package net.ddns.endercrypt.cs2dmap.library.map.obj.entity.type.gen;

import net.ddns.endercrypt.cs2dmap.library.map.obj.entity.Cs2dEntity;
import net.ddns.endercrypt.cs2dmap.library.map.obj.entity.Cs2dEntityUtil;
import net.ddns.endercrypt.cs2dmap.library.map.obj.entity.EntityType;
import net.ddns.endercrypt.cs2dmap.library.raw.RawCs2dEntity;

@EntityType(52)
public class Gen_Weather extends Cs2dEntity
{
	public Gen_Weather()
	{
		super();
	}

	public Gen_Weather(RawCs2dEntity rawCs2dEntity)
	{
		super(rawCs2dEntity);
	}

	public void setWeather(Weather value)
	{
		setIntSetting(0, value.ordinal());
	}

	public void setParticles(int value)
	{
		Cs2dEntityUtil.verifyRange(value, 1, 30);
		setIntSetting(1, value);
	}

	public static enum Weather
	{
		RAIN,
		SNOW,
		FOG,
		DUST,
		SNOG,
		THUNDER;
	}
}
