package com.manywho.services.example;

import com.github.javafaker.Faker;
import com.google.inject.AbstractModule;
import com.manywho.sdk.services.types.TypeProvider;
import com.manywho.services.example.types.RawTypeProvider;

import javax.inject.Singleton;

public class ApplicationModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(Faker.class).in(Singleton.class);
        bind(TypeProvider.class).to(RawTypeProvider.class);
    }
}
