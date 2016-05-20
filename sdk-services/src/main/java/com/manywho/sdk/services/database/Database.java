package com.manywho.sdk.services.database;

import com.manywho.sdk.api.run.elements.type.ListFilter;
import com.manywho.sdk.services.types.Type;

import java.util.Collection;

public interface Database<T extends Type> {
    T create(T object);

    Collection<T> create(Collection<T> objects);

    void delete(T object);

    void delete(Collection<T> objects);

    T find(String id);

    Collection<T> findAll(ListFilter filter);

    T update(T object);

    Collection<T> update(Collection<T> objects);
}
