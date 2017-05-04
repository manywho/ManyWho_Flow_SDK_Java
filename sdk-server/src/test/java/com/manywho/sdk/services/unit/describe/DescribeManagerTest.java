package com.manywho.sdk.services.unit.describe;

import com.google.common.io.Resources;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.manywho.sdk.api.describe.DescribeServiceRequest;
import com.manywho.sdk.api.describe.DescribeServiceResponse;
import com.manywho.sdk.services.actions.ActionRepository;
import com.manywho.sdk.services.actions.DummyActionProvider;
import com.manywho.sdk.services.configuration.ConfigurationParser;
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
import com.manywho.sdk.services.values.ValueParser;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.reflections.Reflections;
import org.skyscreamer.jsonassert.JSONAssert;

import java.nio.file.Files;
import java.nio.file.Paths;

public class DescribeManagerTest extends BaseTest {
    @Test
    public void testDescribe() throws Exception {
//        includeOnly(
//                TestConfigurationSettings.class,
//                TestDataController.class,
//                TestFileController.class,
//                TestIdentityController.class,
//                TestListenerController.class,
//                TestSocialController.class,
//                TestAction.class,
//                TestActionCommand.class,
//                TestType.class
//        );

        Reflections reflections = createReflections();

        Injector injector = Guice.createInjector();

        ActionRepository actionRepository = new ActionRepository(reflections);
        ConfigurationRepository configurationRepository = new ConfigurationRepository(reflections);
        TypeRepository typeRepository = new TypeRepository(reflections);

        DescribeManager manager = new DescribeManager(
                new DescribeService(actionRepository, configurationRepository, new DescribeRepository(reflections)),
                new DescribeTypeService(typeRepository),
                new DescribeActionService(actionRepository),
                new DummyTypeProvider(),
                new ConfigurationParser(injector, configurationRepository, new ValueParser(typeRepository)),
                new DummyActionProvider());

        DescribeServiceResponse response = manager.describe(new DescribeServiceRequest());

        Assert.assertNotNull(response.getActions());
        Assert.assertEquals(1, response.getActions().size());
        Assert.assertThat(response.getActions(), Matchers.hasItem(Matchers.hasProperty("developerName", Matchers.equalTo(TestAction.NAME))));
        Assert.assertThat(response.getActions(), Matchers.hasItem(Matchers.hasProperty("uriPart", Matchers.containsString(TestAction.URI))));

        // TODO: Fix this to be an actual unit test, not a functional test
        JSONAssert.assertEquals(readResourceAsString("responses/metadata.json"), new ObjectMapperContextResolver().getContext(null).writeValueAsString(response), false);
    }

    String readResourceAsString(String name) throws Exception {
        return new String(Files.readAllBytes(Paths.get(Resources.getResource(name).toURI())));
    }
}
