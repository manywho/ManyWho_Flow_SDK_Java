package com.manywho.sdk.services.unit.describe;

import com.google.common.collect.Lists;
import com.manywho.sdk.api.draw.elements.type.TypeElement;
import com.manywho.sdk.services.describe.DescribeTypeService;
import com.manywho.sdk.services.types.TypeHasNoPropertiesException;
import com.manywho.sdk.services.types.TypeIdentifierMissingException;
import com.manywho.sdk.services.types.TypeRepository;
import com.manywho.sdk.services.unit.entities.TestTypeWithValidListProperty;
import com.manywho.sdk.services.unit.entities.TestTypeWithValidObjectProperty;
import com.manywho.sdk.services.unit.entities.TestTypeWithoutIdentifier;
import com.manywho.sdk.services.unit.entities.TestTypeWithoutProperties;
import com.manywho.sdk.services.unit.entities.TestTypeWithoutTypeInterface;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasProperty;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

public class DescribeTypeServiceTest extends BaseTest {

    @Test
    public void testCreateTypesWithNoAnnotatedTypes() {
        reflectionsConfiguration.setUrls(Lists.newArrayList());

        DescribeTypeService describeTypeService = createDescribeTypeService();

        List<TypeElement> types = describeTypeService.createTypes();

        assertNotNull(types);
        assertEquals(0, types.size());
    }

    @Test(expected = TypeIdentifierMissingException.class)
    public void testCreateTypesWithNoIdentifier() {
        includeOnly(TestTypeWithoutIdentifier.class);

        DescribeTypeService describeTypeService = createDescribeTypeService();

        describeTypeService.createTypes();
    }

    @Test(expected = TypeHasNoPropertiesException.class)
    public void testCreateTypesWithoutAnyProperties() {
        includeOnly(TestTypeWithoutProperties.class);

        DescribeTypeService describeTypeService = createDescribeTypeService();

        describeTypeService.createTypes();
    }

    @Test
    public void testCreateTypesWithValidList() {
        includeOnly(TestTypeWithValidListProperty.class, TestTypeWithValidObjectProperty.class);

        DescribeTypeService describeTypeService = createDescribeTypeService();

        List<TypeElement> types = describeTypeService.createTypes();

        assertNotNull(types);
        assertEquals(2, types.size());

        // Assert that the "Valid List" type was created
        assertThat(types, hasItem(hasProperty("developerName", equalTo(TestTypeWithValidListProperty.NAME))));
        assertThat(types, hasItem(hasProperty("developerSummary", equalTo(TestTypeWithValidListProperty.SUMMARY))));

        // Assert that the "Valid List" type contains a property of type "Valid Object"
        assertThat(types, hasItem(hasProperty("properties", hasItem(hasProperty("typeElementDeveloperName", equalTo(TestTypeWithValidObjectProperty.NAME))))));
    }

    @Test
    public void testCreateTypesWithValidObjectAndDefaultSummary() {
        includeOnly(TestTypeWithValidObjectProperty.class);

        DescribeTypeService describeTypeService = createDescribeTypeService();

        List<TypeElement> types = describeTypeService.createTypes();

        assertNotNull(types);
        assertNotEquals(0, types.size());

        // Assert that the "Valid Object" type was created
        assertThat(types, hasItem(hasProperty("developerName", equalTo(TestTypeWithValidObjectProperty.NAME))));
        assertThat(types, hasItem(hasProperty("developerSummary", containsString("object structure"))));
    }

    @Test
    public void testCreateTypesWithoutTypeInterface() {
        includeOnly(TestTypeWithoutTypeInterface.class);

        DescribeTypeService describeTypeService = createDescribeTypeService();

        List<TypeElement> types = describeTypeService.createTypes();

        assertNotNull(types);
        assertEquals(0, types.size());
    }

    private DescribeTypeService createDescribeTypeService() {
        return new DescribeTypeService(new TypeRepository(createReflections()));
    }
}
