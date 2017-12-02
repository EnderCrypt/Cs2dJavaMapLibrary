package net.ddns.endercrypt.cs2dmap.library.map.obj.entity.type.info;

import net.ddns.endercrypt.cs2dmap.library.map.obj.entity.Cs2dEntity;
import net.ddns.endercrypt.cs2dmap.library.map.obj.entity.Cs2dEntityUtil;
import net.ddns.endercrypt.cs2dmap.library.map.obj.entity.EntityType;
import net.ddns.endercrypt.cs2dmap.library.raw.RawCs2dEntity;

@EntityType(18)
public class Info_NoBuildings extends Cs2dEntity
{
	public Info_NoBuildings()
	{
		super();
	}

	public Info_NoBuildings(RawCs2dEntity rawCs2dEntity)
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

	public void allowMinesPortals(boolean value)
	{
		setIntSetting(2, value ? 1 : 0);
	}
}
