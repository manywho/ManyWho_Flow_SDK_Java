package com.manywho.sdk.client;

import com.googlecode.junittoolbox.ParallelRunner;
import com.manywho.sdk.api.jackson.ObjectMapperFactory;
import com.manywho.sdk.client.flow.FlowClient;
import com.manywho.sdk.client.flow.FlowInitializationOptions;
import com.manywho.sdk.client.flow.FlowState;
import com.manywho.sdk.client.run.RunClient;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.io.IOException;
import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@RunWith(ParallelRunner.class)
public class FlowClientTest {
    private FlowClient client;

    @Before
    public void setUp() {
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(JacksonConverterFactory.create(ObjectMapperFactory.create()))
                .baseUrl("https://flow.manywho.com")
                .build();

        RunClient runClient = retrofit.create(RunClient.class);

        client = new FlowClient(runClient);
    }

    @Test
    public void testStartSuccessfulWithoutAuthorization() throws IOException {
        UUID tenant = UUID.fromString("b7539297-103a-4abc-ad56-7615fb9b3f27");
        UUID id = UUID.fromString("21f79572-e7bb-47d1-9539-9e0aa7f2a145");

        FlowState response = client
                .start(tenant, id, null, new FlowInitializationOptions());

        assertNotNull(response.getInvokeResponse());
        assertEquals("200", response.getInvokeResponse().getStatusCode());
        assertTrue(response.hasOutcomes());
    }
}
