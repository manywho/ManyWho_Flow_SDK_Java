package com.manywho.sdk.services.describe;

import org.reflections.Reflections;

import javax.inject.Inject;
import java.lang.annotation.Annotation;

public class DescribeRepository {
    private final Reflections reflections;

    @Inject
    public DescribeRepository(Reflections reflections) {
        this.reflections = reflections;
    }

    public boolean doSubtypesOfExist(Class<?> type) {
        return reflections.getSubTypesOf(type).stream()
                .filter(subType -> subType.getPackage().getName().startsWith("com.manywho.sdk.services.controllers") == false)
                .filter(subType -> subType.getPackage().getName().startsWith("com.manywho.sdk.services.database") == false)
                .filter(subType -> subType.getPackage().getName().startsWith("com.manywho.sdk.services.types") == false)
                .count() > 0;
    }

    public boolean doSubtypesOfExistExcludingSdk(Class<?> type) {
        return reflections.getSubTypesOf(type).stream()
                .anyMatch(subType -> !subType.getPackage().getName().startsWith("com.manywho.sdk"));
    }

    public boolean doFieldsAnnotatedWithExist(final Class<? extends Annotation> annotation) {
        return !reflections.getFieldsAnnotatedWith(annotation).isEmpty();
    }
}
