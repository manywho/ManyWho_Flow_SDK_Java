package com.manywho.sdk.api.describe;

import com.google.common.base.MoreObjects;
import com.google.common.collect.Lists;

import java.util.List;

public class DescribeServiceResponse {
    private List<DescribeValue> configurationValues = Lists.newArrayList();
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
    private String version;

    public List<DescribeValue> getConfigurationValues() {
        return configurationValues;
    }

    public void setConfigurationValues(List<DescribeValue> configurationValues) {
        this.configurationValues = MoreObjects.firstNonNull(configurationValues, Lists.newArrayList());
    }

    public boolean isProvidesAutoBinding() {
        return providesAutoBinding;
    }

    public DescribeServiceResponse setProvidesAutoBinding(boolean providesAutoBinding) {
        this.providesAutoBinding = providesAutoBinding;
        return this;
    }

    public boolean isProvidesDatabase() {
        return providesDatabase;
    }

    public void setProvidesDatabase(boolean providesDatabase) {
        this.providesDatabase = providesDatabase;
    }

    public boolean isProvidesFiles() {
        return providesFiles;
    }

    public void setProvidesFiles(boolean providesFiles) {
        this.providesFiles = providesFiles;
    }

    public boolean isProvidesIdentity() {
        return providesIdentity;
    }

    public void setProvidesIdentity(boolean providesIdentity) {
        this.providesIdentity = providesIdentity;
    }

    public boolean isProvidesListening() {
        return providesListening;
    }

    public void setProvidesListening(boolean providesListening) {
        this.providesListening = providesListening;
    }

    public boolean isProvidesLogic() {
        return providesLogic;
    }

    public void setProvidesLogic(boolean providesLogic) {
        this.providesLogic = providesLogic;
    }

    public boolean isProvidesNotifications() {
        return providesNotifications;
    }

    public void setProvidesNotifications(boolean providesNotifications) {
        this.providesNotifications = providesNotifications;
    }

    public boolean isProvidesSmartSave() {
        return providesSmartSave;
    }

    public void setProvidesSmartSave(boolean providesSmartSave) {
        this.providesSmartSave = providesSmartSave;
    }

    public boolean isProvidesSocial() {
        return providesSocial;
    }

    public void setProvidesSocial(boolean providesSocial) {
        this.providesSocial = providesSocial;
    }

    public boolean isProvidesSharing() {
        return providesSharing;
    }

    public void setProvidesSharing(boolean providesSharing) {
        this.providesSharing = providesSharing;
    }

    public boolean isProvidesViews() {
        return providesViews;
    }

    public void setProvidesViews(boolean providesViews) {
        this.providesViews = providesViews;
    }

    public boolean isProvidesVoting() {
        return providesVoting;
    }

    public void setProvidesVoting(boolean providesVoting) {
        this.providesVoting = providesVoting;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
