package com.manywho.services.example.database;

import com.google.common.collect.Lists;
import com.manywho.sdk.api.draw.content.Command;
import com.manywho.sdk.api.run.elements.type.ListFilter;
import com.manywho.sdk.api.run.elements.type.MObject;
import com.manywho.sdk.api.run.elements.type.ObjectDataType;
import com.manywho.sdk.services.database.RawDatabase;
import com.manywho.services.example.ServiceConfiguration;

import java.util.List;

public class Database implements RawDatabase<ServiceConfiguration> {
    @Override
    public MObject create(ServiceConfiguration configuration, MObject object) {
        return null;
    }

    @Override
    public List<MObject> create(ServiceConfiguration configuration, List<MObject> objects) {
        return null;
    }

    @Override
    public void delete(ServiceConfiguration configuration, MObject object) {

    }

    @Override
    public void delete(ServiceConfiguration configuration, List<MObject> objects) {

    }

    @Override
    public MObject find(ServiceConfiguration configuration, ObjectDataType objectDataType, Command command, String id) {
        return new MObject();
    }

    @Override
    public List<MObject> findAll(ServiceConfiguration configuration, ObjectDataType objectDataType, Command command, ListFilter filter) {
        return Lists.newArrayList();
    }

    @Override
    public MObject update(ServiceConfiguration configuration, MObject object) {
        return null;
    }

    @Override
    public List<MObject> update(ServiceConfiguration configuration, List<MObject> objects) {
        return null;
    }
}
