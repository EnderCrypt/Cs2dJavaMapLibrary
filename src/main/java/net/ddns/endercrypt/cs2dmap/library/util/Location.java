package net.ddns.endercrypt.cs2dmap.library.util;

public class Location
{
	public int x;
	public int y;

	public Location()
	{
		this(0, 0);
	}

	public Location(int x, int y)
	{
		this.x = x;
		this.y = y;
	}

	@Override
	public int hashCode()
	{
		return x + (y * 10_000); // this hashcode finds unique hashcodes for all locations, assuming map width isnt more than 10'000
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		Location other = (Location) obj;
		if (x != other.x) return false;
		if (y != other.y) return false;
		return true;
	}
}
