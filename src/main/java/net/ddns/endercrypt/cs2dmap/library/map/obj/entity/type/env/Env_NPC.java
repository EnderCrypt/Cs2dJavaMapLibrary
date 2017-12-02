package net.ddns.endercrypt.cs2dmap.library.map.obj.entity.type.env;

import net.ddns.endercrypt.cs2dmap.library.map.obj.entity.Cs2dEntity;
import net.ddns.endercrypt.cs2dmap.library.map.obj.entity.Cs2dEntityUtil;
import net.ddns.endercrypt.cs2dmap.library.map.obj.entity.EntityType;
import net.ddns.endercrypt.cs2dmap.library.raw.RawCs2dEntity;

@EntityType(31)
public class Env_NPC extends Cs2dEntity
{
	public Env_NPC()
	{
		super();
	}

	public Env_NPC(RawCs2dEntity rawCs2dEntity)
	{
		super(rawCs2dEntity);
	}

	public void setRotation(int value)
	{
		Cs2dEntityUtil.verifyAngle(value);
		setIntSetting(0, value);
	}

	public void setNpcType(NpcType value)
	{
		setIntSetting(1, value.ordinal() + 1);
	}

	public void setHealth(int value)
	{
		Cs2dEntityUtil.verifyMinimum(value, 1);
		setIntSetting(2, value);
	}

	public void setSpawnOnStart(boolean value)
	{
		setIntSetting(3, value ? 0 : 1);
	}

	public static enum NpcType
	{
		ZOMBIE,
		HEADCRAB,
		SNARK,
		VORTIGAUNT,
		SOLDIER;
	}
}
