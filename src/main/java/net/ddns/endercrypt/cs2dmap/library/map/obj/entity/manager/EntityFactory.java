package net.ddns.endercrypt.cs2dmap.library.map.obj.entity.manager;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import net.ddns.endercrypt.cs2dmap.library.map.obj.entity.Cs2dEntity;
import net.ddns.endercrypt.cs2dmap.library.raw.RawCs2dEntity;

public class EntityFactory
{
	private final Constructor<? extends Cs2dEntity> entityClassConstructor;
	private final Constructor<? extends Cs2dEntity> entityClassConstructorRaw;

	public EntityFactory(Class<? extends Cs2dEntity> entityClass) throws NoSuchMethodException, SecurityException
	{
		entityClassConstructor = entityClass.getConstructor(RawCs2dEntity.class);
		entityClassConstructorRaw = entityClass.getConstructor(RawCs2dEntity.class);
	}

	public Cs2dEntity empty()
	{
		try
		{
			return entityClassConstructor.newInstance();
		}
		catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e)
		{
			throw new RuntimeException(e);
		}
	}

	public Cs2dEntity usingRaw(RawCs2dEntity rawCs2dEntity)
	{
		try
		{
			return entityClassConstructorRaw.newInstance(rawCs2dEntity);
		}
		catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e)
		{
			throw new RuntimeException(e);
		}
	}

}
