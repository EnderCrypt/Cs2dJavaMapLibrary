package net.ddns.endercrypt.cs2dmap.library.map.obj.entity.type.env;

import net.ddns.endercrypt.cs2dmap.library.map.obj.entity.Cs2dEntity;
import net.ddns.endercrypt.cs2dmap.library.map.obj.entity.Cs2dEntityUtil;
import net.ddns.endercrypt.cs2dmap.library.map.obj.entity.EntityType;
import net.ddns.endercrypt.cs2dmap.library.raw.RawCs2dEntity;

@EntityType(24)
public class Env_Decal extends Cs2dEntity
{
	public Env_Decal()
	{
		super();
	}

	public Env_Decal(RawCs2dEntity rawCs2dEntity)
	{
		super(rawCs2dEntity);
	}

	public void setDecalFrame(Decals value)
	{
		setDecalFrame(value.ordinal());
	}

	public void setDecalFrame(int value)
	{
		Cs2dEntityUtil.verifyEnum(value, Decals.class);
		setIntSetting(0, value);
	}

	public void setRed(int value)
	{
		Cs2dEntityUtil.verifyColor(value);
		setIntSetting(1, value);
	}

	public void setGreen(int value)
	{
		Cs2dEntityUtil.verifyColor(value);
		setIntSetting(2, value);
	}

	public void setBlue(int value)
	{
		Cs2dEntityUtil.verifyColor(value);
		setIntSetting(3, value);
	}

	public void setRotation(int value)
	{
		Cs2dEntityUtil.verifyAngle(value);
		setIntSetting(4, value);
	}

	public void setRotation(double value)
	{
		Cs2dEntityUtil.verifyOneRange(value);
		setStringSetting(0, String.valueOf(value));
	}

	public static enum Decals
	{
		BLOOD_PUDDLE,
		BLOOD_1,
		BLOOD_2,
		BLOOD_3,
		BLOOD_4,
		BLOOD_5,
		CROSS,
		SQUARE_R,
		SMOKE_1,
		SMOKE_2,
		SMOKE_3,
		SMOKE_4,
		FISSURE,
		CLOUD,
		FOOTSTEP_1,
		FOOTSTEP_2,
		FOOTSTEP_3,
		FOOTSTEP_4,
		ARROW_UP,
		ARROW_RIGHT,
		ARROW_DOWN,
		ARROW_LEFT,
		UNREALSOFT_LOGO,
		HORIZONTAL_LINE,
		VERTICAL_LINE,
		DIAGONALLY_STRIPED_SQUARE,
		WHITE_SQUARE,
		GRADIENT_SQUARE,
		BIG_CIRCLE,
		MEDIUM_CIRCLE,
		SMALL_CIRCLE,
		LONG_HORIZONTAL_LINE,
		LONG_VERTICAL_LINE,
		PLUS_SIGN,
		SQUARE,
		STAR,
		ZERO,
		ONE,
		TWO,
		THREE,
		FOUR,
		FIVE,
		SIX,
		SEVEN,
		EIGHT,
		NINE,
		A,
		B,
		C,
		D,
		E,
		X,
		CROSSHAIR,
		BUSH,
		BIG_BUSH,
		TREE,
		LEAVES,
		GRASS,
		CORNER,
		WALL,
		SOLID_CORNER,
		STARS,
		DIRTY_1,
		DIRTY_2,
		DIRTY_3,
		DEEP_GRASS,
		DIRTY_4,
		GREYSHADE_1,
		GREYSHADE_2,
		GREYSHADE_3,
		GREYSHADE_4,
		GREYSHADE_5;
	}
}
