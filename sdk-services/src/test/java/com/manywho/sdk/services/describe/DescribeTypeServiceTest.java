package com.manywho.sdk.services.describe;

import com.google.common.collect.Lists;
import com.manywho.sdk.api.ContentType;
import com.manywho.sdk.api.draw.elements.type.TypeElement;
import com.manywho.sdk.services.types.Type;
import com.manywho.sdk.services.types.TypeIdentifierMissingException;
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

        DescribeTypeService describeTypeService = new DescribeTypeService(createReflections());

        List<TypeElement> types = describeTypeService.createTypes();

        assertNotNull(types);
        assertEquals(0, types.size());
    }

    @Test
    public void testCreateTypesWithoutTypeInterface() {
        includeOnly(TypeWithoutTypeInterface.class);

        DescribeTypeService describeTypeService = new DescribeTypeService(createReflections());

        List<TypeElement> types = describeTypeService.createTypes();

        assertNotNull(types);
        assertEquals(0, types.size());
    }

    @Test(expected = TypeIdentifierMissingException.class)
    public void testCreateTypesWithNoIdentifier() {
        includeOnly(TypeWithoutIdentifier.class);

        DescribeTypeService describeTypeService = new DescribeTypeService(createReflections());

        describeTypeService.createTypes();
    }

    @Test
    public void testCreateTypesWithValidList() {
        includeOnly(ValidList.class, ValidObject.class);

        DescribeTypeService describeTypeService = new DescribeTypeService(createReflections());

        List<TypeElement> types = describeTypeService.createTypes();

        assertNotNull(types);
        assertEquals(2, types.size());

        // Assert that the "Valid List" type was created
        assertThat(types, hasItem(hasProperty("developerName", equalTo(ValidList.NAME))));
        assertThat(types, hasItem(hasProperty("developerSummary", equalTo(ValidList.SUMMARY))));

        // Assert that the "Valid List" type contains a property of type "Valid Object"
        assertThat(types, hasItem(hasProperty("properties", hasItem(hasProperty("typeElementDeveloperName", equalTo(ValidObject.NAME))))));
    }

    @Test
    public void testCreateTypesWithValidObjectAndDefaultSummary() {
        includeOnly(ValidObject.class);

        DescribeTypeService describeTypeService = new DescribeTypeService(createReflections());

        List<TypeElement> types = describeTypeService.createTypes();

        assertNotNull(types);
        assertNotEquals(0, types.size());

        // Assert that the "Valid Object" type was created
        assertThat(types, hasItem(hasProperty("developerName", equalTo(ValidObject.NAME))));
        assertThat(types, hasItem(hasProperty("developerSummary", containsString("object structure"))));
    }

    @Type.Element(name = ValidList.NAME, summary = ValidList.SUMMARY)
    class ValidList implements Type {
        static final String NAME = "Valid List";
        static final String SUMMARY = "A valid summary";

        @Type.Identifier
        private String id;

        @Type.Property(name = "Valid Objects", contentType = ContentType.List)
        private List<ValidObject> validObjects;
    }

    @Type.Element(name = ValidObject.NAME)
    class ValidObject implements Type {
        static final String NAME = "Valid Object";

        @Type.Identifier
        private String id;

        @Type.Property(name = "Name", contentType = ContentType.String)
        private String name;
    }

    @Type.Element(name = TypeWithoutTypeInterface.NAME)
    class TypeWithoutTypeInterface {
        static final String NAME = "Type Without Type Interface";
    }

    @Type.Element(name = TypeWithoutIdentifier.NAME)
    class TypeWithoutIdentifier implements Type {
        static final String NAME = "Type Without Identifier";
    }
}
