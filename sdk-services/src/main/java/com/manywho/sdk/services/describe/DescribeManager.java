package com.manywho.sdk.services.describe;

import com.google.common.collect.Lists;
import com.manywho.sdk.api.describe.DescribeServiceActionResponse;
import com.manywho.sdk.api.describe.DescribeServiceRequest;
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

    public DescribeServiceResponse describe(DescribeServiceRequest request) {
        DescribeServiceBuilder builder = new DescribeServiceBuilder();
        builder.setCulture(request.getCulture());

        // If the service contains any controllers that extend AbstractDataController, then we support Database calls
        if (describeService.anyDataControllersExist()) {
            builder.setProvidesDatabase(true);
        }

        // If the service contains any controllers that extend AbstractFileController, then we support Files
        if (describeService.anyFileControllersExist()) {
            builder.setProvidesFiles(true);
        }

        // If the service contains any controllers that extend AbstractIdentityController, then we support Identity
        if (describeService.anyIdentityControllersExist()) {
            builder.setProvidesIdentity(true);
        }

        // If the service contains any controllers that extend AbstractListenerController, then we support Listening
        if (describeService.anyListenerControllersExist()) {
            builder.setProvidesListening(true);
        }

        // If the service contains any controllers that extend AbstractSocialController, then we support Social
        if (describeService.anySocialControllersExist()) {
            builder.setProvidesSocial(true);
        }

        // If the service contains any controllers that implement ViewController, then we support Views
        if (describeService.anyViewControllersExist()) {
            builder.setProvidesViews(true);
        }

        Configuration configuration = configurationParser.from(request, false);

        List<DescribeServiceActionResponse> actionsElements = Lists.newArrayList();
        actionsElements.addAll(describeActionService.createActions());

        List<DescribeServiceActionResponse> customActions = actionProvider.describeActions(configuration, request);
        if (customActions == null) {
            throw new RuntimeException("The configured implementation of " + ActionProvider.class.getCanonicalName() + " must return a valid List<DescribeServiceActionResponse>");
        } else {
            customActions.forEach(action -> action.setUriPart(String.format("actions/%s", action.getUriPart())));
            actionsElements.addAll(customActions);
        }

        builder.setActions(actionsElements);

        if (actionsElements.size() > 0) {
            builder.setProvidesLogic(true);
        }

        List<TypeElement> typeElements = Lists.newArrayList();
        typeElements.addAll(describeTypeService.createTypes());


        List<TypeElement> customTypes = typeProvider.describeTypes(configuration, request);
        if (customTypes == null) {
            throw new RuntimeException("The configured implementation of " + TypeProvider.class.getCanonicalName() + " must return a valid List<TypeElement>");
        } else {
            typeElements.addAll(customTypes);
        }

        builder.setTypes(typeElements);

        if (describeService.anyConfigurationSettingsExist()) {
            builder.setConfigurationSettings(describeService.createConfigurationSettings());
        }

        return builder.createDescribeServiceResponse();
    }
}
