package com.manywho.sdk.client.flow.entities;

import com.manywho.sdk.api.run.elements.map.OutcomeResponse;

import java.util.UUID;

public class Outcome {
    private UUID id;
    private String name;
    private String label;

    public Outcome(UUID id, String name, String label) {
        this.id = id;
        this.name = name;
        this.label = label;
    }

    public Outcome(OutcomeResponse outcomeResponse) {
        this(outcomeResponse.getId(), outcomeResponse.getDeveloperName(), outcomeResponse.getLabel());
    }

    public Outcome() {
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLabel() {
        return label;
    }
}
