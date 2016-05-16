package com.manywho.sdk.services.describe;

import com.google.common.collect.Lists;
import com.manywho.sdk.api.describe.DescribeServiceActionResponse;
import com.manywho.sdk.api.describe.DescribeServiceInstall;
import com.manywho.sdk.api.describe.DescribeServiceResponse;
import com.manywho.sdk.api.describe.DescribeValue;
import com.manywho.sdk.api.draw.elements.type.TypeElement;
import com.manywho.sdk.api.translate.Culture;

import java.util.List;

public class DescribeServiceBuilder {
    private boolean providesAutoBinding;
    private boolean providesDatabase;
    private boolean providesFiles;
    private boolean providesIdentity;
    private boolean providesListening;
    private boolean providesLogic;
    private boolean providesNotifications;
    private boolean providesSmartSave;
    private boolean providesSocial;
    private boolean providesSharing;
    private boolean providesViews;
    private boolean providesVoting;
    private Culture culture;
    private List<DescribeValue> configurationValues = Lists.newArrayList();
    private List<DescribeServiceActionResponse> actions = Lists.newArrayList();
    private List<TypeElement> types = Lists.newArrayList();

    public DescribeServiceBuilder setProvidesAutoBinding(boolean providesAutoBinding) {
        this.providesAutoBinding = providesAutoBinding;
        return this;
    }

    public DescribeServiceBuilder setProvidesDatabase(boolean providesDatabase) {
        this.providesDatabase = providesDatabase;
        return this;
    }

    public DescribeServiceBuilder setProvidesFiles(boolean providesFiles) {
        this.providesFiles = providesFiles;
        return this;
    }

    public DescribeServiceBuilder setProvidesIdentity(boolean providesIdentity) {
        this.providesIdentity = providesIdentity;
        return this;
    }

    public DescribeServiceBuilder setProvidesListening(boolean providesListening) {
        this.providesListening = providesListening;
        return this;
    }

    public DescribeServiceBuilder setProvidesLogic(boolean providesLogic) {
        this.providesLogic = providesLogic;
        return this;
    }

    public DescribeServiceBuilder setProvidesNotifications(boolean providesNotifications) {
        this.providesNotifications = providesNotifications;
        return this;
    }

    public DescribeServiceBuilder setProvidesSmartSave(boolean providesSmartSave) {
        this.providesSmartSave = providesSmartSave;
        return this;
    }

    public DescribeServiceBuilder setProvidesSocial(boolean providesSocial) {
        this.providesSocial = providesSocial;
        return this;
    }

    public DescribeServiceBuilder setProvidesSharing(boolean providesSharing) {
        this.providesSharing = providesSharing;
        return this;
    }

    public DescribeServiceBuilder setProvidesViews(boolean providesViews) {
        this.providesViews = providesViews;
        return this;
    }

    public DescribeServiceBuilder setProvidesVoting(boolean providesVoting) {
        this.providesVoting = providesVoting;
        return this;
    }

    public DescribeServiceBuilder setCulture(Culture culture) {
        this.culture = culture;
        return this;
    }

    public DescribeServiceBuilder addConfigurationValue(DescribeValue configurationValue) {
        this.configurationValues.add(configurationValue);
        return this;
    }

    public DescribeServiceBuilder setConfigurationValues(List<DescribeValue> configurationValues) {
        this.configurationValues = configurationValues;
        return this;
    }

    public DescribeServiceBuilder setActions(List<DescribeServiceActionResponse> actions) {
        this.actions = actions;
        return this;
    }

    public DescribeServiceBuilder setTypes(List<TypeElement> types) {
        this.types = types;
        return this;
    }

    public DescribeServiceResponse createDescribeServiceResponse() {
        DescribeServiceResponse response = new DescribeServiceResponse();
        response.setActions(actions);
        response.setConfigurationValues(configurationValues);
        response.setCulture(culture);
        response.setInstall(new DescribeServiceInstall(types));
        response.setProvidesAutoBinding(providesAutoBinding);
        response.setProvidesDatabase(providesDatabase);
        response.setProvidesFiles(providesFiles);
        response.setProvidesIdentity(providesIdentity);
        response.setProvidesListening(providesListening);
        response.setProvidesLogic(providesLogic);
        response.setProvidesNotifications(providesNotifications);
        response.setProvidesSharing(providesSharing);
        response.setProvidesSmartSave(providesSmartSave);
        response.setProvidesSocial(providesSocial);
        response.setProvidesViews(providesViews);
        response.setProvidesVoting(providesVoting);

        return response;

//        return new AbstractDescribeService() {
//
//            @Override
//            public DescribeServiceInstall createInstall() throws IllegalAccessException, InstantiationException {
//                // Still auto-discover any types in the service
//                TypeElementCollection discoveredTypes = super.createInstall().getTypeElements();
//
//                // If any types were passed into the builder, add them to the collection
//                if (CollectionUtils.isNotEmpty(types)) {
//                    discoveredTypes.addAll(types);
//                }
//
//                return new DescribeServiceInstall(discoveredTypes);
//            }
//        };
    }
}