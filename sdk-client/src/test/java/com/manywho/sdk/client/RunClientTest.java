package com.manywho.sdk.client;

import com.manywho.sdk.client.exceptions.ManyWhoException;
import com.manywho.sdk.entities.draw.flow.FlowId;
import com.manywho.sdk.entities.draw.flow.FlowResponse;
import com.manywho.sdk.entities.run.EngineInitializationRequest;
import com.manywho.sdk.entities.run.EngineInitializationResponse;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.List;

import static org.junit.Assert.*;

public class RunClientTest {

    private RunClient runClient;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Before
    public void setUp() {
        this.runClient = new RunClient();
    }

    @Test
    public void testInitializeFlow() throws Exception {
        EngineInitializationRequest initializationRequest = new EngineInitializationRequest();
        initializationRequest.setFlowId(new FlowId("04b95e44-ab08-4011-8dc8-009a9c27c670"));

        EngineInitializationResponse initializationResponse = runClient.initializeFlow(
                TestConfig.getTenantId(),
                null,
                initializationRequest
        );

        assertNotNull(initializationResponse);
    }

    @Test
    public void testInitializeFlowWithoutAuthorization() throws Exception {
        expectedException.expect(ManyWhoException.class);
        expectedException.expectMessage("Unauthorized");

        EngineInitializationRequest initializationRequest = new EngineInitializationRequest();
        initializationRequest.setFlowId(new FlowId("e10e493f-65ff-4a0b-b184-c451453e5c56"));
        initializationRequest.setMode("");
        initializationRequest.setReportingMode("");

        runClient.initializeFlow(TestConfig.getTenantId(), TestConfig.getAuthorizationToken(), initializationRequest);
    }

    @Test
    public void testLoadFlows() throws Exception {
        List<FlowResponse> flows = runClient.loadFlows(TestConfig.getTenantId());

        assertNotNull(flows);
        assertFalse(flows.isEmpty());
    }

    @Test
    public void testLoadFlowById() throws Exception {
        String flowId = "04b95e44-ab08-4011-8dc8-009a9c27c670";

        FlowResponse flow = runClient.loadFlowById(TestConfig.getTenantId(), flowId);

        assertNotNull(flow);
        assertEquals(flowId, flow.getId().getId());
    }
}
