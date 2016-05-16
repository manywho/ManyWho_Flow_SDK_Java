package com.manywho.sdk.services.providers;

import com.google.inject.Provider;
import com.manywho.sdk.services.configuration.ApplicationConfiguration;
import org.reflections.Reflections;
import org.reflections.scanners.FieldAnnotationsScanner;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;

import javax.inject.Inject;

public class ReflectionsProvider implements Provider<Reflections> {
    private final ApplicationConfiguration applicationConfiguration;

    @Inject
    public ReflectionsProvider(ApplicationConfiguration applicationConfiguration) {
        this.applicationConfiguration = applicationConfiguration;
    }

    @Override
    public Reflections get() {
        ConfigurationBuilder configurationBuilder = new ConfigurationBuilder()
                .addUrls(ClasspathHelper.forPackage(applicationConfiguration.getApplicationPackage()))
                .addUrls(ClasspathHelper.forPackage(this.getClass().getPackage().getName()))
                .addScanners(new SubTypesScanner(), new FieldAnnotationsScanner());

        return new Reflections(configurationBuilder);
    }
}
