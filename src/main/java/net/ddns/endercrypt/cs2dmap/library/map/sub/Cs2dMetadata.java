package net.ddns.endercrypt.cs2dmap.library.map.sub;

import net.ddns.endercrypt.cs2dmap.library.map.Cs2dDataProvider;
import net.ddns.endercrypt.cs2dmap.library.raw.RawCs2dMap;

public class Cs2dMetadata implements Cs2dDataProvider
{
	private int uptime_of_system;
	private int usgn_id_of_the_map_author;
	private int map_daylight_time;

	private String name_of_the_map_author;
	private String name_of_the_program_used_to_save_the_map;

	private int currentSystemTime;
	private long systemUpTime;

	public Cs2dMetadata(RawCs2dMap rawCs2dMap)
	{
		this.uptime_of_system = rawCs2dMap.uptime_of_system;
		this.usgn_id_of_the_map_author = rawCs2dMap.usgn_id_of_the_map_author;
		this.map_daylight_time = rawCs2dMap.map_daylight_time;

		this.name_of_the_map_author = rawCs2dMap.name_of_the_map_author;
		this.name_of_the_program_used_to_save_the_map = rawCs2dMap.name_of_the_program_used_to_save_the_map;

		this.currentSystemTime = rawCs2dMap.currentSystemTime;
		this.systemUpTime = rawCs2dMap.systemUpTime;
	}

	@Override
	public void provide(RawCs2dMap rawCs2dMap)
	{
		rawCs2dMap.uptime_of_system = uptime_of_system;
		rawCs2dMap.usgn_id_of_the_map_author = usgn_id_of_the_map_author;
		rawCs2dMap.map_daylight_time = map_daylight_time;

		rawCs2dMap.name_of_the_map_author = name_of_the_map_author;
		rawCs2dMap.name_of_the_program_used_to_save_the_map = name_of_the_program_used_to_save_the_map;

		rawCs2dMap.currentSystemTime = currentSystemTime;
		rawCs2dMap.systemUpTime = systemUpTime;
	}

	public int getUptimeOfSystem()
	{
		return uptime_of_system;
	}

	public void setptimeOfSystem(int value)
	{
		this.uptime_of_system = value;
	}

	public int getUsgnOfMapAuthor()
	{
		return usgn_id_of_the_map_author - 51;
	}

	public void setUsgnOfMapAuthor(int usgn)
	{
		if (usgn < 0)
		{
			throw new IllegalArgumentException("Usgn must be 0 or above");
		}
		this.usgn_id_of_the_map_author = usgn + 51;
	}

	public int getMapDaylightTime()
	{
		return map_daylight_time;
	}

	public void setMapDaylightTime(int value)
	{
		this.map_daylight_time = value;
	}

	public String getNameOfMapAuthor()
	{
		return name_of_the_map_author;
	}

	public void setNameOfMapAuthor(String name)
	{
		this.name_of_the_map_author = name;
	}

	public String getNameOfProgramUsedToSaveMap()
	{
		return name_of_the_program_used_to_save_the_map;
	}

	public void setNameOfProgramUsedToSaveMap(String name)
	{
		this.name_of_the_program_used_to_save_the_map = name;
	}

	public int getCurrentSystemTime()
	{
		return currentSystemTime;
	}

	public void setCurrentSystemTime(int value)
	{
		this.currentSystemTime = value;
	}

	public long getSystemUpTime()
	{
		return systemUpTime;
	}

	public void setSystemUpTime(long value)
	{
		this.systemUpTime = value;
	}
}
