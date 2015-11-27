package com.manywho.sdk.entities.describe;

import com.manywho.sdk.entities.translate.Culture;
import com.manywho.sdk.services.describe.actions.ActionCollection;

public class DescribeServiceResponse {
    private Culture culture;
    private String uri;
    private DescribeValueCollection configurationValues;
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
    private ActionCollection actions;
    private DescribeServiceInstall install;

    public Culture getCulture() {
        return culture;
    }

    public void setCulture(Culture culture) {
        this.culture = culture;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public DescribeValueCollection getConfigurationValues() {
        return configurationValues;
    }

    public void setConfigurationValues(DescribeValueCollection configurationValues) {
        this.configurationValues = configurationValues;
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

    public ActionCollection getActions() {
        return actions;
    }

    public void setActions(ActionCollection actions) {
        this.actions = actions;
    }

    public DescribeServiceInstall getInstall() {
        return install;
    }

    public void setInstall(DescribeServiceInstall install) {
        this.install = install;
    }
}
