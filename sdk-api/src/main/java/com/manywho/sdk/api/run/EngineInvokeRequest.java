package com.manywho.sdk.api.run;

import com.manywho.sdk.api.InvokeType;
import com.manywho.sdk.api.run.elements.map.MapElementInvokeRequest;
import com.manywho.sdk.api.run.state.Geolocation;
import com.manywho.sdk.api.translate.Culture;
import org.apache.commons.collections4.MapUtils;

import java.util.HashMap;
import java.util.UUID;

public class EngineInvokeRequest {
    private Culture culture;
    private UUID stateId;
    private UUID stateToken;
    private UUID currentMapElementId;
    private UUID navigationElementId;
    private UUID selectedNavigationItemId;
    private UUID selectedMapElementId;
    private InvokeType invokeType;
    private HashMap<String, String> annotations;
    private Geolocation geolocation;
    private MapElementInvokeRequest mapElementInvokeRequest;
    private String mode;

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

    public UUID getNavigationElementId() {
        return navigationElementId;
    }

    public void setNavigationElementId(UUID navigationElementId) {
        this.navigationElementId = navigationElementId;
    }

    public UUID getSelectedNavigationItemId() {
        return selectedNavigationItemId;
    }

    public void setSelectedNavigationItemId(UUID selectedNavigationItemId) {
        this.selectedNavigationItemId = selectedNavigationItemId;
    }

    public UUID getSelectedMapElementId() {
        return selectedMapElementId;
    }

    public void setSelectedMapElementId(UUID selectedMapElementId) {
        this.selectedMapElementId = selectedMapElementId;
    }

    public InvokeType getInvokeType() {
        return invokeType;
    }

    public void setInvokeType(InvokeType invokeType) {
        this.invokeType = invokeType;
    }

    public HashMap<String, String> getAnnotations() {
        return annotations;
    }

    public boolean hasAnnotations() {
        return MapUtils.isNotEmpty(annotations);
    }

    public void setAnnotations(HashMap<String, String> annotations) {
        this.annotations = annotations;
    }

    public Geolocation getGeolocation() {
        return geolocation;
    }

    public void setGeolocation(Geolocation geolocation) {
        this.geolocation = geolocation;
    }

    public MapElementInvokeRequest getMapElementInvokeRequest() {
        return mapElementInvokeRequest;
    }

    public void setMapElementInvokeRequest(MapElementInvokeRequest mapElementInvokeRequest) {
        this.mapElementInvokeRequest = mapElementInvokeRequest;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }
}
