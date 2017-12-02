package net.ddns.endercrypt.cs2dmap.library.map.obj.entity.manager;

import net.ddns.endercrypt.cs2dmap.library.map.obj.entity.Cs2dEntity;

public class EntityTypeManager
{
	private final Class<? extends Cs2dEntity> entityClass;
	private final int typeId;
	private final String name;
	private final EntityFactory entityFactory;

	public EntityTypeManager(Class<? extends Cs2dEntity> entityClass) throws NoSuchMethodException, SecurityException
	{
		// class
		this.entityClass = entityClass;
		// type id
		typeId = Cs2dEntityManager.getEntityTypeFromClass(entityClass);
		// name
		name = entityClass.getSimpleName();
		// factory
		entityFactory = new EntityFactory(entityClass);
	}

	public Class<? extends Cs2dEntity> getEntityClass()
	{
		return entityClass;
	}

	public int getTypeId()
	{
		return typeId;
	}

	public String getName()
	{
		return name;
	}

	public EntityFactory getEntityFactory()
	{
		return entityFactory;
	}
}
