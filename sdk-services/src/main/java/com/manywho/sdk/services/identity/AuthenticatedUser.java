package com.manywho.sdk.services.identity;

public class AuthenticatedUser {
    private String id;
    private String email;
    private String token;
    private String username;
    private String directory;

    public AuthenticatedUser(String id, String email, String token, String username, String directory) {
        this.id = id;
        this.email = email;
        this.token = token;
        this.username = username;
        this.directory = directory;
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getToken() {
        return token;
    }

    public String getUsername() {
        return username;
    }

    public String getDirectory() {
        return directory;
    }
}
