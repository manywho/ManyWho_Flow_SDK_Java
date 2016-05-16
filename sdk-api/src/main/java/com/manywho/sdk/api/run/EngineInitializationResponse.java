package com.manywho.sdk.api.run;

import com.manywho.sdk.api.run.elements.ui.NavigationElementReference;
import com.manywho.sdk.api.translate.Culture;

import java.util.List;

public class EngineInitializationResponse {
    private Culture culture;
    private String stateId;
    private String stateToken;
    private String currentMapElementId;
    private String currentStreamId;
    private String statusCode;
    private EngineAuthorizationContext authorizationContext;
    private List<NavigationElementReference> navigationElementReferences;

    public Culture getCulture() {
        return culture;
    }

    public void setCulture(Culture culture) {
        this.culture = culture;
    }

    public String getStateId() {
        return stateId;
    }

    public void setStateId(String stateId) {
        this.stateId = stateId;
    }

    public String getStateToken() {
        return stateToken;
    }

    public void setStateToken(String stateToken) {
        this.stateToken = stateToken;
    }

    public String getCurrentMapElementId() {
        return currentMapElementId;
    }

    public void setCurrentMapElementId(String currentMapElementId) {
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
        this.navigationElementReferences = navigationElementReferences;
    }
}
