package net.ddns.endercypt.cs2dmap.library.map.obj.entity.type.info;

import net.ddns.endercypt.cs2dmap.library.map.obj.entity.Cs2dEntity;
import net.ddns.endercypt.cs2dmap.library.map.obj.entity.Cs2dEntityUtil;
import net.ddns.endercypt.cs2dmap.library.map.obj.entity.EntityType;
import net.ddns.endercypt.cs2dmap.library.raw.RawCs2dEntity;

@EntityType(3)
public class Info_Hostage extends Cs2dEntity
{
	public Info_Hostage()
	{
		super();
	}

	public Info_Hostage(RawCs2dEntity rawCs2dEntity)
	{
		super(rawCs2dEntity);
	}

	public void setSpawnRotation(int value)
	{
		Cs2dEntityUtil.verifyAngle(value);
		setIntSetting(0, value);
	}

	public void setLook(HostageLooks looks)
	{
		setIntSetting(1, looks.ordinal());
	}

	public static enum HostageLooks
	{
		WHITE_SCIENTIST,
		GUY_ORANGE_SUIT,
		BLACK_SCIENTIST,
		NATIVE,
		BLACK_GUY_OANGE_SUIT,
		BROWN_HAIR_SCIENTIST,
		GRAY_HAIR_SCIENTIST,
		BALD_SCIENTIST;

		public static HostageLooks random()
		{
			HostageLooks[] values = values();
			int index = (int) (Math.random() * values.length);
			return values[index];
		}
	}
}
