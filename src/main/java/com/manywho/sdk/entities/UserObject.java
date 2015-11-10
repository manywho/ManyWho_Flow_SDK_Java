package com.manywho.sdk.entities;

import com.manywho.sdk.entities.run.elements.type.*;
import com.manywho.sdk.enums.AuthorizationType;

public class UserObject extends MObject {
    private String directoryId;
    private String directoryName;
    private AuthorizationType authorizationType;
    private String loginUrl;
    private String authorizationStatus;
    private String userId = "PUBLIC_USER";
    private String username = "PUBLIC_USER";
    private String email = "PUBLIC_USER";
    private String firstName = "PUBLIC_USER";
    private String lastName = "PUBLIC_USER";

    public UserObject(String directoryName, AuthorizationType authorizationType, String loginUrl, String authorizationStatus) {
        this.directoryId = directoryName;
        this.directoryName = directoryName;
        this.authorizationType = authorizationType;
        this.loginUrl = loginUrl;
        this.authorizationStatus = authorizationStatus;
    }

    public UserObject(String directoryName, AuthorizationType authorizationType, String loginUrl, String authorizationStatus, String userId, String username, String email, String firstName) {
        this(directoryName, authorizationType, loginUrl, authorizationStatus);
        this.userId = userId;
        this.username = username;
        this.email = email;
        this.firstName = firstName;
    }

    public UserObject(String directoryId, String directoryName, String authorizationStatus, String userId, String username, String email, String firstName, String lastName) {
        this.directoryId = directoryId;
        this.directoryName = directoryName;
        this.authorizationStatus = authorizationStatus;
        this.userId = userId;
        this.username = username;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String getDeveloperName() {
        return "$User";
    }

    @Override
    public PropertyCollection getProperties() {
        return new PropertyCollection() {{
            add(new Property("Country"));
            add(new Property("Language"));
            add(new Property("Location"));
            add(new Property("Directory Id", UserObject.this.directoryId));
            add(new Property("Directory Name", UserObject.this.directoryName));
            add(new Property("AuthenticationType", UserObject.this.authorizationType.toString()));
            add(new Property("User ID", UserObject.this.userId));
            add(new Property("Username", UserObject.this.username));
            add(new Property("Email", UserObject.this.email));
            add(new Property("First Name", UserObject.this.firstName));
            add(new Property("Last Name", UserObject.this.lastName));
            add(new Property("LoginUrl", UserObject.this.loginUrl));
            add(new Property("Status", UserObject.this.authorizationStatus));
        }};
    }
}
