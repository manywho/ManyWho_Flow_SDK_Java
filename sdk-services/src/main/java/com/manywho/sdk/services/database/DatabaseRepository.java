package com.manywho.sdk.services.database;

import com.manywho.sdk.services.types.Type;
import com.manywho.sdk.services.types.TypeParser;
import org.reflections.Reflections;

import javax.inject.Inject;
import java.util.Set;

public class DatabaseRepository {
    private final Reflections reflections;

    private Set<Class<? extends Database>> databases;
    private Set<Class<? extends ReadOnlyDatabase>> readOnlyDatabases;
    private Set<Class<? extends WritableDatabase>> writableDatabases;

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

    public <T extends Type> Class<? extends ReadOnlyDatabase<?, T>> findReadOnlyDatabase(Class<T> type) {
        return (Class<? extends ReadOnlyDatabase<?, T>>) getReadOnlyDatabases().stream()
                .filter(database -> !database.isInterface())
                .filter(database -> !RawDatabase.class.isAssignableFrom(database))
                .filter(database -> TypeParser.findGenericType(database.getGenericInterfaces()[0], 1).equals(type))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Unable to find an implementation of ReadOnlyDatabase<T> for the type " + type.getCanonicalName()));
    }

    public <T extends Type> Class<? extends WritableDatabase<?, T>> findWritableDatabase(Class<T> type) {
        return (Class<? extends WritableDatabase<?, T>>) getWritableDatabases().stream()
                .filter(database -> !database.isInterface())
                .filter(database -> !RawDatabase.class.isAssignableFrom(database))
                .filter(database -> TypeParser.findGenericType(database.getGenericInterfaces()[0], 1).equals(type))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Unable to find an implementation of WritableDatabase<T> for the type " + type.getCanonicalName()));
    }

    public Set<Class<? extends Database>> getDatabases() {
        if (databases == null) {
            databases = reflections.getSubTypesOf(Database.class);
        }

        return databases;
    }

    public Set<Class<? extends ReadOnlyDatabase>> getReadOnlyDatabases() {
        if (readOnlyDatabases == null) {
            readOnlyDatabases = reflections.getSubTypesOf(ReadOnlyDatabase.class);
        }

        return readOnlyDatabases;
    }

    public Set<Class<? extends WritableDatabase>> getWritableDatabases() {
        if (writableDatabases == null) {
            writableDatabases = reflections.getSubTypesOf(WritableDatabase.class);
        }

        return writableDatabases;
    }
}
