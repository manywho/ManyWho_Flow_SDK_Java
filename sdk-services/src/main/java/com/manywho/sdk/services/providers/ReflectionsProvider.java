package com.manywho.sdk.services.providers;

import com.google.common.collect.Lists;
import com.google.inject.Provider;
import com.manywho.sdk.services.configuration.ApplicationConfiguration;
import org.reflections.Reflections;
import org.reflections.scanners.FieldAnnotationsScanner;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;

import javax.inject.Inject;
import java.io.IOException;
import java.net.URL;
import java.util.Collection;
import java.util.Enumeration;
import java.util.List;

public class ReflectionsProvider implements Provider<Reflections> {
    private final ApplicationConfiguration applicationConfiguration;

    @Inject
    public ReflectionsProvider(ApplicationConfiguration applicationConfiguration) {
        this.applicationConfiguration = applicationConfiguration;
    }

    @Override
    public Reflections get() {
        ConfigurationBuilder configurationBuilder = new ConfigurationBuilder()
                .addUrls(forSinglePackage(applicationConfiguration.getApplicationPackage()))
                .addUrls(forSinglePackage(this.getClass().getPackage().getName()))
                .addUrls(forSinglePackage("com.manywho.sdk.services"))
                .addScanners(new SubTypesScanner(), new FieldAnnotationsScanner());

        Reflections reflections = new Reflections(configurationBuilder);

        ReflectionsHelper.expandSupertypes(reflections, SubTypesScanner.class, new String[][]{
                { applicationConfiguration.getApplicationPackage() },
                { this.getClass().getPackage().getName() },
                { "com.manywho.sdk.services" }
        });

        return reflections;
    }

    private static Collection<URL> forSinglePackage(String name) {
        final List<URL> result = Lists.newArrayList();

        String resourceName = name.replace(".", "/").replace("\\", "/");

        for (ClassLoader classLoader : ClasspathHelper.classLoaders()) {
            try {
                final Enumeration<URL> urls = classLoader.getResources(resourceName);
                while (urls.hasMoreElements()) {
                    result.add(urls.nextElement());
                }
            } catch (IOException e) {
                throw new RuntimeException("Error getting resources for " + name, e);
            }
        }

        return result;
    }
}
