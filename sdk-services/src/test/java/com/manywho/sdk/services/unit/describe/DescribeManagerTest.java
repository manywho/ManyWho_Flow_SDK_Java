package com.manywho.sdk.services.unit.describe;

import com.google.common.io.Resources;
import com.manywho.sdk.api.describe.DescribeServiceRequest;
import com.manywho.sdk.api.describe.DescribeServiceResponse;
import com.manywho.sdk.services.actions.ActionRepository;
import com.manywho.sdk.services.configuration.ConfigurationRepository;
import com.manywho.sdk.services.describe.DescribeActionService;
import com.manywho.sdk.services.describe.DescribeManager;
import com.manywho.sdk.services.describe.DescribeRepository;
import com.manywho.sdk.services.describe.DescribeService;
import com.manywho.sdk.services.describe.DescribeTypeService;
import com.manywho.sdk.services.jaxrs.resolvers.ObjectMapperContextResolver;
import com.manywho.sdk.services.types.DummyTypeProvider;
import com.manywho.sdk.services.types.TypeRepository;
import com.manywho.sdk.services.unit.entities.TestAction;
import com.manywho.sdk.services.unit.entities.TestActionCommand;
import com.manywho.sdk.services.unit.entities.TestConfigurationSettings;
import com.manywho.sdk.services.unit.entities.TestDataController;
import com.manywho.sdk.services.unit.entities.TestFileController;
import com.manywho.sdk.services.unit.entities.TestIdentityController;
import com.manywho.sdk.services.unit.entities.TestListenerController;
import com.manywho.sdk.services.unit.entities.TestSocialController;
import com.manywho.sdk.services.unit.entities.TestType;
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
        includeOnly(
                TestConfigurationSettings.class,
                TestDataController.class,
                TestFileController.class,
                TestIdentityController.class,
                TestListenerController.class,
                TestSocialController.class,
                TestAction.class,
                TestActionCommand.class,
                TestType.class
        );

        Reflections reflections = createReflections();

        ActionRepository actionRepository = new ActionRepository(reflections);
        TypeRepository typeRepository = new TypeRepository(reflections);

        DescribeManager manager = new DescribeManager(
                new DescribeService(actionRepository, new ConfigurationRepository(reflections), new DescribeRepository(reflections)),
                new DescribeTypeService(typeRepository),
                new DescribeActionService(actionRepository),
                new DummyTypeProvider());

        DescribeServiceResponse response = manager.describe(new DescribeServiceRequest());

        assertNotNull(response.getActions());
        assertEquals(1, response.getActions().size());
        assertThat(response.getActions(), hasItem(hasProperty("developerName", equalTo(TestAction.NAME))));
        assertThat(response.getActions(), hasItem(hasProperty("uriPart", containsString(TestAction.URI))));

        JSONAssert.assertEquals(readResourceAsString("responses/metadata.json"), new ObjectMapperContextResolver().getContext(null).writeValueAsString(response), false);
    }

    String readResourceAsString(String name) throws Exception {
        return new String(Files.readAllBytes(Paths.get(Resources.getResource(name).toURI())));
    }
}
