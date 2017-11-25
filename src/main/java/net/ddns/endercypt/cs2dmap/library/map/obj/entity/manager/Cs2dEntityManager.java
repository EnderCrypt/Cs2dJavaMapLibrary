package net.ddns.endercypt.cs2dmap.library.map.obj.entity.manager;

import java.util.HashMap;
import java.util.Map;
import io.github.lukehutch.fastclasspathscanner.FastClasspathScanner;
import io.github.lukehutch.fastclasspathscanner.scanner.ScanResult;
import net.ddns.endercypt.cs2dmap.library.map.obj.entity.Cs2dEntity;
import net.ddns.endercypt.cs2dmap.library.map.obj.entity.Cs2dEntityException;
import net.ddns.endercypt.cs2dmap.library.map.obj.entity.EntityType;
import net.ddns.endercypt.cs2dmap.library.raw.RawCs2dEntity;

public class Cs2dEntityManager
{
	private static final String entityClassPackage = "net.ddns.endercypt.cs2dmap.library.map.obj.entity.type";

	private static final Map<Integer, EntityTypeManager> entityManagers = new HashMap<>();

	static
	{
		FastClasspathScanner fcs = new FastClasspathScanner(entityClassPackage);
		fcs.matchClassesWithAnnotation(EntityType.class, (p) -> {
			// ignore
		});
		fcs.matchSubclassesOf(Cs2dEntity.class, (p) -> {
			// ignore
		});
		ScanResult result = fcs.scan();
		// process
		for (String className : result.getNamesOfSubclassesOf(Cs2dEntity.class))
		{
			try
			{
				@SuppressWarnings("unchecked") Class<? extends Cs2dEntity> entityClass = (Class<? extends Cs2dEntity>) Class.forName(className);
				// entity type manager
				EntityTypeManager entityTypeManager = new EntityTypeManager(entityClass);
				// check
				if (entityManagers.containsKey(entityTypeManager.getTypeId()))
				{
					EntityTypeManager currentEntityTypeManager = getEntityTypeManager(entityTypeManager.getTypeId());
					System.err.println(entityClass.getSimpleName() + " wants entity type id " + entityTypeManager.getTypeId() + " but its already occupied by " + currentEntityTypeManager.getName());
					continue;
				}
				// add
				entityManagers.put(entityTypeManager.getTypeId(), entityTypeManager);
			}
			catch (ClassNotFoundException | NoSuchMethodException | SecurityException e)
			{
				e.printStackTrace();
				continue;
			}
		}
	}

	public static int getEntityTypeFromClass(Class<? extends Cs2dEntity> entityClass)
	{
		EntityType entityType = entityClass.getAnnotation(EntityType.class);
		if (entityType == null)
		{
			throw new IllegalArgumentException("the class " + entityClass.getName() + " does not have the annotation " + EntityType.class);
		}
		return entityType.value();
	}

	public static EntityTypeManager getEntityTypeManager(int entityTypeId)
	{
		EntityTypeManager entityTypeManager = entityManagers.get(entityTypeId);
		if (entityTypeManager == null)
		{
			throw new Cs2dEntityException("No known entity type exists for " + entityTypeId);
		}
		return entityTypeManager;
	}

	public static Cs2dEntity createEntity(RawCs2dEntity rawCs2dEntity)
	{
		EntityTypeManager entityTypeManager = getEntityTypeManager(rawCs2dEntity.entity_type.getInt());
		return entityTypeManager.getEntityFactory().usingRaw(rawCs2dEntity);
	}

	public static Cs2dEntity createEntity(int entityType)
	{
		EntityTypeManager entityTypeManager = getEntityTypeManager(entityType);
		return entityTypeManager.getEntityFactory().empty();
	}

}
