package com.manywho.sdk.client.raw;

import com.manywho.sdk.client.TestConfig;
import com.manywho.sdk.entities.draw.flow.FlowId;
import com.manywho.sdk.entities.draw.flow.FlowResponse;
import com.manywho.sdk.entities.run.EngineInitializationRequest;
import com.manywho.sdk.entities.run.EngineInitializationResponse;
import com.manywho.sdk.entities.run.EngineInvokeRequest;
import com.manywho.sdk.entities.run.EngineInvokeResponse;
import com.manywho.sdk.entities.run.elements.map.MapElementInvokeRequest;
import com.manywho.sdk.enums.InvokeType;
import com.manywho.sdk.exceptions.ManyWhoException;
import com.manywho.sdk.utils.AuthorizationUtils;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.List;
import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class RawRunClientTest {

    private RawRunClient rawRunClient;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Before
    public void setUp() {
        this.rawRunClient = new RawRunClient();
    }

    @Test
    public void testInitializeFlow() throws Exception {
        EngineInitializationRequest initializationRequest = new EngineInitializationRequest();
        initializationRequest.setFlowId(new FlowId("04b95e44-ab08-4011-8dc8-009a9c27c670"));

        EngineInitializationResponse initializationResponse = rawRunClient.initialize(
                TestConfig.getTenantId(),
                null,
                initializationRequest
        );

        assertNotNull(initializationResponse);
    }

    @Test
    public void testInitializeFlowWithIncorrectAuthorization() throws Exception {
        expectedException.expect(ManyWhoException.class);
        expectedException.expectMessage("Unauthorized");

        EngineInitializationRequest initializationRequest = new EngineInitializationRequest();
        initializationRequest.setFlowId(new FlowId("e10e493f-65ff-4a0b-b184-c451453e5c56"));
        initializationRequest.setMode("");
        initializationRequest.setReportingMode("");

        rawRunClient.initialize(
                TestConfig.getTenantId(),
                AuthorizationUtils.createSerializedPublicUser(TestConfig.getTenantId()),
                initializationRequest
        );
    }

    @Test
    public void testInitializeAndExecuteFlow() {
        EngineInitializationRequest initializationRequest = new EngineInitializationRequest();
        initializationRequest.setFlowId(new FlowId("04b95e44-ab08-4011-8dc8-009a9c27c670"));

        EngineInitializationResponse initializationResponse = rawRunClient.initialize(
                TestConfig.getTenantId(),
                null,
                initializationRequest
        );

        EngineInvokeRequest invokeRequest = new EngineInvokeRequest();
        invokeRequest.setCurrentMapElementId(initializationResponse.getCurrentMapElementId());
        invokeRequest.setInvokeType(InvokeType.Forward);
        invokeRequest.setMapElementInvokeRequest(new MapElementInvokeRequest());
        invokeRequest.setStateId(initializationResponse.getStateId());
        invokeRequest.setStateToken(initializationResponse.getStateToken());

        EngineInvokeResponse invokeResponse = rawRunClient.execute(
                TestConfig.getTenantId(),
                null,
                invokeRequest
        );

        assertNotNull(invokeResponse);
        assertEquals(InvokeType.Forward, invokeResponse.getInvokeType());
        assertEquals("200", invokeResponse.getStatusCode());
        assertTrue(invokeResponse.getRunFlowUri().contains("04b95e44-ab08-4011-8dc8-009a9c27c670"));
    }

    @Test
    public void testJoinFlow() {
        EngineInvokeResponse response = rawRunClient.join(
                TestConfig.getTenantId(),
                UUID.fromString("b318b122-2f5e-45a6-b2dc-5d9ae841f0e9"),
                null
        );

        assertNotNull(response);
        assertEquals(InvokeType.Forward, response.getInvokeType());
        assertEquals("b318b122-2f5e-45a6-b2dc-5d9ae841f0e9", response.getStateId());
        assertEquals("200", response.getStatusCode());
        assertTrue(response.getRunFlowUri().contains("04b95e44-ab08-4011-8dc8-009a9c27c670"));
        assertTrue(response.getJoinFlowUri().contains("b318b122-2f5e-45a6-b2dc-5d9ae841f0e9"));
    }

    @Test
    public void testLoadFlows() throws Exception {
        List<FlowResponse> flows = rawRunClient.loadAll(TestConfig.getTenantId());

        assertNotNull(flows);
        assertFalse(flows.isEmpty());
    }

    @Test
    public void testLoadFlowById() throws Exception {
        UUID flowId = UUID.fromString("04b95e44-ab08-4011-8dc8-009a9c27c670");

        FlowResponse flow = rawRunClient.load(TestConfig.getTenantId(), flowId);

        assertNotNull(flow);
        assertEquals(flowId.toString(), flow.getId().getId());
    }
}
