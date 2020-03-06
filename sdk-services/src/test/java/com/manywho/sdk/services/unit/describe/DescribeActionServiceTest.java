package com.manywho.sdk.services.unit.describe;

import com.google.common.collect.Lists;
import com.manywho.sdk.api.ContentType;
import com.manywho.sdk.api.describe.DescribeServiceActionResponse;
import com.manywho.sdk.services.actions.ActionCommandNotFoundException;
import com.manywho.sdk.services.actions.ActionRepository;
import com.manywho.sdk.services.describe.DescribeActionService;
import com.manywho.sdk.services.unit.entities.TestAction;
import com.manywho.sdk.services.unit.entities.TestActionCommand;
import com.manywho.sdk.services.unit.entities.TestActionWithoutCommand;
import com.manywho.sdk.services.unit.entities.TestActionWithoutMetadata;
import com.manywho.sdk.services.unit.entities.TestType;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasProperty;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class DescribeActionServiceTest extends BaseTest {
    private DescribeActionService createDescribeActionService() {
        return new DescribeActionService(new ActionRepository(createReflections()));
    }

    @Test
    public void testCreateActions() {
        includeOnly(TestAction.class, TestActionCommand.class);

        List<DescribeServiceActionResponse> result = createDescribeActionService().createActions();

        assertNotNull(result);
        assertFalse(result.isEmpty());
        assertThat(result, hasItem(hasProperty("developerName", equalTo("Test Action"))));
        assertThat(result, hasItem(hasProperty("developerSummary", equalTo("Test summary"))));
        assertThat(result, hasItem(hasProperty("uriPart", equalTo("actions/testaction"))));
        assertThat(result, hasItem(hasProperty("serviceInputs", hasItem(hasProperty("developerName", equalTo("Name"))))));
        assertThat(result, hasItem(hasProperty("serviceInputs", hasItem(hasProperty("contentType", equalTo(ContentType.String))))));
        assertThat(result, hasItem(hasProperty("serviceInputs", hasItem(hasProperty("developerName", equalTo("Type"))))));
        assertThat(result, hasItem(hasProperty("serviceInputs", hasItem(hasProperty("contentType", equalTo(ContentType.Object))))));
        assertThat(result, hasItem(hasProperty("serviceInputs", hasItem(hasProperty("typeElementDeveloperName", equalTo(TestType.NAME))))));
        assertThat(result, hasItem(hasProperty("serviceInputs", hasItem(hasProperty("developerName", equalTo("Types"))))));
        assertThat(result, hasItem(hasProperty("serviceInputs", hasItem(hasProperty("contentType", equalTo(ContentType.List))))));
    }

    @Test(expected = ActionCommandNotFoundException.class)
    public void testCreateActionsWithoutCommand() {
        includeOnly(TestActionWithoutCommand.class);

        List<DescribeServiceActionResponse> result = createDescribeActionService().createActions();

        assertNotNull(result);
        assertFalse(result.isEmpty());
    }

    @Test
    public void testCreateActionsWithoutAnyActions() {
        reflectionsConfiguration.setUrls(Lists.newArrayList());

        List<DescribeServiceActionResponse> result = createDescribeActionService().createActions();

        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    @Test
    public void testCreateActionsWithoutActionMetadata() {
        includeOnly(TestActionWithoutMetadata.class);

        List<DescribeServiceActionResponse> result = createDescribeActionService().createActions();

        assertNotNull(result);
        assertTrue(result.isEmpty());
    }
}
