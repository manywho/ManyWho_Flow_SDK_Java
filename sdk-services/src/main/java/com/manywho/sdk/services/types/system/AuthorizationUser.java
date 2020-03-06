package com.manywho.sdk.services.types.system;

import com.manywho.sdk.api.ContentType;
import com.manywho.sdk.services.types.Type;

@Type.Element(name = "GroupAuthorizationUser")
public class AuthorizationUser implements Type {

    @Type.Identifier
    @Type.Property(name = "AuthenticationId", contentType = ContentType.String)
    private String id;

    @Type.Property(name = "FriendlyName", contentType = ContentType.String)
    private String name;

    @Type.Property(name = "DeveloperSummary", contentType = ContentType.String)
    private String description;

    public AuthorizationUser() {
    }

    public AuthorizationUser(String id) {
        this.id = id;
    }

    public AuthorizationUser(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public AuthorizationUser(String id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}