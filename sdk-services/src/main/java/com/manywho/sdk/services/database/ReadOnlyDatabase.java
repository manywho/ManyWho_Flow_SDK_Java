package com.manywho.sdk.services.database;

import com.manywho.sdk.api.run.elements.type.ListFilter;
import com.manywho.sdk.services.configuration.Configuration;
import com.manywho.sdk.services.types.Type;

import java.util.List;

public interface ReadOnlyDatabase<C extends Configuration, T extends Type> {
    T find(C configuration, String id);
    List<T> findAll(C configuration, ListFilter filter);
}
