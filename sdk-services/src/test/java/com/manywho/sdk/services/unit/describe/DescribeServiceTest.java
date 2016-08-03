package com.manywho.sdk.services.unit.describe;

import com.google.common.collect.Lists;
import com.manywho.sdk.services.actions.ActionRepository;
import com.manywho.sdk.services.configuration.ConfigurationRepository;
import com.manywho.sdk.services.describe.DescribeRepository;
import com.manywho.sdk.services.describe.DescribeService;
import org.junit.Test;
import org.reflections.Reflections;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DescribeServiceTest extends BaseTest {
    @Test
    public void testAnyActionsDefinedWithTestClass() {
        DescribeService describeService = createDescribeService();

        assertTrue(describeService.anyActionsDefined());
    }

    @Test
    public void testAnyActionsDefinedWithoutTestClass() {
        reflectionsConfiguration.setUrls(Lists.newArrayList());

        DescribeService describeService = createDescribeService();

        assertFalse(describeService.anyActionsDefined());
    }

    @Test
    public void testAnyConfigurationValuesExistWithTestClass() {
        DescribeService describeService = createDescribeService();

        assertTrue(describeService.anyConfigurationValuesExist());
    }

    @Test
    public void testAnyConfigurationValuesExistWithoutTestClass() {
        reflectionsConfiguration.setUrls(Lists.newArrayList());

        DescribeService describeService = createDescribeService();

        assertFalse(describeService.anyConfigurationValuesExist());
    }

    @Test
    public void testAnyDataControllersExistWithTestClass() {
        DescribeService describeService = createDescribeService();

        assertTrue(describeService.anyDataControllersExist());
    }

    @Test
    public void testAnyDataControllersExistWithoutTestClass() {
        reflectionsConfiguration.setUrls(Lists.newArrayList());

        DescribeService describeService = createDescribeService();

        assertFalse(describeService.anyDataControllersExist());
    }

    @Test
    public void testAnyFileControllersExistWithTestClass() {
        DescribeService describeService = createDescribeService();

        assertTrue(describeService.anyFileControllersExist());
    }

    @Test
    public void testAnyFileControllersExistWithoutTestClass() {
        reflectionsConfiguration.setUrls(Lists.newArrayList());

        DescribeService describeService = createDescribeService();

        assertFalse(describeService.anyFileControllersExist());
    }

    @Test
    public void testAnyIdentityControllersExistWithTestClass() {
        DescribeService describeService = createDescribeService();

        assertTrue(describeService.anyIdentityControllersExist());
    }

    @Test
    public void testAnyIdentityControllersExistWithoutTestClass() {
        reflectionsConfiguration.setUrls(Lists.newArrayList());

        DescribeService describeService = createDescribeService();

        assertFalse(describeService.anyIdentityControllersExist());
    }

    @Test
    public void testAnyListenerControllersExistWithTestClass() {
        DescribeService describeService = createDescribeService();

        assertTrue(describeService.anyListenerControllersExist());
    }

    @Test
    public void testAnyListenerControllersExistWithoutTestClass() {
        reflectionsConfiguration.setUrls(Lists.newArrayList());

        DescribeService describeService = createDescribeService();

        assertFalse(describeService.anyListenerControllersExist());
    }

    @Test
    public void testAnySocialControllersExistWithTestClass() {
        DescribeService describeService = createDescribeService();

        assertFalse(describeService.anySocialControllersExist());
    }

    @Test
    public void testAnySocialControllersExistWithoutTestClass() {
        reflectionsConfiguration.setUrls(Lists.newArrayList());

        DescribeService describeService = createDescribeService();

        assertFalse(describeService.anySocialControllersExist());
    }

    private DescribeService createDescribeService() {
        Reflections reflections = createReflections();

        return new DescribeService(new ActionRepository(reflections), new ConfigurationRepository(reflections), new DescribeRepository(reflections));
    }
}
