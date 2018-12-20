package com.manywho.services.example.database;

import com.github.javafaker.Faker;
import com.google.common.collect.Lists;
import com.manywho.sdk.api.ContentType;
import com.manywho.sdk.api.draw.content.Command;
import com.manywho.sdk.api.run.elements.type.ListFilter;
import com.manywho.sdk.api.run.elements.type.MObject;
import com.manywho.sdk.api.run.elements.type.ObjectDataType;
import com.manywho.sdk.api.run.elements.type.Property;
import com.manywho.sdk.services.database.RawDatabase;
import com.manywho.services.example.ServiceConfiguration;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Database implements RawDatabase<ServiceConfiguration> {
    private final Faker faker;

    @Inject
    public Database(Faker faker) {
        this.faker = faker;
    }

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
        if (objectDataType.getDeveloperName().equals("custom-type-one")) {
            List<Property> properties = new ArrayList<>();
            properties.add(new Property("Property One", faker.name().name(), ContentType.String));
            properties.add(new Property("Property Two", faker.book().title(), ContentType.String));

            MObject mObject = new MObject();
            mObject.setDeveloperName(objectDataType.getDeveloperName());
            mObject.setExternalId(id);
            mObject.setProperties(properties);

            return mObject;
        }

        return null;
    }

    @Override
    public List<MObject> findAll(ServiceConfiguration configuration, ObjectDataType objectDataType, Command command, ListFilter filter) {
        List<MObject> objects = Lists.newArrayList();

        IntStream.range(0, filter.getLimit()).forEachOrdered(i -> {
            objects.add(find(configuration, objectDataType, command, String.valueOf(i)));
        });

        return objects;
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
