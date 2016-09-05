package com.manywho.services.example.listeners;

import com.manywho.sdk.services.listeners.Listener;
import com.manywho.services.example.ServiceConfiguration;
import com.manywho.services.example.types.Person;

import java.util.List;

@Listener.Metadata(event = "PERSON_UPDATED")
public class PersonUpdatedListener implements Listener<ServiceConfiguration, Person> {
    @Override
    public void create(ServiceConfiguration configuration, Person value) {

    }

    @Override
    public void createMultiple(ServiceConfiguration configuration, List<Person> values) {

    }
}
