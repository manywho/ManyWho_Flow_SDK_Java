package com.manywho.sdk.services.unit.listeners;

import com.manywho.sdk.api.ContentType;
import com.manywho.sdk.api.run.EngineValue;
import com.manywho.sdk.api.run.elements.config.ListenerServiceRequest;
import com.manywho.sdk.services.listeners.ListenerManager;
import com.manywho.sdk.services.unit.entities.TestType;
import org.junit.Before;
import org.junit.Test;

public class ListenerManagerTest {
    private ListenerManager manager;

    @Before
    public void setUp() {
//        this.manager = new ListenerManager(
//
//        );
    }

    @Test
    public void testCreateWithSingle() {
        ListenerServiceRequest request = new ListenerServiceRequest();
        request.setValueForListening(new EngineValue("Test Value", ContentType.Object, TestType.NAME));

        manager.create(request);
    }
}
