package com.manywho.sdk.entities.run;

import com.manywho.sdk.enums.AuthorizationType;

public class EngineAuthorizationContext {
    private String directoryName;
    private String directoryId;
    private String loginUrl;
    private AuthorizationType authenticationType;

    public String getDirectoryName() {
        return directoryName;
    }

    public void setDirectoryName(String directoryName) {
        this.directoryName = directoryName;
    }

    public String getDirectoryId() {
        return directoryId;
    }

    public void setDirectoryId(String directoryId) {
        this.directoryId = directoryId;
    }

    public String getLoginUrl() {
        return loginUrl;
    }

    public void setLoginUrl(String loginUrl) {
        this.loginUrl = loginUrl;
    }

    public AuthorizationType getAuthenticationType() {
        return authenticationType;
    }

    public void setAuthenticationType(AuthorizationType authenticationType) {
        this.authenticationType = authenticationType;
    }
}
