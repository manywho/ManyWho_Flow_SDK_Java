package com.manywho.sdk.services.describe;

import com.google.common.collect.Lists;
import com.manywho.sdk.api.describe.DescribeValue;
import com.manywho.sdk.services.actions.Action;
import com.manywho.sdk.services.configuration.ConfigurationValue;
import com.manywho.sdk.services.controllers.AbstractDataController;
import com.manywho.sdk.services.controllers.AbstractFileController;
import com.manywho.sdk.services.controllers.AbstractIdentityController;
import com.manywho.sdk.services.controllers.AbstractListenerController;
import com.manywho.sdk.services.controllers.AbstractSocialController;
import com.manywho.sdk.services.types.Type;
import org.reflections.Reflections;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

class DescribeService {
    private final Reflections reflections;

    @Inject
    public DescribeService(Reflections reflections) {
        this.reflections = reflections;
    }

    public boolean anyActionsDefined() {
        return !reflections.getSubTypesOf(Action.class).isEmpty();
    }

    boolean anyConfigurationValuesExist() {
        return !reflections.getFieldsAnnotatedWith(ConfigurationValue.class).isEmpty();
    }

    boolean anyDataControllersExist() {
        return !reflections.getSubTypesOf(AbstractDataController.class).isEmpty();
    }

    boolean anyFileControllersExist() {
        return !reflections.getSubTypesOf(AbstractFileController.class).isEmpty();
    }

    boolean anyIdentityControllersExist() {
        return !reflections.getSubTypesOf(AbstractIdentityController.class).isEmpty();
    }

    boolean anyListenerControllersExist() {
        return !reflections.getSubTypesOf(AbstractListenerController.class).isEmpty();
    }

    boolean anySocialControllersExist() {
        return !reflections.getSubTypesOf(AbstractSocialController.class).isEmpty();
    }

    boolean anyTypesDefined() {
        return !reflections.getTypesAnnotatedWith(Type.Element.class).isEmpty();
    }

    List<DescribeValue> createConfigurationValues() {
        List<DescribeValue> values = reflections.getFieldsAnnotatedWith(ConfigurationValue.class)
                .stream()
                .map(klass -> klass.getAnnotation(ConfigurationValue.class))
                .map(annotation -> new DescribeValue(annotation.name(), annotation.contentType(), annotation.required()))
                .collect(Collectors.toList());

        if (values.isEmpty()) {
            return Lists.newArrayList();
        }

        return values;
    }
}
