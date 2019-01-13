package com.manywho.services.example.database;

import com.manywho.sdk.api.draw.content.Command;
import com.manywho.sdk.api.run.ServiceProblemException;
import com.manywho.sdk.api.run.elements.type.ListFilter;
import com.manywho.sdk.api.security.AuthenticatedWho;
import com.manywho.sdk.services.database.Database;
import com.manywho.services.example.ServiceConfiguration;
import com.manywho.services.example.repositories.PersonRepository;
import com.manywho.services.example.types.Person;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

public class PersonDatabase implements Database<ServiceConfiguration, Person> {
    private final PersonRepository personRepository;
    private final AuthenticatedWho authenticatedWho;

    @Inject
    public PersonDatabase(PersonRepository personRepository, AuthenticatedWho authenticatedWho) {
        this.personRepository = personRepository;
        this.authenticatedWho = authenticatedWho;
    }

    @Override
    public Person create(ServiceConfiguration configuration, Person person) {
        if (authenticatedWho == null) {
            throw new ServiceProblemException(401, "No authenticated who was given");
        }

        return personRepository.create(configuration, person);
    }

    @Override
    public List<Person> create(ServiceConfiguration configuration, List<Person> objects) {
        if (authenticatedWho == null) {
            throw new ServiceProblemException(401, "No authenticated who was given");
        }

        return objects.stream()
                .map(object -> create(configuration, object))
                .collect(Collectors.toList());
    }

    @Override
    public void delete(ServiceConfiguration configuration, Person person) {
        personRepository.delete(configuration, person);
    }

    @Override
    public void delete(ServiceConfiguration configuration, List<Person> objects) {
        objects.forEach(object -> delete(configuration, object));
    }

    @Override
    public Person find(ServiceConfiguration configuration, Command command, String id) {
        return personRepository.find(id);
    }

    @Override
    public List<Person> findAll(ServiceConfiguration configuration, Command command, ListFilter filter) {
        return personRepository.findAll(filter.getLimit(), filter.getOffset());
    }

    @Override
    public Person update(ServiceConfiguration configuration, Person person) {
        return personRepository.update(configuration, person);
    }

    @Override
    public List<Person> update(ServiceConfiguration configuration, List<Person> people) {
        return people.stream().map(person -> update(configuration, person)).collect(Collectors.toList());
    }
}
