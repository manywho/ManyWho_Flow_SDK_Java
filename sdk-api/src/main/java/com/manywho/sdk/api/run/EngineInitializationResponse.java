package com.manywho.sdk.api.run;

import com.google.common.base.MoreObjects;
import com.google.common.collect.Lists;
import com.manywho.sdk.api.run.elements.ui.NavigationElementReference;
import com.manywho.sdk.api.translate.Culture;

import java.util.List;
import java.util.UUID;

public class EngineInitializationResponse {
    private Culture culture;
    private UUID stateId;
    private UUID stateToken;
    private UUID currentMapElementId;
    private String currentStreamId;
    private String statusCode;
    private EngineAuthorizationContext authorizationContext;
    private List<NavigationElementReference> navigationElementReferences = Lists.newArrayList();

    public Culture getCulture() {
        return culture;
    }

    public void setCulture(Culture culture) {
        this.culture = culture;
    }

    public UUID getStateId() {
        return stateId;
    }

    public void setStateId(UUID stateId) {
        this.stateId = stateId;
    }

    public UUID getStateToken() {
        return stateToken;
    }

    public void setStateToken(UUID stateToken) {
        this.stateToken = stateToken;
    }

    public UUID getCurrentMapElementId() {
        return currentMapElementId;
    }

    public void setCurrentMapElementId(UUID currentMapElementId) {
        this.currentMapElementId = currentMapElementId;
    }

    public String getCurrentStreamId() {
        return currentStreamId;
    }

    public void setCurrentStreamId(String currentStreamId) {
        this.currentStreamId = currentStreamId;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public EngineAuthorizationContext getAuthorizationContext() {
        return authorizationContext;
    }

    public void setAuthorizationContext(EngineAuthorizationContext authorizationContext) {
        this.authorizationContext = authorizationContext;
    }

    public List<NavigationElementReference> getNavigationElementReferences() {
        return navigationElementReferences;
    }

    public void setNavigationElementReferences(List<NavigationElementReference> navigationElementReferences) {
        this.navigationElementReferences = MoreObjects.firstNonNull(navigationElementReferences, Lists.newArrayList());
    }
}
