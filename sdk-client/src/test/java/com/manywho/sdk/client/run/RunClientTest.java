package com.manywho.sdk.client.run;

import com.googlecode.junittoolbox.ParallelRunner;
import com.manywho.sdk.api.InvokeType;
import com.manywho.sdk.api.jackson.ObjectMapperFactory;
import com.manywho.sdk.api.run.EngineInvokeRequest;
import com.manywho.sdk.api.run.EngineInvokeResponse;
import com.manywho.sdk.api.run.elements.map.MapElementInvokeRequest;
import com.manywho.sdk.client.TestConfig;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.io.IOException;
import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@RunWith(ParallelRunner.class)
public class RunClientTest {
    private RunClient client;

    @Before
    public void setUp() {
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(JacksonConverterFactory.create(ObjectMapperFactory.create()))
                .baseUrl("https://flow.manywho.com")
                .build();

        client = retrofit.create(RunClient.class);
    }

    @Test
    public void testExecuteSuccessfulWithoutAuthorizationAndStringIdentifiers() throws IOException {
        UUID id = UUID.fromString("2d8f8a15-bd90-4d7b-99ee-55ab7e945802");

        EngineInvokeRequest request = new EngineInvokeRequest();
        request.setCurrentMapElementId(UUID.fromString("4eff27c1-50d8-4308-a12a-7d1ca69d8942"));
        request.setInvokeType(InvokeType.Forward);
        request.setMapElementInvokeRequest(new MapElementInvokeRequest(UUID.fromString("0d95445b-ab1c-4b56-902f-11bfd809f24d")));
        request.setStateId(id);
        request.setStateToken(UUID.randomUUID());

        Response<EngineInvokeResponse> response = client
                .execute(TestConfig.getTenant(), id, request)
                .execute();

        assertTrue(response.isSuccessful());
        assertEquals(200, response.code());
        assertNotNull(response);
        assertEquals(id, response.body().getStateId());
    }

    @Test
    public void testExecuteWithIncorrectParameters() throws IOException {
        Response<EngineInvokeResponse> response = client
                .execute("not-a-token", UUID.randomUUID(), UUID.randomUUID(), new EngineInvokeRequest())
                .execute();

        Assert.assertFalse(response.isSuccessful());
        assertEquals(400, response.code());
    }
}
