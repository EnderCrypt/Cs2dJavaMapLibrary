package net.ddns.endercrypt.cs2dmap.library.map.obj.entity;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(RUNTIME)
@Target(TYPE)
public @interface EntityType
{
	public int value();
}
