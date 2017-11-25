package net.ddns.endercypt.cs2dmap.library.map.sub.extra.tile;

import java.util.Optional;

public enum TileMode
{
	NORMAL_FLOOR_WITHOUT_SOUND(0),
	WALL(1),
	OBSTACLE(2),
	WALL_WITHOUT_SHADOW(3),
	OBSTACLE_WITHOUT_SHADOW(4),
	WALL_THAT_IS_RENDERED_AT_FLOOR_LEVEL(5),
	FLOOR_DIRT(10),
	FLOOR_SNOW_WITH_FOOTPRINTS_AND_FX(11),
	FLOOR_STEP(12),
	FLOOR_TILE(13),
	FLOOR_WADE_WATER_WITH_WAVE_FX(14),
	FLOOR_METAL(15),
	FLOOR_WOOD(16),
	DEADLY_NORMAL(50),
	DEADLY_TOXIC(51),
	DEADLY_EXPLOSION(52),
	DEADLY_ABYSS(53);

	public static final TileMode DEFAULT = NORMAL_FLOOR_WITHOUT_SOUND;

	private int mode;

	private TileMode(int mode)
	{
		this.mode = mode;
	}

	public int getMode()
	{
		return mode;
	}

	private static final TileMode[] reverseLookup;
	static
	{
		// find highest
		int highest = 0;
		for (TileMode tileMode : values())
		{
			if (tileMode.getMode() > highest)
			{
				highest = tileMode.getMode();
			}
		}
		// create
		reverseLookup = new TileMode[highest + 1];
		// insert
		for (TileMode tileMode : values())
		{
			reverseLookup[tileMode.getMode()] = tileMode;
		}
	}

	public static Optional<TileMode> lookup(int mode)
	{
		if (mode < 0)
			throw new IllegalArgumentException(TileMode.class.getSimpleName() + "'s cannot be negative numbers");

		if (mode > reverseLookup.length)
			return Optional.empty();

		return Optional.ofNullable(reverseLookup[mode]);
	}
}
