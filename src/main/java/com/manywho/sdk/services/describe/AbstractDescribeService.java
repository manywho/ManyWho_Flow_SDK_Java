package com.manywho.sdk.services.describe;

import com.manywho.sdk.entities.draw.elements.type.TypeElement;
import com.manywho.sdk.entities.draw.elements.type.TypeElementCollection;
import com.manywho.sdk.entities.describe.DescribeServiceInstall;
import com.manywho.sdk.entities.describe.DescribeServiceResponse;
import com.manywho.sdk.services.CachedData;
import com.manywho.sdk.services.describe.actions.AbstractAction;
import com.manywho.sdk.services.describe.actions.ActionCollection;
import com.manywho.sdk.services.describe.actions.Action;
import com.manywho.sdk.services.describe.types.AbstractType;
import com.manywho.sdk.services.describe.types.Type;
import org.apache.commons.collections4.CollectionUtils;

import java.util.Collections;
import java.util.Comparator;
import java.util.Set;

public abstract class AbstractDescribeService implements DescribeService {
    @Override
    public boolean getProvidesDatabase() {
        return false;
    }

    @Override
    public boolean getProvidesFiles() {
        return false;
    }

    @Override
    public boolean getProvidesIdentity() {
        return false;
    }

    @Override
    public boolean getProvidesListening() {
        return false;
    }

    @Override
    public boolean getProvidesLogic() {
        return false;
    }

    @Override
    public boolean getProvidesNotifications() {
        return false;
    }

    @Override
    public boolean getProvidesSmartSave() {
        return false;
    }

    @Override
    public boolean getProvidesSocial() {
        return false;
    }

    @Override
    public boolean getProvidesSharing() {
        return false;
    }

    @Override
    public boolean getProvidesViews() {
        return false;
    }

    @Override
    public boolean getProvidesVoting() {
        return false;
    }

    @Override
    public ActionCollection createActions() throws IllegalAccessException, InstantiationException {
        final Set<Class<? extends AbstractAction>> annotatedClasses = CachedData.reflections.getSubTypesOf(AbstractAction.class);

        ActionCollection actionCollection = new ActionCollection() {{
            for (Class<? extends Action> action : annotatedClasses) {
                add(action.newInstance());
            }
        }};
        Collections.sort(actionCollection);

        return actionCollection;
    }

    @Override
    public DescribeServiceInstall createInstall() throws IllegalAccessException, InstantiationException {
        final Set<Class<? extends AbstractType>> annotatedClasses = CachedData.reflections.getSubTypesOf(AbstractType.class);

        TypeElementCollection typeElements = new TypeElementCollection();

        if (CollectionUtils.isNotEmpty(annotatedClasses)) {
            for (Class<? extends Type> type : annotatedClasses) {
                typeElements.add((TypeElement) type.newInstance());
            }
        }
        Collections.sort(typeElements);

        return new DescribeServiceInstall() {{
            setTypeElements(typeElements);
        }};
    }

    @Override
    public DescribeServiceResponse createResponse() throws Exception {
        return new DescribeServiceResponse() {{
            setCulture(AbstractDescribeService.this.createCulture());
            setConfigurationValues(AbstractDescribeService.this.createConfigurationValues());
            setProvidesDatabase(AbstractDescribeService.this.getProvidesDatabase());
            setProvidesFiles(AbstractDescribeService.this.getProvidesFiles());
            setProvidesIdentity(AbstractDescribeService.this.getProvidesIdentity());
            setProvidesListening(AbstractDescribeService.this.getProvidesListening());
            setProvidesLogic(AbstractDescribeService.this.getProvidesLogic());
            setProvidesNotifications(AbstractDescribeService.this.getProvidesNotifications());
            setProvidesSmartSave(AbstractDescribeService.this.getProvidesSmartSave());
            setProvidesSocial(AbstractDescribeService.this.getProvidesSocial());
            setProvidesSharing(AbstractDescribeService.this.getProvidesSharing());
            setProvidesViews(AbstractDescribeService.this.getProvidesViews());
            setProvidesVoting(AbstractDescribeService.this.getProvidesVoting());
            setActions(AbstractDescribeService.this.createActions());
            setInstall(AbstractDescribeService.this.createInstall());
        }};
    }
}
