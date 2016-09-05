package com.manywho.sdk.services.listeners;

import com.google.inject.Injector;
import com.manywho.sdk.services.configuration.Configuration;
import com.manywho.sdk.services.types.Type;
import com.manywho.sdk.services.values.ValueParser;

import javax.inject.Inject;
import java.util.List;

public class ListenerService {
    private final ListenerRepository listenerRepository;
    private final Injector injector;
    private final ValueParser valueParser;

    @Inject
    public ListenerService(ListenerRepository listenerRepository, Injector injector, ValueParser valueParser) {
        this.listenerRepository = listenerRepository;
        this.injector = injector;
        this.valueParser = valueParser;
    }

    @SuppressWarnings("unchecked")
    <T extends Type> void createMultiple(Configuration configuration, Class<T> type, ListenerData data) {
        // Find a listener for the desired Type and event name
        Class<? extends Listener> listener = listenerRepository.findListener(type, data.getRequest().getListenType());

        // Parse the incoming object data as a List of the desired Type
        List<T> values = valueParser.asList(data.getRequest().getValueForListening().getObjectData(), type);

        // Create the listener using the defined handler in the service, with the parsed EngineValue
        injector.getInstance(listener)
                .createMultiple(configuration, values, data);
    }

    @SuppressWarnings("unchecked")
    <T extends Type> void createSingle(Configuration configuration, Class<T> type, ListenerData data) {
        // Find a listener for the desired Type and event name
        Class<? extends Listener> listener = listenerRepository.findListener(type, data.getRequest().getListenType());

        // Parse the incoming object data as a single Object of the desired Type
        T value = valueParser.asObject(data.getRequest().getValueForListening().getObjectData(), type);

        // Create the listener using the defined handler in the service, with the parsed EngineValue
        injector.getInstance(listener)
                .create(configuration, value, data);
    }
}
