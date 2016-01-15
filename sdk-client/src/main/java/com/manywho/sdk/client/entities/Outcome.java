package com.manywho.sdk.client.entities;

import com.manywho.sdk.entities.run.elements.map.OutcomeResponse;

public class Outcome {
    private String id;
    private String name;
    private String label;

    public Outcome(String id, String name, String label) {
        this.id = id;
        this.name = name;
        this.label = label;
    }

    public Outcome(OutcomeResponse outcomeResponse) {
        this(outcomeResponse.getId(), outcomeResponse.getDeveloperName(), outcomeResponse.getLabel());
    }

    public Outcome() {
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLabel() {
        return label;
    }
}
