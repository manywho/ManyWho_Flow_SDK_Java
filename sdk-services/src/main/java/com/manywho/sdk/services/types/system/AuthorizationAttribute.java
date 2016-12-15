package com.manywho.sdk.services.types.system;

import com.manywho.sdk.api.ContentType;
import com.manywho.sdk.services.types.Type;

@Type.Element(name = "AuthenticationAttribute")
public class AuthorizationAttribute implements Type {
    @Type.Identifier
    @Type.Property(name = "Value", contentType = ContentType.String)
    private String value;

    @Type.Property(name = "Label", contentType = ContentType.String)
    private String label;

    public AuthorizationAttribute() {
    }

    public AuthorizationAttribute(String value, String label) {
        this.value = value;
        this.label = label;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
