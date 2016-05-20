package com.manywho.services.example.database;

import com.google.common.collect.Lists;
import com.manywho.sdk.api.run.elements.type.ListFilter;
import com.manywho.sdk.services.database.Database;
import com.manywho.services.example.repositories.PersonRepository;
import com.manywho.services.example.types.Person;

import javax.inject.Inject;
import java.util.Collection;
import java.util.UUID;
import java.util.stream.Collectors;

public class PersonDatabase implements Database<Person> {
    private final PersonRepository personRepository;

    @Inject
    public PersonDatabase(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public Person create(Person person) {
        person.setId(UUID.randomUUID().toString());

        return person;
    }

    @Override
    public Collection<Person> create(Collection<Person> objects) {
        return objects.stream().map(this::create).collect(Collectors.toList());
    }

    @Override
    public void delete(Person person) {
        int i = 0;
    }

    @Override
    public void delete(Collection<Person> objects) {
        int i = 0;
    }

    @Override
    public Person find(String id) {
        return personRepository.find(id);
    }

    @Override
    public Collection<Person> findAll(ListFilter filter) {
        return personRepository.findAll(filter.getLimit(), filter.getOffset());
    }

    @Override
    public Person update(Person person) {
        return new Person();
    }

    @Override
    public Collection<Person> update(Collection<Person> people) {
        return Lists.newArrayList();
    }
}
