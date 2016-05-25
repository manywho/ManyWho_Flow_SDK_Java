package com.manywho.sdk.services.database;

import com.manywho.sdk.api.run.elements.type.ListFilter;
import com.manywho.sdk.api.run.elements.type.MObject;
import com.manywho.sdk.api.run.elements.type.ObjectDataType;
import com.manywho.sdk.services.configuration.Configuration;

import java.util.List;

public interface RawDatabase<C extends Configuration, T extends MObject> extends DatabaseBase<C, T> {
    T find(C configuration, ObjectDataType objectDataType, String id);
    List<T> findAll(C configuration, ObjectDataType objectDataType, ListFilter filter);
}
