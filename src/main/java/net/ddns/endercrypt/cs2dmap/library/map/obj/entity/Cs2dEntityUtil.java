package net.ddns.endercrypt.cs2dmap.library.map.obj.entity;

import java.util.function.Function;

public class Cs2dEntityUtil
{
	public static void verifyAngle(int value)
	{
		verifyRange(value, -179, 180);
	}

	public static void verifyFrame(int value)
	{
		verifyRange(value, 0, 255);
	}

	public static void verifyColor(int value)
	{
		verifyRange(value, 0, 255);
	}

	public static <T extends Enum<T>> void verifyEnum(int value, Class<T> enumClass)
	{
		int max = enumClass.getEnumConstants().length - 1;
		verifyRange(value, 0, max);
	}

	public static <T extends Enum<T>> void verifyEnum(int value, Class<T> enumClass, Function<T, Integer> provider)
	{
		for (T enumValue : enumClass.getEnumConstants())
		{
			int id = provider.apply(enumValue);
			if (value == id)
			{
				return;
			}
		}
		throw new IllegalArgumentException("Value not found whitin " + enumClass.getSimpleName());
	}

	public static void verifyOneRange(double value)
	{
		verifyRange(value, 0, 1);
	}

	public static void verifyRange(double value, double min, double max)
	{
		verifyMinimum(value, min);
		verifyMaximum(value, max);
	}

	public static void verifyMinimum(double value, double min)
	{
		if (value < min)
			throw new IllegalArgumentException("Value cannot be less than " + min);
	}

	public static void verifyMaximum(double value, double max)
	{
		if (value > max)
			throw new IllegalArgumentException("Value cannot be higher than " + max);
	}
}
