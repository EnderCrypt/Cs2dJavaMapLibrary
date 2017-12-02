package net.ddns.endercrypt.cs2dmap.library.map.obj.entity;

import java.awt.Point;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import net.ddns.endercrypt.cs2dmap.library.map.obj.entity.manager.Cs2dEntityManager;
import net.ddns.endercrypt.cs2dmap.library.raw.RawCs2dEntity;
import net.ddns.endercrypt.cs2dmap.library.raw.RawData;
import net.ddns.endercrypt.cs2dmap.library.util.Location;

// http://www.cs2d.com/entities.php?cat=all
// TODO: maybe should be abstract?
public class Cs2dEntity implements RawData<RawCs2dEntity>
{
	private RawCs2dEntity rawCs2dEntity;

	public Cs2dEntity()
	{
		this(new RawCs2dEntity());
		int entityType = Cs2dEntityManager.getEntityTypeFromClass(getClass());
		getRaw().entity_type.set((byte) entityType);
	}

	public Cs2dEntity(RawCs2dEntity rawCs2dEntity)
	{
		this.rawCs2dEntity = rawCs2dEntity;
	}

	@Override
	public RawCs2dEntity getRaw()
	{
		return rawCs2dEntity;
	}

	public String getName()
	{
		return rawCs2dEntity.entity_name;
	}

	public void setName(String name)
	{
		rawCs2dEntity.entity_name = name;
	}

	public int getType()
	{
		return rawCs2dEntity.entity_type.getInt();
	}

	public int getX()
	{
		return rawCs2dEntity.x;
	}

	public int getY()
	{
		return rawCs2dEntity.y;
	}

	public Point getPosition()
	{
		return new Point(getX(), getY());
	}

	public void setLocation(Location location)
	{
		setLocation(location.x, location.y);
	}

	public void setLocation(int x, int y)
	{
		rawCs2dEntity.x = x;
		rawCs2dEntity.y = y;
	}

	private static void cleanTriggers(String... triggers)
	{
		for (int i = 0; i < triggers.length; i++)
		{
			String trigger = triggers[i];

			trigger = trigger.trim();

			if (trigger.contains(","))
			{
				throw new IllegalArgumentException("triggers cannot contain comma's: " + trigger);
			}

			if (trigger.length() == 0)
			{
				throw new IllegalArgumentException("trigger cannot be an empty string");
			}

			triggers[i] = trigger;
		}
	}

	public String[] getTriggers()
	{
		String[] triggers = rawCs2dEntity.triggers.split(",");
		cleanTriggers(triggers);
		return triggers;
	}

	public void addTrigger(List<String> triggers)
	{
		addTrigger(triggers.stream().toArray(String[]::new));
	}

	public void addTrigger(String... triggers)
	{
		// clean
		cleanTriggers(triggers);

		// string
		StringBuilder sb = new StringBuilder();
		sb.append(rawCs2dEntity.triggers);

		// starting comma
		if (sb.length() > 0)
		{
			sb.append(',');
		}

		// loop
		for (int i = 0; i < triggers.length; i++)
		{
			sb.append(triggers[i]);
			// comma
			if (i < triggers.length - 1)
			{
				sb.append(',');
			}
		}

		rawCs2dEntity.triggers = sb.toString();
	}

	public void removeTrigger(String... triggers)
	{
		// clean
		cleanTriggers(triggers);

		// list
		List<String> currentTriggers = Arrays.asList(getTriggers());

		// remove
		Arrays.stream(triggers).forEach(currentTriggers::remove);

		// re-assemble
		rawCs2dEntity.triggers = currentTriggers.stream().collect(Collectors.joining(","));
	}

	// int

	public int getIntSetting(int index)
	{
		return rawCs2dEntity.integerSettings[index];
	}

	public <T extends Enum<T>> void setIntSetting(int index, T value)
	{
		setIntSetting(index, value, 0);
	}

	public <T extends Enum<T>> void setIntSetting(int index, T value, int enumOffset)
	{
		Objects.requireNonNull(value);
		rawCs2dEntity.integerSettings[index] = value.ordinal() - enumOffset;
	}

	public void setIntSetting(int index, int value)
	{
		rawCs2dEntity.integerSettings[index] = value;
	}

	// string

	public String getStringSetting(int index)
	{
		return rawCs2dEntity.stringSettings[index];
	}

	public void setStringSetting(int index, String value)
	{
		rawCs2dEntity.stringSettings[index] = value;
	}
}
