package com.manywho.sdk.entities.run.elements.config;

import com.manywho.sdk.enums.AuthenticationType;

public class Authorization {
    private UserCollection users;
    private GroupCollection groups;
    private String runningAuthenticationId;
    private AuthenticationType globalAuthenticationType;

    public UserCollection getUsers() {
        return users;
    }

    public void setUsers(UserCollection users) {
        this.users = users;
    }

    public GroupCollection getGroups() {
        return groups;
    }

    public void setGroups(GroupCollection groups) {
        this.groups = groups;
    }

    public String getRunningAuthenticationId() {
        return runningAuthenticationId;
    }

    public void setRunningAuthenticationId(String runningAuthenticationId) {
        this.runningAuthenticationId = runningAuthenticationId;
    }

    public AuthenticationType getGlobalAuthenticationType() {
        return globalAuthenticationType;
    }

    public void setGlobalAuthenticationType(AuthenticationType globalAuthenticationType) {
        this.globalAuthenticationType = globalAuthenticationType;
    }
}
