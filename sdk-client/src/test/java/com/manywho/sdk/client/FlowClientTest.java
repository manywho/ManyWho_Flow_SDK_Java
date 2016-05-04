package com.manywho.sdk.client;

import com.manywho.sdk.client.entities.FlowState;
import com.manywho.sdk.entities.draw.flow.FlowId;
import com.manywho.sdk.enums.InvokeType;
import org.junit.Before;
import org.junit.Test;

import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class FlowClientTest {
    private FlowClient flowClient;

    @Before
    public void setUp() {
        this.flowClient = new FlowClient();
    }

    @Test
    public void testStartFlow() {
        FlowState state = flowClient.start(
                TestConfig.getTenantId(),
                new FlowId("04b95e44-ab08-4011-8dc8-009a9c27c670")
        );

        assertNotNull(state);
        assertNotNull(state.getInvokeResponse());
        assertEquals(InvokeType.Forward, state.getInvokeType());
        assertEquals(TestConfig.getTenantId(), state.getTenant());
    }

    @Test
    public void testJoinFlow() {
        FlowState state = flowClient.join(
                TestConfig.getTenantId(),
                UUID.fromString("b318b122-2f5e-45a6-b2dc-5d9ae841f0e9")
        );

        assertNotNull(state);
        assertNotNull(state.getInvokeResponse());
        assertEquals(InvokeType.Forward, state.getInvokeType());
        assertEquals(UUID.fromString("b318b122-2f5e-45a6-b2dc-5d9ae841f0e9"), state.getState());
        assertEquals(TestConfig.getTenantId(), state.getTenant());
    }
}
