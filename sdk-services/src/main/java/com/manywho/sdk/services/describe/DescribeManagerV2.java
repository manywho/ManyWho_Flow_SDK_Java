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
import java.util.Collections;
import java.util.List;

public class DescribeManagerV2 {
    private final DescribeService describeService;
    private final DescribeTypeService describeTypeService;
    private final DescribeActionService describeActionService;
    private final TypeProvider typeProvider;
    private final ConfigurationParser configurationParser;
    private final ActionProvider actionProvider;

    @Inject
    public DescribeManagerV2(
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
        DescribeServiceBuilder builder = new DescribeServiceBuilder();

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

        if (describeService.anyConfigurationSettingsExist()) {
            builder.setConfigurationSettings(describeService.createConfigurationSettings());
        }

        return builder.createDescribeServiceResponse();
    }

    public DescribeServiceResponse install(DescribeServiceRequest request) {
        DescribeServiceBuilder builder = new DescribeServiceBuilder();
        builder.setCulture(request.getCulture());

        Configuration configuration = configurationParser.from(request, false);

        createActions(request, builder, configuration);
        createTypes(request, builder, configuration);

        if (describeService.anyConfigurationSettingsExist()) {
            builder.setConfigurationSettings(describeService.createConfigurationSettings());
        }

        return builder.createDescribeServiceResponse();
    }

    private void createTypes(DescribeServiceRequest request, DescribeServiceBuilder builder,
            Configuration configuration) {
        List<TypeElement> typeElements = Lists.newArrayList();
        typeElements.addAll(describeTypeService.createTypes());

        List<TypeElement> customTypes = typeProvider.describeTypes(configuration, request);
        if (customTypes == null) {
            throw new RuntimeException("The configured implementation of " + TypeProvider.class.getCanonicalName() + " must return a valid List<TypeElement>");
        } else {
            typeElements.addAll(customTypes);
        }

        // Sort the types alphabetically
        Collections.sort(typeElements);

        builder.setTypes(typeElements);
    }

    private void createActions(DescribeServiceRequest request, DescribeServiceBuilder builder,
            Configuration configuration) {
        List<DescribeServiceActionResponse> actionsElements = Lists.newArrayList();
        actionsElements.addAll(describeActionService.createActions());

        List<DescribeServiceActionResponse> customActions = actionProvider.describeActions(configuration, request);
        if (customActions == null) {
            throw new RuntimeException("The configured implementation of " + ActionProvider.class.getCanonicalName() + " must return a valid List<DescribeServiceActionResponse>");
        } else {
            customActions.forEach(action -> action.setUriPart(String.format("actions/%s", action.getUriPart())));
            actionsElements.addAll(customActions);
        }

        // Sort the actions alphabetically
        Collections.sort(actionsElements);

        builder.setActions(actionsElements);

        if (actionsElements.size() > 0) {
            builder.setProvidesLogic(true);
        }
    }
}
