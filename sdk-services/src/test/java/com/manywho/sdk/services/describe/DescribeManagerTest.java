package com.manywho.sdk.services.describe;

import com.google.common.io.Resources;
import com.manywho.sdk.api.describe.DescribeServiceRequest;
import com.manywho.sdk.api.describe.DescribeServiceResponse;
import com.manywho.sdk.services.actions.Action;
import com.manywho.sdk.services.actions.ActionCommand;
import com.manywho.sdk.services.actions.ActionResponse;
import com.manywho.sdk.services.jaxrs.resolvers.ObjectMapperContextResolver;
import org.junit.Test;
import org.reflections.Reflections;
import org.skyscreamer.jsonassert.JSONAssert;

import java.nio.file.Files;
import java.nio.file.Paths;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasProperty;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

public class DescribeManagerTest extends BaseTest {
    @Test
    public void testDescribe() throws Exception {
        includeOnly(TestAction.class);

        Reflections reflections = createReflections();

        DescribeManager manager = new DescribeManager(
                new DescribeService(reflections),
                new DescribeTypeService(reflections),
                new DescribeActionService(reflections)
        );

        DescribeServiceResponse response = manager.describe(new DescribeServiceRequest());

        assertNotNull(response.getActions());
        assertEquals(1, response.getActions().size());
        assertThat(response.getActions(), hasItem(hasProperty("developerName", equalTo(TestAction.NAME))));
        assertThat(response.getActions(), hasItem(hasProperty("uriPart", containsString(TestAction.URI))));

        JSONAssert.assertEquals(readResourceAsString("responses/metadata.json"), new ObjectMapperContextResolver().getContext(null).writeValueAsString(response), false);
    }

    @Action.Metadata(name = TestAction.NAME, summary = "A test action summary", uri = TestAction.URI)
    class TestAction implements ActionCommand<TestAction, TestAction, TestAction> {
        static final String NAME = "Test Action";
        static final String URI = "testaction";

        @Override
        public ActionResponse<TestAction> execute(TestAction input) {
            return null;
        }
    }

    String readResourceAsString(String name) throws Exception {
        return new String(Files.readAllBytes(Paths.get(Resources.getResource(name).toURI())));
    }
}
