package com.manywho.sdk.services.functional.functional;

import com.google.common.collect.Lists;
import com.manywho.sdk.api.ContentType;
import com.manywho.sdk.api.InvokeType;
import com.manywho.sdk.api.run.EngineValue;
import com.manywho.sdk.api.run.elements.config.ServiceRequest;
import com.manywho.sdk.api.run.elements.config.ServiceResponse;
import org.hamcrest.Matchers;
import org.jboss.resteasy.mock.MockHttpRequest;
import org.junit.Assert;
import org.junit.Test;

import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.UUID;

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

        Assert.assertNotNull(response);
        Assert.assertEquals(InvokeType.Forward, response.getInvokeType());
        Assert.assertEquals(serviceRequest.getToken(), response.getToken());
        Assert.assertNotNull(response.getOutputs());
        Assert.assertEquals(1, response.getOutputs().size());
        Assert.assertThat(response.getOutputs(), Matchers.hasItem(Matchers.hasProperty("developerName", Matchers.equalTo("Created At"))));
        Assert.assertThat(response.getOutputs(), Matchers.hasItem(Matchers.hasProperty("contentType", Matchers.equalTo(ContentType.DateTime))));
    }
}
