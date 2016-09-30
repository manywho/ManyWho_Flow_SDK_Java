package com.manywho.sdk.services.database;

import com.manywho.sdk.services.types.Type;
import com.manywho.sdk.services.types.TypeParser;
import org.reflections.Reflections;

import javax.inject.Inject;
import java.util.Set;

public class DatabaseRepository {
    private final Reflections reflections;

    private Set<Class<? extends Database>> databases;

    @Inject
    public DatabaseRepository(Reflections reflections) {
        this.reflections = reflections;
    }

    public Class<? extends RawDatabase<?>> findRawDatabase() {
        return (Class<? extends RawDatabase<?>>) reflections.getSubTypesOf(RawDatabase.class).stream()
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Unable to find an implementation of " + RawDatabase.class.getCanonicalName()));
    }

    public <T extends Type> Class<? extends Database<?, T>> findDatabase(Class<T> type) {
        return (Class<? extends Database<?, T>>) getDatabases().stream()
                .filter(database -> TypeParser.findGenericType(database.getGenericInterfaces()[0], 1).equals(type))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Unable to find an implementation of Database<T> for the type " + type.getCanonicalName()));
    }

    public Set<Class<? extends Database>> getDatabases() {
        if (databases == null) {
            databases = reflections.getSubTypesOf(Database.class);
        }

        return databases;
    }
}
