package com.manywho.sdk.services.unit.describe;

import com.manywho.sdk.services.providers.ReflectionsHelper;
import org.reflections.Reflections;
import org.reflections.scanners.FieldAnnotationsScanner;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.scanners.TypeAnnotationsScanner;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;
import org.reflections.util.FilterBuilder;

public class BaseTest {
    protected ConfigurationBuilder reflectionsConfiguration = new ConfigurationBuilder()
            .addUrls(ClasspathHelper.forClass(this.getClass()))
            .addScanners(new SubTypesScanner(), new FieldAnnotationsScanner(), new TypeAnnotationsScanner());

    protected Reflections createReflections() {
        Reflections reflections = new Reflections(reflectionsConfiguration);

        ReflectionsHelper.expandSupertypes(reflections, SubTypesScanner.class, new String[][]{{ "com.manywho.sdk.services" }});

        return reflections;
    }

    void includeOnly(Class<?>... aClasses) {
        FilterBuilder filterBuilder = new FilterBuilder();
        filterBuilder.add(input -> {
            if (input == null) {
                return false;
            }

            for (Class<?> aClass : aClasses) {
                if (aClass.getName().equals(input.replace("/", ".").substring(0, input.length() - 6))) {
                    return true;
                }
            }

            return false;
        });

        reflectionsConfiguration.filterInputsBy(filterBuilder);
    }
}
