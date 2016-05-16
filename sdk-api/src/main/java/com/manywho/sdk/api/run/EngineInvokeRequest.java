package com.manywho.sdk.api.run;

import com.manywho.sdk.api.InvokeType;
import com.manywho.sdk.api.run.elements.map.MapElementInvokeRequest;
import com.manywho.sdk.api.run.state.Geolocation;
import com.manywho.sdk.api.translate.Culture;
import org.apache.commons.collections4.MapUtils;

import java.util.HashMap;

public class EngineInvokeRequest {
    private Culture culture;
    private String stateId;
    private String stateToken;
    private String currentMapElementId;
    private String navigationElementId;
    private String selectedNavigationItemId;
    private String selectedMapElementId;
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

    public String getNavigationElementId() {
        return navigationElementId;
    }

    public void setNavigationElementId(String navigationElementId) {
        this.navigationElementId = navigationElementId;
    }

    public String getSelectedNavigationItemId() {
        return selectedNavigationItemId;
    }

    public void setSelectedNavigationItemId(String selectedNavigationItemId) {
        this.selectedNavigationItemId = selectedNavigationItemId;
    }

    public String getSelectedMapElementId() {
        return selectedMapElementId;
    }

    public void setSelectedMapElementId(String selectedMapElementId) {
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
