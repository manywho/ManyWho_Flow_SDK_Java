package com.manywho.sdk.services.describe;

import com.manywho.sdk.entities.describe.DescribeServiceResponse;
import com.manywho.sdk.entities.translate.Culture;
import com.manywho.sdk.entities.describe.DescribeServiceInstall;
import com.manywho.sdk.entities.describe.DescribeValueCollection;
import com.manywho.sdk.services.describe.actions.ActionCollection;

public interface DescribeService {
    Culture createCulture();
    DescribeValueCollection createConfigurationValues();
    ActionCollection createActions() throws IllegalAccessException, InstantiationException;
    DescribeServiceInstall createInstall() throws IllegalAccessException, InstantiationException;
    boolean getProvidesAutoBinding();
    boolean getProvidesDatabase();
    boolean getProvidesFiles();
    boolean getProvidesIdentity();
    boolean getProvidesListening();
    boolean getProvidesLogic();
    boolean getProvidesNotifications();
    boolean getProvidesSmartSave();
    boolean getProvidesSocial();
    boolean getProvidesSharing();
    boolean getProvidesViews();
    boolean getProvidesVoting();
    DescribeServiceResponse createResponse() throws Exception;
}
