package com.manywho.sdk.services.describe;

import com.google.common.collect.Lists;
import com.manywho.sdk.api.describe.DescribeValue;
import com.manywho.sdk.services.actions.ActionRepository;
import com.manywho.sdk.services.configuration.Configuration;
import com.manywho.sdk.services.configuration.ConfigurationRepository;
import com.manywho.sdk.services.controllers.AbstractDataController;
import com.manywho.sdk.services.controllers.AbstractFileController;
import com.manywho.sdk.services.controllers.AbstractIdentityController;
import com.manywho.sdk.services.controllers.AbstractListenerController;
import com.manywho.sdk.services.database.Database;
import com.manywho.sdk.services.files.FileHandler;
import com.manywho.sdk.services.listeners.Listener;
import com.manywho.sdk.services.types.TypeProvider;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

public class DescribeService {
    private final ActionRepository actionRepository;
    private final ConfigurationRepository configurationRepository;
    private final DescribeRepository describeRepository;

    @Inject
    public DescribeService(ActionRepository actionRepository, ConfigurationRepository configurationRepository, DescribeRepository describeRepository) {
        this.actionRepository = actionRepository;
        this.configurationRepository = configurationRepository;
        this.describeRepository = describeRepository;
    }

    public boolean anyActionsDefined() {
        return !actionRepository.getActions().isEmpty();
    }

    public boolean anyConfigurationSettingsExist() {
        return describeRepository.doFieldsAnnotatedWithExist(Configuration.Setting.class);
    }

    public boolean anyDataControllersExist() {
        return describeRepository.doSubtypesOfExist(AbstractDataController.class) ||
                describeRepository.doSubtypesOfExist(Database.class) ||
                describeRepository.doSubtypesOfExist(TypeProvider.class);
    }

    public boolean anyFileControllersExist() {
        return describeRepository.doSubtypesOfExist(AbstractFileController.class) || describeRepository.doSubtypesOfExist(FileHandler.class);
    }

    public boolean anyIdentityControllersExist() {
        return describeRepository.doSubtypesOfExist(AbstractIdentityController.class);
    }

    public boolean anyListenerControllersExist() {
        return describeRepository.doSubtypesOfExist(AbstractListenerController.class) || describeRepository.doSubtypesOfExist(Listener.class);
    }

    public boolean anySocialControllersExist() {
        return false;
//        return describeRepository.doSubtypesOfExist(AbstractSocialController.class);
    }

    public List<DescribeValue> createConfigurationSettings() {
        List<DescribeValue> values = configurationRepository.getConfigurationSettings()
                .stream()
                .map(klass -> klass.getAnnotation(Configuration.Setting.class))
                .map(annotation -> new DescribeValue(annotation.name(), annotation.contentType(), annotation.required()))
                .collect(Collectors.toList());

        if (values.isEmpty()) {
            return Lists.newArrayList();
        }

        return values;
    }
}
