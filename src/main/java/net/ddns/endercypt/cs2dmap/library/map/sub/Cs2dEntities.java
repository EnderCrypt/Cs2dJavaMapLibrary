package net.ddns.endercypt.cs2dmap.library.map.sub;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import net.ddns.endercypt.cs2dmap.library.map.Cs2dDataProvider;
import net.ddns.endercypt.cs2dmap.library.map.obj.entity.Cs2dEntity;
import net.ddns.endercypt.cs2dmap.library.map.obj.entity.manager.Cs2dEntityManager;
import net.ddns.endercypt.cs2dmap.library.raw.RawCs2dEntity;
import net.ddns.endercypt.cs2dmap.library.raw.RawCs2dMap;

public class Cs2dEntities implements Cs2dDataProvider
{
	private List<Cs2dEntity> entities = new ArrayList<>();

	public Cs2dEntities(RawCs2dMap rawCs2dMap)
	{
		for (RawCs2dEntity rawCs2dEntity : rawCs2dMap.entities)
		{
			Cs2dEntity entity = Cs2dEntityManager.createEntity(rawCs2dEntity);
			entities.add(entity);
		}
	}

	@Override
	public void provide(RawCs2dMap rawCs2dMap)
	{
		rawCs2dMap.entities.clear();
		for (Cs2dEntity cs2dEntity : entities)
		{
			rawCs2dMap.entities.add(cs2dEntity.getRaw());
		}
	}

	public void addEntity(Cs2dEntity entity)
	{
		entities.add(entity);
	}

	public int entityCount()
	{
		return entities.size();
	}

	public List<Cs2dEntity> getEntities()
	{
		return Collections.unmodifiableList(entities);
	}

	public <T extends Cs2dEntity> List<T> getEntities(Class<T> entityType)
	{
		int type = Cs2dEntityManager.getEntityTypeFromClass(entityType);
		List<T> result = new ArrayList<>();
		for (Cs2dEntity entity : entities)
		{
			if (entity.getType() == type)
			{
				T castedEntity = (T) entity; // if this fails, its because someone has manually edited the raw entity_type of an entity
				result.add(castedEntity);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public boolean contains(Class<? extends Cs2dEntity> entityType)
	{
		return contains(Cs2dEntityManager.getEntityTypeFromClass(entityType));
	}

	public <T extends Cs2dEntity> Iterator<T> iterate(Class<T> entityType)
	{
		return getEntities(entityType).iterator();
	}

	public boolean contains(int entityType)
	{
		for (Cs2dEntity entity : entities)
		{
			if (entity.getType() == entityType)
			{
				return true;
			}
		}
		return false;
	}

	public Optional<Cs2dEntity> entityAtLocation(int x, int y)
	{
		for (Cs2dEntity entity : entities)
		{
			if ((entity.getX() == x) && (entity.getY() == y))
			{
				return Optional.of(entity);
			}
		}
		return Optional.empty();
	}

	public boolean removeEntity(Cs2dEntity entity)
	{
		return entities.remove(entity);
	}

	public boolean removeEntityAt(int x, int y)
	{
		return entities.removeIf((e) -> ((e.getX() == x) && (e.getY() == y)));
	}

	public void clearEntities()
	{
		entities.clear();
	}
}
