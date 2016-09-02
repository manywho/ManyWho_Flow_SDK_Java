package com.manywho.sdk.api.run.elements.ui;

import java.util.UUID;

public class NavigationElementReference {
    private UUID id;
    private String developerName;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getDeveloperName() {
        return developerName;
    }

    public void setDeveloperName(String developerName) {
        this.developerName = developerName;
    }
}
