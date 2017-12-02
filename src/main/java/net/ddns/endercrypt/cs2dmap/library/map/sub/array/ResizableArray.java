package net.ddns.endercrypt.cs2dmap.library.map.sub.array;

import java.util.Arrays;
import java.util.function.Function;
import java.util.function.Supplier;

import net.ddns.endercrypt.cs2dmap.library.map.Cs2dDataProvider;
import net.ddns.endercrypt.cs2dmap.library.raw.RawCs2dMap;

public abstract class ResizableArray<T> implements Cs2dDataProvider
{
	private Supplier<T> defaultValueSupplier;
	private T[] array;

	public ResizableArray(Function<Integer, T[]> arraySupplier, Supplier<T> defaultValueSupplier, RawCs2dMap rawCs2dMap)
	{
		this.defaultValueSupplier = defaultValueSupplier;

		array = arraySupplier.apply(rawCs2dMap.tile_count + 1);
		for (int i = 0; i < rawCs2dMap.tile_count + 1; i++)
		{
			array[i] = supplyElement(rawCs2dMap, i);
		}
	}

	public abstract T supplyElement(RawCs2dMap rawCs2dMap, int index);

	@Override
	public void provide(RawCs2dMap rawCs2dMap)
	{
		for (int i = 0; i < rawCs2dMap.tile_count + 1; i++)
		{
			returnElement(rawCs2dMap, get(i), i);
		}
	}

	public abstract void returnElement(RawCs2dMap rawCs2dMap, T element, int index);

	public void resize(int tile_count)
	{
		// resize
		array = Arrays.copyOf(array, tile_count + 1);
		// make bigger
		if (tile_count + 1 > array.length)
		{
			array = Arrays.copyOf(array, tile_count + 1);
			for (int i = 0; i < array.length; i++)
			{
				if (array[i] == null)
				{
					array[i] = defaultValueSupplier.get();
				}
			}
		}
	}

	public T get(int frame)
	{
		return array[frame];
	}

	public void set(int frame, T element)
	{
		filter(element);
		array[frame] = element;
	}

	public abstract void filter(T element);
}
