package net.ddns.endercypt.cs2dmap.library.map.obj.entity.type.func;

import net.ddns.endercypt.cs2dmap.library.map.obj.entity.Cs2dEntity;
import net.ddns.endercypt.cs2dmap.library.map.obj.entity.EntityType;
import net.ddns.endercypt.cs2dmap.library.raw.RawCs2dEntity;

@EntityType(73)
public class Func_GameAction extends Cs2dEntity
{
	public Func_GameAction()
	{
		super();
	}

	public Func_GameAction(RawCs2dEntity rawCs2dEntity)
	{
		super(rawCs2dEntity);
	}

	public void setAction(Action value)
	{
		setIntSetting(0, value);
	}

	public void setParameter(int value)
	{
		setParameter(String.valueOf(value));
	}

	public void setParameter(String value)
	{
		setStringSetting(0, value);
	}

	public static enum Action
	{
		ROUND_DRAW,
		T_WIN,
		CT_WIN,
		ROUND_RESTART_IN_X_SECONDS,
		KILL_ALL_T,
		KILL_ALL_CT,
		KILL_EVERYONE,
		LOAD_MAP_X;
	}
}
