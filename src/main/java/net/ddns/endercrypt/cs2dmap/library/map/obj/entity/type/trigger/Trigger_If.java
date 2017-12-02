package net.ddns.endercrypt.cs2dmap.library.map.obj.entity.type.trigger;

import net.ddns.endercrypt.cs2dmap.library.map.obj.entity.Cs2dEntity;
import net.ddns.endercrypt.cs2dmap.library.map.obj.entity.Cs2dEntityUtil;
import net.ddns.endercrypt.cs2dmap.library.map.obj.entity.EntityType;
import net.ddns.endercrypt.cs2dmap.library.raw.RawCs2dEntity;

/**
 * http://www.cs2d.com/entities.php?cat=all&entity=Trigger_If#entity
 * 
 */
@EntityType(96)
public class Trigger_If extends Cs2dEntity
{
	public Trigger_If()
	{
		super();
	}

	public Trigger_If(RawCs2dEntity rawCs2dEntity)
	{
		super(rawCs2dEntity);
	}

	/**
	 * Condition types (Trigger entities in trigger field if...):
	 * <ul>
		 * <li> 0 - Lua expression (strs[0]) is true (mp_luamap must be enabled to make this work) </li>
		 * <li> 1 - at least A player(s) are in area B,C,D,E (x, y, width, height in tiles) </li>
		 * <li> 2 - max A player(s) area in area B,C,D,E (x, y, width, height in tiles) </li>
		 * <li> 3 - entity state at A, B (position in tiles) is 0 (visible/enabled) </li>
		 * <li> 4 - entity state at A, B (position in tiles) is 1 (hidden/disabled) </li>
		 * <li> 5 - at least A terrorists are alive </li>
		 * <li> 6 - at least A counter-terrorists are alive </li>
		 * <li> 7 - max A terrorists are alive </li>
		 * <li> 8 - max A counter-terrorists are alive </li>
		 * <li> 9 - remaining round time in seconds is greater/equal A (always triggers in game modes without time limit) </li>
		 * <li> 10 - remaining round time in seconds is less/equal A (never triggers in game modes without time limit) </li>
		 * <li> 11 - at least A item(s) are at B,C (position in tiles) </li>
		 * <li> 12 - max A item(s) are at B, C (position in tiles) </li>
		 * <li> 13 - any building is at A, B (position in tiles) </li>
		 * <li> 14 - no building is at A, B (position in tiles) </li>
	 * </ul>
	 */
	public void setConditionType(int value)
	{
		Cs2dEntityUtil.verifyRange(value, 0, 14);
		setIntSetting(0, value);
	}

	/**
	 * @param value (in most cases: amount or X coordinate in tiles)
	 */
	public void setParameterA(int value)
	{
		setIntSetting(1, value);
	}

	/**
	 * @param value (in most cases: X or Y coordinate in tiles)
	 */
	public void setParameterB(int value)
	{
		setIntSetting(2, value);
	}

	/**
	 * @param value (in most cases: Y coordinate in tiles)
	 */
	public void setParameterC(int value)
	{
		setIntSetting(3, value);
	}

	/**
	 * @param value (in most cases: area width in tiles)
	 */
	public void setParameterD(int value)
	{
		setIntSetting(4, value);
	}

	/**
	 * @param value (in most cases: area height in tiles)
	 */
	public void setParameterE(int value)
	{
		setIntSetting(5, value);
	}

	public void setLuaExpression(String value)
	{
		setStringSetting(0, value);
	}
}
