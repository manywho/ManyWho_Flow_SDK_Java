package com.manywho.sdk.services.describe;

import com.manywho.sdk.entities.TypeElement;
import com.manywho.sdk.entities.TypeElementCollection;
import com.manywho.sdk.entities.describe.DescribeServiceInstall;
import com.manywho.sdk.entities.describe.DescribeServiceRequest;
import com.manywho.sdk.entities.DescribeResponse;
import com.manywho.sdk.entities.ResponseInterface;
import com.manywho.sdk.services.BaseApplication;
import com.manywho.sdk.services.AbstractService;
import com.manywho.sdk.services.BaseApplication;
import com.manywho.sdk.services.BaseApplication;
import com.manywho.sdk.services.annotations.DescribeAction;
import com.manywho.sdk.services.annotations.DescribeType;
import com.manywho.sdk.services.describe.actions.ActionCollection;
import com.manywho.sdk.services.describe.actions.ActionInterface;
import org.reflections.Reflections;

import java.util.Set;

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
    public ActionCollection createActions() throws IllegalAccessException, InstantiationException {
        final Set<Class<?>> annotatedClasses = BaseApplication.reflections.getTypesAnnotatedWith(DescribeAction.class);

        return new ActionCollection() {{
            for (Class<?> action : annotatedClasses) {
                add((ActionInterface) action.newInstance());
            }
        }};
    }

    @Override
    public DescribeServiceInstall createInstall() throws IllegalAccessException, InstantiationException {
        final Set<Class<?>> annotatedClasses = BaseApplication.reflections.getTypesAnnotatedWith(DescribeType.class);

        if (!annotatedClasses.isEmpty()) {
            return new DescribeServiceInstall() {{
                setTypeElements(new TypeElementCollection() {{
                    for (Class<?> type : annotatedClasses) {
                        add((TypeElement) type.newInstance());
                    }
                }});
            }};
        } else {
            return null;
        }
    }

    @Override
    public ResponseInterface createResponse() {
        try {
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
        } catch (Exception e) {
            // @todo Log something here
            return null;
        }
    }
}
