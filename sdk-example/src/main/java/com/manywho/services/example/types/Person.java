package com.manywho.services.example.types;

import com.manywho.sdk.api.ContentType;
import com.manywho.sdk.services.types.Type;

import java.time.OffsetDateTime;
import java.util.List;

@Type.Element(name = Person.NAME, summary = "A description of a person")
public class Person implements Type {
    public final static String NAME = "Person";

    @Type.Identifier
    private String id;

    @Type.Property(name = "Name", contentType = ContentType.String)
    private String name;

    @Type.Property(name = "Biography", contentType = ContentType.Content)
    private String biography;

    @Type.Property(name = "Age", contentType = ContentType.Number)
    private Integer age;

    @Type.Property(name = "Password", contentType = ContentType.Password)
    private String password;

    @Type.Property(name = "Social Security Number", contentType = ContentType.Encrypted)
    private String socialSecurityNumber;

    @Type.Property(name = "Groups", contentType = ContentType.List)
    private List<Group> groups;

    @Type.Property(name = "Manager", contentType = ContentType.Object)
    private Person manager;

    @Type.Property(name = "Is Active?", contentType = ContentType.Boolean)
    private boolean active;

    @Type.Property(name = "Created At", contentType = ContentType.DateTime)
    private OffsetDateTime createdAt;

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

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public void setSocialSecurityNumber(String socialSecurityNumber) {
        this.socialSecurityNumber = socialSecurityNumber;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    public Person getManager() {
        return manager;
    }

    public void setManager(Person manager) {
        this.manager = manager;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
