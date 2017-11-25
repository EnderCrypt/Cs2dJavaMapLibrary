package net.ddns.endercypt.cs2dmap.library.map.obj.entity.type.func;

import net.ddns.endercypt.cs2dmap.library.map.obj.entity.Cs2dEntity;
import net.ddns.endercypt.cs2dmap.library.map.obj.entity.EntityType;
import net.ddns.endercypt.cs2dmap.library.raw.RawCs2dEntity;

@EntityType(70)
public class Func_Teleport extends Cs2dEntity
{
	public Func_Teleport()
	{
		super();
	}

	public Func_Teleport(RawCs2dEntity rawCs2dEntity)
	{
		super(rawCs2dEntity);
	}

	public void setTargetTile(int x, int y)
	{
		setXTile(x);
		setYTile(y);
	}

	public void setXTile(int value)
	{
		setIntSetting(0, value);
	}

	public void setYTile(int value)
	{
		setIntSetting(1, value);
	}
}
