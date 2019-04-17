package com.manywho.services.example.database;

import com.manywho.sdk.api.draw.content.Command;
import com.manywho.sdk.api.run.elements.type.ListFilter;
import com.manywho.sdk.api.run.elements.type.ObjectDataType;
import com.manywho.sdk.services.database.Database;
import com.manywho.services.example.ServiceConfiguration;
import com.manywho.services.example.repositories.PersonRepository;
import com.manywho.services.example.types.Person;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

public class PersonDatabase implements Database<ServiceConfiguration, Person> {
    private final PersonRepository personRepository;

    @Inject
    public PersonDatabase(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public Person create(ServiceConfiguration configuration, ObjectDataType objectDataType, Person person) {
        return personRepository.create(configuration, person);
    }

    @Override
    public List<Person> create(ServiceConfiguration configuration, ObjectDataType objectDataType, List<Person> objects) {
        return objects.stream()
                .map(object -> create(configuration, objectDataType, object))
                .collect(Collectors.toList());
    }

    @Override
    public void delete(ServiceConfiguration configuration, ObjectDataType objectDataType, Person person) {
        personRepository.delete(configuration, person);
    }

    @Override
    public void delete(ServiceConfiguration configuration, ObjectDataType objectDataType, List<Person> objects) {
        objects.forEach(object -> delete(configuration, objectDataType, object));
    }

    @Override
    public Person find(ServiceConfiguration configuration, ObjectDataType objectDataType, Command command, String id) {
        return personRepository.find(id);
    }

    @Override
    public List<Person> findAll(ServiceConfiguration configuration, ObjectDataType objectDataType, Command command, ListFilter filter) {
        return personRepository.findAll(filter.getLimit(), filter.getOffset());
    }

    @Override
    public Person update(ServiceConfiguration configuration, ObjectDataType objectDataType, Person person) {
        return personRepository.update(configuration, person);
    }

    @Override
    public List<Person> update(ServiceConfiguration configuration, ObjectDataType objectDataType, List<Person> people) {
        return people.stream().map(person -> update(configuration, objectDataType, person)).collect(Collectors.toList());
    }
}
