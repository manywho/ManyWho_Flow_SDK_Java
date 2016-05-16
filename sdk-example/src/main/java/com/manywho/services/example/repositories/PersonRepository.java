package com.manywho.services.example.repositories;

import com.github.javafaker.Faker;
import com.google.common.collect.Lists;
import com.manywho.services.example.types.Group;
import com.manywho.services.example.types.Person;

import javax.inject.Inject;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.stream.IntStream;

public class PersonRepository {
    private final Faker faker;

    @Inject
    public PersonRepository(Faker faker) {
        this.faker = faker;
    }

    public Person find(String id) {
        Person person = createPerson();
        person.setManager(createPerson());

        return person;
    }

    public List<Person> findAll(int limit, int offset) {
        List<Person> people = Lists.newArrayList();

        IntStream.range(0, faker.number().numberBetween(3, 8)).forEachOrdered(i -> {
            people.add(find(faker.idNumber().valid()));
        });

        return people;
    }

    Person createPerson() {
        List<Group> groups = Lists.newArrayList();
        groups.add(new Group("1", "Developers"));
        groups.add(new Group("2", "TechOps"));

        Person person = new Person();
        person.setActive(faker.bool().bool());
        person.setAge(faker.number().numberBetween(1, 80));
        person.setBiography(faker.chuckNorris().fact());
        person.setCreatedAt(OffsetDateTime.ofInstant(faker.date().between(new Date(123456), new Date()).toInstant(), ZoneId.systemDefault()));
        person.setGroups(groups);
        person.setId(faker.idNumber().valid());
        person.setName(faker.name().fullName());
        person.setPassword(faker.crypto().md5());
        person.setSocialSecurityNumber(faker.idNumber().ssnValid());

        return person;
    }
}
