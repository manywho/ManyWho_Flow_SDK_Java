package com.manywho.sdk.services.database;

import com.manywho.sdk.api.run.elements.type.ListFilter;
import com.manywho.sdk.services.configuration.Configuration;

import java.util.List;

public interface DatabaseBase<C extends Configuration, T> {
    T create(C configuration, T object);

    List<T> create(C configuration, List<T> objects);

    void delete(C configuration, T object);

    void delete(C configuration, List<T> objects);

    T find(C configuration, String id);

    List<T> findAll(C configuration, ListFilter filter);

    T update(C configuration, T object);

    List<T> update(C configuration, List<T> objects);
}
