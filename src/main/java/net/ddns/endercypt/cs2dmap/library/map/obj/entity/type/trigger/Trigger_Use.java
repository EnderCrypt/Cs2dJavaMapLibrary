package net.ddns.endercypt.cs2dmap.library.map.obj.entity.type.trigger;

import net.ddns.endercypt.cs2dmap.library.map.obj.entity.Cs2dEntity;
import net.ddns.endercypt.cs2dmap.library.map.obj.entity.Cs2dEntityUtil;
import net.ddns.endercypt.cs2dmap.library.map.obj.entity.EntityType;
import net.ddns.endercypt.cs2dmap.library.raw.RawCs2dEntity;

@EntityType(93)
public class Trigger_Use extends Cs2dEntity
{
	public Trigger_Use()
	{
		super();
	}

	public Trigger_Use(RawCs2dEntity rawCs2dEntity)
	{
		super(rawCs2dEntity);
	}

	public void setButtonStyle(ButtonStyle value)
	{
		setIntSetting(0, value);
	}

	public void setAlignment(Alignment value)
	{
		setIntSetting(1, value);
	}

	public void setTeam(Team value)
	{
		setIntSetting(2, value);
	}

	/**
	 * @param value (ms)
	 */
	public void setReUseDelay(int value)
	{
		Cs2dEntityUtil.verifyMinimum(value, 0);
		setIntSetting(3, value);
	}

	public static enum ButtonStyle
	{
		NONE_INVISIBLE,
		GRAY_BROAD,
		GRAY_SMALL,
		BLACK,
		KNOB,
		RED_SMALL,
		PIPE_VALVE,
		GLASS_COVERED,
		VALVE,
		LEVER_A,
		LEVER_B,
		LIGHTED_RED,
		LIGHTED_GREEN,
		LIGHTED_BLUE,
		LIGHTED_YELLOW,
		LIGHTED_WHITE,
		RED_LIGHTED_ALARM,
		GREEN_LIGHTED_ALARM;
	}

	public static enum Alignment
	{
		TOP,
		BOTTOM,
		LEFT,
		RIGHT;
	}

	public static enum Team
	{
		EVERYONE,
		TERRORISTS,
		COUNTER_TERRORISTS;
	}
}
