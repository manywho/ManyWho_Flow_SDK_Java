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
        initializationRequest.setFlowId(new FlowId("c6b211f0-b342-4f67-b7b1-b8b62868b2a4"));

        EngineInitializationResponse initializationResponse = runClient.initializeFlow(
                TestConfig.getTenantId(),
                TestConfig.getAuthorizationToken(),
                initializationRequest
        );

        assertNotNull(initializationResponse);
    }

    @Test
    public void testInitializeFlowWithoutAuthorization() throws Exception {
        expectedException.expect(ManyWhoException.class);
        expectedException.expectMessage("Unauthorized");

        EngineInitializationRequest initializationRequest = new EngineInitializationRequest();
        initializationRequest.setFlowId(new FlowId("c6b211f0-b342-4f67-b7b1-b8b62868b2a4"));
        initializationRequest.setJoinPlayerUrl("https://flow.manywho.com/07f799a4-af7c-449b-ba7c-f1f526f7000a/play/default");
        initializationRequest.setPlayerUrl("https://flow.manywho.com/07f799a4-af7c-449b-ba7c-f1f526f7000a/play/default");
        initializationRequest.setMode("");
        initializationRequest.setReportingMode("");

        runClient.initializeFlow(TestConfig.getTenantId(), null, initializationRequest);
    }

    @Test
    public void testLoadFlows() throws Exception {
        List<FlowResponse> flows = runClient.loadFlows(TestConfig.getTenantId());

        assertNotNull(flows);
        assertFalse(flows.isEmpty());
    }

    @Test
    public void testLoadFlowById() throws Exception {
        String flowId = "c6b211f0-b342-4f67-b7b1-b8b62868b2a4";

        FlowResponse flow = runClient.loadFlowById(TestConfig.getTenantId(), flowId);

        assertNotNull(flow);
        assertEquals(flowId, flow.getId().getId());
    }
}
