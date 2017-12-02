package net.ddns.endercrypt.cs2dmap.library.map.obj.entity.type.func;

import net.ddns.endercrypt.cs2dmap.library.map.obj.entity.Cs2dEntity;
import net.ddns.endercrypt.cs2dmap.library.map.obj.entity.Cs2dEntityUtil;
import net.ddns.endercrypt.cs2dmap.library.map.obj.entity.EntityType;
import net.ddns.endercrypt.cs2dmap.library.raw.RawCs2dEntity;

@EntityType(71)
public class Func_DynWall extends Cs2dEntity
{
	public Func_DynWall()
	{
		super();
	}

	public Func_DynWall(RawCs2dEntity rawCs2dEntity)
	{
		super(rawCs2dEntity);
	}

	public void setFrame(int value)
	{
		Cs2dEntityUtil.verifyFrame(value);
		setIntSetting(0, value);
	}

	public void setBehaviour(Behavior value)
	{
		setIntSetting(1, value);
	}

	public void setCloseOnlyIfNotBlocked(boolean value)
	{
		setIntSetting(2, value ? 1 : 0);
	}

	public void setTransparency(double value)
	{
		Cs2dEntityUtil.verifyOneRange(value);
		setStringSetting(0, String.valueOf(value));
	}

	public static enum Behavior
	{
		WALL,
		OBSTACLE,
		WALL_WO_SHADOW,
		OBSTACLE_WO_SHADOW,
		FLOOR_AND_TILE_BEHAVIOUR;
	}
}
