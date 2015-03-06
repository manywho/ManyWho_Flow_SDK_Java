package com.manywho.sdk.services.describe;

import com.manywho.sdk.entities.draw.elements.type.TypeElement;
import com.manywho.sdk.entities.draw.elements.type.TypeElementCollection;
import com.manywho.sdk.entities.describe.DescribeServiceInstall;
import com.manywho.sdk.entities.describe.DescribeServiceResponse;
import com.manywho.sdk.services.BaseApplication;
import com.manywho.sdk.services.describe.actions.AbstractAction;
import com.manywho.sdk.services.describe.actions.ActionCollection;
import com.manywho.sdk.services.describe.actions.Action;
import com.manywho.sdk.services.describe.types.AbstractType;
import com.manywho.sdk.services.describe.types.Type;
import org.apache.commons.collections4.CollectionUtils;

import java.util.Set;

public abstract class AbstractDescribeService implements DescribeService {
    @Override
    public boolean getProvidesDatabase() {
        return false;
    }

    @Override
    public boolean getProvidesLogic() {
        return false;
    }

    @Override
    public boolean getProvidesViews() {
        return false;
    }

    @Override
    public boolean getProvidesIdentity() {
        return false;
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
        final Set<Class<? extends AbstractAction>> annotatedClasses = BaseApplication.reflections.getSubTypesOf(AbstractAction.class);

        return new ActionCollection() {{
            for (Class<? extends Action> action : annotatedClasses) {
                add(action.newInstance());
            }
        }};
    }

    @Override
    public DescribeServiceInstall createInstall() throws IllegalAccessException, InstantiationException {
        final Set<Class<? extends AbstractType>> annotatedClasses = BaseApplication.reflections.getSubTypesOf(AbstractType.class);

        if (CollectionUtils.isNotEmpty(annotatedClasses)) {
            return new DescribeServiceInstall() {{
                setTypeElements(new TypeElementCollection() {{
                    for (Class<? extends Type> type : annotatedClasses) {
                        add((TypeElement) type.newInstance());
                    }
                }});
            }};
        } else {
            return null;
        }
    }

    @Override
    public DescribeServiceResponse createResponse() {
        try {
            return new DescribeServiceResponse() {{
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
