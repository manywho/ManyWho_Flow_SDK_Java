package com.manywho.sdk.services.describe;

import com.manywho.sdk.api.describe.DescribeInstallRequest;
import com.manywho.sdk.api.describe.DescribeInstallResponse;
import com.manywho.sdk.api.describe.DescribeServiceActionResponse;
import com.manywho.sdk.api.describe.DescribeServiceResponse;
import com.manywho.sdk.api.draw.elements.type.TypeElement;
import com.manywho.sdk.services.actions.ActionProvider;
import com.manywho.sdk.services.configuration.Configuration;
import com.manywho.sdk.services.configuration.ConfigurationParser;
import com.manywho.sdk.services.types.TypeProvider;

import javax.inject.Inject;
import java.util.List;

public class DescribeManager {
    private final DescribeService describeService;
    private final DescribeTypeService describeTypeService;
    private final DescribeActionService describeActionService;
    private final TypeProvider typeProvider;
    private final ConfigurationParser configurationParser;
    private final ActionProvider actionProvider;

    @Inject
    public DescribeManager(
            DescribeService describeService,
            DescribeTypeService describeTypeService,
            DescribeActionService describeActionService,
            TypeProvider typeProvider,
            ConfigurationParser configurationParser,
            ActionProvider actionProvider
    ) {
        this.describeService = describeService;
        this.describeTypeService = describeTypeService;
        this.describeActionService = describeActionService;
        this.typeProvider = typeProvider;
        this.configurationParser = configurationParser;
        this.actionProvider = actionProvider;
    }

    public DescribeServiceResponse describe() {
        DescribeServiceResponse describeServiceResponse = new DescribeServiceResponse();
        describeServiceResponse.setVersion("2");

        // If the service contains any controllers that extend AbstractDataController, then we support Database calls
        if (describeService.anyDataControllersExist()) {
            describeServiceResponse.setProvidesDatabase(true);
        }

        // If the service contains any controllers that extend AbstractFileController, then we support Files
        if (describeService.anyFileControllersExist()) {
            describeServiceResponse.setProvidesFiles(true);
        }

        // If the service contains any controllers that extend AbstractIdentityController, then we support Identity
        if (describeService.anyIdentityControllersExist()) {
            describeServiceResponse.setProvidesIdentity(true);
        }

        // If the service contains any controllers that extend AbstractListenerController, then we support Listening
        if (describeService.anyListenerControllersExist()) {
            describeServiceResponse.setProvidesListening(true);
        }

        // If the service contains any actions, or has an action provider then we support Logic
        if (describeService.anyActionsDefined() || describeService.anyActionProviderDefined()) {
            describeServiceResponse.setProvidesLogic(true);
        }

        // If the service contains any controllers that extend AbstractSocialController, then we support Social
        if (describeService.anySocialControllersExist()) {
            describeServiceResponse.setProvidesSocial(true);
        }

        if (describeService.anyConfigurationSettingsExist()) {
            describeServiceResponse.setConfigurationValues(describeService.createConfigurationSettings());
        }

        return describeServiceResponse;
    }

    public DescribeInstallResponse install(DescribeInstallRequest request) {
        DescribeInstallResponse response = new DescribeInstallResponse();

        Configuration configuration = configurationParser.from(request, false);

        // Create the list of actions, both static and dynamic ones
        List<DescribeServiceActionResponse> actionsElements = describeActionService.createActions();

        List<DescribeServiceActionResponse> customActions = actionProvider.describeActions(configuration, request);
        if (customActions == null) {
            throw new RuntimeException("The configured implementation of " + ActionProvider.class.getCanonicalName() + " must return a valid List<DescribeServiceActionResponse>");
        } else {
            // We want to append "actions/" to the beginning of any custom action URIs
            customActions.forEach(action -> action.setUriPart("actions/" + action.getUriPart()));

            actionsElements.addAll(customActions);
        }

        response.setActions(actionsElements);

        // Create the list of types, both static and dynamic ones
        List<TypeElement> typeElements = describeTypeService.createTypes();

        List<TypeElement> customTypes = typeProvider.describeTypes(configuration, request);
        if (customTypes == null) {
            throw new RuntimeException("The configured implementation of " + TypeProvider.class.getCanonicalName() + " must return a valid List<TypeElement>");
        } else {
            typeElements.addAll(customTypes);
        }

        response.setTypes(typeElements);

        return response;
    }
}
