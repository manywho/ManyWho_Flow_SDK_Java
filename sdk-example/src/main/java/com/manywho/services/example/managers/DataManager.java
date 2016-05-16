package com.manywho.services.example.managers;

import com.manywho.sdk.api.run.elements.type.ListFilter;
import com.manywho.sdk.api.run.elements.type.MObject;
import com.manywho.sdk.api.run.elements.type.ObjectDataRequest;
import com.manywho.sdk.api.run.elements.type.ObjectDataResponse;
import com.manywho.sdk.services.types.TypeBuilder;
import com.manywho.sdk.services.values.ValueParser;
import com.manywho.services.example.repositories.PersonRepository;
import com.manywho.services.example.types.Person;

import javax.inject.Inject;
import java.util.List;

public class DataManager {
    private final PersonRepository personRepository;
    private final TypeBuilder typeBuilder;
    private final ValueParser valueParser;

    @Inject
    public DataManager(PersonRepository personRepository, TypeBuilder typeBuilder, ValueParser valueParser) {
        this.personRepository = personRepository;
        this.typeBuilder = typeBuilder;
        this.valueParser = valueParser;
    }

    public ObjectDataResponse load(ObjectDataRequest objectDataRequest) {
        List<MObject> objects = null;

        ListFilter listFilter = objectDataRequest.getListFilter() != null ? objectDataRequest.getListFilter() : new ListFilter();

        switch (objectDataRequest.getObjectDataType().getDeveloperName()) {
            case Person.NAME:
                if (listFilter.hasId()) {
                    objects = typeBuilder.from(personRepository.find(listFilter.getId()));
                } else {
                    objects = typeBuilder.from(personRepository.findAll(listFilter.getLimit(), listFilter.getOffset()));
                }

                break;
        }

        return new ObjectDataResponse(objects);
    }

    public ObjectDataResponse save(ObjectDataRequest objectDataRequest) {
        switch (objectDataRequest.getObjectDataType().getDeveloperName()) {
            case Person.NAME:
                Person person = valueParser.fromObject(objectDataRequest.getObjectData(), Person.class);

                int i = 0;

                break;
        }

        return new ObjectDataResponse();
    }
}
