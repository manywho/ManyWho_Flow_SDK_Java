package com.manywho.sdk.entities.draw.elements.group;

public class GroupAuthorization {
    private String serviceElementId;
    private String globalAuthenticationType;
    private String streamBehaviourType;
    private GroupAuthorizationGroupCollection groups;
    private GroupAuthorizationUserCollection users;
    private GroupAuthorizationLocationCollection locations;

    public String getServiceElementId() {
        return serviceElementId;
    }

    public void setServiceElementId(String serviceElementId) {
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

    public GroupAuthorizationGroupCollection getGroups() {
        return groups;
    }

    public void setGroups(GroupAuthorizationGroupCollection groups) {
        this.groups = groups;
    }

    public GroupAuthorizationUserCollection getUsers() {
        return users;
    }

    public void setUsers(GroupAuthorizationUserCollection users) {
        this.users = users;
    }

    public GroupAuthorizationLocationCollection getLocations() {
        return locations;
    }

    public void setLocations(GroupAuthorizationLocationCollection locations) {
        this.locations = locations;
    }
}
