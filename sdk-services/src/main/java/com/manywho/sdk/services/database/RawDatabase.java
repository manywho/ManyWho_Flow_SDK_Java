package com.manywho.sdk.services.database;

import com.manywho.sdk.api.run.elements.type.ListFilter;
import com.manywho.sdk.api.run.elements.type.MObject;
import com.manywho.sdk.api.run.elements.type.ObjectDataType;
import com.manywho.sdk.services.configuration.Configuration;

import java.util.List;

public interface RawDatabase<C extends Configuration> extends WritableDatabase<C, MObject> {
    MObject find(C configuration, ObjectDataType objectDataType, String id);
    List<MObject> findAll(C configuration, ObjectDataType objectDataType, ListFilter filter);
}
