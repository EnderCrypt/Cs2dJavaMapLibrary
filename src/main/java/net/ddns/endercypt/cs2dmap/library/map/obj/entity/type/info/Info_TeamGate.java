package net.ddns.endercypt.cs2dmap.library.map.obj.entity.type.info;

import net.ddns.endercypt.cs2dmap.library.map.obj.entity.Cs2dEntity;
import net.ddns.endercypt.cs2dmap.library.map.obj.entity.Cs2dEntityUtil;
import net.ddns.endercypt.cs2dmap.library.map.obj.entity.EntityType;
import net.ddns.endercypt.cs2dmap.library.raw.RawCs2dEntity;

@EntityType(20)
public class Info_TeamGate extends Cs2dEntity
{
	public Info_TeamGate()
	{
		super();
	}

	public Info_TeamGate(RawCs2dEntity rawCs2dEntity)
	{
		super(rawCs2dEntity);
	}

	public void setWidth(int value)
	{
		Cs2dEntityUtil.verifyMinimum(value, 1);
		setIntSetting(0, value);
	}

	public void setHeight(int value)
	{
		Cs2dEntityUtil.verifyMinimum(value, 1);
		setIntSetting(1, value);
	}

	public void setAllowedTeam(Team value)
	{
		setIntSetting(2, value.ordinal());
	}

	public void setKillFlagCarrier(boolean value)
	{
		setIntSetting(3, value ? 0 : 1);
	}

	public void setKillBombCarrier(boolean value)
	{
		setIntSetting(4, value ? 0 : 1);
	}

	public void setKillDefuseKitCarrier(boolean value)
	{
		setIntSetting(5, value ? 0 : 1);
	}

	public void setKillVip(boolean value)
	{
		setIntSetting(6, value ? 0 : 1);
	}

	public void setKillGasMaskWearer(boolean value)
	{
		setIntSetting(7, value ? 0 : 1);
	}

	public void setKillNightVisionWearer(boolean value)
	{
		setIntSetting(8, value ? 0 : 1);
	}

	public static enum Team
	{
		NOBODY,
		TERRORISTS,
		COUNTER_TERRORISTS;
	}
}
