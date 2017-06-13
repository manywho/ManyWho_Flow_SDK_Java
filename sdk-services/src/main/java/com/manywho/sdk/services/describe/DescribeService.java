package com.manywho.sdk.services.describe;

import com.google.common.collect.Lists;
import com.manywho.sdk.api.describe.DescribeValue;
import com.manywho.sdk.services.actions.ActionProvider;
import com.manywho.sdk.services.actions.ActionRepository;
import com.manywho.sdk.services.configuration.Configuration;
import com.manywho.sdk.services.configuration.ConfigurationRepository;
import com.manywho.sdk.services.controllers.AuthenticationController;
import com.manywho.sdk.services.controllers.AuthorizationController;
import com.manywho.sdk.services.controllers.DataController;
import com.manywho.sdk.services.controllers.FileController;
import com.manywho.sdk.services.controllers.IdentityController;
import com.manywho.sdk.services.controllers.ListenerController;
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

    public boolean anyActionProviderDefined() {
        return describeRepository.doSubtypesOfExistExcludingSdk(ActionProvider.class);
    }

    public boolean anyActionsDefined() {
        return !actionRepository.getActions().isEmpty();
    }

    public boolean anyConfigurationSettingsExist() {
        return describeRepository.doFieldsAnnotatedWithExist(Configuration.Setting.class);
    }

    public boolean anyDataControllersExist() {
        return describeRepository.doSubtypesOfExist(DataController.class) ||
                describeRepository.doSubtypesOfExist(Database.class) ||
                describeRepository.doSubtypesOfExist(TypeProvider.class);
    }

    public boolean anyFileControllersExist() {
        return describeRepository.doSubtypesOfExist(FileController.class) || describeRepository.doSubtypesOfExist(FileHandler.class);
    }

    public boolean anyIdentityControllersExist() {
        return describeRepository.doSubtypesOfExist(AuthenticationController.class) ||
                describeRepository.doSubtypesOfExist(AuthorizationController.class) ||
                describeRepository.doSubtypesOfExist(IdentityController.class);
    }

    public boolean anyListenerControllersExist() {
        return describeRepository.doSubtypesOfExist(ListenerController.class) || describeRepository.doSubtypesOfExist(Listener.class);
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
