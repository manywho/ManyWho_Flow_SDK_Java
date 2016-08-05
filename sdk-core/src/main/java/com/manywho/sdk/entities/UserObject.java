package com.manywho.sdk.entities;

import com.manywho.sdk.entities.run.elements.type.MObject;
import com.manywho.sdk.entities.run.elements.type.Property;
import com.manywho.sdk.entities.run.elements.type.PropertyCollection;
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
        PropertyCollection properties = new PropertyCollection();
        properties.add(new Property("Country"));
        properties.add(new Property("Language"));
        properties.add(new Property("Location"));
        properties.add(new Property("Directory Id", this.directoryId));
        properties.add(new Property("Directory Name", this.directoryName));
        properties.add(new Property("AuthenticationType", this.authorizationType.toString()));
        properties.add(new Property("User ID", this.userId));
        properties.add(new Property("Username", this.username));
        properties.add(new Property("Email", this.email));
        properties.add(new Property("First Name", this.firstName));
        properties.add(new Property("Last Name", this.lastName));
        properties.add(new Property("LoginUrl", this.loginUrl));
        properties.add(new Property("Status", this.authorizationStatus));

        return properties;
    }
}
