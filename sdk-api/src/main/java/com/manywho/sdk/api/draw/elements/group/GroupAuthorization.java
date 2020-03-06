package com.manywho.sdk.api.draw.elements.group;

import com.google.common.base.MoreObjects;
import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class GroupAuthorization {
    private UUID serviceElementId;
    private String globalAuthenticationType;
    private String streamBehaviourType;
    private List<GroupAuthorizationGroup> groups = Lists.newArrayList();
    private List<GroupAuthorizationUser> users = Lists.newArrayList();
    private List<GroupAuthorizationLocation> locations = Lists.newArrayList();

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
        this.groups = MoreObjects.firstNonNull(groups, new ArrayList<GroupAuthorizationGroup>());
    }

    public List<GroupAuthorizationUser> getUsers() {
        return users;
    }

    public void setUsers(List<GroupAuthorizationUser> users) {
        this.users = MoreObjects.firstNonNull(users, new ArrayList<GroupAuthorizationUser>());
    }

    public List<GroupAuthorizationLocation> getLocations() {
        return locations;
    }

    public void setLocations(List<GroupAuthorizationLocation> locations) {
        this.locations = MoreObjects.firstNonNull(locations, new ArrayList<GroupAuthorizationLocation>());
    }
}
