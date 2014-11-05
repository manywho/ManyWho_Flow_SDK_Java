package com.manywho.sdk.services.describe;

import com.manywho.sdk.entities.describe.DescribeServiceInstall;
import com.manywho.sdk.entities.describe.DescribeServiceRequest;
import com.manywho.sdk.entities.responses.DescribeResponse;
import com.manywho.sdk.entities.responses.ResponseInterface;
import com.manywho.sdk.services.AbstractService;

public abstract class AbstractDescribeService extends AbstractService implements DescribeServiceInterface {
    protected DescribeServiceRequest describeServiceRequest;

    public AbstractDescribeService() {

    }

    public AbstractDescribeService(String json) throws InstantiationException, IllegalAccessException {
        this.describeServiceRequest = this.convertToRequest(json, DescribeServiceRequest.class);
    }

    @Override
    public boolean getProvidesDatabase() {
        return false;
    }

    @Override
    public boolean getProvidesLogic() {
        return true;
    }

    @Override
    public boolean getProvidesViews() {
        return false;
    }

    @Override
    public boolean getProvidesIdentity() {
        return true;
    }

    @Override
    public boolean getProvidesSocial() {
        return false;
    }

    @Override
    public boolean getProvidesFiles() {
        return false;
    }

    @Override
    public DescribeServiceInstall createInstall() {
        return null;
    }

    @Override
    public ResponseInterface createResponse() throws Exception {
        return new DescribeResponse() {{
            setCulture(AbstractDescribeService.this.createCulture());
            setConfigurationValues(AbstractDescribeService.this.createConfigurationValues());
            setProvidesDatabase(AbstractDescribeService.this.getProvidesDatabase());
            setProvidesLogic(AbstractDescribeService.this.getProvidesLogic());
            setProvidesViews(AbstractDescribeService.this.getProvidesViews());
            setProvidesIdentity(AbstractDescribeService.this.getProvidesIdentity());
            setProvidesSocial(AbstractDescribeService.this.getProvidesSocial());
            setProvidesFiles(AbstractDescribeService.this.getProvidesFiles());
            setActions(AbstractDescribeService.this.createActions());
            setInstall(AbstractDescribeService.this.createInstall());
        }};
    }
}
