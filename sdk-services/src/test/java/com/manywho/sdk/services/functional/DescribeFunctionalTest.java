package com.manywho.sdk.services.functional;

import com.manywho.sdk.api.ContentType;
import com.manywho.sdk.api.describe.DescribeServiceActionResponse;
import com.manywho.sdk.api.describe.DescribeServiceRequest;
import com.manywho.sdk.api.describe.DescribeServiceResponse;
import com.manywho.sdk.api.draw.elements.type.TypeElement;
import com.manywho.sdk.api.draw.elements.type.TypeElementBinding;
import org.junit.Test;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import java.util.List;

import static org.hamcrest.Matchers.emptyCollectionOf;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasProperty;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

public class DescribeFunctionalTest extends BaseFunctionalTest {
    @Test
    public void testDescribe() throws Exception {
        DescribeServiceResponse response = target("/metadata").request()
                .post(Entity.entity(new DescribeServiceRequest(), MediaType.APPLICATION_JSON))
                .readEntity(DescribeServiceResponse.class);

        assertNotNull(response);
        assertNotNull(response.getInstall());

        List<DescribeServiceActionResponse> actions = response.getActions();        
        assertNotNull(actions);
        assertEquals(1, actions.size());
        assertThat(actions, hasItem(hasProperty("developerName", equalTo("Test Action"))));
        assertThat(actions, hasItem(hasProperty("developerSummary", equalTo("This is a test action"))));
        assertThat(actions, hasItem(hasProperty("uriPart", equalTo("actions/testaction"))));
        assertThat(actions, hasItem(hasProperty("serviceInputs", hasItem(hasProperty("developerName", equalTo("Name"))))));
        assertThat(actions, hasItem(hasProperty("serviceInputs", hasItem(hasProperty("contentType", equalTo(ContentType.String))))));
        assertThat(actions, hasItem(hasProperty("serviceInputs", hasItem(hasProperty("required", equalTo(true))))));
        assertThat(actions, hasItem(hasProperty("serviceOutputs", hasItem(hasProperty("developerName", equalTo("Created At"))))));
        assertThat(actions, hasItem(hasProperty("serviceOutputs", hasItem(hasProperty("contentType", equalTo(ContentType.DateTime))))));
        assertThat(actions, hasItem(hasProperty("serviceOutputs", hasItem(hasProperty("required", equalTo(false))))));
        
        List<TypeElement> types = response.getInstall().getTypeElements();
        assertNotNull(types);
        assertEquals(2, types.size());
        assertThat(types, hasItem(hasProperty("developerName", equalTo("Test Type"))));
        assertThat(types, hasItem(hasProperty("developerSummary", equalTo("The Test Type object structure"))));
        assertThat(types, hasItem(hasProperty("elementType", equalTo("TYPE"))));
        assertThat(types, hasItem(hasProperty("properties", hasItem(hasProperty("developerName", equalTo("Name"))))));
        assertThat(types, hasItem(hasProperty("properties", hasItem(hasProperty("contentType", equalTo(ContentType.String))))));
        assertThat(types, hasItem(hasProperty("properties", hasItem(hasProperty("developerName", equalTo("Twos"))))));
        assertThat(types, hasItem(hasProperty("properties", hasItem(hasProperty("contentType", equalTo(ContentType.List))))));
        assertThat(types, hasItem(hasProperty("properties", hasItem(hasProperty("typeElementDeveloperName", equalTo("Test Type Two"))))));
        assertThat(types, hasItem(hasProperty("bindings", hasItem(hasProperty("developerName", equalTo("Test Type"))))));
        assertThat(types, hasItem(hasProperty("bindings", hasItem(hasProperty("developerSummary", equalTo("The Test Type object structure"))))));
        assertThat(types, hasItem(hasProperty("bindings", hasItem(hasProperty("databaseTableName", equalTo("Test Type"))))));
        assertThat(types, hasItem(hasProperty("bindings", hasItem(hasProperty("propertyBindings", hasItem(hasProperty("databaseFieldName", equalTo("Name"))))))));
        assertThat(types, hasItem(hasProperty("bindings", hasItem(hasProperty("propertyBindings", hasItem(hasProperty("typeElementPropertyDeveloperName", equalTo("Name"))))))));
        assertThat(types, hasItem(hasProperty("bindings", hasItem(hasProperty("propertyBindings", hasItem(hasProperty("databaseFieldName", equalTo("Twos"))))))));
        assertThat(types, hasItem(hasProperty("bindings", hasItem(hasProperty("propertyBindings", hasItem(hasProperty("typeElementPropertyDeveloperName", equalTo("Twos"))))))));
        assertThat(types, hasItem(hasProperty("developerName", equalTo("Test Type Two"))));
        assertThat(types, hasItem(hasProperty("developerSummary", equalTo("This is the second test type"))));
        assertThat(types, hasItem(hasProperty("elementType", equalTo("TYPE"))));
        assertThat(types, hasItem(hasProperty("properties", hasItem(hasProperty("developerName", equalTo("Age"))))));
        assertThat(types, hasItem(hasProperty("properties", hasItem(hasProperty("contentType", equalTo(ContentType.Number))))));
        assertThat(types, hasItem(hasProperty("bindings", emptyCollectionOf(TypeElementBinding.class))));
    }
}
