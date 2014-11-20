package com.manywho.sdk.services.describe;

import com.manywho.sdk.entities.Culture;
import com.manywho.sdk.entities.describe.DescribeServiceInstall;
import com.manywho.sdk.entities.describe.DescribeValueCollection;
import com.manywho.sdk.services.ResponseProvider;
import com.manywho.sdk.services.describe.actions.ActionCollection;

public interface DescribeService extends ResponseProvider {
    public Culture createCulture();
    public DescribeValueCollection createConfigurationValues();
    public ActionCollection createActions() throws IllegalAccessException, InstantiationException;
    public DescribeServiceInstall createInstall() throws IllegalAccessException, InstantiationException;
    public boolean getProvidesDatabase();
    public boolean getProvidesLogic();
    public boolean getProvidesViews();
    public boolean getProvidesIdentity();
    public boolean getProvidesSocial();
    public boolean getProvidesFiles();
}
