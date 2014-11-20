package com.manywho.sdk.entities;

import com.manywho.sdk.entities.describe.DescribeServiceInstall;
import com.manywho.sdk.entities.describe.DescribeValueCollection;
import com.manywho.sdk.services.describe.actions.ActionCollection;

public class DescribeResponse implements Response {
    private Culture culture;
    private String uri;
    private DescribeValueCollection configurationValues;
    private boolean providesLogic;
    private boolean providesViews;
    private boolean providesDatabase;
    private boolean providesIdentity;
    private boolean providesSocial;
    private boolean providesFiles;
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

    public boolean isProvidesLogic() {
        return providesLogic;
    }

    public void setProvidesLogic(boolean providesLogic) {
        this.providesLogic = providesLogic;
    }

    public boolean isProvidesViews() {
        return providesViews;
    }

    public void setProvidesViews(boolean providesViews) {
        this.providesViews = providesViews;
    }

    public boolean isProvidesDatabase() {
        return providesDatabase;
    }

    public void setProvidesDatabase(boolean providesDatabase) {
        this.providesDatabase = providesDatabase;
    }

    public boolean isProvidesIdentity() {
        return providesIdentity;
    }

    public void setProvidesIdentity(boolean providesIdentity) {
        this.providesIdentity = providesIdentity;
    }

    public boolean isProvidesSocial() {
        return providesSocial;
    }

    public void setProvidesSocial(boolean providesSocial) {
        this.providesSocial = providesSocial;
    }

    public boolean isProvidesFiles() {
        return providesFiles;
    }

    public void setProvidesFiles(boolean providesFiles) {
        this.providesFiles = providesFiles;
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
