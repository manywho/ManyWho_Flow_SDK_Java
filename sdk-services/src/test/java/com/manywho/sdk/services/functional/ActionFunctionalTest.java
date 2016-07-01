package com.manywho.sdk.services.functional;

import com.google.common.collect.Lists;
import com.manywho.sdk.api.ContentType;
import com.manywho.sdk.api.InvokeType;
import com.manywho.sdk.api.run.EngineValue;
import com.manywho.sdk.api.run.elements.config.ServiceRequest;
import com.manywho.sdk.api.run.elements.config.ServiceResponse;
import org.jboss.resteasy.mock.MockHttpRequest;
import org.junit.Test;

import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.net.URISyntaxException;
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
    public void testTestAction() throws IOException, URISyntaxException {
        List<EngineValue> inputs = Lists.newArrayList();
        inputs.add(new EngineValue("Name", ContentType.String, "Jonjo"));

        ServiceRequest serviceRequest = new ServiceRequest();
        serviceRequest.setInputs(inputs);
        serviceRequest.setToken(UUID.randomUUID().toString());

        MockHttpRequest request = MockHttpRequest.post("/actions/testaction")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsBytes(serviceRequest));

        ServiceResponse response = getResponseContent(request, ServiceResponse.class);

        assertNotNull(response);
        assertEquals(InvokeType.Forward, response.getInvokeType());
        assertEquals(serviceRequest.getToken(), response.getToken());
        assertNotNull(response.getOutputs());
        assertEquals(1, response.getOutputs().size());
        assertThat(response.getOutputs(), hasItem(hasProperty("developerName", equalTo("Created At"))));
        assertThat(response.getOutputs(), hasItem(hasProperty("contentType", equalTo(ContentType.DateTime))));
    }
}
