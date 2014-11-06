package com.manywho.sdk.services.describe;

import com.manywho.sdk.entities.Culture;
import com.manywho.sdk.entities.describe.DescribeServiceInstall;
import com.manywho.sdk.entities.describe.DescribeValueCollection;
import com.manywho.sdk.services.ResponseProviderInterface;
import com.manywho.sdk.services.describe.actions.ActionCollection;

public interface DescribeServiceInterface extends ResponseProviderInterface {
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
