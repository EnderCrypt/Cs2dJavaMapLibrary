package net.ddns.endercypt.cs2dmap.library.map.obj.entity.type.info;

import net.ddns.endercypt.cs2dmap.library.map.obj.entity.Cs2dEntity;
import net.ddns.endercypt.cs2dmap.library.map.obj.entity.EntityType;
import net.ddns.endercypt.cs2dmap.library.raw.RawCs2dEntity;

@EntityType(12)
public class Info_NoWeapons extends Cs2dEntity
{
	public Info_NoWeapons()
	{
		super();
	}

	public Info_NoWeapons(RawCs2dEntity rawCs2dEntity)
	{
		super(rawCs2dEntity);
	}

	/**
	 * setting this to true, will strip all weapons when a new round starts
	 * false will allow players to keep the weapons if they survive the round
	 * @param value
	 * @return
	 */
	public void setStripWeaponsOnNewRound(boolean value)
	{
		setIntSetting(0, value ? 0 : 1);
	}
}
