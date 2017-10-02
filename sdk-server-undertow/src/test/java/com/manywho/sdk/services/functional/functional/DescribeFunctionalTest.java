package com.manywho.sdk.services.functional.functional;

import com.manywho.sdk.api.ContentType;
import com.manywho.sdk.api.describe.DescribeServiceActionResponse;
import com.manywho.sdk.api.describe.DescribeServiceRequest;
import com.manywho.sdk.api.describe.DescribeServiceResponse;
import com.manywho.sdk.api.draw.elements.type.TypeElement;
import com.manywho.sdk.api.draw.elements.type.TypeElementBinding;
import org.hamcrest.Matchers;
import org.jboss.resteasy.mock.MockHttpRequest;
import org.junit.Assert;
import org.junit.Test;

import javax.ws.rs.core.MediaType;
import java.util.List;

public class DescribeFunctionalTest extends BaseFunctionalTest {
    @Test
    public void testDescribe() throws Exception {
        MockHttpRequest request = MockHttpRequest.post("/metadata")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsBytes(new DescribeServiceRequest()));

        DescribeServiceResponse response = getResponseContent(request, DescribeServiceResponse.class);

        Assert.assertNotNull(response);
        Assert.assertNotNull(response.getInstall());

        List<DescribeServiceActionResponse> actions = response.getActions();
        Assert.assertNotNull(actions);
        Assert.assertEquals(1, actions.size());
        Assert.assertThat(actions, Matchers.hasItem(Matchers.hasProperty("developerName", Matchers.equalTo("Test Action"))));
        Assert.assertThat(actions, Matchers.hasItem(Matchers.hasProperty("developerSummary", Matchers.equalTo("This is a test action"))));
        Assert.assertThat(actions, Matchers.hasItem(Matchers.hasProperty("uriPart", Matchers.equalTo("actions/testaction"))));
        Assert.assertThat(actions, Matchers.hasItem(Matchers.hasProperty("serviceInputs", Matchers.hasItem(Matchers.hasProperty("developerName", Matchers.equalTo("Name"))))));
        Assert.assertThat(actions, Matchers.hasItem(Matchers.hasProperty("serviceInputs", Matchers.hasItem(Matchers.hasProperty("contentType", Matchers.equalTo(ContentType.String))))));
        Assert.assertThat(actions, Matchers.hasItem(Matchers.hasProperty("serviceInputs", Matchers.hasItem(Matchers.hasProperty("required", Matchers.equalTo(true))))));
        Assert.assertThat(actions, Matchers.hasItem(Matchers.hasProperty("serviceOutputs", Matchers.hasItem(Matchers.hasProperty("developerName", Matchers.equalTo("Created At"))))));
        Assert.assertThat(actions, Matchers.hasItem(Matchers.hasProperty("serviceOutputs", Matchers.hasItem(Matchers.hasProperty("contentType", Matchers.equalTo(ContentType.DateTime))))));
        Assert.assertThat(actions, Matchers.hasItem(Matchers.hasProperty("serviceOutputs", Matchers.hasItem(Matchers.hasProperty("required", Matchers.equalTo(false))))));

        List<TypeElement> types = response.getInstall().getTypeElements();
        Assert.assertNotNull(types);
        Assert.assertEquals(2, types.size());
        Assert.assertThat(types, Matchers.hasItem(Matchers.hasProperty("developerName", Matchers.equalTo("Test Type"))));
        Assert.assertThat(types, Matchers.hasItem(Matchers.hasProperty("developerSummary", Matchers.equalTo("The Test Type object structure"))));
        Assert.assertThat(types, Matchers.hasItem(Matchers.hasProperty("elementType", Matchers.equalTo("TYPE"))));
        Assert.assertThat(types, Matchers.hasItem(Matchers.hasProperty("properties", Matchers.hasItem(Matchers.hasProperty("developerName", Matchers.equalTo("Name"))))));
        Assert.assertThat(types, Matchers.hasItem(Matchers.hasProperty("properties", Matchers.hasItem(Matchers.hasProperty("contentType", Matchers.equalTo(ContentType.String))))));
        Assert.assertThat(types, Matchers.hasItem(Matchers.hasProperty("properties", Matchers.hasItem(Matchers.hasProperty("developerName", Matchers.equalTo("Twos"))))));
        Assert.assertThat(types, Matchers.hasItem(Matchers.hasProperty("properties", Matchers.hasItem(Matchers.hasProperty("contentType", Matchers.equalTo(ContentType.List))))));
        Assert.assertThat(types, Matchers.hasItem(Matchers.hasProperty("properties", Matchers.hasItem(Matchers.hasProperty("typeElementDeveloperName", Matchers.equalTo("Test Type Two"))))));
        Assert.assertThat(types, Matchers.hasItem(Matchers.hasProperty("bindings", Matchers.hasItem(Matchers.hasProperty("developerName", Matchers.equalTo("Test Type"))))));
        Assert.assertThat(types, Matchers.hasItem(Matchers.hasProperty("bindings", Matchers.hasItem(Matchers.hasProperty("developerSummary", Matchers.equalTo("The Test Type object structure"))))));
        Assert.assertThat(types, Matchers.hasItem(Matchers.hasProperty("bindings", Matchers.hasItem(Matchers.hasProperty("databaseTableName", Matchers.equalTo("Test Type"))))));
        Assert.assertThat(types, Matchers.hasItem(Matchers.hasProperty("bindings", Matchers.hasItem(Matchers.hasProperty("propertyBindings", Matchers.hasItem(Matchers.hasProperty("databaseFieldName", Matchers.equalTo("Name"))))))));
        Assert.assertThat(types, Matchers.hasItem(Matchers.hasProperty("bindings", Matchers.hasItem(Matchers.hasProperty("propertyBindings", Matchers.hasItem(Matchers.hasProperty("typeElementPropertyDeveloperName", Matchers.equalTo("Name"))))))));
        Assert.assertThat(types, Matchers.hasItem(Matchers.hasProperty("bindings", Matchers.hasItem(Matchers.hasProperty("propertyBindings", Matchers.hasItem(Matchers.hasProperty("databaseFieldName", Matchers.equalTo("Twos"))))))));
        Assert.assertThat(types, Matchers.hasItem(Matchers.hasProperty("bindings", Matchers.hasItem(Matchers.hasProperty("propertyBindings", Matchers.hasItem(Matchers.hasProperty("typeElementPropertyDeveloperName", Matchers.equalTo("Twos"))))))));
        Assert.assertThat(types, Matchers.hasItem(Matchers.hasProperty("developerName", Matchers.equalTo("Test Type Two"))));
        Assert.assertThat(types, Matchers.hasItem(Matchers.hasProperty("developerSummary", Matchers.equalTo("This is the second test type"))));
        Assert.assertThat(types, Matchers.hasItem(Matchers.hasProperty("elementType", Matchers.equalTo("TYPE"))));
        Assert.assertThat(types, Matchers.hasItem(Matchers.hasProperty("properties", Matchers.hasItem(Matchers.hasProperty("developerName", Matchers.equalTo("Age"))))));
        Assert.assertThat(types, Matchers.hasItem(Matchers.hasProperty("properties", Matchers.hasItem(Matchers.hasProperty("contentType", Matchers.equalTo(ContentType.Number))))));
        Assert.assertThat(types, Matchers.hasItem(Matchers.hasProperty("bindings", Matchers.emptyCollectionOf(TypeElementBinding.class))));
    }
}
