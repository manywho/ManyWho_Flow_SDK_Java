package com.manywho.sdk.services.describe;

import com.google.common.collect.Lists;
import com.manywho.sdk.api.describe.DescribeServiceRequest;
import com.manywho.sdk.api.describe.DescribeServiceResponse;
import com.manywho.sdk.api.draw.elements.type.TypeElement;
import com.manywho.sdk.services.types.TypeProvider;

import javax.inject.Inject;
import java.util.List;

public class DescribeManager {
    private final DescribeService describeService;
    private final DescribeTypeService describeTypeService;
    private final DescribeActionService describeActionService;
    private final TypeProvider typeProvider;

    @Inject
    public DescribeManager(DescribeService describeService, DescribeTypeService describeTypeService, DescribeActionService describeActionService, TypeProvider typeProvider) {
        this.describeService = describeService;
        this.describeTypeService = describeTypeService;
        this.describeActionService = describeActionService;
        this.typeProvider = typeProvider;
    }

    public DescribeServiceResponse describe(DescribeServiceRequest request) {
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

        if (describeService.anyActionsDefined()) {
            builder.setProvidesLogic(true);

            builder.setActions(describeActionService.createActions());
        }

        List<TypeElement> typeElements = Lists.newArrayList();
        typeElements.addAll(describeTypeService.createTypes());

        List<TypeElement> customTypes = typeProvider.describeTypes(request);
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
