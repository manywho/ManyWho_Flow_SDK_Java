package com.manywho.sdk.services.functional;

import com.google.common.collect.Lists;
import com.manywho.sdk.api.ContentType;
import com.manywho.sdk.api.InvokeType;
import com.manywho.sdk.api.run.EngineValue;
import com.manywho.sdk.api.run.elements.config.ServiceRequest;
import com.manywho.sdk.api.run.elements.config.ServiceResponse;
import org.junit.Test;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.UUID;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasProperty;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

public class ActionFunctionalTest extends BaseFunctionalTest {
    @Test
    public void testTestAction() {
        List<EngineValue> inputs = Lists.newArrayList();
        inputs.add(new EngineValue("Name", ContentType.String, "Jonjo"));

        ServiceRequest request = new ServiceRequest();
        request.setInputs(inputs);
        request.setToken(UUID.randomUUID().toString());

        ServiceResponse response = target("/actions/testaction").request()
                .post(Entity.entity(request, MediaType.APPLICATION_JSON))
                .readEntity(ServiceResponse.class);

        assertNotNull(response);
        assertEquals(InvokeType.Forward, response.getInvokeType());
        assertEquals(request.getToken(), response.getToken());
        assertNotNull(response.getOutputs());
        assertEquals(1, response.getOutputs().size());
        assertThat(response.getOutputs(), hasItem(hasProperty("developerName", equalTo("Created At"))));
        assertThat(response.getOutputs(), hasItem(hasProperty("contentType", equalTo(ContentType.DateTime))));
    }
}
