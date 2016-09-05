package com.manywho.sdk.services.listeners;

import com.manywho.sdk.api.run.elements.config.ListenerServiceRequest;
import com.manywho.sdk.api.security.AuthenticatedWho;
import com.manywho.sdk.services.configuration.Configuration;
import com.manywho.sdk.services.configuration.ConfigurationParser;
import com.manywho.sdk.services.types.Type;
import com.manywho.sdk.services.types.TypeRepository;

import javax.inject.Inject;

public class ListenerManager {
    private final TypeRepository typeRepository;
    private final ConfigurationParser configurationParser;
    private final ListenerService listenerService;
    private final AuthenticatedWho authenticatedWho;

    @Inject
    public ListenerManager(
            TypeRepository typeRepository,
            ConfigurationParser configurationParser,
            ListenerService listenerService,
            AuthenticatedWho authenticatedWho
    ) {
        this.typeRepository = typeRepository;
        this.configurationParser = configurationParser;
        this.listenerService = listenerService;
        this.authenticatedWho = authenticatedWho;
    }

    public void create(ListenerServiceRequest request) {
        // Find the type that we're creating a listener for
        Class<? extends Type> type = typeRepository.findTypeElement(request.getValueForListening().getTypeElementDeveloperName());

        // Create the configuration values from the request
        Configuration configuration = configurationParser.from(request);

        ListenerData listenerData = new ListenerData(authenticatedWho, request);

        switch (request.getValueForListening().getContentType()) {
            case List:
                listenerService.createMultiple(configuration, type, listenerData);
                break;
            case Object:
                listenerService.createSingle(configuration, type, listenerData);
                break;
            default:
                throw new RuntimeException("Creating listeners is only supported with Lists and Objects");
        }
    }
}
