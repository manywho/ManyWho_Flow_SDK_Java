package com.manywho.sdk.api.draw.elements.group;

import java.util.List;
import java.util.UUID;

public class GroupAuthorization {
    private UUID serviceElementId;
    private String globalAuthenticationType;
    private String streamBehaviourType;
    private List<GroupAuthorizationGroup> groups;
    private List<GroupAuthorizationUser> users;
    private List<GroupAuthorizationLocation> locations;

    public UUID getServiceElementId() {
        return serviceElementId;
    }

    public void setServiceElementId(UUID serviceElementId) {
        this.serviceElementId = serviceElementId;
    }

    public String getGlobalAuthenticationType() {
        return globalAuthenticationType;
    }

    public void setGlobalAuthenticationType(String globalAuthenticationType) {
        this.globalAuthenticationType = globalAuthenticationType;
    }

    public String getStreamBehaviourType() {
        return streamBehaviourType;
    }

    public void setStreamBehaviourType(String streamBehaviourType) {
        this.streamBehaviourType = streamBehaviourType;
    }

    public List<GroupAuthorizationGroup> getGroups() {
        return groups;
    }

    public void setGroups(List<GroupAuthorizationGroup> groups) {
        this.groups = groups;
    }

    public List<GroupAuthorizationUser> getUsers() {
        return users;
    }

    public void setUsers(List<GroupAuthorizationUser> users) {
        this.users = users;
    }

    public List<GroupAuthorizationLocation> getLocations() {
        return locations;
    }

    public void setLocations(List<GroupAuthorizationLocation> locations) {
        this.locations = locations;
    }
}
