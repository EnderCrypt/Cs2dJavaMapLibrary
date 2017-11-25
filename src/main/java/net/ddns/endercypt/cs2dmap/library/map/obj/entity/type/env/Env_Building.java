package net.ddns.endercypt.cs2dmap.library.map.obj.entity.type.env;

import net.ddns.endercypt.cs2dmap.library.map.obj.entity.Cs2dEntity;
import net.ddns.endercypt.cs2dmap.library.map.obj.entity.Cs2dEntityUtil;
import net.ddns.endercypt.cs2dmap.library.map.obj.entity.EntityType;
import net.ddns.endercypt.cs2dmap.library.raw.RawCs2dEntity;

@EntityType(30)
public class Env_Building extends Cs2dEntity
{
	public Env_Building()
	{
		super();
	}

	public Env_Building(RawCs2dEntity rawCs2dEntity)
	{
		super(rawCs2dEntity);
	}

	public void setBuilding(Building value)
	{
		setBuilding(value.getBuildingId());
	}

	public void setBuilding(int value)
	{
		Cs2dEntityUtil.verifyEnum(value, Building.class, Building::getBuildingId);
		setIntSetting(0, value);
	}

	public void setTeam(Team value)
	{
		setIntSetting(1, value);
	}

	public void setRotation(Rotation rotation)
	{
		setRotation(rotation.getRotation());
	}

	public void setRotation(int value)
	{
		Cs2dEntityUtil.verifyEnum(value, Rotation.class, Rotation::getRotation);
		Cs2dEntityUtil.verifyAngle(value);
		setIntSetting(2, value);
	}

	public static enum Building
	{
		BARRICADE(1),
		BARBED_WIRE(2),
		WALL_1(3),
		WALL_2(4),
		WALL_3(5),
		GATE_FIELD(6),
		DISPENSER(7),
		TURRET(8),
		SUPPLY(9),
		BUILD_PLACE(10),
		DUAL_TURRET(11),
		TRIPLE_TURRET(12),
		TELEPORT_ENTRANCE(13),
		TELEPORT_EXIT(14),
		SUPER_SUPPLY(15),
		MINE(20),
		LASER_MINE(21),
		PORTAL_ORANGE(22),
		PORTAL_BLUE(23);

		private int id;

		private Building(int id)
		{
			this.id = id;
		}

		public int getBuildingId()
		{
			return id;
		}
	}

	public static enum Team
	{
		NEUTRAL,
		TERRORISTS,
		COUNTER_TERRORISTS;
	}

	public static enum Rotation
	{
		UP(0),
		LEFT(90),
		RIGHT(-90),
		DOWN(-180);

		private int rotation;

		private Rotation(int rotation)
		{
			this.rotation = rotation;
		}

		public int getRotation()
		{
			return rotation;
		}
	}
}
